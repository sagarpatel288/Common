package com.example.android.common.basedi.networkmodules

import android.util.Log
import com.example.android.common.baseconstants.BASE_URL
import com.example.android.common.baserest.BaseApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * Created by Birju Vachhani on 18 November 2019
 * Copyright © 2019 Login MVVM. All rights reserved.
 */

val networkModule = module {

    single {
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e("SERVER", message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().setPrettyPrinting().create()))
            .build()
            .create(BaseApi::class.java)
    }

    single {
        getBaseApi(get())
    }

    /**
     * 2/18/2020
     * Parameter injection
     * <p>
     * Koin
     * </p>
     * Parameterized Injection {@link #} []
     *
     * @author srdpatel
     * @see <a href="http://google.com">https://github.com/InsertKoinIO/koin/blob/master/koin-projects/docs/reference/koin-core/injection-parameters.md</a>
     * [Parameterized Injection](https://github.com/InsertKoinIO/koin/blob/master/koin-projects/docs/reference/koin-core/injection-parameters.md "Parameterized Injection")
     * @since 1.0
     */
    single { (baseUrl: String, apiInterface: Class<*>) ->
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().setPrettyPrinting().create()))
            .build()
            .create(apiInterface)
    }

    single { (apiInterface: Class<*>) ->
        getApi(get(), apiInterface)
    }
}

fun getBaseApi(retrofit: Retrofit): BaseApi = retrofit.create(BaseApi::class.java)

fun <T> getApi(retrofit: Retrofit, apiInterface: Class<T>): T = retrofit.create(apiInterface)
