package com.example.findmeadoctor.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.findmeadoctor.presentation.ui.theme.DarkGreen
import com.example.findmeadoctor.presentation.ui.theme.Orange


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,
    state: MutableState<Boolean> = mutableStateOf(true),

    ) {

    // if show bottom nav bar state is true we show it
    if (state.value){

        val backStackEntry = navController.currentBackStackEntryAsState()

        BottomNavigation(
            modifier = modifier,
            backgroundColor = Color.White,
            elevation = 5.dp,
        ) {
            items.forEach {item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected  ,
                    onClick = { onItemClick(item) },
                    icon = {
                        Column(
                            horizontalAlignment = CenterHorizontally
                        ) {
                            if (selected){
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "",
                                    tint = Orange
                                )
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    color = Orange,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp

                                )
                            }else{
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "",
                                )
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp

                                )
                            }
                        }
                    }
                )
            }
        }
    }

}