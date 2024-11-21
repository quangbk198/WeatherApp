package com.example.weatherapp

import android.app.Application

class MyApplication : Application() {

    init {
        application = this
    }

    companion object {
        private var application: Application? = null

        fun getInstance(): MyApplication {
            return application as MyApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
    }


}