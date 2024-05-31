package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.core_database.Constants.TABLE_TREND

// @Entity(tableName = TABLE_TREND)
data class TrendModel(
    // @PrimaryKey
    val id: Int,
    val adult: Boolean = false,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val genreIds: List<Int> = emptyList(),
    val originalTitle: String? = null,
    val des: String? = null,
    val releaseDate: String? = null,
    val title: String? = null,
)