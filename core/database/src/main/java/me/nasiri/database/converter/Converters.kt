package me.nasiri.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.nasiri.database.entitys.GenreEntity

class Converters {

    @TypeConverter
    fun fromGenre(genreIds: List<GenreEntity>): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenre(genreIdsString: String): List<GenreEntity> {
        val listType = object : TypeToken<List<GenreEntity>>() {}.type
        return Gson().fromJson(genreIdsString, listType)
    }

}