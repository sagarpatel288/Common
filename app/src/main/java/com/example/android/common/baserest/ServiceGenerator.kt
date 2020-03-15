package com.example.android.common.baserest

import com.example.android.common.BuildConfig
import com.example.android.common.baseconstants.BASE_URL_GITHUB
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * 2/29/2020
 * Adaptive, flexible and sustainable retrofit client class for network api calls
 * <p>
 * All class members are static here because we don't want to eat up memory by creating new objects each and every time
 * to use unnecessary new open socket connection. We need only one to reuse open socket connections.
 * </p>
 * {@link #} []
 *
 * @author srdpatel
 * @see <a href="https://futurestud.io/tutorials/retrofit-2-creating-a-sustainable-android-client">Source</a>
 * [Source] (https://futurestud.io/tutorials/retrofit-2-creating-a-sustainable-android-client "Source")
 * @since 1.0
 */
class ServiceGenerator {

    // comment by srdpatel: 2/29/2020 companion object acts like a static methods but it can be only inside the class
    companion object {

        var baseUrl: String = BASE_URL_GITHUB
        private var retrofitBuilder =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
        private var okHttpClientBuilder = OkHttpClient.Builder()
        private val httpLoggingInterceptor = HttpLoggingInterceptor()
        private var retrofit =
            retrofitBuilder
                .client(getOkHttpClient())
                .build()

        @JvmStatic
        fun getOkHttpClient(): OkHttpClient {
            if (BuildConfig.DEBUG && !okHttpClientBuilder.interceptors().contains(httpLoggingInterceptor)) {
                httpLoggingInterceptor.level = (HttpLoggingInterceptor.Level.BODY)
                okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
            }
            return okHttpClientBuilder.build()
        }

        @JvmStatic
        fun <S> withBaseUrl(baseUrl: String, apiInterface: Class<S>): S {
            retrofitBuilder =
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl).client(getOkHttpClient())

            retrofit = retrofitBuilder.build()

            return retrofit.create(apiInterface)
        }
    }
}