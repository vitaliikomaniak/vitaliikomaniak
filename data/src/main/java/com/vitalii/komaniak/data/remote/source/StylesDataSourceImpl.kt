package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.api.RestApiClient
import com.vitalii.komaniak.data.remote.model.StylesResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class StylesDataSourceImpl(private val restApiClient: RestApiClient) :
    DataSource<String, Result<StylesResponse>> {

    override suspend fun read(stylesUrl: String): Result<StylesResponse> {
        return try {
            val stylesResponse = restApiClient.get(stylesUrl)
            Result.success(json.decodeFromString(stylesResponse))
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}