package com.vitalii.komaniak.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vitalii.komaniak.components.cards.Card
import com.vitalii.komaniak.entities.CardModel
import com.vitalii.komaniak.entities.CollectionComponentModel

@Composable
fun ListOfListsComponent(listComponentModel: CollectionComponentModel, itemClick: (CardModel) -> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)
    ) {
        items(listComponentModel.cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(listComponentModel = listComponentModel, itemClick = itemClick)
        }
        items(listComponentModel.cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(listComponentModel = listComponentModel, itemClick = itemClick)
        }
        items(listComponentModel.cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(listComponentModel = listComponentModel, itemClick = itemClick)
        }
        items(listComponentModel.cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(listComponentModel = listComponentModel, itemClick = itemClick)
        }
    }
}