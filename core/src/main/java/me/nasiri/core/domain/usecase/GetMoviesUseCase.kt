package me.nasiri.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.until.Resource
import me.nasiri.core_database.entity.MovieEntity
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repo: MovieRepository,
) {
    operator fun invoke(): Flow<Resource<List<MovieEntity>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repo.getMovie()
            if (data.isEmpty()) emit(Resource.Error(message = "No Data Found"))
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "UnKnown Error"))
        } catch (io: IOException) {
            emit(Resource.Error(io.localizedMessage ?: "IO Error"))
        }
    }
}