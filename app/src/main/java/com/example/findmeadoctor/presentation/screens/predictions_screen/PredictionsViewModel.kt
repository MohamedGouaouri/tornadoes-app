package com.example.findmeadoctor.presentation.screens.predictions_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.findmeadoctor.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PredictionsViewModel @Inject constructor(): ViewModel() {


    val days = mutableStateOf(listOf<Day>(
        Day(1, .65f, WeatherType.SUNNY),
        Day(2, .15f, WeatherType.RAINY),
        Day(3, .25f, WeatherType.SUNNY),
        Day(4, .62f, WeatherType.RAINY),
        Day(5, .61f, WeatherType.CLOUDY),
    ))

    private val devices = mutableStateOf(listOf(
        Device(
            id = 1,
            name = "machine a laver",
            consumeFrom = ConsumptionType.RESERVE,
            state = DeviceState.ON
        ),
        Device(
            id = 2,
            name = "Smart TV",
            consumeFrom = ConsumptionType.RESERVE,
            state = DeviceState.ON
        ),
        Device(
            id = 3,
            name = "Air conditioner",
            consumeFrom = ConsumptionType.RESERVE,
            state = DeviceState.OFF
        )
    ))

    val predictions = mutableStateOf(listOf(
        Prediction(devices.value[0], "7h"),
        Prediction(devices.value[1], "2h"),
        Prediction(devices.value[2], "30 min")
    ))
}