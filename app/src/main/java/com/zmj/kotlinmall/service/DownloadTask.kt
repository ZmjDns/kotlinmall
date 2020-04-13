package com.zmj.kotlinmall.service

import android.os.AsyncTask

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/13
 * Description :
 */
class DownloadTask(var downloadListener: IDownloadListener ):AsyncTask<String,Int,Int>() {

    public val TYPE_SUCCESS = 0
    public val TYPE_FAILED = 0
    public val TYPE_PAUSE = 0
    public val TYPE_CANCEL = 0

    //接收外界传来的信息，控制下载的状态
    private var isPaused = false
    private var isCanceled = false


    override fun onPreExecute() {
        super.onPreExecute()
    }

    //通知最终执行完的结果
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        when(result){
            TYPE_SUCCESS ->{

            }


        }

    }

    override fun doInBackground(vararg params: String?): Int {




        publishProgress(TYPE_CANCEL)
        return 0
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }
}