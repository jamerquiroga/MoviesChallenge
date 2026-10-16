package com.jquiroga.movieschallenge.feature.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.common.ui.movie.MovieCard
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.favorite.data.FavoritesPreviewData

@Preview(showBackground = true)
@Composable
private fun MovieCardPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieCard(
            title = FavoritesPreviewData.movie.title,
            posterUrl = FavoritesPreviewData.movie.posterUrl,
            releaseYear = FavoritesPreviewData.movie.releaseYear,
            voteAverage = FavoritesPreviewData.movie.voteAverage,
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp),
        )
    }
}
