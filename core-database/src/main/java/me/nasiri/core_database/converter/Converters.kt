package me.nasiri.core_database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.nasiri.core_database.entity.GenreModel

class Converters {
    @TypeConverter
    fun fromGenreIds(genreIds: List<Int?>?): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenreIds(genreIdsString: String): List<Int?>? {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(genreIdsString, listType)
    }


    @TypeConverter
    fun fromGenreList(value: List<GenreModel?>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toGenreList(value: String): List<GenreModel?>? {
        val listType = object : TypeToken<List<GenreModel?>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringList(value: List<String?>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String?> {
        val listType = object : TypeToken<List<String?>>() {}.type
        return Gson().fromJson(value, listType)
    }

}
