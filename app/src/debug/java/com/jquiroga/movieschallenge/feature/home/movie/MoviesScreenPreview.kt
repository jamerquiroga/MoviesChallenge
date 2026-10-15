package com.jquiroga.movieschallenge.feature.home.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.home.data.MoviePreviewData
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import com.jquiroga.movieschallenge.features.home.ui.movie.MoviesScreen

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun MoviesScreenPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesScreen(
            uiState = MoviesUiState(),
            movies = MoviePreviewData.movies().collectAsLazyPagingItems(),
            onSearchQueryChanged = {},
            onMovieClick = {}
        )
    }
}
