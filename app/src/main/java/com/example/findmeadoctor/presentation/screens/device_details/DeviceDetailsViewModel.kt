package com.example.findmeadoctor.presentation.screens.device_details
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.findmeadoctor.domain.model.ConsumptionType
import com.example.findmeadoctor.domain.model.Device
import com.example.findmeadoctor.domain.model.DeviceState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DeviceDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var devices = listOf(
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
    )
    private var _state = mutableStateOf<Device?>(null)
    var state = _state


    init {
        savedStateHandle.get<String>("deviceId")?.let { deviceId ->
            val f = devices.filter {
                it.id == deviceId.toInt()
            }
            if (f.isNotEmpty()) {
                state.value =  f[0]
            } else {
                state.value = null
            }
        }
    }


}