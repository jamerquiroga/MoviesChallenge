package com.jquiroga.movieschallenge.feature.movies.data

import androidx.paging.PagingData
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal object MoviePreviewData {
    val movie = MovieUiModel(
        id = 603,
        title = "The Matrix",
        posterUrl = null,
        releaseYear = "1999",
        voteAverage = 8.2
    )

    fun movies(): Flow<PagingData<MovieUiModel>> = flowOf(
        PagingData.from(items)
    )

    private val items = listOf(
        movie,
        MovieUiModel(
            id = 550,
            title = "Fight Club",
            posterUrl = null,
            releaseYear = "1999",
            voteAverage = 8.4
        ),
        MovieUiModel(
            id = 27205,
            title = "Inception",
            posterUrl = null,
            releaseYear = "2010",
            voteAverage = 8.4
        ),
        MovieUiModel(
            id = 157336,
            title = "Interstellar",
            posterUrl = null,
            releaseYear = "2014",
            voteAverage = 8.5
        )
    )
}