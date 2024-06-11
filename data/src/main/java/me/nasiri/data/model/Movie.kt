package me.nasiri.data.model

data class Movie(
    val id: Int,
    val adult: Boolean,
    val isFavorite: Boolean,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val backdropPath: String,
    val genres: List<Genre>,
)