package me.nasiri.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreen(vm: HomeViewModel = hiltViewModel(), modifier: Modifier) {
    val homeState = vm.state
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
            item {
                LazyRow {
                    items(genres) { item ->
                        Text(text = item.name)
                    }
                }
            }
            items(movies) { item ->
                Text(text = item.title)
            }
        }
    }
}
