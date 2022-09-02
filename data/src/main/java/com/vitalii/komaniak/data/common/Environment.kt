package com.vitalii.komaniak.data.common

interface Environment {

    fun getDeviceUUID(): String

    fun getCurrentTime(): Long
}