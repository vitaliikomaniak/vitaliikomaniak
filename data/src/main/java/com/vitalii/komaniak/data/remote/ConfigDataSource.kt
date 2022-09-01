package com.vitalii.komaniak.data.remote

import com.vitalii.komaniak.data.remote.model.AppConfigResponse

interface ConfigDataSource {
    suspend fun loadConfig(configUrl: String): AppConfigResponse
}