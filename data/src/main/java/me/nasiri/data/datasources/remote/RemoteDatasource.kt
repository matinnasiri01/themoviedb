package me.nasiri.data.datasources.remote

import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.database.Genre
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.network.MovieApiService
import javax.inject.Inject

class RemoteDatasource @Inject constructor(private val api: MovieApiService) :
    MovieDataSources.Remote {

    override suspend fun getMovies(
        page: Int,
        checkFavorite: (Int) -> Boolean?,
        checkGenre: (List<Int>) -> List<Genre>?,
    ): List<MovieEntity> = api.getAllMovies(page = page).convert(checkFavorite, checkGenre)


    override suspend fun getGenre(): List<GenreEntity> = api.getAllGenreList().convert()
}