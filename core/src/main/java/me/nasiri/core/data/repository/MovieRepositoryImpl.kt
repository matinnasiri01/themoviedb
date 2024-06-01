package me.nasiri.core.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.data.model.TrendModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.until.convert
import me.nasiri.core.until.e
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_network.MovieApiService
import me.nasiri.core_network.model.MoviesIDDto

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

    override suspend fun getMovieList(): List<MoviesIDDto.Result?>? {
        val list = remote.getAllMoviesId(1)
        println("BEFORE SIZE : ${list.results?.size}")
        list.results?.convert(job = {
            println("NOT FOUND 404 : ${list.results?.size}")
            list.results = list.results?.filter { s->s?.id != it }
        }, remote)
        println("AFTER SIZE : ${list.results?.size}")
        return list?.results
    }

    override suspend fun getMovieDetailsById(mvID: Int): MovieModel {
        return MovieModel()
    }

    override suspend fun fetchGenre() {

    }

    override suspend fun fetchTrendMovies() {

    }

    override suspend fun fetchMovies() {

    }
}