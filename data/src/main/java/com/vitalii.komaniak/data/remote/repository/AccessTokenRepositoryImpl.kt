package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.AccessTokenDataSource
import com.vitalii.komaniak.domain.repository.AccessTokenRepository

class AccessTokenRepositoryImpl(private val accessTokenDataSource: AccessTokenDataSource): AccessTokenRepository {

    override suspend fun requestToken(accessTokenUrl: String) {
    }

    override suspend fun validateToken(request: suspend () -> Unit) {
        //need to compare requested date and expiration date of the access token
        request.invoke()
    }

    override suspend fun isLocallyStoredTokenValid(): Boolean {
        return false
    }

    override suspend fun refreshToken(accessTokenUrl: String) {
        val refreshTokenResponse = accessTokenDataSource.refreshToken(accessTokenUrl, emptyMap())
    }

    override suspend fun clearToken() {
    }
}