package me.nasiri.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.database.util.Constants.TABLE_GENRE

@Entity(tableName = TABLE_GENRE)
data class GenreEntity(
    @PrimaryKey val id: Int = 0,
    val name: String = "",
)