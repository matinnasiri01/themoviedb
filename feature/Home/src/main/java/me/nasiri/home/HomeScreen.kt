package me.nasiri.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.until.StateModel
import me.nasiri.core_ui.error.ErrorMessage
import me.nasiri.home.components.CategoriesRow
import me.nasiri.home.components.PreviewSlider

@Composable
fun HomeScreen(state: StateModel<Pair<List<MovieModel>, List<GenreModel>>>) {
    Box(modifier = Modifier.fillMaxSize()) {
        state.data?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                PreviewSlider(list = it.first)
                CategoriesRow(data = it)
            }
        }
        state.error?.let { ErrorMessage(message = it, modifier = Modifier.align(Alignment.Center)) }
        if (state.isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}