package com.vitalii.komaniak.domain.repository

import com.vitalii.komaniak.domain.model.app_config.AppConfig

interface ConfigRepository {
    suspend fun loadAppConfig(configUrl: String): AppConfig
}