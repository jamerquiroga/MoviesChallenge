package com.jquiroga.movieschallenge.features.home.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.jquiroga.movieschallenge.features.home.ui.movie.MoviesScreen
import com.jquiroga.movieschallenge.features.home.view.MoviesViewModel

@Composable
fun MoviesRoute(
    viewModel: MoviesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val pagedMovies = viewModel.pagedMovies.collectAsLazyPagingItems()

    MoviesScreen(
        uiState = uiState,
        movies = pagedMovies,
        onSearchQueryChanged = viewModel::onSearchQueryChanged
    )
}
