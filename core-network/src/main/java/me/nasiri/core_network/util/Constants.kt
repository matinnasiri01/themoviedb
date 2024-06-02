package me.nasiri.core_network.util

object Constants {

    // SERVICE
    const val BASE_URL = "https://api.themoviedb.org/3/"

    // KEYS
    const val HERDER_KEY =
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YzhmYzExOWI2MjdhNWIxODE4YmUzOGZmY2RiMmVjYyIsInN1YiI6IjY2NTVhMDZmMWQ3OTBlYWQ3NWE4ODdhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2LJ9oWRbBfAaWJb065BzxqGka_4XRKQpBgF5uUvoYBc"


    // ROUTES
    const val GET_MOVIES = "movie/now_playing"
    const val GET_GENRE = "genre/movie/list"
    const val GET_MOVIE_DETAIL = "movie/{movie_id}"

}