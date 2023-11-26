package io.example.movie.presentation.movies.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.example.movie.domain.model.Movie
import io.example.movie.domain.repository.Movies

@Composable
@ExperimentalMaterialApi
fun MoviesContent(
    padding: PaddingValues,
    movies: Movies,
    deleteBook: (movie: Movie) -> Unit,
    navigateToUpdateMovieScreen: (movieId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = movies
        ) { movie ->
            MovieCard(
                movie = movie,
                deleteBook = {
                    deleteBook(movie)
                },
                navigateToUpdateMovieScreen = navigateToUpdateMovieScreen
            )
        }
    }
}