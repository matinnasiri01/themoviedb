package me.nasiri.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel


@SuppressLint("MutableCollectionMutableState")
@Composable
fun CategoriesRow(data: Pair<List<MovieModel>, List<GenreModel>>, modifier: Modifier = Modifier) {
    val (movies, genres) = data
    val selectedGenres = remember { mutableStateListOf<Int>() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    ) {
        Text(text = "Categories", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        GenreChipsRow(genres, selectedGenres)
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movies) { movie ->
                MoviesRow(item = movie)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreChipsRow(genres: List<GenreModel>, selectedGenres: MutableList<Int>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(genres) { index, genre ->
            FilterChip(selected = selectedGenres.contains(index), onClick = {
                if (selectedGenres.contains(index)) selectedGenres.remove(index)
                else selectedGenres.add(index)

            }, label = { Text(text = genre.name ?: "Null") })
        }
    }
}


@Composable
fun MoviesRow(item: MovieModel, modifier: Modifier = Modifier) {
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
                    .clip(RoundedCornerShape(16.dp)),
                model = item.posterPath,
                loading = { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) },
                contentScale = ContentScale.FillWidth,
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
                    text = item.releaseDate?.dropLast(6) ?: "Null",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        Text(text = item.title ?: "Title", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
