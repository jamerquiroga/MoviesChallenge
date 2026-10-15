package com.jquiroga.movieschallenge.data.datasource.remote.mapper

import com.jquiroga.movieschallenge.domain.result.DomainError
import java.io.IOException
import kotlinx.serialization.SerializationException
import retrofit2.HttpException

internal fun Throwable.toDomainError(): DomainError = when (this) {
    is IOException -> DomainError.NetworkUnavailable
    is SerializationException -> DomainError.Unexpected(this)
    is HttpException -> when (code()) {
        401, 403 -> DomainError.Unauthorized
        404 -> DomainError.NotFound
        else -> DomainError.Server(code())
    }
    else -> DomainError.Unexpected(this)
}
