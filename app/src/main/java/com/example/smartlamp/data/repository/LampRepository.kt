package com.example.smartlamp.data.repository

import com.example.smartlamp.data.model.BrightnessLevels
import com.example.smartlamp.data.model.Color

interface LampRepository {

    // State operations
    suspend fun on(): Result<Boolean?>

    suspend fun off(): Result<Boolean?>

    suspend fun getState(): Result<Boolean?>

    // Brightness operations
    suspend fun getLevels(): Result<BrightnessLevels?>

    suspend fun setLevel(level: Int): Result<Boolean?>

    suspend fun getCurrentLevel(): Result<Int?>

    // Color operations
    suspend fun setColor(color: String): Result<Boolean?>

    suspend fun getNamesOnly(): Result<List<String>?>

    suspend fun getCurrentColor(): Result<Color?>
}