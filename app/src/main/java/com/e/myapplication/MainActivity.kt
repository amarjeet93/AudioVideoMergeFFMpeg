package com.e.myapplication

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arthenica.mobileffmpeg.ExecuteCallback
import com.arthenica.mobileffmpeg.FFmpeg
import com.arthenica.mobileffmpeg.FFmpegExecution

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Merge(view: View?) {
        val c = arrayOf(
            "-i",
            Environment.getExternalStorageDirectory().path
                    + "/Download/Mp4.mp4",
            "-i",
            Environment.getExternalStorageDirectory().path
                    + "/Download/Download unavailable-480p.m4a",
            "-c:v",
            "copy",
            "-c:a",
            "aac",
            "-map",
            "0:v:0",
            "-map",
            "1:a:0",
            "-shortest",
            (
                    Environment.getExternalStorageDirectory().path
                            + "/Download/2Merge Video.mp4")
        )
        MergeVideo(c)
    }

    private fun MergeVideo(co: Array<String>) {
        FFmpeg.executeAsync(co, ExecuteCallback { executionId, returnCode ->
            Log.d("hello", "return  $returnCode")
            Log.d("hello", "executionID  $executionId")
            Log.d("hello", "FFMPEG  " + FFmpegExecution(executionId, co))
        })
    }
}