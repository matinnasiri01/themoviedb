package me.nasiri.data.datasources.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.database.MovieDao
import me.nasiri.database.entity.GenreEntity
import me.nasiri.database.entity.MovieEntity
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.entities.Movie
import me.nasiri.domain.util.runOtherThread
import javax.inject.Inject


class MovieLocalDataSources @Inject constructor(private val movieDao: MovieDao) :
    MovieDataSources.Local {

    override fun getMovies(): Flow<List<Movie>> = movieDao.getMovies().map { it.convert() }
    override fun getGenres(): List<Genre> = runOtherThread { movieDao.getGenre().convert() }
    override fun getMovieById(id: Int): MovieEntity = runOtherThread { movieDao.getMovieById(id) }
    override fun getFavourite(): Flow<List<Movie>> {
        return movieDao.getFavoriteMovies().map { it.convert() }
    }

    override suspend fun insertMovies(movies: List<MovieEntity>) = movieDao.upsertMovies(movies)
    override suspend fun insertGenres(genres: List<GenreEntity>) = movieDao.upsertGenre(genres)
    override suspend fun updateFavourite(movie: MovieEntity) =
        movieDao.updateFavorite(movie.id, movie.isFavorite)

}