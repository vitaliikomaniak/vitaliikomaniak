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
    DataSource<String, StylesResponse> {

    override suspend fun read(stylesUrl: String): StylesResponse {
        val stylesResponse = restApiClient.get(stylesUrl)
        return json.decodeFromString(stylesResponse)
    }
}