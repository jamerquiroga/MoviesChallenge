package com.jquiroga.movieschallenge.domain.usecase.home

import androidx.paging.PagingData
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertSame
import org.junit.Test

class GetMoviesUseCaseTest {

    private val repository: MovieRepository = mockk()
    private val useCase = GetMoviesUseCase(repository)

    @Test
    fun `Given query contains surrounding spaces when invoked then trims query`() {
        val expectedFlow: Flow<PagingData<Movie>> = flowOf(PagingData.empty())
        every { repository.getMovies("Batman") } returns expectedFlow

        val result = useCase("  Batman  ")

        assertSame(expectedFlow, result)
        verify(exactly = 1) { repository.getMovies("Batman") }
        confirmVerified(repository)
    }

    @Test
    fun `Given query contains only spaces when invoked then requests an empty query`() {
        val expectedFlow: Flow<PagingData<Movie>> = flowOf(PagingData.empty())
        every { repository.getMovies("") } returns expectedFlow

        val result = useCase("   ")

        assertSame(expectedFlow, result)
        verify(exactly = 1) { repository.getMovies("") }
        confirmVerified(repository)
    }
}