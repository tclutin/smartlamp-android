package com.example.smartlamp.domain.usecase.color

interface GetNamesOnlyUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}