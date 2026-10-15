package com.jquiroga.movieschallenge.features.detail.mapper

import com.jquiroga.movieschallenge.domain.model.MovieDetail
import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailError
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiModel

internal fun MovieDetail.toUiModel() = MovieDetailUiModel(
    id = movie.id,
    title = movie.title,
    overview = movie.overview,
    heroImageUrl = movie.backdropUrl ?: movie.posterUrl,
    releaseYear = movie.releaseDate?.take(RELEASE_YEAR_LENGTH),
    voteAverage = movie.voteAverage,
    genres = genres.joinToString { genre -> genre.name },
    runtimeMinutes = runtimeMinutes,
    tagline = tagline
)

internal fun DomainError.toMovieDetailError(): MovieDetailError = when (this) {
    DomainError.NetworkUnavailable -> MovieDetailError.NetworkUnavailable
    DomainError.NotFound -> MovieDetailError.NotFound
    is DomainError.Server,
    DomainError.Unauthorized,
    is DomainError.Unexpected
    -> MovieDetailError.Generic
}

private const val RELEASE_YEAR_LENGTH = 4
