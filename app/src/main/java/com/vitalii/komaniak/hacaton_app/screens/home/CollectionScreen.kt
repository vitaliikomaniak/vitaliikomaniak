package com.vitalii.komaniak.hacaton_app.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.vitalii.komaniak.hacaton_app.common.ViewState
//import com.vitalii.komaniak.hacaton_app.components.ListComponent
import com.vitalii.komaniak.hacaton_app.di.AppModule
import com.vitalii.komaniak.hacaton_app.entities.CardsModel

@Composable
fun HomeScreen(
    viewModel: CollectionViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = AppModule.getCollectionViewModelFactory()
    ), cardClick: (CardsModel) -> Unit
) {
    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (state.value) {
        is ViewState.Loading -> {
            LoadingScreen()
            viewModel.onEvent(HomeCollectionsEvent.FetchCollection)
        }
        is ViewState.Success<*> -> {
            HomeContentScreen(
                cardsList = (state.value as ViewState.Success<*>).value as List<CardsModel>,
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
    cardsList: List<CardsModel>,
    viewModel: CollectionViewModel,
    cardClick: (CardsModel) -> Unit
) {
//    ListComponent(cards = cardsList, itemClick = {
//        cardClick.invoke(it)
//    })
}