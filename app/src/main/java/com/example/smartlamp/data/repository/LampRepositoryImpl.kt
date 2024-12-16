package com.example.smartlamp.data.repository

import android.util.Log
import com.example.smartlamp.data.model.BrightnessLevels
import com.example.smartlamp.data.model.Color
import com.example.smartlamp.data.service.LampService
import retrofit2.HttpException
import javax.inject.Inject

class LampRepositoryImpl @Inject constructor(
    private val service: LampService
): LampRepository {

    // State operations
    override suspend fun on(): Result<Boolean?> {
        return try {
            val response = service.on()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun off(): Result<Boolean?> {
        return try {
            val response = service.off()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun getState(): Result<Boolean?> {
        return try {
            val response = service.getState()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    // Brightness operations
    override suspend fun getLevels(): Result<BrightnessLevels?> {
        return try {
            val response = service.getLevels()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun setLevel(level: Int): Result<Boolean?> {
        return try {
            val response = service.setLevel(level)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun getCurrentLevel(): Result<Int?> {
        return try {
            val response = service.getCurrentLevel()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    // Color operations
    override suspend fun setColor(color: String): Result<Boolean?> {
        return try {
            val response = service.setColor(color)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun getNamesOnly(): Result<List<String>?> {
        return try {
            val response = service.getNamesOnly()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun getCurrentColor(): Result<Color?> {
        return try {
            val response = service.getCurrentColor()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}