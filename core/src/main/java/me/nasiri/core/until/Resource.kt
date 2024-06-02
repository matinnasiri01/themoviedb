package me.nasiri.core.until


sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Loading<T> : Resource<T>(data = null, message = null)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}