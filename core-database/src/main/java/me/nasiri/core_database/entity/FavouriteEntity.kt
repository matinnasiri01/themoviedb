package me.nasiri.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.nasiri.core_database.Constants.TABLE_FAVOURITE

@Entity(tableName = TABLE_FAVOURITE)
data class FavouriteEntity(
    val mvTitle: String,
    val mvID: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}