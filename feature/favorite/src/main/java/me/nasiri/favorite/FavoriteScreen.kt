package me.nasiri.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import me.nasiri.core_ui.error.ErrorMessage
import me.nasiri.core_ui.item.MovieItem


@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel = hiltViewModel()) {
    val state = viewModel.state
    Box(modifier = Modifier.fillMaxSize()) {

        state.data?.let {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item { Text(text = "Favorite") }
                items(it) { i -> MovieItem(i) }
            }
        }
        state.error?.let {
            ErrorMessage(
                message = it,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (state.isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}