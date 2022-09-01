package com.vitalii.komaniak.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Base class for a `coroutine` use case.
 */
abstract class UseCase<out Type, in Params>(private val coroutineDispatcher: CoroutineDispatcher) where Type : Any {

    abstract suspend fun run(params: Params): Either<Exception, Type>

    suspend operator fun invoke(
        params: Params,
        onSuccess: (Type) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        val result = run(params)
        coroutineScope {
            launch(coroutineDispatcher) {
                result.fold(
                    failed = { onFailure(it) },
                    succeeded = { onSuccess(it) }
                )
            }
        }
    }
}

