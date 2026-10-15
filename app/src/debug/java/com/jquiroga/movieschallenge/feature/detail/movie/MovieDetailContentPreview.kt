package com.jquiroga.movieschallenge.feature.detail.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.detail.data.MovieDetailPreviewData
import com.jquiroga.movieschallenge.features.detail.ui.movie.MovieDetailContent

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun MovieDetailContentPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieDetailContent(movie = MovieDetailPreviewData.movie)
    }
}