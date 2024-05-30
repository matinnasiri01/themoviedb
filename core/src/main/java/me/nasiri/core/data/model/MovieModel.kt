package me.nasiri.core.data.model

data class MovieModel(

    val id: Long? = null,
    val imdbID: String? = null,
    val title: String? = null,
    val tagline: String? = null,
    val adult: Boolean? = null,
    val status: String? = null,
    val overview: String? = null,
    val genres: List<GenreModel?>? = null,
    val releaseDate: String? = null,

    val backdropPath: String? = null,
    val posterPath: String? = null,

    val originalLanguage: String? = null,
    val originCountry: List<String?>? = null,
    val spokenLanguages: List<SpokenLanguage?>? = null,
) {
    data class SpokenLanguage(
        val englishName: String?,
        val iso6391: String?,
        val name: String?,
    )
}
