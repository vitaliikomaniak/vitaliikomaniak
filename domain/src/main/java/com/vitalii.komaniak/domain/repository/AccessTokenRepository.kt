package com.vitalii.komaniak.domain.repository

import com.vitalii.komaniak.domain.model.content_compiler.AccessToken

interface AccessTokenRepository {

    suspend fun requestToken(accessTokenUrl: String): AccessToken

    suspend fun getValidToken(): String

    suspend fun storedLocallyTokenExist(): Boolean

    suspend fun refreshToken(accessTokenUrl: String) : AccessToken

    suspend fun clearToken()
}