package io.example.movie.domain.repository

import kotlinx.coroutines.flow.Flow
import io.example.movie.domain.model.Movie

typealias Movies = List<Movie>

interface MovieRepository {
    fun getMoviesFromRoom(): Flow<Movies>

    suspend fun getMovieFromRoom(id: Int): Movie

    suspend fun addMovieToRoom(movie: Movie)

    suspend fun updateMovieInRoom(movie: Movie)

    suspend fun deleteMovieFromRoom(movie: Movie)
}