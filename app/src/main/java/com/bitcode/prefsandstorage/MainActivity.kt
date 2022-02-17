package com.bitcode.prefsandstorage

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("my_prefs", Activity.MODE_PRIVATE)
        var editor : SharedPreferences.Editor = prefs.edit()

        editor.putString("name", "Vishal Jagtap")
        editor.putInt("code", 10903)
        editor.commit()

        var name = prefs.getString("name", "NA")
        var code = prefs.getInt("code", -1)

        Log.e("tag", "$name -- $code")

        prefs = getPreferences(Activity.MODE_PRIVATE)
        editor= prefs.edit()

        editor.putString("name", "Vishal Jagtap")
        editor.putInt("code", 10903)
        editor.commit()

        name = prefs.getString("name", "NA")
        code = prefs.getInt("code", -1)

        Log.e("tag", "$name -- $code")


    }
}