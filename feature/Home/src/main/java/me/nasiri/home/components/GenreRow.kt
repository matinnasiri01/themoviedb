package me.nasiri.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.nasiri.core.data.model.GenreModel

@Composable
fun GenreRow(list: List<GenreModel>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    ) {
        Text(text = "Genres", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(14.dp))
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) {
                GenreItem(text = it.name ?: "Null")
            }
        }
    }
}


@Composable
fun GenreItem(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(15.dp))
        .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
        .clickable { }
        .padding(horizontal = 14.dp, vertical = 8.dp), contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}