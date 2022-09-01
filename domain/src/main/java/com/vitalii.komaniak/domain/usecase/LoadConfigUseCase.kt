package com.vitalii.komaniak.domain.usecase

import com.vitalii.komaniak.domain.model.app_config.AppConfig
import com.vitalii.komaniak.domain.repository.ConfigRepository
import com.vitalii.komaniak.domain.repository.Repository
import com.vitalii.komaniak.domain.usecase.base.Either
import com.vitalii.komaniak.domain.usecase.base.Failure
import com.vitalii.komaniak.domain.usecase.base.Success
import com.vitalii.komaniak.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class LoadConfigUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val configRepository: Repository<String, AppConfig>,
) : UseCase<AppConfig, String>(coroutineDispatcher) {

    override suspend fun run(params: String): Either<Exception, AppConfig> {
        return try {
            val config = configRepository.read(params)
            Success(config)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}