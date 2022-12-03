package com.example.findmeadoctor.domain.model

data class Device(
    val id: Int,
    val name: String,
    val state: DeviceState = DeviceState.OFF,
    val consumeFrom: ConsumptionType,
)


enum class DeviceState{
    ON, OFF
}

enum class ConsumptionType{
    RESERVE, NORMAL
}