package me.nasiri.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.nasiri.database.converter.Converters
import me.nasiri.database.entity.GenreEntity
import me.nasiri.database.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
        GenreEntity::class,
    ], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CoreDatabase : RoomDatabase() {
    abstract val mvDao: MovieDao
}