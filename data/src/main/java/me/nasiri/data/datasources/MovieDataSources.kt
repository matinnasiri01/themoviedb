package me.nasiri.data.datasources

import kotlinx.coroutines.flow.Flow
import me.nasiri.database.entity.GenreEntity
import me.nasiri.database.entity.MovieEntity
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.entities.Movie

interface MovieDataSources {

    interface Remote {
        suspend fun getGenre(): Result<List<GenreEntity>>
        suspend fun getMovies(
            page: Int,
            findFav: (Int) -> Boolean?,
            findGenres: (List<Int>) -> List<Genre>?,
        ): Result<List<MovieEntity>>
    }

    interface Local {
        fun getMovies(): Flow<List<Movie>>
        fun getGenres(): List<Genre>
        fun getFavourite(): Flow<List<Movie>>
        fun getMovieById(id: Int): MovieEntity

        suspend fun insertMovies(movies: List<MovieEntity>)
        suspend fun insertGenres(genres: List<GenreEntity>)
        suspend fun updateFavourite(movie: MovieEntity)
    }
}