package com.example.smartlamp.domain.usecase.brightness

interface SetLevelUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean?>
}