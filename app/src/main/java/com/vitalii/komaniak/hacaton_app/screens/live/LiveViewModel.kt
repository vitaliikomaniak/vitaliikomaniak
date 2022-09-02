package com.vitalii.komaniak.hacaton_app.screens.live

import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.domain.usecase.LoadContentUseCase
import com.vitalii.komaniak.hacaton_app.common.ContentViewModel
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LiveViewModel(private val loadContentUseCase: LoadContentUseCase) :
    ContentViewModel(loadContentUseCase) {

    private val viewStateMutable: MutableStateFlow<ViewState<*>> =
        MutableStateFlow(ViewState.Loading)
    val viewState = viewStateMutable.asStateFlow()

    fun onEvent(detailsEvent: LiveEvent) {
        when (detailsEvent) {
            LiveEvent.LoadLiveChannels -> loadLiveChannels()
        }
    }

    private fun loadLiveChannels() = viewModelScope.launch(Dispatchers.IO) {
        delay(2500)
        viewStateMutable.value = ViewState.Success(Unit)
    }
}