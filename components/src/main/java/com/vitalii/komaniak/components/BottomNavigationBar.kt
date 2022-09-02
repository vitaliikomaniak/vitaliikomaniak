package com.vitalii.komaniak.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.vitalii.komaniak.entities.NavigationItem

@Composable
fun BottomNavigationBar(navItemClicked: (NavigationItem) -> Unit) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Explore,
        NavigationItem.Live,
        NavigationItem.MyStuff,
        NavigationItem.Settings
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.bg_color),
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = true,
                onClick = {
                    navItemClicked.invoke(item)
                }
            )
        }
    }
}
