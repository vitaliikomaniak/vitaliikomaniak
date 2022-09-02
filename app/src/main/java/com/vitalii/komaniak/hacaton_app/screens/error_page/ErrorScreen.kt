package com.vitalii.komaniak.hacaton_app.screens.error_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.vitalii.komaniak.hacaton_app.R

@Composable
fun ErrorScreen(errorMessage: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = com.vitalii.komaniak.components.R.color.bg_color))) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = errorMessage)
        }
    }
}