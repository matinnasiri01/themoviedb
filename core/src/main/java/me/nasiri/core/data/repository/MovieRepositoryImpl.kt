package me.nasiri.core.data.repository


import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_network.MovieApiService


class MovieRepositoryImpl(
    private val remote: MovieApiService,
    private val local: MovieDao,
) : MovieRepository {
    override suspend fun getMovies() {

    }
}

