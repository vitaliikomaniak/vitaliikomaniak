package com.vitalii.komaniak.hacaton_app.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {

    private val viewStateMutable: MutableStateFlow<ViewState<*>> =
        MutableStateFlow(ViewState.Loading)
    val viewState = viewStateMutable.asStateFlow()

    fun onEvent(detailsEvent: DetailsEvent) {
        when(detailsEvent) {
            DetailsEvent.LoadDetails -> loadData()
        }
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO) {
        delay(2500)
        viewStateMutable.value = ViewState.Success(Unit)
    }
}