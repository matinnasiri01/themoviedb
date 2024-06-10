package me.nasiri.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.nasiri.database.Genre

class Converters {

    @TypeConverter
    fun fromGenre(genreIds: List<Genre>): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenre(genreIdsString: String): List<Genre> {
        val listType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(genreIdsString, listType)
    }

}
