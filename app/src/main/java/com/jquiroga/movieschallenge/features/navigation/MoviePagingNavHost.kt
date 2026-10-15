package com.jquiroga.movieschallenge.features.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.jquiroga.movieschallenge.features.detail.ui.MovieDetailRoute
import com.jquiroga.movieschallenge.features.home.ui.MoviesRoute

@Composable
internal fun MoviePagingNavHost() {
    val backStack = rememberNavBackStack(MoviesDestination)
    val navigateBack = {
        if (backStack.size > 1) {
            backStack.removeLastOrNull()
        }
        Unit
    }

    NavDisplay(
        backStack = backStack,
        onBack = navigateBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<MoviesDestination> {
                MoviesRoute(
                    onMovieClick = { movieId ->
                        backStack.add(MovieDetailDestination(movieId))
                    },
                )
            }

            entry<MovieDetailDestination> { destination ->
                MovieDetailRoute(
                    movieId = destination.movieId,
                    onBackClick = navigateBack,
                )
            }
        },
    )
}
