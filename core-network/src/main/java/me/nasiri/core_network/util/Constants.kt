package me.nasiri.core_network.util

object Constants {

    // SERVICE
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMDB_URL = "https://haji-api.ir/imdb/"
    const val BASE_IMAGE = "https://image.tmdb.org/t/p/original"

    // KEYS
    const val HERDER_KEY =
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YzhmYzExOWI2MjdhNWIxODE4YmUzOGZmY2RiMmVjYyIsInN1YiI6IjY2NTVhMDZmMWQ3OTBlYWQ3NWE4ODdhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2LJ9oWRbBfAaWJb065BzxqGka_4XRKQpBgF5uUvoYBc"

    const val HAJI_API_KEY = "2DV8ZGYnRg0HairVHOR7yDdZMRHI0qwWu0uAD1shTMlYA"

    // ROUTES
    const val GET_MOVIEID = "movie/changes"
    const val GET_GENRE = "genre/movie/list"
    const val GET_MOVIES_DETAIL = "movie/{movie_id}"
    const val GET_TREND_MOVIES = "trending/movie/{time_window}"

    const val GET_IMDB_DETAIL = "imdb/"
}