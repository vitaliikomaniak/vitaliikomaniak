package com.vitalii.komaniak.data.remote

import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse

interface AccessTokenDataSource {
    suspend fun getUnAuthAccessToken(authUrl: String)

    suspend fun refreshToken(): AccessTokenDataResponse
}