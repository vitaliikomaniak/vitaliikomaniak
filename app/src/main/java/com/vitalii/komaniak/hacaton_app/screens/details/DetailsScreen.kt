package com.vitalii.komaniak.hacaton_app.screens.details

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitalii.komaniak.hacaton_app.common.ViewState
import com.vitalii.komaniak.hacaton_app.di.AppModule
import com.vitalii.komaniak.hacaton_app.screens.home.LoadingScreen

@Composable
fun DetailsScreen(viewModel: DetailsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = AppModule.getCollectionViewModelFactory()), onclick: () -> Unit) {

    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (state.value) {
        is ViewState.Loading -> {
            LoadingScreen()
            viewModel.onEvent(DetailsEvent.LoadDetails)
        }
        is ViewState.Success<*> -> {
            //DetailsContentScreen(onclick = onclick)
            Content()
        }
        is ViewState.Error<*> -> {

        }
    }
}

@Composable
fun DetailsContentScreen(onclick: () -> Unit) {
    Button(onClick = {
        onclick.invoke()
    }) {
        Text(text = "Button click")
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Content() {
    Row {
        LazyColumn {
            items(20) { index ->
                Box(
                    modifier = Modifier
                        .dpadFocusable({})
                        .focusable(enabled = true)
                        .size(60.dp)
                        .background(Color.Green)
                ) {
                    Text(text = index.toString(), color = Color.White, fontSize = 22.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            LazyRow {
                items(20) { index ->
                    Box(
                        modifier = Modifier
                            .dpadFocusable({})
                            .focusable(enabled = true)
                            .size(60.dp)
                            .background(Color.Red)
                    ) {
                        Text(text = index.toString(), color = Color.White, fontSize = 22.sp)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow {
                items(20) { index ->
                    Box(
                        modifier = Modifier
                            .dpadFocusable({})
                            .focusable(enabled = true)
                            .size(60.dp)
                            .background(Color.Blue)
                    ) {
                        Text(text = index.toString(), color = Color.White, fontSize = 22.sp)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
fun Modifier.dpadFocusable(
    onClick: () -> Unit,
    borderWidth: Dp = 4.dp,
    unfocusedBorderColor: Color = Color(0x00f39c12),
    focusedBorderColor: Color = Color(0xfff39c12)
) = composed {
    val boxInteractionSource = remember { MutableInteractionSource() }
    val isItemFocused by boxInteractionSource.collectIsFocusedAsState()
    val animatedBorderColor by animateColorAsState(
        targetValue =
        if (isItemFocused) focusedBorderColor
        else unfocusedBorderColor
    )

    this
        .border(
            width = borderWidth,
            color = animatedBorderColor
        )
        .focusable(interactionSource = boxInteractionSource)
}