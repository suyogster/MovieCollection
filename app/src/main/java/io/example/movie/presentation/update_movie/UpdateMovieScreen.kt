package io.example.movie.presentation.update_movie

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import io.example.movie.presentation.movies.MoviesViewModel
import io.example.movie.presentation.update_movie.components.UpdateMovieContent
import io.example.movie.presentation.update_movie.components.UpdateMovieTopBar

@Composable
fun UpdateMovieScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    movieId: Int,
    navigateBack: () -> Unit,
) {
    LaunchedEffect(Unit) {
        viewModel.getMovie(movieId)
    }
    Scaffold(
        topBar = {
            UpdateMovieTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateMovieContent(
                padding = padding,
                movie = viewModel.movie,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateStudio = { author ->
                    viewModel.updateStudio(author)
                },
                updateDescription = { description ->
                    viewModel.updateStudio(description)
                },
                updateImage = { url ->
                    viewModel.updateImage(url)
                },
                updateRating = { rating ->
                    viewModel.updateRating(rating)
                },
                updateMovie = { movie ->
                    viewModel.updateMovie(movie)
                },
                navigateBack = navigateBack
            )
        }
    )
}