package com.vitalii.komaniak.data.common

import java.util.*

class DeviceEnvironmentImpl : Environment {

    override fun getDeviceUUID(): String {
        return UUID.randomUUID().toString()
    }

    override fun getCurrentTime(): Long {
        return System.currentTimeMillis()
    }

    override fun getLanguage(): String {
        return "en"
    }

    override fun getPlatform(): String {
        return "android"
    }
}