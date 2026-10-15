package com.jquiroga.movieschallenge.data.core.interceptor

import com.jquiroga.movieschallenge.data.core.utils.ApiConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authenticatedRequest = chain.request()
            .newBuilder()
            .header("Accept", "application/json")
            .header("Authorization", "Bearer ${ApiConfig.AUTH_TOKEN}")
            .build()

        return chain.proceed(authenticatedRequest)
    }
}
