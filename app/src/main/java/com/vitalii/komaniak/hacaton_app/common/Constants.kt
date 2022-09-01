package com.vitalii.komaniak.hacaton_app.common

sealed class Screen(val screenName: String) {

    object Collection: Screen(COLLECTION)
    object Details: Screen(DETAILS)
    object Navigation : Screen(NAVIGATION)
    object Splash : Screen(SPLASH)
    object MemberHome : Screen(TABLE_LIST)
    object Explore : Screen(EXPLORE)
    object Settings : Screen(SETTINGS)
    object Browser : Screen(BROWSER)
    object Guest : Screen(GUEST)
    object Login : Screen(LOGIN)
    object VideoPlayer : Screen(VIDEO_PLAYER)
    object SignUp : Screen(REGISTRATION)

    companion object {
        const val NAVIGATION = "navigation"
        const val COLLECTION = "collection"
        const val DETAILS = "details"
        const val SPLASH = "splash"
        const val TABLE_LIST = "table-list"
        const val EXPLORE = "explore"
        const val SETTINGS = "settings"
        const val BROWSER = "browser"
        const val LOGIN = "login"
        const val GUEST = "guest"
        const val VIDEO_PLAYER = "video-player"
        const val REGISTRATION = "registration"
    }
}

