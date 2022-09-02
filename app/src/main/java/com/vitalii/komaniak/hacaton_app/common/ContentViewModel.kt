package com.vitalii.komaniak.hacaton_app.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.domain.model.content_compiler.Module
import com.vitalii.komaniak.domain.usecase.LoadContentUseCase
import kotlinx.coroutines.launch

open class ContentViewModel(private val loadContentUseCase: LoadContentUseCase) : ViewModel() {

    suspend fun loadContent(
        contentPath: String,
        onSuccess: (Module) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        loadContentUseCase.invoke(params = contentPath,
            onSuccess = {
                onSuccess.invoke(it)
            }, onFailure = {
                onFailure.invoke(it)
            }
        )
    }

}