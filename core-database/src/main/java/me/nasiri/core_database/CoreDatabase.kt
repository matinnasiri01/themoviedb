package me.nasiri.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.nasiri.core_database.dao.MovieDao
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
abstract class CoreDatabase : RoomDatabase() {
    abstract val mvDao: MovieDao
}