package com.example.findmeadoctor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findmeadoctor.presentation.BOTTOM_NAVIGATION_HEIGHT
import com.example.findmeadoctor.presentation.navigation.BottomNavItem
import com.example.findmeadoctor.presentation.navigation.BottomNavigationBar
import com.example.findmeadoctor.presentation.screens.Routes
import com.example.findmeadoctor.presentation.screens.device_details.DeviceDetails
import com.example.findmeadoctor.presentation.screens.devices_list.Home
import com.example.findmeadoctor.presentation.screens.energy_cost.EnergyCost
import com.example.findmeadoctor.presentation.screens.predictions_screen.PredictionsScreen
import com.example.findmeadoctor.presentation.screens.settings.Settings
import com.example.findmeadoctor.presentation.ui.theme.FindMeADoctorTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomBarState = remember {
                mutableStateOf(true)
            }

            FindMeADoctorTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            modifier = Modifier.height(BOTTOM_NAVIGATION_HEIGHT),
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = Routes.DevicesListScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Forecasting",
                                    route = Routes.PredictionScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.cloud_solid_1)
                                ),
                                BottomNavItem(
                                    name = "Cost",
                                    route = Routes.EnergyCostScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.money_check_dollar_solid_1)
                                ),
                                BottomNavItem(
                                    name = "Settings",
                                    route = Routes.TornadoesSettings.route,
                                    icon = Icons.Default.Settings
                                )
                            ),
                            navController =
                            navController,
                            onItemClick = {
                                navController.navigate(it.route){
                                    popUpTo(route = Routes.DevicesListScreen.route)
                                }
                            },
                            state = bottomBarState
                        )
                    }
                ) {
                    NavHost(navController = navController, startDestination = Routes.DevicesListScreen.route){
                        composable(route = Routes.DevicesListScreen.route){
                            Home(navController = navController)
                        }
                        composable(route = Routes.DeviceDetailScreen.route + "/{deviceId}"){
                            DeviceDetails(navController = navController)
                        }
                        composable(route = Routes.PredictionScreen.route){
                            PredictionsScreen(navController = navController)
                        }
                        composable(route = Routes.EnergyCostScreen.route){
                            EnergyCost(navController = navController)
                        }
                        composable(route = Routes.TornadoesSettings.route){
                            Settings()
                        }
                    }
                }
            }
        }
    }
}


