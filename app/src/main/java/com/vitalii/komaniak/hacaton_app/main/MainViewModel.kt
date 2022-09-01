package com.vitalii.komaniak.hacaton_app.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase
import com.vitalii.komaniak.hacaton_app.common.TAG
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val loadConfigUseCase: LoadConfigUseCase) : ViewModel() {

    private val viewStateMutable: MutableStateFlow<ViewState<*>> = MutableStateFlow(ViewState.Loading)
    val viewState = viewStateMutable.asStateFlow()

    fun loadConfig(configUrl: String) {
        viewModelScope.launch {
            loadConfigUseCase.invoke(params = configUrl,
                onSuccess = { appConfig ->
                    Log.d(TAG(), ":: config: $appConfig")
                    val entryPoint = appConfig.entryPoint

                    viewStateMutable.value = ViewState.Success(Unit)
                }, onFailure = {
                    Log.d(TAG(), ":: error: ${it.localizedMessage}")
                }
            )
        }
    }
}