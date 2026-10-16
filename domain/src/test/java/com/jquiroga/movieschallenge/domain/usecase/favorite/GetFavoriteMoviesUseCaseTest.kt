package com.jquiroga.movieschallenge.domain.usecase.favorite

import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.favorite.provider.MockDataProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertSame
import org.junit.Test

class GetFavoriteMoviesUseCaseTest {

    private val repository: FavoriteRepository = mockk()
    private val useCase = GetFavoriteMoviesUseCase(repository)

    @Test
    fun `Given repository succeeds when invoked then returns favorite movies`() = runTest {
        val favoriteMovies = listOf(MockDataProvider.createMovie())
        val expectedResult = DomainResult.Success(favoriteMovies)
        coEvery { repository.getFavorites() } returns expectedResult

        val result = useCase()

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.getFavorites() }
        confirmVerified(repository)
    }

    @Test
    fun `Given repository fails when invoked then returns failure`() = runTest {
        val expectedResult = DomainResult.Failure(DomainError.NetworkUnavailable)
        coEvery { repository.getFavorites() } returns expectedResult

        val result = useCase()

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.getFavorites() }
        confirmVerified(repository)
    }
}