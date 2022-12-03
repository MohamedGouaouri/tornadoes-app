package com.example.findmeadoctor.presentation.screens.device_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.findmeadoctor.R
import com.example.findmeadoctor.domain.model.ConsumptionType
import com.example.findmeadoctor.presentation.BOTTOM_NAVIGATION_HEIGHT
import com.example.findmeadoctor.presentation.screens.Routes
import com.example.findmeadoctor.presentation.ui.theme.LightGreen
import com.example.findmeadoctor.presentation.ui.theme.Orange

@Composable
fun DeviceDetails(
    navController: NavController,
    viewModel: DeviceDetailsViewModel = hiltViewModel()
){


    val device by viewModel.state
    val radioOptions = listOf(
        "Auto shutdown if needed",
        "Always ask before shutting down",
        "Never"
    )

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    val configuration = LocalConfiguration.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(configuration.screenHeightDp.dp - BOTTOM_NAVIGATION_HEIGHT)
        .padding(10.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .height((configuration.screenHeightDp * 5/6).dp)
        ) {
            //        Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back", modifier = Modifier.clickable {
                    navController.navigate(Routes.DevicesListScreen.route){
                        popUpTo(route = Routes.DevicesListScreen.route)
                    }
                })
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)

                    ,
                    painter = painterResource(id = R.drawable.television1),
                    contentDescription = "")
                Text(text = device!!.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = if (device!!.consumeFrom == ConsumptionType.NORMAL) "Running on normal electricity" else "Running on solar panels", fontSize = 15.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(25.dp))

            Image(painter = painterResource(id = R.drawable.bars), contentDescription = "bars", modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))

            Spacer(modifier = Modifier.height(48.dp))

            LazyColumn(){
                items(radioOptions) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Text(text = it)
                        RadioButton(
                            selected = (it == selectedOption),
                            onClick = { onOptionSelected(it) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Orange
                            )
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Orange)
            .height(70.dp)
            .clickable {}
            .padding(horizontal = 70.dp, vertical = 20.dp)
            .align(Alignment.BottomCenter)
            .fillMaxWidth()

            ,
            contentAlignment = Alignment.Center

        ){
            Text(text = "Save Changes", color = Color.White)
        }
    }
}

