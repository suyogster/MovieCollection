package io.example.movie.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.example.movie.data.dao.MovieDao
import io.example.movie.domain.model.Movie
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)
abstract class MovieDb : RoomDatabase() {
    abstract val movieDao: MovieDao
}