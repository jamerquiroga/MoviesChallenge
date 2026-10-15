package com.jquiroga.movieschallenge.features.home.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.jquiroga.movieschallenge.features.home.view.MoviesScreen
import com.jquiroga.movieschallenge.features.home.view.MoviesViewModel

@Composable
fun MoviesRoute(
    viewModel: MoviesViewModel = MoviesViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val pagedMovies = viewModel.pagedMovies.collectAsLazyPagingItems()

    MoviesScreen(
        uiState = uiState,
        movies = pagedMovies,
    )
}
