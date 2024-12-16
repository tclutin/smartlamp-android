package com.example.smartlamp.presenter.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smartlamp.R
import com.example.smartlamp.UiState
import com.example.smartlamp.databinding.FragmentMainBinding
import com.example.smartlamp.di.appComponent
import com.example.smartlamp.di.viewModel.ViewModelFactory
import com.example.smartlamp.presenter.viewModel.BrightnessViewModel
import com.example.smartlamp.presenter.viewModel.ColorViewModel
import com.example.smartlamp.presenter.viewModel.StateViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main), AdapterView.OnItemSelectedListener {

    private val binding: FragmentMainBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val stateViewModel: StateViewModel by viewModels { viewModelFactory }
    private val brightnessViewModel: BrightnessViewModel by viewModels { viewModelFactory }
    private val colorViewModel: ColorViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpListeners()
    }

    private fun setUpObservers() {
        setUpStateObserver()
        setUpBrightnessObserver()
        setUpColorObserver()
    }

    private fun setUpStateObserver() {
        stateViewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is UiState.Success -> {
                    val isChecked = it.value?: false
                    binding.switchState.isChecked = isChecked
                }
                is UiState.Failure -> {
                    showMessage("Лампочка выключена")
                }
                else -> {}
            }
        }
    }

    private fun setUpBrightnessObserver() {
        brightnessViewModel.brightnessLevels.observe(viewLifecycleOwner) {
            when(it) {
                is UiState.Success -> {
                    val minBrightness = it.value?.min ?: 0
                    val maxBrightness = it.value?.max ?: 100

                    binding.seekbar.min = minBrightness
                    binding.seekbar.max = maxBrightness
                }
                is UiState.Failure -> {
                    showMessage("Лампочка выключена")
                }
                else -> {}
            }
        }

        brightnessViewModel.currentLevel.observe(viewLifecycleOwner) {
            when(it) {
                is UiState.Success -> {
                    val level = it.value?: 0
                    binding.seekbar.progress = level
                }
                is UiState.Failure -> {
                    showMessage("Лампочка выключена")
                }
                else -> {}
            }
        }
    }

    private fun setUpColorObserver() {
        colorViewModel.colors.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    val colorList = it.value?: emptyList()
                    val adapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        colorList
                    )

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinner.adapter = adapter
                    binding.spinner.onItemSelectedListener = this

                    setUpCurrentColorObserver(colorList)
                }

                is UiState.Failure -> {
                    showMessage("Лампочка выключена")
                }

                else -> {}
            }
        }

    }

    private fun setUpCurrentColorObserver(colorList: List<String>) {
        colorViewModel.currentColor.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    val currentColor = it.value?.color?: "red"

                    val colorIndex = colorList.indexOf(currentColor)

                    if (colorIndex >= 0) {
                        binding.spinner.setSelection(colorIndex)
                    }
                }

                is UiState.Failure -> {
                    showMessage("Лампочка выключена")
                }

                else -> {}
            }
        }
    }

    private fun setUpListeners() {
        binding.switchState.setOnClickListener {
            val isChecked = binding.switchState.isChecked
            stateViewModel.changeState(isChecked)
        }

        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    brightnessViewModel.setLevel(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        colorViewModel.setColor(binding.spinner.adapter.getItem(position) as String)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

}