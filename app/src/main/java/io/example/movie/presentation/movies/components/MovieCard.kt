package io.example.movie.presentation.movies.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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
import io.example.movie.domain.model.Movie

@Composable
@ExperimentalMaterialApi
fun MovieCard(
    movie: Movie,
    deleteBook: () -> Unit,
    navigateToUpdateMovieScreen: (movieId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 12.dp
            )
            .fillMaxWidth(),
        elevation = 6.dp,
        onClick = {
//            navigateToUpdateMovieScreen(movie.id)
        }
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.image)
                    .crossfade(true)
                    .size(500, 500)
                    .build(),
                "Movie Thumbnail",
                contentScale = ContentScale.Fit,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(
                    modifier = Modifier.weight(0.2f)
                )
                Column {
                    TextTitle(
                        bookTitle = movie.title
                    )
                    TextAuthor(
                        bookAuthor = movie.studio
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    RatingBar(
                        value = movie.rating,
                        onValueChange = {},
                        onRatingChanged = {},
                        config = RatingBarConfig()
                            .size(28.dp)
                    )

                }
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                UpdateIcon {
                    navigateToUpdateMovieScreen(movie.id)
                }
                DeleteIcon(
                    deleteBook = deleteBook
                )
            }
        }
    }
}