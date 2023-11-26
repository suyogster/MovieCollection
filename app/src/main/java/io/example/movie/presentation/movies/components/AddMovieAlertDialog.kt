package io.example.movie.presentation.movies.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import kotlinx.coroutines.job
import io.example.movie.core.Constants.Companion.ADD_BUTTON
import io.example.movie.core.Constants.Companion.ADD_MOVIE
import io.example.movie.core.Constants.Companion.DEFAULT_IMG
import io.example.movie.core.Constants.Companion.STUDIO
import io.example.movie.core.Constants.Companion.MOVIE_TITLE
import io.example.movie.core.Constants.Companion.DISMISS_BUTTON
import io.example.movie.core.Constants.Companion.EMPTY_STRING
import io.example.movie.domain.model.Movie

data class Poster(val label: String, val value: String)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddMovieAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addBook: (movie: Movie) -> Unit
) {
    if (openDialog) {
        var rating by remember { mutableFloatStateOf(1f) }
        var title by remember { mutableStateOf(EMPTY_STRING) }
        var studio by remember { mutableStateOf(EMPTY_STRING) }

        val options = listOf(
            Poster("Poster 1", DEFAULT_IMG),
            Poster("Poster 2", "https://images.unsplash.com/photo-1626814026160-2237a95fc5a0?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            Poster("Poster 3", "https://images.unsplash.com/photo-1536440136628-849c177e76a1?q=80&w=3125&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            Poster("Poster 4", "https://images.unsplash.com/photo-1619164816991-22d393238d8f?q=80&w=3072&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            Poster("Poster 5", "https://images.unsplash.com/photo-1478720568477-152d9b164e26?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
        )
        var expanded by remember { mutableStateOf(false) }
        var selectedImage by remember { mutableStateOf(options[0]) }

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            backgroundColor = Color.LightGray,
            modifier = Modifier.clip(RoundedCornerShape(28.dp)),
            title = {
                Text(
                    text = ADD_MOVIE
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = MOVIE_TITLE
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = studio,
                        onValueChange = { studio = it },
                        placeholder = {
                            Text(
                                text = STUDIO
                            )
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    RatingBar(
                        value = rating,
                        onValueChange = {
                            if (it in 1f..5f)
                                rating = it
                        },
                        onRatingChanged = {},
                        config = RatingBarConfig()
                            .size(48.dp)
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                            readOnly = true,
                            value = selectedImage.label,
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
                                        selectedImage = selectionOption
                                        expanded = false
                                    }
                                ) {
                                    Text(text = selectionOption.label)
                                }
                            }
                        }
                    }

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val movie = Movie(0, title, studio, selectedImage.value, rating )
                        addBook(movie)
                    }
                ) {
                    Text(
                        text = ADD_BUTTON
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = DISMISS_BUTTON
                    )
                }
            }
        )
    }
}