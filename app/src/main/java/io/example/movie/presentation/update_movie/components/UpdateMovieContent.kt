package io.example.movie.presentation.update_movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import io.example.movie.core.Constants
import io.example.movie.core.Constants.Companion.DEFAULT_IMG
import io.example.movie.core.Constants.Companion.STUDIO
import io.example.movie.core.Constants.Companion.MOVIE_TITLE
import io.example.movie.core.Constants.Companion.UPDATE_BUTTON
import io.example.movie.domain.model.Movie
import io.example.movie.presentation.movies.components.Poster

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpdateMovieContent(
    padding: PaddingValues,
    movie: Movie,
    updateTitle: (title: String) -> Unit,
    updateStudio: (author: String) -> Unit,
    updateImage: (url: String) -> Unit,
    updateRating: (rating: Float) -> Unit,
    updateMovie: (movie: Movie) -> Unit,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val options = listOf(
            Poster("Poster 1", Constants.DEFAULT_IMG),
            Poster(
                "Poster 2",
                "https://images.unsplash.com/photo-1626814026160-2237a95fc5a0?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            Poster(
                "Poster 3",
                "https://images.unsplash.com/photo-1536440136628-849c177e76a1?q=80&w=3125&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            Poster(
                "Poster 4",
                "https://images.unsplash.com/photo-1619164816991-22d393238d8f?q=80&w=3072&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            Poster(
                "Poster 5",
                "https://images.unsplash.com/photo-1478720568477-152d9b164e26?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
        )
        var expanded by remember { mutableStateOf(false) }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(movie.image)
                .crossfade(true)
                .size(800,800)
                .build(),
            "Movie Thumbnail",
            contentScale = ContentScale.Fit,
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = movie.title,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = MOVIE_TITLE
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = movie.studio,
            onValueChange = { studio ->
                updateStudio(studio)
            },
            placeholder = {
                Text(
                    text = STUDIO
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        RatingBar(
            value = movie.rating,
            onValueChange = {
                if (it in 1f..5f)
                    updateRating(it)
            },
            onRatingChanged = {
            },
            config = RatingBarConfig()
                .size(48.dp)
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                readOnly = true,
                value = options.find { it.value == movie.image }?.label ?: "DEFAULT POSTER",
                onValueChange = { },
                label = { Text("Movie Poster") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            updateImage(selectionOption.value)
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption.label)
                    }
                }
            }
        }

        Button(
            onClick = {
                updateMovie(movie)
                navigateBack()
            }
        ) {
            Text(
                text = UPDATE_BUTTON
            )
        }
    }
}