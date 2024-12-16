package com.example.smartlamp.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlamp.UiState
import com.example.smartlamp.data.model.Color
import com.example.smartlamp.domain.usecase.color.GetCurrentColorUseCase
import com.example.smartlamp.domain.usecase.color.GetNamesOnlyUseCase
import com.example.smartlamp.domain.usecase.color.SetColorUseCase
import com.example.smartlamp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class ColorViewModel @Inject constructor(
    private val setColorUseCase: SetColorUseCase,
    private val getNamesOnlyUseCase: GetNamesOnlyUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase
) : ViewModel() {
    private val _colors = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    val colors: LiveData<UiState<List<String>?>>
        get() = _colors

    private val _currentColor = MutableLiveData<UiState<Color?>>(UiState.Loading)
    val currentColor: LiveData<UiState<Color?>>
        get() = _currentColor

    init {
        loadColors()
        loadCurrentColor()
    }

    fun loadColors() {
        viewModelScope.launch {
            val result = getNamesOnlyUseCase()
            _colors.postValue(result.toUiState())
        }
    }

    fun loadCurrentColor() {
        viewModelScope.launch {
            val result = getCurrentColorUseCase()
            _currentColor.postValue(result.toUiState())
        }
    }


    fun setColor(color: String) {
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }
}