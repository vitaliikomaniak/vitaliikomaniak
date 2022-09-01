package com.vitalii.komaniak.hacaton_app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.vitalii.komaniak.hacaton_app.AppApplication
import com.vitalii.komaniak.hacaton_app.R
import com.vitalii.komaniak.hacaton_app.SetupNavigationGraph
import com.vitalii.komaniak.hacaton_app.states.ViewState
import com.vitalii.komaniak.hacaton_app.di.Injection
import com.vitalii.komaniak.hacaton_app.presentation.components.BottomNavigationBar
import com.vitalii.komaniak.hacaton_app.presentation.components.ListComponent
import com.vitalii.komaniak.hacaton_app.presentation.components.TopBar
import com.vitalii.komaniak.hacaton_app.screens.loading.LoadingScreen
import com.vitalii.komaniak.hacaton_app.ui.theme.AppTheme

const val CONFIG_URL =
    "https://gw.cds.amcn.com/config-cn/api/v1/amcplus-android-settings-ap/public/mobile/v2/content.json"

class MainActivity : ComponentActivity() {

    private val injection: Injection by lazy { (application as AppApplication).getInjection() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = injection.getMainViewModel(owner = this)
        mainViewModel.loadConfig(configUrl = CONFIG_URL)

        setContent {
            val state = mainViewModel.viewState.collectAsState(initial = ViewState.Loading)
            when (state.value) {
                is ViewState.Loading -> {
                    LoadingScreen()
                }
                is ViewState.Success<*> -> {
                    MainScreen()
                }
                is ViewState.Error<*> -> {

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
                bottomBar = { BottomNavigationBar(navController = navController) },
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
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
        ListComponent(cards = emptyList(), itemClick = {
            //no-op
        })
    }
}