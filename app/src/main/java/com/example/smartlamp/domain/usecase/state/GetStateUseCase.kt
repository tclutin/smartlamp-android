package com.example.smartlamp.domain.usecase.state

interface GetStateUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}