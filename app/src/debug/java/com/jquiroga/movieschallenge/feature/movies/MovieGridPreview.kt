package com.jquiroga.movieschallenge.feature.movies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.jquiroga.movieschallenge.feature.movies.data.MoviePreviewData
import com.jquiroga.movieschallenge.features.home.ui.MovieGrid
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun MovieGridPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieGrid(
            movies = MoviePreviewData.movies().collectAsLazyPagingItems(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
