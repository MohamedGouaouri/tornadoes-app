package com.example.findmeadoctor.presentation.screens.energy_cost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.findmeadoctor.R
import com.example.findmeadoctor.presentation.BOTTOM_NAVIGATION_HEIGHT
import com.example.findmeadoctor.presentation.components.CircularProgressBar
import com.example.findmeadoctor.presentation.components.CostCard


@Composable
fun EnergyCost(
    navController: NavController,
    viewModel: EnergyCostViewModel = hiltViewModel()
){
    val costs by viewModel.costs

    val configuration = LocalConfiguration.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(configuration.screenHeightDp.dp - BOTTOM_NAVIGATION_HEIGHT)
            .padding(10.dp)
//            .background(Color.Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically

        ) {
            CircularProgressBar(percentage = 0.81f, number = 100, radius = 18.dp, strokeWidth = 2.dp, fontSize = 12.sp)
        }
    
        
        Text(text = "Monthly Energy Cost", fontWeight = FontWeight.Bold, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(28.dp))

//        Graph Here
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            painter = painterResource(id = R.drawable.cost_graph),
            contentDescription = "")

        Column(
//            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Consumption per device", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 10.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                itemsIndexed(costs){index, cost ->
                    CostCard(cost = cost) {
//                    navController.navigate(Routes.DeviceDetailScreen.route + "/${device.id}")
                    }
                    if (index < costs.lastIndex){
                        Divider(color = Color.Gray.copy(alpha = 0.2f), thickness = 1.dp)
                    }
                }

                item {
                    Divider(color = Color.Gray.copy(alpha = 0.2f), thickness = 1.dp)
                }

                item {
                    Row(modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(text = "Total consumed budgets", fontWeight = FontWeight.Bold)
                        Text(text = "${costs.fold(0) { acc, cost -> (acc + cost.cost).toInt() }} Euro", color = Color.Red, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}