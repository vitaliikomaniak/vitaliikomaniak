package com.vitalii.komaniak.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vitalii.komaniak.components.cards.Card
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.entities.CollectionComponentModel

@Composable
fun GridComponent(collectionComponentModel: CollectionComponentModel, itemClick: (CardModel) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        collectionComponentModel.cards.forEach { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            }, with = 150)
        }
    }
}