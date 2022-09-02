package com.vitalii.komaniak.hacaton_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vitalii.komaniak.hacaton_app.common.Screen
import com.vitalii.komaniak.hacaton_app.screens.SplashScreen
import com.vitalii.komaniak.hacaton_app.screens.details.DetailsScreen
import com.vitalii.komaniak.hacaton_app.screens.collection.CollectionScreen

@Composable
fun SetupNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Collection.screenName
    ) {
        composable(route = Screen.Collection.screenName) {
            CollectionScreen(cardClick = { itemClick ->
                navController.navigate(route = Screen.Details.screenName)
            })
        }
        composable(route = Screen.Explore.screenName) {
            CollectionScreen(cardClick = { itemClick ->
                navController.navigate(route = Screen.Details.screenName)
            })
        }
        composable(route = Screen.MyStuff.screenName) {
            CollectionScreen(cardClick = { itemClick ->
                navController.navigate(route = Screen.Details.screenName)
            })
        }
        composable(route = Screen.Live.screenName) {
            DetailsScreen(itemClick = {
                navController.navigate(route = Screen.Details.screenName)
            })
        }
        composable(route = Screen.Settings.screenName) {
            DetailsScreen(itemClick = {
                navController.popBackStack()
            })
        }
    }
}