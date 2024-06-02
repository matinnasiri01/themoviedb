package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.core_database.Constants.TABLE_MOVIES

@Entity(tableName = TABLE_MOVIES)
data class MovieEntity(
    @PrimaryKey val id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    val adult: Boolean = false,
    val releaseDate: String? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val originalLanguage: String? = null,
    val genres: List<Int> = emptyList(),
)