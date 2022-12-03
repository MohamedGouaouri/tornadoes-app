package com.example.findmeadoctor.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmeadoctor.domain.model.ConsumptionType
import com.example.findmeadoctor.domain.model.Device
import com.example.findmeadoctor.domain.model.DeviceState
import com.example.findmeadoctor.presentation.ui.theme.LightOrange
import com.example.findmeadoctor.presentation.ui.theme.Orange
import com.example.findmeadoctor.R

@Composable
fun DeviceCard(
    device: Device,
    onClick: () -> Unit,
) {

    val context = LocalContext.current
    var on_offToggleState by remember {
        mutableStateOf(device.state == DeviceState.ON)
    }

    val config = LocalConfiguration.current
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightOrange)
            .padding(5.dp)
            .clickable {
                onClick()
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id = if(device.consumeFrom == ConsumptionType.RESERVE) R.drawable.sunny else R.drawable.thunder),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            Switch(checked = on_offToggleState, onCheckedChange = {on_offToggleState = it}, colors = SwitchDefaults.colors(checkedThumbColor = Orange))
        }
        Text(text = device.name, fontSize = 18.sp, color = Color.White)
    }
}