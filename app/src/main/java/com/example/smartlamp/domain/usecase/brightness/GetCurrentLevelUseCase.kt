package com.example.smartlamp.domain.usecase.brightness

interface GetCurrentLevelUseCase {
    suspend operator fun invoke(): Result<Int?>
}