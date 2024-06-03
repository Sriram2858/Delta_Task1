package com.example.deltatask1

import android.content.Context
import android.content.SharedPreferences

class Preferencesmanager(context: Context) {
    private val sharedPreferences: SharedPreferences = context
        .getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveInteger(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInteger(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun getAllKeys(): MutableSet<String> {
        return sharedPreferences.all.keys
    }
}