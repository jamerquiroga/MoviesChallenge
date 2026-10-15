package com.jquiroga.movieschallenge.features.home.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import com.jquiroga.movieschallenge.features.home.ui.MovieGrid
import com.jquiroga.movieschallenge.features.home.ui.MoviesEmptyState
import com.jquiroga.movieschallenge.features.home.ui.MoviesErrorState
import com.jquiroga.movieschallenge.features.home.ui.MoviesLoadingState
import com.jquiroga.movieschallenge.features.home.ui.MoviesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MoviesScreen(
    uiState: MoviesUiState,
    movies: LazyPagingItems<MovieUiModel>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MoviesTopAppBar(catalog = uiState.catalog)
        },
    ) { innerPadding ->
        when (movies.loadState.refresh) {
            is LoadState.Loading if movies.itemCount == 0 -> {
                MoviesLoadingState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }

            is LoadState.Error if movies.itemCount == 0 -> {
                MoviesErrorState(
                    onRetry = movies::retry,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }

            is LoadState.NotLoading if movies.itemCount == 0 -> {
                MoviesEmptyState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }

            else -> {
                MovieGrid(
                    movies = movies,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}
