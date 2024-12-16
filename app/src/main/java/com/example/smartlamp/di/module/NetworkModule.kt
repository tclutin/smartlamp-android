package com.example.smartlamp.di.module

import com.example.smartlamp.data.service.LampService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://46.17.45.34:1337/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideLampService(retrofit: Retrofit): LampService {
        return retrofit.create(LampService::class.java)
    }
}