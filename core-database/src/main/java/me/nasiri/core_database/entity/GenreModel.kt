package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GenreModel(

    @PrimaryKey
    val id: Int? = null,

    val name: String? = null,
)