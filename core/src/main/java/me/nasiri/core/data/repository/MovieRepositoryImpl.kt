package me.nasiri.core.data.repository


import me.nasiri.core.data.mappers.format
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_database.entity.FavouriteEntity
import me.nasiri.core_database.entity.GenreEntity
import me.nasiri.core_database.entity.MovieEntity
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

    override suspend fun getMovieGenre(list: List<Int>): List<String> {
        return list.map { nId ->
            local.getGenre().filter { it.id == nId }[0].name.toString()
        }
    }

    override suspend fun getGenre(): List<GenreEntity> {
        return local.getGenre()
    }

    override suspend fun getMovie(): List<MovieEntity> {
        return local.getMovies()
    }

    override suspend fun addFavourite(item: FavouriteEntity) {
        local.upsertFavourite(item)
    }

    override suspend fun removeFavourite(item: FavouriteEntity) {
        local.removeFavourite(item)
    }

    override suspend fun getFavourite(): List<FavouriteEntity> {
        return local.getFavourite()
    }

}

