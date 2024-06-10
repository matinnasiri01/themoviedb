package me.nasiri.data.datasources

import me.nasiri.database.Genre
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity

interface MovieDataSources {

    interface Remote {
        suspend fun getMovies(
            page: Int = 1,
            checkFavorite: (Int) -> Boolean?,
            checkGenre: (List<Int>) -> List<Genre>?,
        ): List<MovieEntity>

        suspend fun getGenre(): List<GenreEntity>
    }

    interface Local

}