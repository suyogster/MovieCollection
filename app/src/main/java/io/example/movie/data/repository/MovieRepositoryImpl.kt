package io.example.movie.data.repository

import io.example.movie.data.dao.MovieDao
import io.example.movie.domain.model.Movie
import io.example.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieDao: MovieDao
) : MovieRepository {
    override fun getMoviesFromRoom() = movieDao.getMovies()

    override suspend fun getMovieFromRoom(id: Int) = movieDao.getMovie(id)

    override suspend fun addMovieToRoom(movie: Movie) = movieDao.addMovie(movie)

    override suspend fun updateMovieInRoom(movie: Movie) = movieDao.updateMovie(movie)

    override suspend fun deleteMovieFromRoom(movie: Movie) = movieDao.deleteMovie(movie)
}