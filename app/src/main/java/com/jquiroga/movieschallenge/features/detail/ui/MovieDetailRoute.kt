package com.jquiroga.movieschallenge.features.detail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jquiroga.movieschallenge.features.detail.ui.movie.MovieDetailScreen
import com.jquiroga.movieschallenge.features.detail.viewmodel.MovieDetailViewModel

@Composable
internal fun MovieDetailRoute(
    movieId: Long,
    onBackClick: () -> Unit,
    viewModel: MovieDetailViewModel = hiltViewModel<MovieDetailViewModel, MovieDetailViewModel.Factory>(
        creationCallback = { factory -> factory.create(movieId) }
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MovieDetailScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onRetryClick = viewModel::retry
    )
}