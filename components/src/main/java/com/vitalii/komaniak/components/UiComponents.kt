package com.vitalii.komaniak.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun HorizontalListComponent(cards: List<CardModel>, itemClick: (CardModel) -> Unit) {
    Text(text = "listTitle", fontSize = 16.sp)
    val state = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = state
    ) {
        items(cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
    }
}

@Composable
fun GridComponent(cards: List<CardModel>, itemClick: (CardModel) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        cards.forEach { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            }, with = 150)
        }
    }
}

@Composable
fun ListComponent(cards: List<CardModel>, itemClick: (CardModel) -> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)
    ) {
        item {
            GridComponent(cards = cards.subList(0, 3), itemClick = itemClick)
        }
        items(cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        items(cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        items(cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        items(cards) { item ->
            Card(cardModel = item, click = {
                itemClick.invoke(item)
            })
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
        item {
            HorizontalListComponent(cards = cards, itemClick = itemClick)
        }
    }
}