package com.vitalii.komaniak.hacaton_app.screens.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.domain.usecase.LoadContentUseCase
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NavigationViewModel(private val loadContentUseCase: LoadContentUseCase): ViewModel() {

    private val viewStateMutable: MutableStateFlow<ViewState<*>> =
        MutableStateFlow(ViewState.Loading)
    val viewState = viewStateMutable.asStateFlow()

    fun onEvent(detailsEvent: NavigationEvent) {
        when(detailsEvent) {
            NavigationEvent.LoadNavigation -> loadNavigation()
        }
    }

    private fun loadNavigation() = viewModelScope.launch(Dispatchers.IO) {
        delay(2500)
        viewStateMutable.value = ViewState.Success(Unit)
    }
}