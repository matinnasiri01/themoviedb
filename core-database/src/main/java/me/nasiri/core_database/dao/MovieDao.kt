package me.nasiri.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.nasiri.core_database.Constants.TABLE_GENRE
import me.nasiri.core_database.Constants.TABLE_MOVIES
import me.nasiri.core_database.Constants.TABLE_TREND
import me.nasiri.core_database.entity.GenreModel
import me.nasiri.core_database.entity.MovieModel
import me.nasiri.core_database.entity.TrendModel

@Dao
interface MovieDao {
    @Query("SELECT * FROM $TABLE_MOVIES")
    fun getAllMovies(): Flow<List<MovieModel>>


    @Query("SELECT * FROM $TABLE_GENRE")
    fun getAllGenre(): Flow<List<GenreModel>>


    @Query("SELECT * FROM $TABLE_TREND")
    fun getAllTrend(): Flow<List<TrendModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inMovies(list: List<MovieModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inGenre(list: List<GenreModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inTrend(list: List<TrendModel>)

}