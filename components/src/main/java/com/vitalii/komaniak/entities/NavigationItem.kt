package com.vitalii.komaniak.entities

import com.vitalii.komaniak.components.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_navigation_home, "Home")
    object Explore : NavigationItem("explore", R.drawable.ic_navigation_explore, "Explore")
    object Live : NavigationItem("live", R.drawable.ic_navigation_live, "Live")
    object MyStuff : NavigationItem("mystuff", R.drawable.ic_navigation_my_stuff, "MyStuff")
    object Settings : NavigationItem("settings", R.drawable.ic_navigation_settings, "Settings")
}