package me.nasiri.domain.util

data class State<out T>(
    val isLoading: Boolean = false,
    val error: String? = "Unknown error",
    val data: T? = null,
)
