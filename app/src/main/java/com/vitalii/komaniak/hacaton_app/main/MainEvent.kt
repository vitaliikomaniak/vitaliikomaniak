package com.vitalii.komaniak.hacaton_app.main

sealed class MainEvent {
    object LoadStyles: MainEvent()
    object OpenEntrypoint: MainEvent()
}