package com.jquiroga.movieschallenge.feature.detail.data

import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiModel

internal object MovieDetailPreviewData {
    val movie = MovieDetailUiModel(
        id = 603L,
        title = "Matrix",
        overview = "Un programador descubre que el mundo que conoce es una simulación y se une a una rebelión.",
        heroImageUrl = null,
        releaseYear = "1999",
        voteAverage = 8.2,
        genres = "Acción, Ciencia ficción",
        runtimeMinutes = 136,
        tagline = "Bienvenido al mundo real."
    )
}
