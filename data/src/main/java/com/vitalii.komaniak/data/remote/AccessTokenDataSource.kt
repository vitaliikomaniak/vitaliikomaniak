package com.vitalii.komaniak.data.remote

interface AccessTokenDataSource {
    suspend fun getUnAuthAccessToken(authUrl: String)
}