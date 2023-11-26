package io.example.movie.presentation.movies.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.example.movie.core.Constants.Companion.UPDATE_MOVIE_SCREEN

@Composable
fun UpdateIcon(
    updateBook: () -> Unit
) {
    IconButton(
        onClick = updateBook
    ) {
        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = UPDATE_MOVIE_SCREEN,
            Modifier.size(40.dp, 40.dp)
        )
    }
}