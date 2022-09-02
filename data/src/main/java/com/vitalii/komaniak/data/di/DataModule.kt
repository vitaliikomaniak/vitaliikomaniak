package com.vitalii.komaniak.data.di

import android.content.Context
import com.vitalii.komaniak.data.remote.api.RestApiClientImpl
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.mapping.access_token.AccessTokenResponseDataMapper
import com.vitalii.komaniak.data.remote.mapping.content_compiler.ModuleDataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerModule
import com.vitalii.komaniak.data.remote.repository.*
import com.vitalii.komaniak.data.remote.source.AccessTokenDataSourceImpl
import com.vitalii.komaniak.data.remote.source.ConfigDataSourceImpl
import com.vitalii.komaniak.data.remote.source.ContentCompilerDataSourceImpl
import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.model.content_compiler.Module
import com.vitalii.komaniak.domain.repository.AccessTokenRepository
import com.vitalii.komaniak.domain.repository.Repository

object DataModule {

    private val restHttpClient by lazy { RestApiClientImpl() }

    fun getConfigRepository(): Repository<String, AppConfig> {
        return ConfigRepositoryImpl(configDataSource = ConfigDataSourceImpl(restApiClient = restHttpClient))
    }

    fun getContentRepository(context: Context): Repository<String, Module> {
        return ContentCompilerRepositoryImpl(
            accessTokenRepository = getAccessTokenRepository(context),
            requestHeadersRepository = getRequestHeadersRepository(),
            dataMapper = getContentDataMapper(),
            contentCompilerDataSource = ContentCompilerDataSourceImpl(restApiClient = restHttpClient)
        )
    }

    private fun getContentDataMapper(): DataMapper<ContentCompilerModule, Module> {
        return ModuleDataMapper(isTablet = false)
    }

    private fun getAccessTokenRepository(context: Context): AccessTokenRepository {
        return AccessTokenRepositoryImpl(
            accessTokenDataSource = AccessTokenDataSourceImpl(httpClient = restHttpClient),
            preferencesRepository = PreferencesRepositoryImpl(context = context),
            requestHeadersRepository = getRequestHeadersRepository(),
            dataMapper = AccessTokenResponseDataMapper(),
        )
    }

    private fun getRequestHeadersRepository(): Repository<String, Map<String, String>> {
        return RequestHeadersRepositoryImpl()
    }
}