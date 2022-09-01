package com.vitalii.komaniak.hacaton_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vitalii.komaniak.hacaton_app.common.Screen
import com.vitalii.komaniak.hacaton_app.di.Injection
import com.vitalii.komaniak.hacaton_app.screens.details.DetailsScreen
import com.vitalii.komaniak.hacaton_app.screens.home.HomeScreen

object Navigator {

    @Composable
    fun getRoute(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.screenName
        ) {
            composable(route = Screen.Home.screenName) {
                HomeScreen(cardClick = { cardsModel ->
                    navController.navigate(route = Screen.Details.screenName)
                })
            }
            composable(route = Screen.Details.screenName) {
                DetailsScreen(onclick = {
                    navController.popBackStack()
                })
            }
        }
    }
}