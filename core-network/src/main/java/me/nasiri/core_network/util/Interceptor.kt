package me.nasiri.core_network.util

import me.nasiri.core_network.util.Constants.HERDER_KEY
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", HERDER_KEY)
            .build()
        return chain.proceed(request)
    }
}