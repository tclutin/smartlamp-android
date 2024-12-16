package com.example.smartlamp.domain.usecase.color

import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class SetColorUseCaseImpl@Inject constructor(
    private val repository: LampRepository
): SetColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean?> {
        return repository.setColor(color)
    }
}