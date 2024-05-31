package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TrendModel(

    @PrimaryKey
    val id: Int? = null,

    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val genreIds: List<Int?>? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val title: String? = null,
)
