package com.vitalii.komaniak.data.remote.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.vitalii.komaniak.domain.repository.PreferencesRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val Context.PreferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = "app_data")

class PreferencesRepositoryImpl(val context: Context) : PreferencesRepository {

    private val dataStore = context.PreferenceDataStore

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun setValue(keyName: String, value: Any?) {
        scope.launch {
            setValueSync(keyName, value)
        }
    }

    override suspend fun setValueSync(keyName: String, value: Any?) {
        when (value) {
            is Int -> dataStore.edit { it[intPreferencesKey(keyName)] = value }
            is Long -> dataStore.edit { it[longPreferencesKey(keyName)] = value }
            is Double -> dataStore.edit { it[doublePreferencesKey(keyName)] = value }
            is Float -> dataStore.edit { it[floatPreferencesKey(keyName)] = value }
            is Boolean -> dataStore.edit { it[booleanPreferencesKey(keyName)] = value }
            is String? -> dataStore.edit { it[stringPreferencesKey(keyName)] = value.orEmpty() }
            else -> throw UnsupportedOperationException("Not implemented")
        }
    }


    override fun <T> getValueFlow(key: String, defaultValue: T): Flow<T> {
        val prefKey = getPrefKey(key, defaultValue)
        return dataStore.data.map { (it[prefKey] ?: defaultValue) as T }
    }

    override suspend fun <T> getValue(key: String, defaultValue: T): T {
        return getValueFlow(key, defaultValue).first()
    }

    private fun <T> getPrefKey(key: String, defaultValue: T) = when (defaultValue) {
        is Int -> intPreferencesKey(key)
        is Long -> longPreferencesKey(key)
        is Float -> floatPreferencesKey(key)
        is Double -> doublePreferencesKey(key)
        is Boolean -> booleanPreferencesKey(key)
        is String -> stringPreferencesKey(key)
        is Set<*> -> stringSetPreferencesKey(key)
        else -> throw UnsupportedOperationException("Not implemented")
    }

}