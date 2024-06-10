package me.nasiri.database.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.database.util.Constants.TABLE_GENRE

@Entity(tableName = TABLE_GENRE)
data class GenreEntity(
    @PrimaryKey val id: Int? = null,
    val name: String? = null,
)