package com.jquiroga.movieschallenge.features.favorite.mapper

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.features.favorite.model.FavoriteMovieUiModel

internal fun Movie.toFavoriteUiModel() = FavoriteMovieUiModel(
    id = id,
    title = title,
    posterUrl = posterUrl,
    releaseYear = releaseDate?.take(RELEASE_YEAR_LENGTH),
    voteAverage = voteAverage,
)

private const val RELEASE_YEAR_LENGTH = 4
