package me.nasiri.core.data.model

data class MovieCore(
    val id: Int? = null,
    val imdbID: String? = null,
    val title: String? = null,
    val adult: Boolean? = null,
    val status: String? = null,
    val genres: List<GenreCore?>? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val originalLanguage: String? = null,
    val originCountry: List<String?>? = null,
)
