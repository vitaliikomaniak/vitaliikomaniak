package com.vitalii.komaniak.hacaton_app.common

sealed class Screen(val screenName: String) {
    object Home: Screen("home")
    object Details: Screen("details")
}

