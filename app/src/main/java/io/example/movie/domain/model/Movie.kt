package io.example.movie.domain.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.example.movie.core.Constants.Companion.MOVIE_TABLE

@Entity(tableName = MOVIE_TABLE)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val studio: String,
    val image: String,
    val rating: Float
)