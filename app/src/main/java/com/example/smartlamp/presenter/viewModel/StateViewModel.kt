package com.example.smartlamp.presenter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlamp.UiState
import com.example.smartlamp.domain.usecase.state.GetStateUseCase
import com.example.smartlamp.domain.usecase.state.TurnOffUseCase
import com.example.smartlamp.domain.usecase.state.TurnOnUseCase
import com.example.smartlamp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class StateViewModel @Inject constructor(
    private val getStateUseCase: GetStateUseCase,
    private val turnOnUseCase: TurnOnUseCase,
    private val turnOffUseCase: TurnOffUseCase
): ViewModel() {
    private val _state = MutableLiveData<UiState<Boolean?>>(UiState.Loading)
    val state: LiveData<UiState<Boolean?>>
        get() = _state

    init {
        loadState()
    }

    fun loadState() {
        viewModelScope.launch {
            val result = getStateUseCase()
            _state.postValue(result.toUiState())
        }
    }

    fun changeState(state: Boolean) {
        if (state) {
            turnOn()
        } else {
            turnOff()
        }
    }

    fun turnOn() {
        viewModelScope.launch {
            turnOnUseCase()
        }
    }

    fun turnOff() {
        viewModelScope.launch {
            turnOffUseCase()
        }
    }

}