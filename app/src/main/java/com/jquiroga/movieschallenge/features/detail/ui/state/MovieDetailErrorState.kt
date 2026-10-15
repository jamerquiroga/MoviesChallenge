package com.jquiroga.movieschallenge.features.detail.ui.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.R
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailError

@Composable
internal fun MovieDetailErrorState(
    error: MovieDetailError,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val message = when (error) {
        MovieDetailError.NetworkUnavailable -> stringResource(
            R.string.movie_detail_network_error_message,
        )
        MovieDetailError.NotFound -> stringResource(R.string.movie_detail_not_found_message)
        MovieDetailError.Generic -> stringResource(R.string.movie_detail_generic_error_message)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        Text(
            text = stringResource(R.string.movie_detail_error_title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Button(onClick = onRetryClick) {
            Text(text = stringResource(R.string.retry))
        }
    }
}