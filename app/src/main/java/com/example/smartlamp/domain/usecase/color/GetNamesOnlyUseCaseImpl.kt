package com.example.smartlamp.domain.usecase.color

import com.example.smartlamp.data.repository.LampRepository
import javax.inject.Inject

class GetNamesOnlyUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetNamesOnlyUseCase {
    override suspend fun invoke(): Result<List<String>?> {
        return repository.getNamesOnly()
    }
}