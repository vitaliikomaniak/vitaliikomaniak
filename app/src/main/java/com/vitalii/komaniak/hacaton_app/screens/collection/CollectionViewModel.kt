package com.vitalii.komaniak.hacaton_app.screens.collection

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.hacaton_app.presentation.entities.CardModel
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CollectionViewModel : ViewModel() {

    private val viewStateMutable: MutableStateFlow<ViewState<*>> =
        MutableStateFlow(ViewState.Loading)
    val viewState = viewStateMutable.asStateFlow()

    //State
    private val _state = mutableStateOf(CardModel())
    val state: State<CardModel> = _state

    fun onEvent(event: CollectionEvent) {
        when (event) {
            is CollectionEvent.FetchCollection -> loadData()
        }
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO) {
        delay(2500)
        viewStateMutable.value = ViewState.Success(getCards())
    }

    private fun getCards(): List<CardModel> {
        val cards = mutableListOf<CardModel>()
        (0..20).forEach {
            cards.add(CardModel(
                id = it.inc(),
                title = "Card title #${it.inc()}",
                subtitle = "Card sub title #${it.inc()}",
                imageUrl = "https://www.komar.de/en/media/cms/fileadmin/user_upload/Category/Fototapeten/Marvel/komar-fototapeten-marvel.jpg"
            ))
        }
        return cards
    }
}