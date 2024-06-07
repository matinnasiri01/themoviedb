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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import kotlinx.coroutines.flow.Flow
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel


@SuppressLint("MutableCollectionMutableState")
@Composable
fun CategoriesRow(
    data: Pair<Flow<List<MovieModel>>, List<GenreModel>>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
) {
    val (movies, genres) = data
    val movieList = movies.collectAsState(initial = emptyList()).value
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
            items(if (selectedGenres.isNotEmpty()) movieList.filter { model ->
                selectedGenres.any { it in model.genres.map { id -> id.id } }
            } else movieList) { movie ->
                MoviesRow(item = movie, onClick = onClick)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreChipsRow(genres: List<GenreModel>, list: MutableList<Int>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(genres) { genre ->
            val id = genre.id
            FilterChip(selected = id in list, onClick = {
                if (id in list) list.remove(id) else list.add(id!!)
            }, label = { Text(text = "${genre.name}") })
        }
    }
}


@Composable
fun MoviesRow(item: MovieModel, modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
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
                    .clip(RoundedCornerShape(16.dp)),
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
                    text = item.releaseDate?.dropLast(6) ?: "Null",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                IconButton(onClick = { onClick(item.id!!) }) {
                    Icon(
                        imageVector = if (item.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = if (item.isFavorite) Color.Red else Color.White
                    )
                }
            }
        }
        Text(text = "${item.title}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
