package com.example.smartlamp.di

import android.content.Context
import com.example.smartlamp.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }