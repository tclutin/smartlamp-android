package com.example.smartlamp.domain.usecase.color

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}