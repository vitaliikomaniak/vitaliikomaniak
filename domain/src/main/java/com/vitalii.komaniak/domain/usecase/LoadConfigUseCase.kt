package com.vitalii.komaniak.domain.usecase

import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.domain.usecase.base.Either
import com.vitalii.komaniak.domain.usecase.base.Failure
import com.vitalii.komaniak.domain.usecase.base.Success
import com.vitalii.komaniak.domain.usecase.base.UseCase

class LoadConfigUseCase(private val configRepository: ConfigRepository): UseCase<AppConfig, String>() {

    override suspend fun run(params: String): Either<Exception, AppConfig> {
        return try {
            val config = configRepository.loadAppConfig(params)
            Success(config)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}