package com.vitalii.komaniak.hacaton_app.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun TopBar(title: String, canPop: Boolean, iconClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = if (canPop) {
            {
                IconButton(onClick = { iconClick.invoke() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        }
    )
}