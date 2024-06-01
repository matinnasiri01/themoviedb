package me.nasiri.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_database.converter.Converters
import me.nasiri.core_database.entity.GenreModel
import me.nasiri.core_database.entity.MovieModel
import me.nasiri.core_database.entity.TrendModel

@Database(
    entities = [
        MovieModel::class,
        GenreModel::class,
        TrendModel::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CoreDatabase : RoomDatabase() {
    abstract val mvDao: MovieDao
}