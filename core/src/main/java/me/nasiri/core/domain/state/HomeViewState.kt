package me.nasiri.core.domain.state

import me.nasiri.core.data.model.MovieCore
import me.nasiri.core.data.model.TrendCore
import me.nasiri.core_database.entity.Genre

data class HomeViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: MainData? = null,
) {
    data class MainData(
        val genre: List<Genre>,
        val trendList: List<TrendCore>,
        val movies: List<MovieCore>,
    )
}


