package com.example.smartlamp.data.service

import com.example.smartlamp.data.model.BrightnessLevels
import com.example.smartlamp.data.model.Color
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {

    // State operations
    @POST("/state/on")
    suspend fun on(): Response<Boolean>

    @POST("/state/off")
    suspend fun off(): Response<Boolean>

    @GET("/state/")
    suspend fun getState(): Response<Boolean>

    // Brightness operations
    @GET("/brightness/")
    suspend fun getLevels(): Response<BrightnessLevels>

    @POST("/brightness/")
    suspend fun setLevel(@Query("level") level: Int): Response<Boolean>

    @GET("/brightness/current")
    suspend fun getCurrentLevel(): Response<Int>

    // Color operations
    @POST("/color/")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET("/color/names_only")
    suspend fun getNamesOnly(): Response<List<String>>

    @GET("/color/current")
    suspend fun getCurrentColor(): Response<Color>
}