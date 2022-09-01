package com.vitalii.komaniak.hacaton_app.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.hacaton_app.common.ViewState
import com.vitalii.komaniak.hacaton_app.di.AppModule
import com.vitalii.komaniak.hacaton_app.presentation.components.ListComponent

@Composable
fun CollectionScreen(
    viewModel: CollectionViewModel = viewModel(factory = AppModule.getCollectionViewModelFactory()),
    cardClick: (CardModel) -> Unit,
) {
    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (state.value) {
        is ViewState.Loading -> {
            LoadingScreen()
            viewModel.onEvent(HomeCollectionsEvent.FetchCollection)
        }
        is ViewState.Success<*> -> {
            HomeContentScreen(
                cardsList = (state.value as ViewState.Success<*>).value as List<CardModel>,
                viewModel = viewModel,
                cardClick = cardClick
            )
        }
        is ViewState.Error<*> -> {

        }
    }
}

@Composable
fun HomeContentScreen(
    cardsList: List<CardModel>,
    viewModel: CollectionViewModel,
    cardClick: (CardModel) -> Unit,
) {
    ListComponent(cards = cardsList, itemClick = {
        cardClick.invoke(it)
    })
}