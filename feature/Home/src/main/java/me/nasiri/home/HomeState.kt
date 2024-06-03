package me.nasiri.home

data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
)