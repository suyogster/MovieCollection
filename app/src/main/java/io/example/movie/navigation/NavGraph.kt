package io.example.movie.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.example.movie.core.Constants.Companion.MOVIE_ID
import io.example.movie.domain.model.Movie
import io.example.movie.navigation.Screen.MoviesScreen
import io.example.movie.navigation.Screen.UpdateMovieScreen
import io.example.movie.presentation.movies.MoviesScreen
import io.example.movie.presentation.update_movie.UpdateMovieScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MoviesScreen.route
    ) {
        composable(
            route = MoviesScreen.route
        ) {
            MoviesScreen(
                navigateToUpdateMovieScreen = { movieId ->
                    navController.navigate(
                        route = "${UpdateMovieScreen.route}/${movieId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateMovieScreen.route}/{$MOVIE_ID}",
            arguments = listOf(
                navArgument(MOVIE_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt(MOVIE_ID) ?: 0
            UpdateMovieScreen(
                movieId = movieId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}