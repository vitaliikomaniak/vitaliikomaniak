package com.vitalii.komaniak.data.common

fun Any.TAG(): String {
    return this.javaClass.canonicalName
}