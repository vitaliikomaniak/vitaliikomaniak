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
    DataSource<String, Result<AppConfigResponse>> {

    override suspend fun read(configUrl: String): Result<AppConfigResponse> {
        return try {
            val jsonResponse = restApiClient.get(url = configUrl)
            Result.success(json.decodeFromString(jsonResponse))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}