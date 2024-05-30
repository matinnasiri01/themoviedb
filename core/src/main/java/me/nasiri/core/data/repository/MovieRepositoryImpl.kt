package me.nasiri.core.data.repository

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.format
import me.nasiri.core_network.MovieApiService

class MovieRepositoryImpl(
    private val remote: MovieApiService,
) : MovieRepository {
    override suspend fun getGenre(): List<GenreModel> {
        return remote.getAllGenreList().format()!!
    }
}