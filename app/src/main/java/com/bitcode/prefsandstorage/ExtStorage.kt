package com.bitcode.prefsandstorage

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ExtStorage : AppCompatActivity() {

    private fun mt(text : String){
        Log.e("tag", text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var state = Environment.getExternalStorageState()

        mt("State : $state  ${state == Environment.MEDIA_MOUNTED}")
        var root = Environment.getExternalStorageDirectory()
        mt("root = ${root.absolutePath}")
        var musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        mt("music dir: ${musicDir.absolutePath}")
        mt("Root dir* ${Environment.getRootDirectory().absolutePath}")


        var appRoot =getExternalFilesDir(null)
        mt("App root on ext: ${appRoot!!.absolutePath}")

        var appRootImages =getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        mt("App root images on ext: ${appRootImages!!.absolutePath}")

        mt("Ext cache: ${externalCacheDir!!.absolutePath}")

    }
}