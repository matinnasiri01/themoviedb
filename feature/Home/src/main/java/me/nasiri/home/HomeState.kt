package me.nasiri.home

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel

data class HomeState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val data: Pair<List<MovieModel>, List<GenreModel>>? = null,
)