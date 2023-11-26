package io.example.movie.presentation.movies.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import io.example.movie.core.Constants.Companion.MOVIES_SCREEN

@Composable
fun MoviesTopBar() {
    TopAppBar (
        title = {
            Text(
                text = MOVIES_SCREEN
            )
        }
    )
}