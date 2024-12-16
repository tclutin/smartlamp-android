package com.example.smartlamp.domain.usecase.color

import com.example.smartlamp.data.model.Color

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): Result<Color?>
}