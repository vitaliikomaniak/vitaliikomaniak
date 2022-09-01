package com.vitalii.komaniak.hacaton_app.entities

import com.vitalii.komaniak.hacaton_app.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_launcher_background, "Home")
    object Music : NavigationItem("music", R.drawable.ic_launcher_background, "Music")
    object Movies : NavigationItem("movies", R.drawable.ic_launcher_background, "Movies")
    object Books : NavigationItem("books", R.drawable.ic_launcher_background, "Books")
    object Profile : NavigationItem("profile", R.drawable.ic_launcher_background, "Profile")
}