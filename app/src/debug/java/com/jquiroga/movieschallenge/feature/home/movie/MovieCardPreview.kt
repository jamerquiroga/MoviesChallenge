package com.jquiroga.movieschallenge.feature.home.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.common.ui.movie.MovieCard
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.home.data.MoviePreviewData

@Preview(showBackground = true)
@Composable
private fun MovieCardPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        Box(
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp),
        ) {
            MovieCard(
                title = MoviePreviewData.movie.title,
                posterUrl = MoviePreviewData.movie.posterUrl,
                releaseYear = MoviePreviewData.movie.releaseYear,
                voteAverage = MoviePreviewData.movie.voteAverage,
                onClick = {},
            )
        }
    }
}
