package me.nasiri.core.data.repository


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.nasiri.core.data.mappers.format
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_network.MovieApiService


class MovieRepositoryImpl(
    private val remote: MovieApiService,
    private val local: MovieDao,
) : MovieRepository {
    override suspend fun fMovies() {
        local.upsertMovies(remote.getAllMovies(page = 1).format { getMovieById(it!!).isFavorite })
    }

    override suspend fun fGenre() {
        local.upsertGenre(remote.getAllGenreList().format())
    }

    override suspend fun getMovieGenre(list: List<Int>): List<GenreModel> {
        return list.map { nId ->
            getGenre().filter { it.id == nId }[0]
        }
    }

    override suspend fun getMovieById(id: Int): MovieModel {
        return local.getMovieById(id = id).format { getMovieGenre(it) }
    }

    override suspend fun getGenre(): List<GenreModel> {
        return local.getGenre().format()
    }

    override suspend fun getMovie(): Flow<List<MovieModel>> {
        return local.getMovies().map { l -> l.map { i -> i.format { getMovieGenre(it) } } }
    }

    override suspend fun updateFavourite(item: MovieModel) {
        local.updateFavorite(item.id!!, item.isFavorite)
    }


    override suspend fun getFavourite(): Flow<List<MovieModel>> {
        return local.getFavoriteMovies().map { l -> l.map { i -> i.format { getMovieGenre(it) } } }
    }
}


