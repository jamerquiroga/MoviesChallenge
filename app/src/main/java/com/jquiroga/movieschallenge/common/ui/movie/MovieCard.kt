package com.jquiroga.movieschallenge.common.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jquiroga.movieschallenge.R

@Composable
internal fun MovieCard(
    title: String,
    posterUrl: String?,
    releaseYear: String?,
    voteAverage: Double,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    MovieCardContainer(
        onClick = onClick,
        modifier = modifier,
    ) {
        MovieCardContent(
            title = title,
            posterUrl = posterUrl,
            releaseYear = releaseYear,
            voteAverage = voteAverage,
        )
    }
}

@Composable
private fun MovieCardContainer(
    onClick: (() -> Unit)?,
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val shape = RoundedCornerShape(16.dp)
    val colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
    )

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = colors,
            content = content,
        )
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            colors = colors,
            content = content,
        )
    }
}

@Composable
private fun MovieCardContent(
    title: String,
    posterUrl: String?,
    releaseYear: String?,
    voteAverage: Double,
) {
    val placeholderColor = MaterialTheme.colorScheme.surfaceVariant
    val placeholder = remember(placeholderColor) {
        ColorPainter(placeholderColor)
    }

    AsyncImage(
        model = posterUrl,
        contentDescription = stringResource(
            R.string.movie_poster_content_description,
            title,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(POSTER_ASPECT_RATIO)
            .background(placeholderColor),
        placeholder = placeholder,
        error = placeholder,
        fallback = placeholder,
        contentScale = ContentScale.Crop,
    )

    Column(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.movie_rating, voteAverage),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            releaseYear?.let { year ->
                Text(
                    text = year,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

private const val POSTER_ASPECT_RATIO = 2f / 3f
