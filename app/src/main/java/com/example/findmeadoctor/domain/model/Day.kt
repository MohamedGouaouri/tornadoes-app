package com.example.findmeadoctor.domain.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.findmeadoctor.R
data class Day(
    val dayNumber: Int,
    val percentage: Float,
    val weather: WeatherType
)

enum class WeatherType {
    CLOUDY, CLEAR_CLOUDY, PARTLY_CLOUDY, RAINY, SUNNY,
}



val mapDayToResource = mutableMapOf<WeatherType, Int>(
    WeatherType.CLOUDY to  R.drawable.cloudy,
//    WeatherType.CLEAR_CLOUDY to  R.drawable.cl,
    WeatherType.SUNNY to  R.drawable.sunny,
    WeatherType.RAINY to  R.drawable.rainy,
//    WeatherType.CLOUDY to  R.drawable.cloudy,
)