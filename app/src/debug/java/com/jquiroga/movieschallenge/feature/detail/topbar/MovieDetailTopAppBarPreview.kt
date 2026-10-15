package com.jquiroga.movieschallenge.feature.detail.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.detail.ui.topbar.MovieDetailTopAppBar

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MovieDetailTopAppBarPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieDetailTopAppBar(onBackClick = {})
    }
}