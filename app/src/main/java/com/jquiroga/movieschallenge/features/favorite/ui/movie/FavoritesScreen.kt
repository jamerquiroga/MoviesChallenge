package com.jquiroga.movieschallenge.features.favorite.ui.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jquiroga.movieschallenge.features.favorite.model.FavoritesUiState
import com.jquiroga.movieschallenge.features.favorite.ui.state.FavoritesEmptyState
import com.jquiroga.movieschallenge.features.favorite.ui.state.FavoritesErrorState
import com.jquiroga.movieschallenge.features.favorite.ui.state.FavoritesLoadingState
import com.jquiroga.movieschallenge.features.favorite.ui.topbar.FavoritesTopAppBar

@Composable
internal fun FavoritesScreen(
    uiState: FavoritesUiState,
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            FavoritesTopAppBar(onBackClick = onBackClick)
        },
    ) { innerPadding ->
        val contentModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)

        when (uiState) {
            FavoritesUiState.Loading -> FavoritesLoadingState(modifier = contentModifier)
            FavoritesUiState.Empty -> FavoritesEmptyState(modifier = contentModifier)
            is FavoritesUiState.Content -> FavoritesGrid(
                movies = uiState.movies,
                modifier = contentModifier,
            )
            FavoritesUiState.Error -> FavoritesErrorState(
                onRetryClick = onRetryClick,
                modifier = contentModifier,
            )
        }
    }
}