package com.example.sharedpreferenceskotlin

import android.app.Application

class SharedPreferencesKotlinApplication : Application() {
    companion object{
        lateinit var prefs:Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}