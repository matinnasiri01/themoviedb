package me.nasiri.core_database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.nasiri.core_database.Constants.DATABASE_NAME
import me.nasiri.core_database.CoreDatabase
import me.nasiri.core_database.dao.MovieDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): CoreDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = CoreDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideMoviesDao(database: CoreDatabase): MovieDao = database.mvDao

}