package com.example.smartlamp.di.module

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        LampModule::class
    ]
)
class AppModule