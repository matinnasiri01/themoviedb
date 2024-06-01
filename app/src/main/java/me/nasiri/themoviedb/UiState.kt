package me.nasiri.themoviedb

/**
 * @param T Return Success
 * @param TT Return Error
 */
sealed class UiState<out T,out TT> {
    data object Loading : UiState<Nothing,Nothing>()
    data class Success<T>(val value: T?) : UiState<T,Nothing>()
    data class Error<TT>(val value: TT?) : UiState<Nothing,TT>()
}