package com.zmj.kotlinmall.service

import android.os.AsyncTask
import android.os.Environment
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.InputStream
import java.io.RandomAccessFile

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/13
 * Description :
 */
class DownloadTask(var downloadListener: IDownloadListener ):AsyncTask<String,Int,Int>() {

    public val TYPE_SUCCESS = 0
    public val TYPE_FAILED = 1
    public val TYPE_PAUSE = 2
    public val TYPE_CANCEL = 3

    //接收外界传来的信息，控制下载的状态
    private var isPaused = false
    private var isCanceled = false
    private var lastProgress:Int = 0


    override fun onPreExecute() {
        super.onPreExecute()
    }

    //通知最终执行完的结果
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        when(result){
            TYPE_SUCCESS ->{
                downloadListener.onSuccess()
            }
            TYPE_FAILED -> {
                downloadListener.onFailed()
            }
            TYPE_PAUSE -> {
                downloadListener.onPaused()
            }
            TYPE_CANCEL -> {
                downloadListener.onCanceled()
            }
        }
    }

    override fun doInBackground(vararg params: String?): Int {
        var inputStream: InputStream? = null
        var savedFile: RandomAccessFile? = null     //使用RandomAccessFile便于查找已经下载过的数据，用于断点下载
        try {
            val downloadUrl = params[0] ?: return TYPE_FAILED
            val fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"))
            val downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
            val file = File(downloadPath + fileName)
            var downloadedFileLength: Long = 0
            if (file.exists()){
                downloadedFileLength = file.length()
            }
            val fileLength: Long = getFileLength(downloadUrl)
            if (fileLength < 1){
                return TYPE_FAILED
            }
            if (downloadedFileLength == fileLength){
                return TYPE_SUCCESS
            }

            val okHttpClient = OkHttpClient.Builder().build()
            val request = Request.Builder()
                //断点下载
                .addHeader("RANGE","bytes=$downloadedFileLength-")
                .url(downloadUrl)
                .build()
            val response = okHttpClient.newCall(request).execute()
            val body = response.body() ?: return TYPE_FAILED

            inputStream = body.byteStream()
            //使用RandomAccessFile便于查找已经下载过的数据，用于断点下载
            savedFile = RandomAccessFile(file,"rw")
            savedFile.seek(downloadedFileLength)    //跳过已下载的字节
            val buffer = ByteArray(1024)
            var len: Int = 0
            while ((inputStream.read(buffer).also { len = it}) != -1){
                if (isCanceled){
                    return TYPE_CANCEL
                }else if (isPaused){
                    return TYPE_PAUSE
                }else{
                    savedFile.write(buffer,0,len)
                    downloadedFileLength += len
                    val progress = (downloadedFileLength * 100 / fileLength).toInt()
                    Log.i("DownloadTask","已下载的数据：$downloadedFileLength / $fileLength   Progress:${downloadedFileLength * 100 / fileLength})")

                    publishProgress(progress)
                }
            }
            body.close()
            return TYPE_SUCCESS
        }catch (e: Exception){
            e.printStackTrace()
        }finally {
            inputStream?.close()
            savedFile?.close()
        }
        return TYPE_FAILED
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        val progress = values[0]
        if (progress != null) {
            if(progress > lastProgress){
                downloadListener.onProgress(progress)
                lastProgress = progress
            }
        }
    }

    fun pauseDownload(){
        isPaused = true
    }
    fun cancelDownload(){
        isCanceled = true
    }

    //获取要下载文件长度
    private fun getFileLength(downloadUrl: String): Long {
        val okHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder().url(downloadUrl).build()
        val response = okHttpClient.newCall(request).execute()
        if (response.isSuccessful ){
            val body = response.body() ?: return 0
            return body.contentLength()
        }
        return 0
    }
}