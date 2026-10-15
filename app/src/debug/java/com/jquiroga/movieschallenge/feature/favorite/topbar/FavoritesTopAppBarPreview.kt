package com.jquiroga.movieschallenge.feature.favorite.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.favorite.ui.topbar.FavoritesTopAppBar

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun FavoritesTopAppBarPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        FavoritesTopAppBar(onBackClick = {})
    }
}
