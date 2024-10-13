package com.example.bankui

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankui.data.Card
import com.example.bankui.ui.theme.BlueEnd
import com.example.bankui.ui.theme.BlueStart
import com.example.bankui.ui.theme.GreenEnd
import com.example.bankui.ui.theme.GreenStart
import com.example.bankui.ui.theme.OrangeEnd
import com.example.bankui.ui.theme.OrangeStart
import com.example.bankui.ui.theme.PurpleEnd
import com.example.bankui.ui.theme.PurpleStart

var cardItems = listOf(
  Card(
    cardType = "VISA",
    cardNumber = "3364 3445 6458 4323",
    cardName = "Business",
    balance = 43.564,
    color = getGradient(PurpleStart, PurpleEnd),
  ), Card(
    cardType = "MASTER CARD",
    cardNumber = "3563 3445 2334 3422",
    cardName = "Savings",
    balance = 34.64,
    color = getGradient(BlueStart, BlueEnd),
  ), Card(
    cardType = "VISA",
    cardNumber = "0000 2353 4323 4235",
    cardName = "School",
    balance = 4.64,
    color = getGradient(OrangeStart, OrangeEnd),
  ), Card(
    cardType = "VERVE",
    cardNumber = "5400 3445 2343 4323",
    cardName = "Business",
    balance = 53.54,
    color = getGradient(GreenStart, GreenEnd),
  ),
)


private fun getGradient(
  startColor: Color,
  endColor: Color
): Brush {
  return Brush.horizontalGradient(
    colors = listOf(startColor, endColor)
  )
}

@Preview
@Composable
fun CardSection(){
  LazyRow {
    items(cardItems.size){
      index -> CardItem(index)
    }
  }
}

@Composable
fun CardItem(index: Int){
  var card = cardItems[index]
  var lastItemPadding = 0.dp
  if(index == cardItems.size -1){
    lastItemPadding = 16.dp
  }

  var image = painterResource(id = R.drawable.ic_visa)
  if(card.cardType == "MASTER CARD"){
    image = painterResource(id = R.drawable.ic_mastercard)
  }

  Box(
    modifier = Modifier

      .padding(start = 16.dp, end = lastItemPadding)
  ){
    Column (
      modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(card.color)
        .width(250.dp)
        .height(160.dp)
        .clickable { }
        .padding(vertical = 12.dp, horizontal = 16.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ){
      Image(
        painter = image,
        contentDescription = card.cardName,
        modifier = Modifier.width(60.dp)
        )
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = card.cardName,
        color = Color.White,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = "$ ${card.balance}",
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = card.cardNumber,
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
      )

    }
  }
}