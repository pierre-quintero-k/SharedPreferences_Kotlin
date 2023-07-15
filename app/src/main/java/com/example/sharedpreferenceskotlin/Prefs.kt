package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context: Context) {
    val PREFS_NAME = "dataDB"
    private val storage = context.getSharedPreferences( PREFS_NAME, 0)

    fun saveData( key: String, data: String){
        storage.edit().putString( key, data).apply()
    }

    fun getData( key: String): String? {
        return storage.getString(key, null)
    }

    fun removeData( key: String) {
        storage.edit().remove(key).apply()
    }
}
