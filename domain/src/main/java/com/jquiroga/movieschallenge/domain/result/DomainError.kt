package com.jquiroga.movieschallenge.domain.result

sealed interface DomainError {
    data object NetworkUnavailable : DomainError

    data object Unauthorized : DomainError

    data object NotFound : DomainError

    data class Server(val statusCode: Int) : DomainError

    data class Unexpected(val cause: Throwable) : DomainError
}