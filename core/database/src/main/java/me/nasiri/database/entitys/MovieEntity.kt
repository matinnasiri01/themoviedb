package me.nasiri.database.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.database.Genre
import me.nasiri.database.util.Constants.TABLE_MOVIES

@Entity(tableName = TABLE_MOVIES)
data class MovieEntity(
    @PrimaryKey val id: Int? = null,
    val adult: Boolean = false,
    val isFavorite: Boolean = false,
    val title: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val genres: List<Genre> = emptyList(),
)