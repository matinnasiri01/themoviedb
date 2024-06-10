package me.nasiri.data.datasources.remote

import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.mapper.convert
import me.nasiri.database.entity.GenreEntity
import me.nasiri.database.entity.MovieEntity
import me.nasiri.domain.entities.Genre
import me.nasiri.network.MovieApiService
import javax.inject.Inject


class MovieRemoteDataSources @Inject constructor(private val apiService: MovieApiService) :
    MovieDataSources.Remote {
    override suspend fun getGenre(): Result<List<GenreEntity>> {
        return try {
            val response = apiService.getAllGenreList()
            Result.success(response.convert())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMovies(
        page: Int,
        findFav: (Int) -> Boolean?,
        findGenres: (List<Int>) -> List<Genre>?,
    ): Result<List<MovieEntity>> {
        return try {
            val response = apiService.getAllMovies(page = page)
            Result.success(response.convert(findFav = findFav, findGenres = findGenres))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}