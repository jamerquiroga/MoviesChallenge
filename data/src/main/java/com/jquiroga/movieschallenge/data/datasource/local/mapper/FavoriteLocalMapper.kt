package com.jquiroga.movieschallenge.data.datasource.local.mapper

import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity
import com.jquiroga.movieschallenge.domain.model.Movie

internal fun FavoriteMovieEntity.toDomain() = Movie(
    id = id,
    title = title,
    overview = overview,
    posterUrl = posterUrl,
    backdropUrl = backdropUrl,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount
)