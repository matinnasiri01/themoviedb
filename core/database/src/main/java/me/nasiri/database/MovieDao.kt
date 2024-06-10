package me.nasiri.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.database.util.Constants.TABLE_GENRE
import me.nasiri.database.util.Constants.TABLE_MOVIES

@Dao
interface MovieDao {

    // Raed
    @Query("SELECT * FROM $TABLE_MOVIES")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM $TABLE_MOVIES WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("SELECT * FROM $TABLE_MOVIES WHERE isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM $TABLE_GENRE")
    suspend fun getGenre(): List<GenreEntity>

    // Write
    @Upsert
    suspend fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    suspend fun upsertGenre(list: List<GenreEntity>)

    @Query("UPDATE $TABLE_MOVIES SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavorite(id: Int, isFavorite: Boolean)

}