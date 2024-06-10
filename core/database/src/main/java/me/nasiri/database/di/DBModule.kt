package me.nasiri.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.nasiri.database.CoreDatabase
import me.nasiri.database.MovieDao
import me.nasiri.database.util.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

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