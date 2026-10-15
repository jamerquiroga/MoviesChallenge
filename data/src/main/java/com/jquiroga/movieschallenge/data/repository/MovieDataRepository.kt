package com.jquiroga.movieschallenge.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jquiroga.movieschallenge.data.datasource.remote.source.MoviePagingSource
import com.jquiroga.movieschallenge.data.datasource.remote.source.MovieRemoteDataSource
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
) : MovieRepository {

    override fun getMovies(query: String): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(
                    remoteDataSource = remoteDataSource,
                    query = query
                )
            },
        ).flow

    private companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 5
    }
}