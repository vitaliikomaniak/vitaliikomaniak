package com.vitalii.komaniak.domain.di

import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.domain.repository.Repository
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase
import kotlinx.coroutines.Dispatchers

object DomainModule {

    fun getLoadConfigUseCase(configRepository: Repository<String, AppConfig>): LoadConfigUseCase {
        return LoadConfigUseCase(
            coroutineDispatcher = Dispatchers.IO,
            configRepository = configRepository
        )
    }
}