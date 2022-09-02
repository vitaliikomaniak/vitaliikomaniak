package com.vitalii.komaniak.hacaton_app.screens.collection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitalii.komaniak.components.ListOfListsComponent
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.entities.CollectionComponentModel
import com.vitalii.komaniak.hacaton_app.R
import com.vitalii.komaniak.hacaton_app.states.ViewState
import com.vitalii.komaniak.hacaton_app.di.AppModule
import com.vitalii.komaniak.hacaton_app.screens.error_page.ErrorScreen
import com.vitalii.komaniak.hacaton_app.screens.loading.LoadingScreen

@Composable
fun CollectionScreen(
    viewModel: CollectionViewModel = viewModel(factory = AppModule.getCollectionViewModelFactory(
        context = LocalContext.current)
    ),
    cardClick: (CardModel) -> Unit,
) {
    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (state.value) {
        is ViewState.Loading -> {
            LoadingScreen()
            viewModel.onEvent(CollectionEvent.FetchCollection)
        }
        is ViewState.Success<*> -> {
            CollectionContentScreen(
                cardsList = (state.value as ViewState.Success<*>).value as List<CardModel>,
                cardClick = cardClick
            )
        }
        is ViewState.Error -> {
            val errorMessage = (state.value as ViewState.Error).exception.message ?: stringResource(
                id = R.string.error_message)
            ErrorScreen(errorMessage = errorMessage)
        }
    }
}

@Composable
fun CollectionContentScreen(
    cardsList: List<CardModel>,
    cardClick: (CardModel) -> Unit,
) {
    val listComponentModel = CollectionComponentModel(type = "list", cards = cardsList)
    ListOfListsComponent(listComponentModel = listComponentModel, itemClick = {
        cardClick.invoke(it)
    })
}