package com.vitalii.komaniak.hacaton_app.screens.collection

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.vitalii.komaniak.domain.usecase.LoadContentUseCase
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.hacaton_app.common.ContentViewModel
import com.vitalii.komaniak.hacaton_app.states.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CollectionViewModel(private val loadContentUseCase: LoadContentUseCase) :
    ContentViewModel(loadContentUseCase) {

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
        delay(2000)
        viewStateMutable.value = ViewState.Success(getCards())
//        loadContent(contentPath = "path",
//            onSuccess = {
//                viewStateMutable.value = ViewState.Success(getCards())
//            }, onFailure = {
//                Log.d(TAG(), ":: content error: ${it}")
//            }
//        )
    }

    private fun getCards(): List<CardModel> {
        val cards = mutableListOf<CardModel>()
        (0..4).forEach {
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