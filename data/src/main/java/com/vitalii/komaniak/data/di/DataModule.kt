package com.vitalii.komaniak.data.di

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.api.RestApiClientImpl
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import com.vitalii.komaniak.data.remote.repository.ConfigRepositoryImpl
import com.vitalii.komaniak.data.remote.source.ConfigDataSourceImpl
import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.Repository

object DataModule {

    private val restHttpClient by lazy { RestApiClientImpl() }

    fun getConfigRepository(): Repository<String, AppConfig> {
        return ConfigRepositoryImpl(configDataSource = getConfigDataSource())
    }

    private fun getConfigDataSource(): DataSource<String, AppConfigResponse> {
        return ConfigDataSourceImpl(restApiClient = restHttpClient)
    }
}