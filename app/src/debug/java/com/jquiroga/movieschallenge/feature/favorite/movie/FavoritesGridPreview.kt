package com.jquiroga.movieschallenge.feature.favorite.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.favorite.data.FavoritesPreviewData
import com.jquiroga.movieschallenge.features.favorite.ui.movie.FavoritesGrid

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun FavoritesGridPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        FavoritesGrid(
            movies = FavoritesPreviewData.movies
        )
    }
}
