package me.nasiri.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.data.datasources.local.LocalDataSources
import me.nasiri.data.datasources.remote.RemoteDatasource
import me.nasiri.data.repository.MovieRepositoryImpl
import me.nasiri.database.MovieDao
import me.nasiri.domain.repository.MovieRepository
import me.nasiri.network.MovieApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: MovieApiService): MovieDataSources.Remote =
        RemoteDatasource(api = api)


    @Provides
    @Singleton
    fun provideLocalDataSource(dao: MovieDao): MovieDataSources.Local = LocalDataSources(dao)


    @Provides
    @Singleton
    fun provideMovieRepository(
        remote: MovieDataSources.Remote,
        local: MovieDataSources.Local,
    ): MovieRepository = MovieRepositoryImpl(remote, local)

}