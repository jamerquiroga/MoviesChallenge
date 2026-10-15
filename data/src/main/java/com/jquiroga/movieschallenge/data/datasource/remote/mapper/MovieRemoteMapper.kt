package com.jquiroga.movieschallenge.data.datasource.remote.mapper

import com.jquiroga.movieschallenge.data.core.utils.ImageUrlBuilder
import com.jquiroga.movieschallenge.data.datasource.remote.dto.MovieDto
import com.jquiroga.movieschallenge.domain.model.Movie

internal fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id ?: 0L,
        title = title,
        overview = overview.trim(),
        posterUrl = ImageUrlBuilder.poster(posterPath),
        backdropUrl = ImageUrlBuilder.backdrop(backdropPath),
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}