package me.nasiri.data.datasources.remote

import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.network.MovieApiService
import javax.inject.Inject

class RemoteDatasource @Inject constructor(private val api: MovieApiService) :
    MovieDataSources.Remote {

    override suspend fun getMovies(
        page: Int,
        cFavourites: suspend (Int) -> Boolean?,
        genres: suspend (List<Int>) -> List<GenreEntity>?,
    ): List<MovieEntity> =
        api.getAllMovies(page = page).convert(favourites = cFavourites, genres = genres)


    override suspend fun getGenre(): List<GenreEntity> = api.getAllGenreList().convert()
}