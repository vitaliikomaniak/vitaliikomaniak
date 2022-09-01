package com.vitalii.komaniak.hacaton_app.common

fun Any.TAG(): String {
    return this.javaClass.canonicalName
}