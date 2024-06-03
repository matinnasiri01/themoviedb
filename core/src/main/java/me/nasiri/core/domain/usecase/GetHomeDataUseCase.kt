package me.nasiri.core.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.until.Resource
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repo: MovieRepository,
) {
    operator fun invoke(): Flow<Resource<Pair<List<MovieModel>, List<GenreModel>>>> = flow {
        emit(Resource.Loading())

        val movies = repo.getMovie().ifEmpty {
            repo.fMovies()
            repo.getMovie()
        }
        val genres = repo.getGenre()
        emit(Resource.Success(Pair(movies, genres)))
    }.catch {
        emit(Resource.Error(it.message ?: "Unknown Error"))
    }.flowOn(Dispatchers.IO)
}