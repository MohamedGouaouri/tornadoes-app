package com.example.findmeadoctor.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.findmeadoctor.domain.model.Day
import com.example.findmeadoctor.domain.model.mapDayToResource


@Composable
fun DayChip(
    day: Day
){
    Column(modifier = Modifier
        .padding(vertical = 2.dp, horizontal = 10.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.LightGray),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Day ${day.dayNumber}")

        mapDayToResource[day.weather]?.let { painterResource(id = it) }
            ?.let { Image(painter = it, contentDescription = "", modifier = Modifier.height(40.dp).width(40.dp)) }
        
        Text(text = "${day.percentage} %")
    }
}