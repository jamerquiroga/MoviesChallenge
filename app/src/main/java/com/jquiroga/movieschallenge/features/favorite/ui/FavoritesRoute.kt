package com.jquiroga.movieschallenge.features.favorite.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jquiroga.movieschallenge.features.favorite.ui.movie.FavoritesScreen
import com.jquiroga.movieschallenge.features.favorite.viewmodel.FavoritesViewModel

@Composable
internal fun FavoritesRoute(
    onBackClick: () -> Unit,
    viewModel: FavoritesViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FavoritesScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onRetryClick = viewModel::retry,
    )
}