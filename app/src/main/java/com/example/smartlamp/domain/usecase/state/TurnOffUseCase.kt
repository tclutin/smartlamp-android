package com.example.smartlamp.domain.usecase.state

interface TurnOffUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}