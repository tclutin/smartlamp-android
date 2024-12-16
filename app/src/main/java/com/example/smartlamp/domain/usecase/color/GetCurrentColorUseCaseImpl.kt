package com.example.smartlamp.domain.usecase.color

import com.example.smartlamp.data.model.Color
import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentColorUseCase {
    override suspend fun invoke(): Result<Color?> {
        return repository.getCurrentColor()
    }
}