package com.example.smartlamp.domain.usecase.brightness

import com.example.smartlamp.data.model.BrightnessLevels
import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class GetLevelsUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetLevelsUseCase{
    override suspend fun invoke(): Result<BrightnessLevels?> {
        return repository.getLevels()
    }
}