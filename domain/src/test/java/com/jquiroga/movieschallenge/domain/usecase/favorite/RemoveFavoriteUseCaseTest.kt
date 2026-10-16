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

class RemoveFavoriteUseCaseTest {

    private val repository: FavoriteRepository = mockk()
    private val useCase = RemoveFavoriteUseCase(repository)

    @Test
    fun `Given repository succeeds when invoked then returns success`() = runTest {
        val movieId = MockDataProvider.createMovie().id
        val expectedResult = DomainResult.Success(Unit)
        coEvery { repository.removeFavorite(movieId) } returns expectedResult

        val result = useCase(movieId)

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.removeFavorite(movieId) }
        confirmVerified(repository)
    }

    @Test
    fun `Given repository fails when invoked then returns failure`() = runTest {
        val movieId = MockDataProvider.createMovie().id
        val expectedResult = DomainResult.Failure(DomainError.NetworkUnavailable)
        coEvery { repository.removeFavorite(movieId) } returns expectedResult

        val result = useCase(movieId)

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.removeFavorite(movieId) }
        confirmVerified(repository)
    }
}