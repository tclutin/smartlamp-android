package com.example.smartlamp.domain.usecase.brightness

import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class GetCurrentLevelUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentLevelUseCase {
    override suspend fun invoke(): Result<Int?> {
        return repository.getCurrentLevel()
    }
}