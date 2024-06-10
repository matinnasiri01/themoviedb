package me.nasiri.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.nasiri.domain.entities.Genre
import javax.inject.Singleton

@Singleton
class Converters {
    @TypeConverter
    fun fromGenreList(genreIds: List<Genre>): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenreList(genreIdsString: String): List<Genre> {
        val listType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(genreIdsString, listType)
    }

}
