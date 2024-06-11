package me.nasiri.data.datasources

import kotlinx.coroutines.flow.Flow
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.domain.model.Genre
import me.nasiri.domain.model.Movie

interface MovieDataSources {

    interface Remote {
        suspend fun getMovies(
            page: Int, cFavourites: suspend (Int) -> Boolean?,
            genres: suspend (List<Int>) -> List<GenreEntity>?,
        ): List<MovieEntity>

        suspend fun getGenre(): List<GenreEntity>
    }

    interface Local {
        fun getMovies(): Flow<List<Movie>>
        suspend fun getMovie(id: Int): Movie?
        fun getGenres(): List<Genre>
        fun getFavourites(): Flow<List<Movie>>

        suspend fun insertMovies(movies: List<MovieEntity>)
        suspend fun insertGenres(genres: List<GenreEntity>)
        suspend fun updateMovie(movie: Movie)
    }

}