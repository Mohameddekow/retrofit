package com.example.retrofit.api

import okhttp3.Interceptor
import okhttp3.Response


//intercepting all retrofit request read more of this concept
class MyIntercepter: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("X-platform", "Android")
            .addHeader("X-Auth-token", "12345676")
            .build()

        return chain.proceed(request)
    }
}