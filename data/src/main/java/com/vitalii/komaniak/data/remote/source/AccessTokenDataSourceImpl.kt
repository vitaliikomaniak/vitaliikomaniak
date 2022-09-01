package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.AccessTokenDataSource
import com.vitalii.komaniak.data.remote.api.RestHttpClient
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

class AccessTokenDataSourceImpl(private val httpClient: RestHttpClient) : AccessTokenDataSource {

    override suspend fun getUnAuthAccessToken(
        authUrl: String,
        headers: Map<String, String>,
    ): AccessTokenDataResponse {
        val unAuthTokenResponse =
            httpClient.post(url = authUrl, headers = headers, requestBody = null)
        return json.decodeFromString(unAuthTokenResponse)
    }

    override suspend fun refreshToken(
        refreshTokenUrl: String,
        headers: Map<String, String>,
    ): AccessTokenDataResponse {
        val refreshTokenResponse =
            httpClient.post(url = refreshTokenUrl, headers = headers, requestBody = null)
        return json.decodeFromString(refreshTokenResponse)
    }
}