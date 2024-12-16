package com.example.smartlamp.domain.usecase.brightness

import com.example.smartlamp.data.model.BrightnessLevels

interface GetLevelsUseCase {
    suspend operator fun invoke(): Result<BrightnessLevels?>
}