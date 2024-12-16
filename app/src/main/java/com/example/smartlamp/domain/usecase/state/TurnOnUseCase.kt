package com.example.smartlamp.domain.usecase.state

interface TurnOnUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}