package me.nasiri.core.data.model

data class MovieModel(
    val id: Int? = null,
    val title: String? = null,
    val isFavorite: Boolean = false,
    val overview: String? = null,
    val adult: Boolean = false,
    val releaseDate: String? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val originalLanguage: String? = null,
    val genres: List<GenreModel> = emptyList(),
)