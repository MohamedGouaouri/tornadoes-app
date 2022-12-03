package com.example.findmeadoctor.presentation.screens.predictions_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.findmeadoctor.domain.model.mapDayToResource
import com.example.findmeadoctor.presentation.BOTTOM_NAVIGATION_HEIGHT
import com.example.findmeadoctor.presentation.components.CircularProgressBar
import com.example.findmeadoctor.presentation.components.DayChip
import com.example.findmeadoctor.presentation.components.DeviceCard
import com.example.findmeadoctor.presentation.components.PredictionCard
import com.example.findmeadoctor.presentation.screens.Routes
import com.example.findmeadoctor.presentation.screens.devices_list.DevicesListViewModel

@Composable
fun PredictionsScreen(
    navController: NavController,
    predictionsViewModel: PredictionsViewModel = hiltViewModel()
){
    val predictions by predictionsViewModel.predictions
    val days by predictionsViewModel.days
    val config = LocalConfiguration.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(config.screenHeightDp.dp - BOTTOM_NAVIGATION_HEIGHT)
//        .background(color = GreenWhite)
            .padding(top = 10.dp)
    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)
//        ) {
//            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back", modifier = Modifier.clickable {
//                navController.navigate(Routes.DevicesListScreen.route){
//                    popUpTo(route = Routes.DevicesListScreen.route)
//                }
//            })
//        }
        CircularProgressBar(
            percentage = 0.65f, number = 100, message = "Consumable for 11 more hours")

        Spacer(modifier = Modifier.height(20.dp))


        Column(

        ) {
            Text(text = "5 days weather forecasting", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                days.forEach {day ->
                    DayChip(day)
                }
            }
            Spacer(modifier = Modifier.height(48.dp))
        }

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "My devices", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 10.dp))
            LazyColumn(){
                itemsIndexed(predictions){index, pred ->
                    PredictionCard(prediction = pred) {
//                    navController.navigate(Routes.DeviceDetailScreen.route + "/${device.id}")
                    }
                    if (index < predictions.lastIndex){
                        Divider(color = Color.Gray.copy(alpha = 0.2f), thickness = 1.dp)
                    }
                }
            }
        }
    }
}

