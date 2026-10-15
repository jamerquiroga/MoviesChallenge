package com.jquiroga.movieschallenge.features.home.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@Composable
internal fun MoviesErrorState(
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MoviesMessageState(
        title = stringResource(R.string.movies_error_title),
        message = stringResource(R.string.movies_error_message),
        actionLabel = stringResource(R.string.retry),
        onAction = onRetry,
        modifier = modifier
    )
}
