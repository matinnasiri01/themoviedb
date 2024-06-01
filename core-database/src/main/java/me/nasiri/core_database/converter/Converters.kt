package me.nasiri.core_database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.nasiri.core_database.entity.Genre
import me.nasiri.core_database.entity.SpokenLanguage

class Converters {
    @TypeConverter
    fun fromGenreIds(genreIds: List<Int>): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenreIds(genreIdsString: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(genreIdsString, listType)
    }


    @TypeConverter
    fun fromGenreList(value: List<Genre?>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toGenreList(value: String): List<Genre?>? {
        val listType = object : TypeToken<List<Genre?>>() {}.type
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

    @TypeConverter
    fun fromSpokenLanguageList(value: List<SpokenLanguage?>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toSpokenLanguageList(value: String): List<SpokenLanguage?> {
        val listType = object : TypeToken<List<SpokenLanguage?>>() {}.type
        return Gson().fromJson(value, listType)
    }

}
