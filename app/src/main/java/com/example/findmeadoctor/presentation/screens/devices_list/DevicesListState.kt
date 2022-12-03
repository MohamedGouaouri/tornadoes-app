package com.example.findmeadoctor.presentation.screens.devices_list

import com.example.findmeadoctor.domain.model.Device

data class DevicesListState(
    val isLoading: Boolean = false,
    val devices: List<Device> = emptyList(),
    // If we add configs than we should get the initial value from the config store
    val isRefreshing: Boolean = false
)