package com.jquiroga.movieschallenge.features.favorite.model

import androidx.compose.runtime.Immutable

@Immutable
data class FavoriteMovieUiModel(
    val id: Long,
    val title: String,
    val posterUrl: String?,
    val releaseYear: String?,
    val voteAverage: Double,
)