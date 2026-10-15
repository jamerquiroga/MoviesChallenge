package com.jquiroga.movieschallenge.data.datasource.remote.mapper

import com.jquiroga.movieschallenge.data.core.utils.ImageUrlBuilder
import com.jquiroga.movieschallenge.data.datasource.remote.dto.MovieDetailDto
import com.jquiroga.movieschallenge.data.datasource.remote.dto.MovieDto
import com.jquiroga.movieschallenge.domain.model.Genre
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.model.MovieDetail

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

internal fun MovieDetailDto.toDomain(): MovieDetail {
    val summary = MovieDto(
        id = id,
        title = title,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
    ).toDomain()

    return MovieDetail(
        movie = summary,
        genres = genres.map { Genre(id = it.id, name = it.name.trim()) },
        runtimeMinutes = runtime?.takeIf { it > 0 },
        tagline = tagline,
        status = status
    )
}