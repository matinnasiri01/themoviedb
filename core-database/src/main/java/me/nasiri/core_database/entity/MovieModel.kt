package me.nasiri.core_database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.core_database.Constants.TABLE_MOVIES

//@Entity(tableName = TABLE_MOVIES)
data class MovieModel(
    //@PrimaryKey
    val id: Int? = null,
    val imdbID: String? = null,
    val title: String? = null,
    val tagline: String? = null,
    val adult: Boolean? = null,
    val status: String? = null,
    val des: String? = null,
    //@Embedded
    val genres: List<GenreModel?>? = emptyList(),
    val releaseDate: String? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val originalLanguage: String? = null,
    val originCountry: List<String?>? = emptyList(),
    //@Embedded
    val spokenLanguages: List<SpokenLanguage?>? = emptyList(),
)

data class SpokenLanguage(
    val englishName: String? = null,
    val iso6391: String? = null,
    val name: String? = null,
)