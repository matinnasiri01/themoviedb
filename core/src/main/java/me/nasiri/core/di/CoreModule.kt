package me.nasiri.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.nasiri.core.data.repository.MovieRepositoryImpl
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core_database.dao.MovieDao
import me.nasiri.core_network.MovieApiService
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideRepository(remote: MovieApiService, local: MovieDao): MovieRepositoryImpl =
        MovieRepositoryImpl(remote, local)

}