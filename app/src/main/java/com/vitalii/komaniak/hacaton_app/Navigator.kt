package com.vitalii.komaniak.hacaton_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vitalii.komaniak.hacaton_app.common.Screen
import com.vitalii.komaniak.hacaton_app.screens.SplashScreen
import com.vitalii.komaniak.hacaton_app.screens.details.DetailsScreen
import com.vitalii.komaniak.hacaton_app.screens.home.CollectionScreen

@Composable
fun SetupNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.screenName
    ) {
        composable(route = Screen.Splash.screenName) {
            SplashScreen(navController)
        }
        composable(route = Screen.Collection.screenName) {
            CollectionScreen(cardClick = { cardsModel ->
                navController.navigate(route = Screen.Details.screenName)
            })
        }
        composable(route = Screen.Explore.screenName) {
            CollectionScreen(cardClick = { cardsModel ->
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