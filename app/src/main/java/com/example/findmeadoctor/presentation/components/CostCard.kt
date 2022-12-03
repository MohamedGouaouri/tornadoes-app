package com.example.findmeadoctor.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.findmeadoctor.domain.model.Cost
import com.example.findmeadoctor.domain.model.Prediction

@Composable
fun CostCard(
    cost: Cost,
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

        Text(text = cost.device.name)
        Text(text = "${cost.cost} Euro", color = Color.Gray)
    }
}