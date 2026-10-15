package com.jquiroga.movieschallenge.data.datasource.remote.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jquiroga.movieschallenge.data.datasource.remote.mapper.toDomain
import com.jquiroga.movieschallenge.domain.model.Movie
import kotlinx.coroutines.CancellationException

internal class MoviePagingSource(
    private val remoteDataSource: MovieRemoteDataSource,
    private val query: String,
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: FIRST_PAGE

        return try {
            val response = remoteDataSource.getMovies(page = page, query = query)
            val movies = response.results.map { it.toDomain() }
            val lastPage = response.totalPages.coerceAtLeast(page)

            LoadResult.Page(
                data = movies,
                prevKey = (page - 1).takeIf { page > FIRST_PAGE },
                nextKey = (page + 1).takeIf {
                    movies.isNotEmpty() && page < lastPage
                },
            )
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            LoadResult.Error(error)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let { page ->
                page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
            }
        }

    private companion object {
        const val FIRST_PAGE = 1
    }
}