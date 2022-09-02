package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.api.RestApiClient
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import com.vitalii.komaniak.data.remote.model.RequestParams
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class ContentCompilerDataSourceImpl(private val restApiClient: RestApiClient) :
    DataSource<RequestParams, ContentCompilerResponse> {

    override suspend fun read(input: RequestParams): ContentCompilerResponse {
        val jsonResponse = restApiClient.get(url = input.requestUrl)
        return json.decodeFromString(jsonResponse)
    }
}