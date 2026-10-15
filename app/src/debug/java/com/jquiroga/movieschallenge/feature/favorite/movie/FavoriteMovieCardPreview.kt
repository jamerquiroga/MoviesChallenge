package com.jquiroga.movieschallenge.feature.favorite.movie

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.favorite.data.FavoritesPreviewData
import com.jquiroga.movieschallenge.features.favorite.ui.movie.FavoriteMovieCard

@Preview(showBackground = true)
@Composable
private fun FavoriteMovieCardPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        FavoriteMovieCard(
            movie = FavoritesPreviewData.movie,
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp)
        )
    }
}
