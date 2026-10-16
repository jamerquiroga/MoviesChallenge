package com.jquiroga.movieschallenge.domain.usecase.detail

import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.detail.provider.MockDataProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertSame
import org.junit.Test

class GetMovieDetailUseCaseTest {

    private val repository: MovieRepository = mockk()
    private val useCase = GetMovieDetailUseCase(repository)

    @Test
    fun `Given repository succeeds when invoked then returns movie detail`() = runTest {
        val movieDetail = MockDataProvider.createMovieDetail()
        val movieId = movieDetail.movie.id
        val expectedResult = DomainResult.Success(movieDetail)
        coEvery { repository.getMovieDetail(movieId) } returns expectedResult

        val result = useCase(movieId)

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.getMovieDetail(movieId) }
        confirmVerified(repository)
    }

    @Test
    fun `Given repository fails when invoked then returns failure`() = runTest {
        val movieId = MockDataProvider.createMovieDetail().movie.id
        val expectedResult = DomainResult.Failure(DomainError.NotFound)
        coEvery { repository.getMovieDetail(movieId) } returns expectedResult

        val result = useCase(movieId)

        assertSame(expectedResult, result)
        coVerify(exactly = 1) { repository.getMovieDetail(movieId) }
        confirmVerified(repository)
    }
}