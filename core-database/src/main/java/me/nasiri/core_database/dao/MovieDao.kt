package me.nasiri.core_database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import me.nasiri.core_database.Constants.TABLE_GENRE
import me.nasiri.core_database.Constants.TABLE_MOVIES
import me.nasiri.core_database.entity.GenreEntity
import me.nasiri.core_database.entity.MovieEntity

@Dao
interface MovieDao {


    @Query("SELECT * FROM $TABLE_MOVIES WHERE isFavorite = 1")
    suspend fun getFavoriteMovies(): List<MovieEntity>


    @Query("SELECT * FROM $TABLE_MOVIES")
    suspend fun getMovies(): List<MovieEntity>


    @Query("SELECT * FROM $TABLE_MOVIES WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity


    @Query("SELECT * FROM $TABLE_GENRE")
    suspend fun getGenre(): List<GenreEntity>

    @Upsert
    suspend fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    suspend fun upsertGenre(list: List<GenreEntity>)

    @Query("UPDATE $TABLE_MOVIES SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavorite(id: Int, isFavorite: Boolean)
}