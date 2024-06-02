package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.core_database.Constants.TABLE_GENRE

@Entity(tableName = TABLE_GENRE)
data class GenreEntity(
    @PrimaryKey val id: Int? = null,
    val name: String? = null,
)