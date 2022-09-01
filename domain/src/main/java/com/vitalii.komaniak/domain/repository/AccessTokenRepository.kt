package com.vitalii.komaniak.domain.repository

interface AccessTokenRepository {

    suspend fun requestToken(accessTokenUrl: String)

    suspend fun validateToken(request: suspend () -> Unit)

    suspend fun isLocallyStoredTokenValid(): Boolean

    suspend fun refreshToken(accessTokenUrl: String)

    suspend fun clearToken()
}