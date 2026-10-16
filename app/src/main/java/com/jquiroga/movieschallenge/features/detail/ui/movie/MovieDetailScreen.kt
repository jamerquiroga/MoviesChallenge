package com.jquiroga.movieschallenge.features.detail.ui.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiState
import com.jquiroga.movieschallenge.features.detail.ui.state.MovieDetailErrorState
import com.jquiroga.movieschallenge.features.detail.ui.state.MovieDetailLoadingState
import com.jquiroga.movieschallenge.features.detail.ui.topbar.MovieDetailTopAppBar

@Composable
internal fun MovieDetailScreen(
    uiState: MovieDetailUiState,
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            val content = uiState as? MovieDetailUiState.Content
            MovieDetailTopAppBar(
                isFavorite = content?.isFavorite,
                isFavoriteUpdating = content?.isFavoriteUpdating == true,
                onBackClick = onBackClick,
                onFavoriteClick = onFavoriteClick
            )
        },
    ) { innerPadding ->
        when (uiState) {
            MovieDetailUiState.Loading -> MovieDetailLoadingState(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )

            is MovieDetailUiState.Content -> MovieDetailContent(
                movie = uiState.movie,
                favoriteUpdateFailed = uiState.favoriteUpdateFailed,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )

            is MovieDetailUiState.Error -> MovieDetailErrorState(
                error = uiState.type,
                onRetryClick = onRetryClick,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}