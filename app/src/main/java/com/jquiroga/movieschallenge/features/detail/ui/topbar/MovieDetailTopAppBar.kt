package com.jquiroga.movieschallenge.features.detail.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MovieDetailTopAppBar(
    isFavorite: Boolean?,
    isFavoriteUpdating: Boolean,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.movie_detail_title))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back)
                )
            }
        },
        actions = {
            isFavorite?.let { favorite ->
                IconButton(
                    onClick = onFavoriteClick,
                    enabled = !isFavoriteUpdating,
                ) {
                    Icon(
                        imageVector = if (favorite) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = stringResource(
                            if (favorite) {
                                R.string.remove_from_favorites
                            } else {
                                R.string.add_to_favorites
                            },
                        )
                    )
                }
            }
        }
    )
}