package com.example.smartlamp.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlamp.UiState
import com.example.smartlamp.data.model.BrightnessLevels
import com.example.smartlamp.domain.usecase.brightness.GetCurrentLevelUseCase
import com.example.smartlamp.domain.usecase.brightness.GetLevelsUseCase
import com.example.smartlamp.domain.usecase.brightness.SetLevelUseCase
import com.example.smartlamp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class BrightnessViewModel  @Inject constructor(
    private val getLevelsUseCase: GetLevelsUseCase,
    private val setLevelUseCase: SetLevelUseCase,
    private val getCurrentLevelUseCase: GetCurrentLevelUseCase
): ViewModel() {
    private val _brightnessLevels = MutableLiveData<UiState<BrightnessLevels?>>(UiState.Loading)
    val brightnessLevels: LiveData<UiState<BrightnessLevels?>>
        get() = _brightnessLevels

    private val _currentLevel = MutableLiveData<UiState<Int?>>(UiState.Loading)
    val currentLevel: LiveData<UiState<Int?>>
        get() = _currentLevel

    init {
        loadLevels()
        loadCurrentLevel()
    }

    fun loadLevels() {
        viewModelScope.launch {
            val result = getLevelsUseCase()
            _brightnessLevels.postValue(result.toUiState())
        }
    }

    fun loadCurrentLevel() {
        viewModelScope.launch {
            val result = getCurrentLevelUseCase()
            _currentLevel.postValue(result.toUiState())
        }
    }

    fun setLevel(level: Int) {
        viewModelScope.launch {
            setLevelUseCase(level)
        }
    }
}