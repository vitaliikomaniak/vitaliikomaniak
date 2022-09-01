package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.AccessTokenDataSource
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse
import com.vitalii.komaniak.domain.repository.AccessTokenRepository
import com.vitalii.komaniak.domain.repository.PreferencesRepository
import com.vitalii.komaniak.domain.repository.RequestHeadersRepository

class AccessTokenRepositoryImpl(
    private val accessTokenDataSource: AccessTokenDataSource,
    private val preferencesRepository: PreferencesRepository,
    private val requestHeadersRepository: RequestHeadersRepository,
) : AccessTokenRepository {

    override suspend fun requestToken(accessTokenUrl: String) {
        val requestHeaders = requestHeadersRepository.getRequestHeaders()
        val accessTokenResponse =
            accessTokenDataSource.getUnAuthAccessToken(
                authUrl = accessTokenUrl,
                headers = requestHeaders
            )
        storeTokenData(token = accessTokenResponse)
    }

    override suspend fun validateToken(request: suspend () -> Unit) {
        //need to compare requested date and expiration date of the access token
        val expireIn = preferencesRepository.getValue(PreferencesRepository.ACCESS_TOKEN, 0)
        request.invoke()
    }

    override suspend fun storedLocallyTokenExist(): Boolean {
        return preferencesRepository.getValue(PreferencesRepository.ACCESS_TOKEN, "").isNotBlank()
    }

    override suspend fun refreshToken(accessTokenUrl: String) {
        val refreshTokenResponse = accessTokenDataSource.refreshToken(accessTokenUrl, emptyMap())
        storeTokenData(token = refreshTokenResponse)
    }

    override suspend fun clearToken() {
        clearTokenData()
    }

    private fun storeTokenData(token: AccessTokenDataResponse) {
        preferencesRepository.setValue(PreferencesRepository.ACCESS_TOKEN, token.accessToken)
        preferencesRepository.setValue(PreferencesRepository.REFRESH_TOKEN, token.refreshToken)
        preferencesRepository.setValue(PreferencesRepository.EXPIRE_IN, token.expireIn)
        preferencesRepository.setValue(PreferencesRepository.TOKEN_REQUESTED_AT,
            System.currentTimeMillis())
    }

    private fun clearTokenData() {
        preferencesRepository.setValue(PreferencesRepository.ACCESS_TOKEN, "")
        preferencesRepository.setValue(PreferencesRepository.REFRESH_TOKEN, "")
        preferencesRepository.setValue(PreferencesRepository.EXPIRE_IN, 0)
        preferencesRepository.setValue(PreferencesRepository.TOKEN_REQUESTED_AT, 0)
    }
}