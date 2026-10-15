package com.jquiroga.movieschallenge.feature.detail.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.detail.data.MovieDetailPreviewData
import com.jquiroga.movieschallenge.features.detail.ui.movie.MovieDetailMetadata

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MovieDetailMetadataPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieDetailMetadata(
            movie = MovieDetailPreviewData.movie,
        )
    }
}