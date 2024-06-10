package me.nasiri.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.nasiri.network.MovieApiService
import me.nasiri.network.util.Constants.BASE_URL
import me.nasiri.network.util.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().apply { addInterceptor(Interceptor()) }.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApiService::class.java)
    }
}