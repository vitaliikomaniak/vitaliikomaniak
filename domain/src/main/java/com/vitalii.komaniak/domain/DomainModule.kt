package com.vitalii.komaniak.domain

import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase
import kotlinx.coroutines.Dispatchers

object DomainModule {

    fun getLoadConfigUseCase(configRepository: ConfigRepository): LoadConfigUseCase {
        return LoadConfigUseCase(
            coroutineDispatcher = Dispatchers.IO,
            configRepository = configRepository)
    }
}