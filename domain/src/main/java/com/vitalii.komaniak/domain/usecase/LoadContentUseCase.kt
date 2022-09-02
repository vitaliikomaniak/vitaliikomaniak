package com.vitalii.komaniak.domain.usecase

import com.vitalii.komaniak.domain.model.content_compiler.Module
import com.vitalii.komaniak.domain.repository.Repository
import com.vitalii.komaniak.domain.usecase.base.Either
import com.vitalii.komaniak.domain.usecase.base.Failure
import com.vitalii.komaniak.domain.usecase.base.Success
import com.vitalii.komaniak.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class LoadContentUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val contentRepository: Repository<String, Module>,
) :
    UseCase<Module, String>(coroutineDispatcher) {

    override suspend fun run(params: String): Either<Exception, Module> {
        return try {
            val config = contentRepository.read(buildBaseUrl(
                tenant = "amcn",
                network = "amcplus",
                path = params)
            )
            Success(config)
        } catch (e: Exception) {
            Failure(e)
        }
    }

    private fun buildBaseUrl(
        tenant: String,
        network: String,
        path: String,
    ): String {
        val baseUrl = "https://gw.cds.amcn.com/content-compiler-cr/api/v1/content/"
        return "$baseUrl$tenant/$network/$path"
    }
}