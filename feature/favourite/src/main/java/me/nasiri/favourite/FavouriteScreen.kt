package me.nasiri.favourite

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import me.nasiri.favourite.component.MovieItem

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier, vm: FavouriteViewModel = hiltViewModel(),
    nav: NavHostController,
) {
    val state = vm.state
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) item { CircularProgressIndicator() }
        state.data?.let {
            item {
                Text(
                    text = "Favourite",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            if (it.isEmpty()) {
                item { Text(text = "List Empty") }
            } else {
                items(it) { movie ->
                    MovieItem(
                        data = movie,
                        onClick = { nav.navigate("details/${it}") }) { item -> vm.like(item) }
                }
            }
        }
    }
}