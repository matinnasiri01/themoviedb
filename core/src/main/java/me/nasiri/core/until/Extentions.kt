package me.nasiri.core.until

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core_network.MovieApiService
import me.nasiri.core_network.model.MoviesIDDto


fun e(msg: String, tag: String = "ttll") {
    Log.e(tag, msg)
}

suspend fun  <T> List<MoviesIDDto.Result?>?.convert(
    job: suspend CoroutineScope.(Int) -> T,
    remote: MovieApiService
): List<T> {
    return runBlocking {
        this@convert?.mapNotNull {
            try {
                remote.getMovieDetail(movieId = it?.id ?: 0)
                null
            } catch (e: Exception) {
                it?.let { job(it.id!!) }
            }

        }?.toList() ?: emptyList()
    }
}