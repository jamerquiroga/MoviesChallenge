package com.jquiroga.movieschallenge.features.home.model

data class MovieUiModel(
    val id: Long,
    val title: String,
    val posterUrl: String?,
    val releaseYear: String?,
    val voteAverage: Double,
)