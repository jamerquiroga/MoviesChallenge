package com.jquiroga.movieschallenge.features.home.mapper

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel

internal fun Movie.toUiModel() = MovieUiModel(
    id = id,
    title = title,
    posterUrl = posterUrl,
    releaseYear = releaseDate?.take(RELEASE_YEAR_LENGTH),
    voteAverage = voteAverage
)

private const val RELEASE_YEAR_LENGTH = 4
