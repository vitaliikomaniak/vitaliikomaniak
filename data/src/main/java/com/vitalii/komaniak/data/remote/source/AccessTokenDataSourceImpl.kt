package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.api.RestApiClient
import com.vitalii.komaniak.data.remote.model.RequestParams
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class AccessTokenDataSourceImpl(private val httpClient: RestApiClient) :
    DataSource<RequestParams, AccessTokenDataResponse> {

    override suspend fun read(input: RequestParams): AccessTokenDataResponse {
        val refreshTokenResponse =
            httpClient.post(url = input.requestUrl, headers = input.headers, requestBody = null)
        return json.decodeFromString(refreshTokenResponse)
    }
}