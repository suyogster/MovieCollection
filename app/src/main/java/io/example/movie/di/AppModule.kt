package io.example.movie.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.example.movie.core.Constants.Companion.MOVIE_TABLE
import io.example.movie.data.dao.MovieDao
import io.example.movie.data.network.MovieDb
import io.example.movie.data.repository.MovieRepositoryImpl
import io.example.movie.domain.repository.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideMovieDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        MovieDb::class.java,
        MOVIE_TABLE
    ).build()

    @Provides
    fun provideMovieDao(
        movieDb: MovieDb
    ) = movieDb.movieDao

    @Provides
    fun provideBookRepository(
        movieDao: MovieDao
    ): MovieRepository = MovieRepositoryImpl(
        movieDao = movieDao
    )
}