package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.data.remote.ConfigDataSource
import com.vitalii.komaniak.data.remote.mappers.config.AppConfigDataMapper
import com.vitalii.komaniak.domain.model.app_config.AppConfig

class ConfigRepositoryImpl(private val configDataSource: ConfigDataSource): ConfigRepository {

    override suspend fun loadAppConfig(configUrl: String): AppConfig {
        return configDataSource.loadConfig(configUrl).let { appConfigResponse ->
            AppConfigDataMapper().convert(appConfigResponse)
        }
    }
}