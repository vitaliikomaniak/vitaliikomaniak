package com.vitalii.komaniak.domain

import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase

object DomainModule {

    fun getLoadConfigUseCase(configRepository: ConfigRepository): LoadConfigUseCase {
        return LoadConfigUseCase(configRepository = configRepository)
    }
}