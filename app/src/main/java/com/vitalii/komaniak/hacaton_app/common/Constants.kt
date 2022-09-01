package com.vitalii.komaniak.hacaton_app.common

sealed class Screen(val screenName: String) {
    object Splash: Screen("splash")
    object Collection: Screen("collection")
    object Details: Screen("details")
    object Explore: Screen("explore")
}

