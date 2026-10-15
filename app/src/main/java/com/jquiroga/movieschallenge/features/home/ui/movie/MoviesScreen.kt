package com.jquiroga.movieschallenge.features.home.ui.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesEmptyState
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesErrorState
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesLoadingState
import com.jquiroga.movieschallenge.features.home.ui.topbar.MoviesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MoviesScreen(
    uiState: MoviesUiState,
    movies: LazyPagingItems<MovieUiModel>,
    onSearchQueryChanged: (String) -> Unit,
    onMovieClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var isSearchActive by rememberSaveable {
        mutableStateOf(uiState.searchQuery.isNotBlank())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MoviesTopAppBar(
                searchQuery = uiState.searchQuery,
                isSearchActive = isSearchActive,
                onSearchClick = { isSearchActive = true },
                onSearchQueryChanged = onSearchQueryChanged,
                onClearSearch = { onSearchQueryChanged("") },
                onCloseSearch = {
                    onSearchQueryChanged("")
                    isSearchActive = false
                },
            )
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
                    searchQuery = uiState.searchQuery,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }

            else -> {
                MovieGrid(
                    movies = movies,
                    onMovieClick = onMovieClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }
        }
    }
}
