package com.vitalii.komaniak.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    fun setValue(keyName: String, value: Any?)

    suspend fun setValueSync(keyName: String, value: Any?)

    suspend fun <T> getValue(key: String, defaultValue: T): T

    fun <T> getValueFlow(key: String, defaultValue: T): Flow<T>

    companion object {
        const val ACCESS_TOKEN = "access_token"
    }
}