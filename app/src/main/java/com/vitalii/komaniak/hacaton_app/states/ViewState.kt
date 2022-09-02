package com.vitalii.komaniak.hacaton_app.states


sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<out T>(val value: T?) : ViewState<T>()
    data class Error(val exception: Throwable) : ViewState<Exception>()
}