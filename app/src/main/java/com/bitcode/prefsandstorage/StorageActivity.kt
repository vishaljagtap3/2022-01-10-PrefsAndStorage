package com.bitcode.prefsandstorage

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class StorageActivity : AppCompatActivity() {

    private fun mt(text : String) {
        Log.e("tag", text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mt("App files root dir: ${filesDir.absolutePath}")

        var newFile1 = File(filesDir, "newfile1.dat")
        if(!newFile1.exists()) {
            newFile1.createNewFile()
        }

        var fout = FileOutputStream(newFile1)
        fout.write("BitCode is the best place to learn Android".toByteArray())
        fout.close()

        var fin = FileInputStream(newFile1)
        var data = ByteArray(1024 * 1)
        var count = 0
        while(true) {
            count = fin.read(data)
            if(count == -1) {
                break
            }
            Log.e("tag", String(data, 0, count))
        }
        fin.close()


        var newDir = File(filesDir, "new_dir")
        if(!newDir.exists()) {
            newDir.mkdir()
        }

        var myfile = File(newDir, "myfile.mp3")
        if(!myfile.exists()) {
            myfile.createNewFile()
        }

        var fileNames = filesDir.list()
        for(fileName in fileNames) {
            mt(":${fileName}")
        }

        mt("-------------------")
        var fileObjects = filesDir.listFiles()
        for(file in fileObjects) {
            mt("- ${file.name}")
            if(file.isDirectory) {
                for(file1 in file.listFiles()) {
                    mt("----- ${file1.name}")
                }
            }
        }

        mt("Cache dir ---> ${cacheDir.absolutePath}")

        //newDir.delete()

        /*var fout = openFileOutput("myfile1.txt", Activity.MODE_PRIVATE or Activity.MODE_APPEND)
        fout.write("this is a sample string...".toByteArray())
        fout.write("It is around 3pm and time to sleep...".toByteArray())
        fout.close()

        var fin = openFileInput("myfile1.txt")
        var data = ByteArray(1024 * 1)
        var count = 0
        while(true) {
            count = fin.read(data)
            if(count == -1) {
                break
            }
            Log.e("tag", String(data, 0, count))
        }
        fin.close()

        var fileNames = fileList()
        for(fileName  in fileNames) {
            Log.e("tag", fileName)
        }

        deleteFile("myfile1.txt")
        var dirTest : File = getDir("test_dir", Activity.MODE_PRIVATE)*/

    }


}