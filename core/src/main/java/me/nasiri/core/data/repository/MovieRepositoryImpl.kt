package me.nasiri.core.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import me.nasiri.core.data.mappers.format
import me.nasiri.core_database.entity.*
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_network.MovieApiService


class MovieRepositoryImpl(
    private val remote: MovieApiService,
    private val local: MovieDao,
) : MovieRepository {
    override suspend fun getGenre(): Flow<List<GenreModel>> {
        return local.getAllGenre()
    }

    override suspend fun getTrendMovies(): Flow<List<TrendModel>> {
        return local.getAllTrend()
    }

    override suspend fun getMovieList(): Flow<List<MovieModel>> {
        return local.getAllMovies()
    }

    override suspend fun getMovieDetailsById(mvID: Int): Flow<MovieModel> {
        return local.getMovieById(mvID)
    }


    override suspend fun fetchGenre() {
        val list = remote.getAllGenreList()
        local.inGenre(list.format())
    }

    override suspend fun fetchTrendMovies() {
        val list = remote.getTrendMovies()
        local.inTrend(list.format())
    }

    override suspend fun fetchMovies() {
        val ids = remote.getAllMoviesId().results?.map { it?.id!! }!!
        val getMovieDetail = withContext(Dispatchers.IO) {
            ids.take(9).mapNotNull {
                try {
                    remote.getMovieDetail(it)
                } catch (e: Exception) {
                    null
                }
            }
        }

        local.inMovies(getMovieDetail.map { it.format() })
    }
}


