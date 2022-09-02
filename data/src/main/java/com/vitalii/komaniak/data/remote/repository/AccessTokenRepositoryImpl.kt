package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.RequestParams
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse
import com.vitalii.komaniak.domain.model.content_compiler.AccessToken
import com.vitalii.komaniak.domain.repository.AccessTokenRepository
import com.vitalii.komaniak.domain.repository.PreferencesRepository
import com.vitalii.komaniak.domain.repository.Repository

class AccessTokenRepositoryImpl(
    private val accessTokenDataSource: DataSource<RequestParams, AccessTokenDataResponse>,
    private val preferencesRepository: PreferencesRepository,
    private val requestHeadersRepository: Repository<String, Map<String, String>>,
    private val dataMapper: DataMapper<AccessTokenDataResponse, AccessToken>,
) : AccessTokenRepository {

    override suspend fun requestToken(accessTokenUrl: String): AccessToken {
        val requestHeaders = requestHeadersRepository.read("android")
        val accessTokenResponse =
            accessTokenDataSource.read(input = RequestParams(
                requestUrl = accessTokenUrl,
                headers = requestHeaders)
            )
        return dataMapper.convert(accessTokenResponse).also {
            storeTokenData(token = it)
        }
    }

    override suspend fun getValidToken(): String {
        val expireIn = preferencesRepository.getValue(PreferencesRepository.ACCESS_TOKEN, 0)
        val token = preferencesRepository.getValue(PreferencesRepository.ACCESS_TOKEN, "")
        if (isTokenExpired(expireIn)) {
            val refreshTokenResponse = refreshToken("")

        } else {

        }
        return token
    }

    override suspend fun storedLocallyTokenExist(): Boolean {
        return preferencesRepository.getValue(PreferencesRepository.ACCESS_TOKEN, "").isNotBlank()
    }

    override suspend fun refreshToken(accessTokenUrl: String): AccessToken {
        val refreshTokenResponse = accessTokenDataSource.read(input = RequestParams(
            requestUrl = accessTokenUrl,
            headers = emptyMap())
        )
        return dataMapper.convert(refreshTokenResponse).also {
            storeTokenData(token = it)
        }
    }

    override suspend fun clearToken() {
        clearTokenData()
    }

    private fun storeTokenData(token: AccessToken) {
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

    private fun isTokenExpired(expireIn: Int): Boolean {
        return false
    }
}