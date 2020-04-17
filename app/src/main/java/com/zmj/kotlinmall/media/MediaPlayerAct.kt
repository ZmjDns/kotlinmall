package com.zmj.kotlinmall.media

import android.Manifest
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import com.zmj.permissionlibrary.isGetSinglePermission
import kotlinx.android.synthetic.main.act_media_player.*
import java.io.File

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/16
 * Description :
 */
class MediaPlayerAct: BaseActivity() {

    private val mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_media_player)

        permission()


    }


    fun permission(){
        if (!isGetSinglePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),101)
        }else{
            initMediaPlayer()
            initVideoPlayer()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (isGetSinglePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            initMediaPlayer()
            initVideoPlayer()
        }else{
            Toast.makeText(this,"NO permission", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initMediaPlayer(){
        val mediaPath = "/storage/emulated/0/DCIM/Taylor Swift - All You Had To Do Was Stay.mp3"
        val aa = Environment.getExternalStorageDirectory()
        val soundFile = File(mediaPath)
        if (soundFile.exists()){
            mediaPlayer.setDataSource(soundFile.path)
            mediaPlayer.prepare()
            Toast.makeText(this,"媒体文件准完成，可以开始播放",Toast.LENGTH_SHORT).show()

            playController()
        }else{
            Toast.makeText(this,"媒体文件出错",Toast.LENGTH_SHORT).show()
        }
    }

    private fun playController(){
        play.setOnClickListener {
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
            }
        }

        stop.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
            }
        }
        replay.setOnClickListener {
            mediaPlayer.reset()
            initMediaPlayer()
        }
    }

    private fun initVideoPlayer(){
        val videoPath = "/storage/emulated/0/DCIM/ScreenRecorder/Screenrecorder-2020-04-06-17-16-53-939.mp4"

        video.setVideoPath(videoPath)

        playVideo.setOnClickListener {
            if (!video.isPlaying){
                video.start()
            }
        }
        pauseVideo.setOnClickListener {
            if (video.isPlaying){
                video.pause()
            }
        }

        replayVideo.setOnClickListener {
            if (video.isPlaying){
                video.resume()   //重新播放
            }
        }


    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }
}