package com.example.findmeadoctor.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.findmeadoctor.domain.model.DeviceState
import com.example.findmeadoctor.domain.model.Prediction


@Composable
fun PredictionCard(
    prediction: Prediction,
    onClick: () -> Unit,
){
    Row(modifier = Modifier
        .padding(vertical = 10.dp)
        .fillMaxWidth()
        .clickable {
            onClick()
        }
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = prediction.device.name)
        Text(text = prediction.prediction, color = Color.Gray)
    }
}