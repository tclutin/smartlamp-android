package com.example.smartlamp.domain.usecase.state

import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class TurnOffUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): TurnOffUseCase {
    override suspend fun invoke(): Result<Boolean?> {
        return repository.off()
    }
}