package com.vitalii.komaniak.hacaton_app.screens.home

sealed class HomeCollectionsEvent {
    object FetchCollection: HomeCollectionsEvent()
}