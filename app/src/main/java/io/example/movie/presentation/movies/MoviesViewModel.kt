package io.example.movie.presentation.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.example.movie.core.Constants.Companion.DEFAULT_IMG
import kotlinx.coroutines.launch
import io.example.movie.core.Constants.Companion.EMPTY_STRING
import io.example.movie.domain.model.Movie
import io.example.movie.domain.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repo: MovieRepository
) : ViewModel() {
    var movie by mutableStateOf(Movie(1, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, DEFAULT_IMG, 0f))
        private set
    var openDialog by mutableStateOf(false)

    val movies = repo.getMoviesFromRoom()

    fun getMovie(id: Int) = viewModelScope.launch {
        movie = repo.getMovieFromRoom(id)
    }

    fun addMovie(movie: Movie) = viewModelScope.launch {
        repo.addMovieToRoom(movie)
    }

    fun updateMovie(movie: Movie) = viewModelScope.launch {
        repo.updateMovieInRoom(movie)
    }

    fun deleteMovie(movie: Movie) = viewModelScope.launch {
        repo.deleteMovieFromRoom(movie)
    }

    fun updateTitle(title: String) {
        movie = movie.copy(
            title = title
        )
    }

    fun updateStudio(studio: String) {
        movie = movie.copy(
            studio = studio
        )
    }

    fun updateDescription(description: String) {
        movie = movie.copy(
            description = description
        )
    }

    fun updateImage(url: String) {
        movie = movie.copy(
            image = url
        )
    }

    fun updateRating(rating: Float) {
        movie = movie.copy(
            rating = rating
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}