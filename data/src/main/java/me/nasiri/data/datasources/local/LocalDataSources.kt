package me.nasiri.data.datasources.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.data.model.Genre
import me.nasiri.data.model.Movie
import me.nasiri.database.MovieDao
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import javax.inject.Inject

class LocalDataSources @Inject constructor(private val dao: MovieDao) : MovieDataSources.Local {
    override fun getMovies(): Flow<List<Movie>> {
        return dao.getMovies().map { it.convert() }
    }

    override fun getMovie(id: Int): Movie {
        return runBlocking { dao.getMovieById(id).convert() }
    }

    override fun getGenres(): List<Genre> = runBlocking { dao.getGenre().convert() }

    override fun getFavourites(): Flow<List<Movie>> {
        return dao.getFavoriteMovies().map { it.convert() }
    }

    override suspend fun insertMovies(movies: List<MovieEntity>) {
        dao.upsertMovies(movies)
    }

    override suspend fun insertGenres(genres: List<GenreEntity>) {
        dao.upsertGenre(genres)
    }

    override suspend fun updateMovie(movie: Movie) {
        dao.updateFavorite(movie.id, movie.isFavorite)
    }
}