package com.example.weatherapp.utils.shared_preference

import android.content.Context
import com.example.weatherapp.MyApplication
import com.example.weatherapp.utils.Constants.SHARED_PREFERENCES_FOLDER_NAME

object SharedPreferences {

    private val sharedPreferences = MyApplication.getInstance()
        .applicationContext
        .getSharedPreferences(
            SHARED_PREFERENCES_FOLDER_NAME,
            Context.MODE_PRIVATE
        )

    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun saveInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun saveFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun saveLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun clearAllSharedPreferences() {
        sharedPreferences.edit().clear().apply()
    }

    fun removeKey(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}