package com.vitalii.komaniak.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitalii.komaniak.components.cards.Card
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.entities.CollectionComponentModel

@Composable
fun HorizontalListComponent(listComponentModel: CollectionComponentModel, itemClick: (CardModel) -> Unit) {
    Text(text = "listTitle", fontSize = 16.sp)
    val state = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = state
    ) {
        items(listComponentModel.cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
    }
}