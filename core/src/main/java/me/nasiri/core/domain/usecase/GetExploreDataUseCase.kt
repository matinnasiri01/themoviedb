package me.nasiri.core.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.until.Resource
import javax.inject.Inject

class GetExploreDataUseCase @Inject constructor(
    private val repo: MovieRepository,
) {
    operator fun invoke(): Flow<Resource<List<MovieModel>>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(repo.getMovie()))
    }.catch {
        emit(Resource.Error(it.message ?: "Unknown Error"))
    }.flowOn(Dispatchers.IO)
}