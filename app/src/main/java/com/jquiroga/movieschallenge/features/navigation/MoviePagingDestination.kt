package com.jquiroga.movieschallenge.features.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
internal data object MoviesDestination : NavKey

@Serializable
internal data class MovieDetailDestination(
    val movieId: Long,
) : NavKey
