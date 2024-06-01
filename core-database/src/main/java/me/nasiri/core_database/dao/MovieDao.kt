package me.nasiri.core_database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
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


    @Query("SELECT * FROM $TABLE_MOVIES WHERE id = :id")
    fun getMovieById(id: Int): Flow<MovieModel>


    @Query("SELECT * FROM $TABLE_GENRE")
    fun getAllGenre(): Flow<List<GenreModel>>


    @Query("SELECT * FROM $TABLE_TREND")
    fun getAllTrend(): Flow<List<TrendModel>>

    @Upsert
    suspend fun inMovies(list: List<MovieModel>)

    @Upsert
    suspend fun inGenre(list: List<GenreModel>)

    @Upsert
    suspend fun inTrend(list: List<TrendModel>)

}