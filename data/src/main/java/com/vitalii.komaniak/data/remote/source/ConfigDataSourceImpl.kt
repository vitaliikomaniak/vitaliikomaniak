package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.ConfigDataSource
import com.vitalii.komaniak.data.remote.api.RestHttpClient
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class ConfigDataSourceImpl(private val restApiClient: RestHttpClient): ConfigDataSource {

    override suspend fun loadConfig(configUrl: String): AppConfigResponse {
        val jsonResponse = restApiClient.get(url = configUrl)
        return json.decodeFromString(jsonResponse)
    }
}