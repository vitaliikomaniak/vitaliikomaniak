package com.vitalii.komaniak.hacaton_app.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.vitalii.komaniak.components.BottomNavigationBar
import com.vitalii.komaniak.components.ListOfListsComponent
import com.vitalii.komaniak.components.TopBar
import com.vitalii.komaniak.entities.CollectionComponentModel
import com.vitalii.komaniak.hacaton_app.AppApplication
import com.vitalii.komaniak.hacaton_app.R
import com.vitalii.komaniak.hacaton_app.SetupNavigationGraph
import com.vitalii.komaniak.hacaton_app.common.TAG
import com.vitalii.komaniak.hacaton_app.states.ViewState
import com.vitalii.komaniak.hacaton_app.di.Injection
import com.vitalii.komaniak.hacaton_app.screens.SplashScreen
import com.vitalii.komaniak.hacaton_app.screens.error_page.ErrorScreen
import com.vitalii.komaniak.hacaton_app.screens.loading.LoadingScreen
import com.vitalii.komaniak.hacaton_app.ui.theme.AppTheme

const val CONFIG_URL =
    "https://gw.cds.amcn.com/config-cn/api/v1/amcplus-android-settings-ap/public/mobile/v2/content.json"

class MainActivity : ComponentActivity() {

    private val injection: Injection by lazy { (application as AppApplication).getInjection() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = injection.getMainViewModel(owner = this)
        mainViewModel.loadAppConfig(configUrl = CONFIG_URL)

        setContent {
            SplashScreen(splashFinished = {

            })
            val state = mainViewModel.viewState.collectAsState(initial = ViewState.Loading)
            when (state.value) {
                is ViewState.Success<*> -> {
                    MainScreen()
                }
                is ViewState.Loading -> {
                    //LoadingScreen()
                }
                is ViewState.Error -> {
                    val errorMessage = (state.value as ViewState.Error).exception.message ?: stringResource(
                        id = R.string.error_message)
                    ErrorScreen(errorMessage = errorMessage)
                }
            }
        }
    }

    @Composable
    private fun MainScreen() {
        AppTheme {
            val navController = rememberNavController()
            var canPop by remember { mutableStateOf(false) }
            navController.addOnDestinationChangedListener { controller, _, _ ->
                canPop = controller.previousBackStackEntry != null
            }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                backgroundColor = Color.White,
                topBar = {
                    TopBar(
                        title = resources.getString(R.string.app_name),
                        canPop = canPop,
                        iconClick = { navController.navigateUp() })
                },
                bottomBar = {
                    BottomNavigationBar(navItemClicked = { item ->
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
                },
            ) {
                Box(modifier = Modifier.padding(2.dp)) {
                    SetupNavigationGraph(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        ListOfListsComponent(listComponentModel = CollectionComponentModel(type = "list",
            cards = emptyList()), itemClick = {
            //no-op
        })
    }
}