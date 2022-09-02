package com.vitalii.komaniak.hacaton_app.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitalii.komaniak.hacaton_app.R
import com.vitalii.komaniak.hacaton_app.di.AppModule
import com.vitalii.komaniak.hacaton_app.screens.error_page.ErrorScreen
import com.vitalii.komaniak.hacaton_app.screens.loading.LoadingScreen
import com.vitalii.komaniak.hacaton_app.states.ViewState

@Composable
fun NavigationScreen(
    viewModel: NavigationViewModel = viewModel(factory = AppModule.getNavigationViewModelFactory(
        context = LocalContext.current)
    ),
    onClickCallback: () -> Unit,
) {

    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (state.value) {
        is ViewState.Loading -> {
            LoadingScreen()
            viewModel.onEvent(NavigationEvent.LoadNavigation)
        }
        is ViewState.Success -> {
            NavigationScreen(onClickCallback = {
                onClickCallback.invoke()
            })
        }
        is ViewState.Error -> {
            val errorMessage = (state.value as ViewState.Error).exception.message ?: stringResource(
                id = R.string.error_message)
            ErrorScreen(errorMessage = errorMessage)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavigationScreen(onClickCallback: () -> Unit) {

}