package me.nasiri.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import me.nasiri.domain.model.Movie


@Composable
fun MovieItem(
    item: Movie,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
    onLikeClick: (Int) -> Unit,
) {
    Column(
        modifier = modifier
            .width(240.dp)
            .padding(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            SubcomposeAsyncImage(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .height(320.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onClick(item.id) },
                model = item.posterPath,
                loading = { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) },
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.releaseDate.take(4),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                IconButton(onClick = { onLikeClick(item.id) }) {
                    Icon(
                        imageVector = if (item.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = if (item.isFavorite) Color.Red else Color.White
                    )
                }
            }
        }
        Text(text = item.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}