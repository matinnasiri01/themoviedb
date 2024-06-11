package me.nasiri.data.datasources

import kotlinx.coroutines.flow.Flow
import me.nasiri.data.model.Genre
import me.nasiri.data.model.Movie
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity

interface MovieDataSources {

    interface Remote {
        suspend fun getMovies(
            page: Int = 1,
            checkFavorite: (Int) -> Boolean?,
            checkGenre: (List<Int>) -> List<GenreEntity>?,
        ): List<MovieEntity>

        suspend fun getGenre(): List<GenreEntity>
    }

    interface Local {
        fun getMovies(): Flow<List<Movie>>
        fun getMovie(id: Int): Movie
        fun getGenres(): List<Genre>
        fun getFavourites(): Flow<List<Movie>>

        suspend fun insertMovies(movies: List<MovieEntity>)
        suspend fun insertGenres(genres: List<GenreEntity>)
        suspend fun updateMovie(movie: Movie)
    }

}