package io.example.movie.presentation.movies

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import io.example.movie.presentation.movies.components.AddMovieAlertDialog
import io.example.movie.presentation.movies.components.AddMovieFloatingActionButton
import io.example.movie.presentation.movies.components.MoviesContent
import io.example.movie.presentation.movies.components.MoviesTopBar

@Composable
@ExperimentalMaterialApi
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    navigateToUpdateMovieScreen: (movieId: Int) -> Unit
) {
    val movies by viewModel.movies.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            MoviesTopBar()
        },
        content = { padding ->
            MoviesContent(
                padding = padding,
                movies = movies,
                deleteBook = { book ->
                    viewModel.deleteMovie(book)
                },
                navigateToUpdateMovieScreen = navigateToUpdateMovieScreen
            )
            AddMovieAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addMovie(book)
                }
            )
        },
        floatingActionButton = {
            AddMovieFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}