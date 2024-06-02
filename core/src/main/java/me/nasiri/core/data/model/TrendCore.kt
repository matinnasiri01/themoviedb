package me.nasiri.core.data.model

data class TrendCore(
    val id: Int?,
    val adult: Boolean?,
    val backdropPath: String?,
    val posterPath: String?,
    val genreIds: List<Int?>?,
    val originalTitle: String?,
    val overview: String?,
    val releaseDate: String?,
    val title: String?,
)
