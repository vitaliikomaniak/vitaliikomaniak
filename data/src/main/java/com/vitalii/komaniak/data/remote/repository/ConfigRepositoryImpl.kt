package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.mapping.config.AppConfigDataMapper
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.Repository

class ConfigRepositoryImpl(private val configDataSource: DataSource<String, AppConfigResponse>) :
    Repository<String, AppConfig> {

    override suspend fun read(configUrl: String): AppConfig {
        return configDataSource.read(configUrl).let { appConfigResponse ->
            AppConfigDataMapper().convert(appConfigResponse)
        }
    }
}