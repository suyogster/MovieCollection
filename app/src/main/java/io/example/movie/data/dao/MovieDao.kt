package io.example.movie.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow
import io.example.movie.core.Constants.Companion.MOVIE_TABLE
import io.example.movie.domain.model.Movie
import io.example.movie.domain.repository.Movies

@Dao
interface MovieDao {
    @Query("SELECT * FROM $MOVIE_TABLE ORDER BY id ASC")
    fun getMovies(): Flow<Movies>

    @Query("SELECT * FROM $MOVIE_TABLE WHERE id = :id")
    suspend fun getMovie(id: Int): Movie

    @Insert(onConflict = IGNORE)
    suspend fun addMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}