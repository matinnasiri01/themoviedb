package me.nasiri.data.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.domain.model.Genre
import me.nasiri.domain.model.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remote: MovieDataSources.Remote,
    private val local: MovieDataSources.Local,
) : MovieRepository {

    override fun getMovies(): Flow<List<Movie>> = local.getMovies()

    override suspend fun getMovie(id: Int): Movie? = local.getMovie(id)

    override fun getGenres(): List<Genre> = local.getGenres()

    override fun getFavouriteMovies(): Flow<List<Movie>> = local.getFavourites()

    override suspend fun fetchMovies(page: Int) {
        val listOfGenres = remote.getGenre()
        local.insertMovies(
            remote.getMovies(
                page = page,
                cFavourites = { getMovie(id = it)?.isFavorite },
                genres = { list ->
                    list.map { id -> listOfGenres.first { it.id == id } }
                })
        )
    }

    override suspend fun fetchGenres() {
        local.insertGenres(remote.getGenre())
    }

    override suspend fun updateFaivouriteMovies(id: Int) {
        val newMovie = getMovie(id) ?: return
        local.updateMovie(newMovie.copy(isFavorite = !newMovie.isFavorite))
    }
}