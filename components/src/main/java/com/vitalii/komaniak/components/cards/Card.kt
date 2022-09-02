package com.vitalii.komaniak.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vitalii.komaniak.entities.CardModel

@Composable
fun Card(
    cardModel: CardModel,
    click: (String) -> Unit,
    with: Int = 0
) {
    Column(
        modifier = if (with == 0) {
            Modifier.fillMaxWidth()
        }
        else {
            Modifier.width(with.dp)
        }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = cardModel.imageUrl,
            contentDescription = "Some image",
        )
        Text(text = "This is an item title #${cardModel.title}")
        Button(
            onClick = {
                click.invoke("Item ${cardModel.title} clicked!!!")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "click me! #${cardModel.title}")
        }
    }
}