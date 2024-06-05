package me.nasiri.explore

import me.nasiri.core.data.model.MovieModel

data class ExploreState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<MovieModel>? = null,
)
