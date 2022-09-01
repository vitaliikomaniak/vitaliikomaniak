package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.AccessTokenDataSource
import com.vitalii.komaniak.data.remote.api.RestHttpClient
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse

class AccessTokenDataSourceImpl(private val httpClient: RestHttpClient): AccessTokenDataSource {

    override suspend fun getUnAuthAccessToken(authUrl: String) {
        TODO("Not yet implemented")
    }

    override suspend fun refreshToken(): AccessTokenDataResponse {
        TODO("Not yet implemented")
    }
}