package com.example.findmeadoctor.presentation.screens

sealed class Routes(val route: String) {
    object DevicesListScreen : Routes("devices_list_screen")
    object DeviceDetailScreen : Routes("device_details_screen")

    object PredictionScreen: Routes("predictions_screen")

    object EnergyCostScreen: Routes("energy_cost_screen")

    object TornadoesSettings: Routes("settings")

}
