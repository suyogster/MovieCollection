package io.example.movie.navigation

import io.example.movie.core.Constants.Companion.MOVIES_SCREEN
import io.example.movie.core.Constants.Companion.UPDATE_MOVIE_SCREEN

sealed class Screen(val route: String) {
    object MoviesScreen: Screen(MOVIES_SCREEN)
    object UpdateMovieScreen: Screen(UPDATE_MOVIE_SCREEN)
}