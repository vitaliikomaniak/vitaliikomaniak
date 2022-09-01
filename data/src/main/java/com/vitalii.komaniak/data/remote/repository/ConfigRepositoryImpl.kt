package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.data.remote.ConfigDataSource
import com.vitalii.komaniak.data.remote.mappers.config.AppConfigDataMapper
import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.Repository

class ConfigRepositoryImpl(private val configDataSource: ConfigDataSource): Repository<String, AppConfig> {

//    override suspend fun loadAppConfig(configUrl: String): AppConfig {
//        return configDataSource.loadConfig(configUrl).let { appConfigResponse ->
//            AppConfigDataMapper().convert(appConfigResponse)
//        }
//    }

    override suspend fun create(input: String) {
        TODO("Not yet implemented")
    }

    override suspend fun read(configUrl: String): AppConfig {
        return configDataSource.loadConfig(configUrl).let { appConfigResponse ->
            AppConfigDataMapper().convert(appConfigResponse)
        }
    }

    override suspend fun update(input: String) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(input: String) {
        TODO("Not yet implemented")
    }
}