package com.vitalii.komaniak.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    fun setValue(keyName: String, value: Any?)

    suspend fun setValueSync(keyName: String, value: Any?)

    suspend fun <T> getValue(key: String, defaultValue: T): T

    fun <T> getValueFlow(key: String, defaultValue: T): Flow<T>

    companion object {
        const val ACCESS_TOKEN = "access_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val EXPIRE_IN = "expire_in"
        const val TOKEN_REQUESTED_AT = "requested_at"
    }
}