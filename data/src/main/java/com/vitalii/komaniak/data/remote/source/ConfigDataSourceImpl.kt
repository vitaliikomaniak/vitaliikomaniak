package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.api.RestApiClient
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class ConfigDataSourceImpl(private val restApiClient: RestApiClient) :
    DataSource<String, AppConfigResponse> {

    override suspend fun read(configUrl: String): AppConfigResponse {
        val jsonResponse = restApiClient.get(url = configUrl)
        return json.decodeFromString(jsonResponse)
    }
}