package com.vitalii.komaniak.components

import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

@Composable
fun TopBar(title: String, canPop: Boolean, iconClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = title, color = colorResource(id = R.color.white)) },
        backgroundColor = colorResource(id = R.color.bg_color),
        navigationIcon = if (canPop) {
            {
                IconButton(onClick = { iconClick.invoke() },) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        } else {
            null
        }
    )
}