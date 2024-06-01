package me.nasiri.core.data.repository

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.data.model.TrendModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_database.entity.Genre
import me.nasiri.core_network.MovieApiService

class MovieRepositoryImpl(
    private val remote: MovieApiService,
    private val local: MovieDao,
) : MovieRepository {
    override suspend fun getGenre(): List<GenreModel> {
        return emptyList()
    }

    override suspend fun getTrendMovies(): List<TrendModel> {
        return emptyList()
    }

    override suspend fun getMovieList(): List<MovieModel> {
        return emptyList()
    }

    override suspend fun getMovieDetailsById(mvID: Int): MovieModel {
        return MovieModel()
    }

    override suspend fun fetchGenre() {
        local.inGenre(listOf(me.nasiri.core_database.entity.GenreModel(1, "matin")))
    }

    override suspend fun fetchTrendMovies() {

    }

    override suspend fun fetchMovies() {
        local.inMovies(listOf(me.nasiri.core_database.entity.MovieModel(12, genres = listOf(Genre(1,"bitch")))))
    }
}