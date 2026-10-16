package com.jquiroga.movieschallenge.features.favorite.viewmodel

import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.jquiroga.movieschallenge.features.favorite.model.FavoriteMovieUiModel
import com.jquiroga.movieschallenge.features.favorite.model.FavoritesUiState
import com.jquiroga.movieschallenge.features.favorite.viewmodel.provider.MockDataProvider
import com.jquiroga.movieschallenge.testutil.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FavoritesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getFavoriteMovies: GetFavoriteMoviesUseCase = mockk()

    @Test
    fun `Given favorite movies when view model is created then emits loading and content`() = runTest {
        val movie = MockDataProvider.createMovie()
        val expectedMovies = listOf(
            FavoriteMovieUiModel(
                id = movie.id,
                title = movie.title,
                posterUrl = movie.posterUrl,
                releaseYear = movie.releaseDate?.take(4),
                voteAverage = movie.voteAverage
            ),
        )
        coEvery { getFavoriteMovies() } returns DomainResult.Success(listOf(movie))

        val viewModel = FavoritesViewModel(getFavoriteMovies)

        assertEquals(FavoritesUiState.Loading, viewModel.uiState.value)

        advanceUntilIdle()

        assertTrue(viewModel.uiState.value is FavoritesUiState.Content)
        val content = viewModel.uiState.value as FavoritesUiState.Content
        assertEquals(expectedMovies, content.movies)
        coVerify(exactly = 1) { getFavoriteMovies() }
        confirmVerified(getFavoriteMovies)
    }

    @Test
    fun `Given no favorite movies when view model is created then emits empty`() = runTest {
        coEvery { getFavoriteMovies() } returns DomainResult.Success(emptyList())

        val viewModel = FavoritesViewModel(getFavoriteMovies)
        advanceUntilIdle()

        assertEquals(FavoritesUiState.Empty, viewModel.uiState.value)
        coVerify(exactly = 1) { getFavoriteMovies() }
        confirmVerified(getFavoriteMovies)
    }

    @Test
    fun `Given favorite movies request fails when view model is created then emits error`() = runTest {
        coEvery { getFavoriteMovies() } returns DomainResult.Failure(
            DomainError.NetworkUnavailable,
        )

        val viewModel = FavoritesViewModel(getFavoriteMovies)
        advanceUntilIdle()

        assertEquals(FavoritesUiState.Error, viewModel.uiState.value)
        coVerify(exactly = 1) { getFavoriteMovies() }
        confirmVerified(getFavoriteMovies)
    }

    @Test
    fun `Given initial request fails when retry succeeds then emits loading and content`() = runTest {
        val movie = MockDataProvider.createMovie()
        coEvery { getFavoriteMovies() } returnsMany listOf(
            DomainResult.Failure(DomainError.NetworkUnavailable),
            DomainResult.Success(listOf(movie)),
        )
        val viewModel = FavoritesViewModel(getFavoriteMovies)
        advanceUntilIdle()
        assertEquals(FavoritesUiState.Error, viewModel.uiState.value)

        viewModel.retry()

        assertEquals(FavoritesUiState.Loading, viewModel.uiState.value)
        advanceUntilIdle()
        assertTrue(viewModel.uiState.value is FavoritesUiState.Content)
        coVerify(exactly = 2) { getFavoriteMovies() }
        confirmVerified(getFavoriteMovies)
    }
}
