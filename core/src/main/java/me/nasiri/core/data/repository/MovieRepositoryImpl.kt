package me.nasiri.core.data.repository


import me.nasiri.core.data.mappers.format
import me.nasiri.core.data.model.FavouriteModel
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
        local.upsertMovies(remote.getAllMovies(page = 1).format())
    }

    override suspend fun fGenre() {
        local.upsertGenre(remote.getAllGenreList().format())
    }

    override suspend fun getMovieGenre(list: List<Int>): List<GenreModel> {
        return list.map { nId ->
            getGenre().filter { it.id == nId }[0]
        }
    }

    override suspend fun getGenre(): List<GenreModel> {
        return local.getGenre().format()
    }

    override suspend fun getMovie(): List<MovieModel> {
        return local.getMovies().format { getMovieGenre(it) }
    }

    override suspend fun addFavourite(item: FavouriteModel) {
        local.upsertFavourite(item.format())
    }

    override suspend fun removeFavourite(item: FavouriteModel) {
        local.removeFavourite(item.format())
    }

    override suspend fun getFavourite(): List<FavouriteModel> {
        return local.getFavourite().map { it.format() }
    }

}

