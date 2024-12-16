package com.example.smartlamp.di.module

import com.example.smartlamp.data.repository.LampRepository
import com.example.smartlamp.data.repository.LampRepositoryImpl
import com.example.smartlamp.domain.usecase.brightness.GetCurrentLevelUseCase
import com.example.smartlamp.domain.usecase.brightness.GetCurrentLevelUseCaseImpl
import com.example.smartlamp.domain.usecase.brightness.GetLevelsUseCase
import com.example.smartlamp.domain.usecase.brightness.GetLevelsUseCaseImpl
import com.example.smartlamp.domain.usecase.brightness.SetLevelUseCase
import com.example.smartlamp.domain.usecase.brightness.SetLevelUseCaseImpl
import com.example.smartlamp.domain.usecase.color.GetCurrentColorUseCase
import com.example.smartlamp.domain.usecase.color.GetCurrentColorUseCaseImpl
import com.example.smartlamp.domain.usecase.color.GetNamesOnlyUseCase
import com.example.smartlamp.domain.usecase.color.GetNamesOnlyUseCaseImpl
import com.example.smartlamp.domain.usecase.color.GetNamesOnlyUseCaseImpl_Factory
import com.example.smartlamp.domain.usecase.color.SetColorUseCase
import com.example.smartlamp.domain.usecase.color.SetColorUseCaseImpl
import com.example.smartlamp.domain.usecase.state.GetStateUseCase
import com.example.smartlamp.domain.usecase.state.GetStateUseCaseImpl
import com.example.smartlamp.domain.usecase.state.TurnOffUseCase
import com.example.smartlamp.domain.usecase.state.TurnOffUseCaseImpl
import com.example.smartlamp.domain.usecase.state.TurnOnUseCase
import com.example.smartlamp.domain.usecase.state.TurnOnUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface LampModule {
    @Binds
    @Singleton
    fun bindLampRepository(repository: LampRepositoryImpl): LampRepository

    @Binds
    @Singleton
    fun bindGetStateUseCase(useCase: GetStateUseCaseImpl): GetStateUseCase

    @Binds
    @Singleton
    fun bindTurnOffUseCase(useCase: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    @Singleton
    fun bindTurnOnUseCase(useCase: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    @Singleton
    fun bindGetCurrentLevelUseCase(useCase: GetCurrentLevelUseCaseImpl): GetCurrentLevelUseCase

    @Binds
    @Singleton
    fun bindGetLevelsUseCase(useCase: GetLevelsUseCaseImpl): GetLevelsUseCase

    @Binds
    @Singleton
    fun bindSetLevelUseCase(useCase: SetLevelUseCaseImpl): SetLevelUseCase

    @Binds
    @Singleton
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    @Singleton
    fun bindGetNamesOnlyUseCase(useCase: GetNamesOnlyUseCaseImpl): GetNamesOnlyUseCase

    @Binds
    @Singleton
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase

}