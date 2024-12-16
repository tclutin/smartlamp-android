package com.example.smartlamp.domain.usecase.state

import android.util.Log
import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class TurnOnUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): TurnOnUseCase {
    override suspend fun invoke(): Result<Boolean?> {
        return repository.on()
    }
}