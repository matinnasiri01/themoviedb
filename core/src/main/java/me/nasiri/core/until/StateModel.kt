package me.nasiri.core.until

data class StateModel<T>(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: T? = null,
)
