package com.example.bankui

import BottomNavigationItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val items = listOf(
  BottomNavigationItem(
    title = "Home",
    icon = Icons.Rounded.Home
  ) , BottomNavigationItem(
    title = "Wallet",
    icon = Icons.Rounded.Wallet
  )  ,BottomNavigationItem(
    title = "Notifications",
    icon = Icons.Rounded.Notifications
  )  ,BottomNavigationItem(
    title = "Account",
    icon = Icons.Rounded.AccountCircle
  )
)

@Preview
@Composable
fun BottomNavigationBar(){
  NavigationBar {
    Row(
      modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
    ){
      var currentIndex by remember {
        mutableStateOf(0)
      }
      items.forEachIndexed { index, item ->
        NavigationBarItem(
          selected = index == currentIndex,
          onClick = { currentIndex = index},
          icon = {
            Icon(
              imageVector = item.icon
              , contentDescription = item.title,
              tint = MaterialTheme.colorScheme.onBackground
            )

          },
          label = { Text(text = item.title,
            color = MaterialTheme.colorScheme.onBackground) }
          )
      }
    }
  }
}