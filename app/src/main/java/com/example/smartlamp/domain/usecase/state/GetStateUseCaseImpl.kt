package com.example.smartlamp.domain.usecase.state

import com.example.smartlamp.data.repository.LampRepository
import com.example.smartlamp.data.repository.LampRepositoryImpl
import javax.inject.Inject

class GetStateUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetStateUseCase {
    override suspend fun invoke(): Result<Boolean?> {
        return repository.getState()
    }
}