package me.nasiri.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import me.nasiri.home.component.Carousel
import me.nasiri.home.component.GenreChipsItem
import me.nasiri.home.component.MovieItem


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = hiltViewModel(),
    nav: NavHostController,
) {
    val homeState = vm.state
    val selectedGenres = remember { mutableStateListOf<Int>() }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item { Spacer(modifier = Modifier.height(16.dp)) }
        if (homeState.isLoading) item { CircularProgressIndicator() }
        homeState.error?.let { error ->
            item {
                Text(text = error)

                Button(onClick = { vm.refreshData() }) {
                    Text(text = "Retry")
                }
            }
        }
        homeState.data?.let { (movies, genres) ->
            item { Carousel(list = movies) { nav.navigate("details/${it}") } }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(genres) { genre ->
                        GenreChipsItem(genre, selectedGenres)
                    }
                }
            }
            item {
                LazyRow {
                    items(
                        movies.filter { model ->
                            if (selectedGenres.isNotEmpty()) selectedGenres.any { it in model.genres.map { id -> id.id } } else true
                        }
                    ) { movie ->
                        MovieItem(
                            item = movie,
                            onClick = { nav.navigate("details/${it}") }) { vm.like(it) }
                    }
                }
            }
        }
    }
}
