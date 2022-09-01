package com.vitalii.komaniak.hacaton_app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.vitalii.komaniak.components.ListComponent
import com.vitalii.komaniak.hacaton_app.AppApplication
import com.vitalii.komaniak.hacaton_app.Navigator
import com.vitalii.komaniak.hacaton_app.R
import com.vitalii.komaniak.hacaton_app.di.Injection
import com.vitalii.komaniak.hacaton_app.entities.NavigationItem
import com.vitalii.komaniak.hacaton_app.ui.theme.AppForMillionTheme

const val CONFIG_URL = "https://gw.cds.amcn.com/config-cn/api/v1/amcplus-android-settings-ap/public/mobile/v2/content.json"

class MainActivity : ComponentActivity() {

    private lateinit var injection: Injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injection = (application as AppApplication).getInjection()

        val mainViewModel = injection.getMainViewModel(owner = this)
        mainViewModel.loadConfig(configUrl = CONFIG_URL)

        setContent {
            AppForMillionTheme {
                val navController = rememberNavController()
                var canPop by remember { mutableStateOf(false) }
                navController.addOnDestinationChangedListener { controller, _, _ ->
                    canPop = controller.previousBackStackEntry != null
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = Color.White,
                    topBar = { TopBar(canPop = canPop, navController = navController) },
                    bottomBar = { BottomNavigationBar(navController = navController) },
                ) {
                    Box(modifier = Modifier.padding(10.dp)) {
                        Navigator.getRoute(navController = navController)
                    }
                }
            }
        }
    }

    @Composable
    fun TopBar(canPop: Boolean, navController: NavHostController) {
        TopAppBar(
            title = { Text(text = "App title") },
            navigationIcon = if (canPop) {
                {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            } else {
                null
            }
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Music,
        NavigationItem.Movies,
        NavigationItem.Books,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppForMillionTheme {
//        ListComponent(cards = emptyList(), itemClick = {
//            //no-op
//        })
    }
}