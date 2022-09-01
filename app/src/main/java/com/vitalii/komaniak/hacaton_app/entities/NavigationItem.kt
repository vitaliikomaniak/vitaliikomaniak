package com.vitalii.komaniak.hacaton_app.entities

import com.vitalii.komaniak.hacaton_app.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_launcher_background, "Home")
    object Explore : NavigationItem("explore", R.drawable.ic_launcher_background, "Explore")
    object MyStuff : NavigationItem("mystuff", R.drawable.ic_launcher_background, "MyStuff")
    object Settings : NavigationItem("settings", R.drawable.ic_launcher_background, "Settings")
}