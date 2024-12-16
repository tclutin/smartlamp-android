package com.example.smartlamp

import android.app.Application
import com.example.smartlamp.di.AppComponent
import com.example.smartlamp.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }

}