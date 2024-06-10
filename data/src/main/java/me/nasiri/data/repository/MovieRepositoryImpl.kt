package me.nasiri.data.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.entities.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remote: MovieDataSources.Remote,
    private val local: MovieDataSources.Local,
) : MovieRepository {

    override suspend fun fetchMovies(page: Int) {
        remote.getMovies(page = page, findFav = { null }, findGenres = { null }).onSuccess {
            local.insertMovies(
                it
            )
        }
    }

    override suspend fun fetchGenres() {
        remote.getGenre().onSuccess { local.insertGenres(it) }
    }


    override fun getMovies(): Flow<List<Movie>> = local.getMovies()
    override fun getMovieById(movieId: Int): Movie = local.getMovieById(movieId).convert()
    override fun getGenres(): List<Genre> = local.getGenres()
    override fun getFavorites(): Flow<List<Movie>> = local.getFavourite()


    override suspend fun updateFavourite(movieId: Int) {
        val movieSelected = local.getMovieById(movieId)
        local.updateFavourite(movieSelected.copy(isFavorite = !movieSelected.isFavorite))
    }

}