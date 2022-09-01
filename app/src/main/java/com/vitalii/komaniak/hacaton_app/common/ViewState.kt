package com.vitalii.komaniak.hacaton_app.common

import java.lang.Exception

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<out T>(val value: T?) : ViewState<T>()
    data class Error<out T>(val exception: Exception) : ViewState<Exception>()
}