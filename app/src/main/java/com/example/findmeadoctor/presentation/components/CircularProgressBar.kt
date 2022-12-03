package com.example.findmeadoctor.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmeadoctor.presentation.ui.theme.Orange

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 18.sp,
    radius: Dp = 80.dp,
    color: Color = Orange,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    message: String = "",
    modifier: Modifier = Modifier
){

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    var currentPercentage = animateFloatAsState(targetValue = if (animationPlayed) percentage else 0f,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            )
        )
    
    LaunchedEffect(key1 = true){
        animationPlayed = true
    }

    
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(radius * 2f),
            contentAlignment = Alignment.Center,
        ){
            Canvas(modifier = Modifier.size(radius * 2f)){
                drawArc(
                    color = color,
                    startAngle = -90f,
                    sweepAngle = -360 * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = "${(currentPercentage.value * number).toInt()} %",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = fontSize
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = message, color = Color.Gray)
    }

}