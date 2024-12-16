package com.example.smartlamp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartlamp.di.viewModel.ViewModelFactory
import com.example.smartlamp.di.viewModel.ViewModelKey
import com.example.smartlamp.presenter.viewModel.BrightnessViewModel
import com.example.smartlamp.presenter.viewModel.ColorViewModel
import com.example.smartlamp.presenter.viewModel.StateViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StateViewModel::class)
    fun bindStateViewModel(viewModel: StateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrightnessViewModel::class)
    fun bindBrightnessViewModel(viewModel: BrightnessViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ColorViewModel::class)
    fun bindColorViewModel(viewModel: ColorViewModel): ViewModel
}