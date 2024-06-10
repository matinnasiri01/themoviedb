package me.nasiri.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.database.util.Constants.TABLE_MOVIES
import me.nasiri.domain.entities.Genre

@Entity(tableName = TABLE_MOVIES)
data class MovieEntity(
    @PrimaryKey val id: Int = 0,
    val adult: Boolean = false,
    val isFavorite: Boolean = false,
    val title: String = "",
    val overview: String = "",
    val releaseDate: String = "",
    val posterPath: String = "",
    val backdropPath: String = "",
    val genres: List<Genre> = emptyList(),
)