package com.example.android.common.networking

import okhttp3.Interceptor
import okhttp3.Response

// comment by srdpatel: 3/7/2020 https://github.com/harmittaa/KoinExample/blob/master/app/src/main/java/com/github/harmittaa/koinexample/networking/AuthInterceptor.kt
class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        // DON'T INCLUDE API KEYS IN YOUR SOURCE CODE
        // Edit (or add) a gradle.properties file in your project root
        // and add the API_KEY there!

        val requestBuilder = chain.request().newBuilder()
        val url = request.url.newBuilder().addQueryParameter("APPID", "BuildConfig.API_KEY").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}