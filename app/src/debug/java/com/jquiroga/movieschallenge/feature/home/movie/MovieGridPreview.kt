package com.jquiroga.movieschallenge.feature.home.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.jquiroga.movieschallenge.feature.home.data.MoviePreviewData
import com.jquiroga.movieschallenge.features.home.ui.movie.MovieGrid
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun MovieGridPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieGrid(
            movies = MoviePreviewData.movies().collectAsLazyPagingItems(),
            onMovieClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
