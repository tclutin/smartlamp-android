package com.example.smartlamp.domain.usecase.brightness

import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class SetLevelUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): SetLevelUseCase {
    override suspend fun invoke(level: Int): Result<Boolean?> {
        return repository.setLevel(level)
    }
}