package com.jquiroga.movieschallenge.features.detail.model

data class MovieDetailUiModel(
    val id: Long,
    val title: String,
    val overview: String,
    val heroImageUrl: String?,
    val releaseYear: String?,
    val voteAverage: Double,
    val genres: String,
    val runtimeMinutes: Int?,
    val tagline: String?
)