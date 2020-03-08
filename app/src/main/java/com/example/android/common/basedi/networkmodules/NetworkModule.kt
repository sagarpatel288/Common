package com.example.android.common.basedi.networkmodules

import android.util.Log
import com.example.android.common.baseconstants.BASE_URL
import com.example.android.common.baserest.BaseApi
import com.example.android.common.networking.AuthInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 3/8/2020
 *  []
 * <p>
 * This class has [getBaseApi] method that will use [com.example.android.common.baserest.BaseApi] interface.
 * We want to provide a flexible way using which you can
 * either change both baseUrl and apiInterface or only one of them at runtime using appropriate method.
 * </p>
 * @see <a href="https://github.com/harmittaa/KoinExample/blob/master/app/src/main/java/com/github/harmittaa/koinexample/networking/RetrofitClient.kt">harmittaa koin example</a>
 * [harmitta koin example](https://github.com/harmittaa/KoinExample/blob/master/app/src/main/java/com/github/harmittaa/koinexample/networking/RetrofitClient.kt "harmitta koin example")
 * @author srdpatel
 * @since 1.0
 */
val networkModule = module {

    factory {
        AuthInterceptor()
    }

    factory {
        getHttpLoggingInterceptor()
    }

    factory {
        getOkHttpClient(get(), get())
    }

    single {
        getRetrofit(get())
    }

    factory {
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
    factory { (baseUrl: String, apiInterface: Class<*>) ->
        getApi(baseUrl, get(), apiInterface)
    }

    factory { (apiInterface: Class<*>) ->
        getApi(get(), apiInterface)
    }
}

fun getBaseApi(retrofit: Retrofit): BaseApi = retrofit.create(BaseApi::class.java)

fun <T> getApi(retrofit: Retrofit, apiInterface: Class<T>): T = retrofit.create(apiInterface)

fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL /*BuildConfig.API_URL*/)
        .client(okHttpClient)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().setPrettyPrinting().create()
            )
        )
        .build()
    /*return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()*/
}

fun <T> getApi(baseUrl: String, okHttpClient: OkHttpClient, apiInterface: Class<T>): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().setPrettyPrinting().create()
            )
        )
        .build()
        .create(apiInterface)
}

fun getOkHttpClient(
    authInterceptor: AuthInterceptor,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor).build()
}

/**
 * Inspired from:
 * [BirjuVachhani login mvvm final code] (https://github.com/BirjuVachhani/login-mvvm-final-code/blob/master/app/src/main/java/com/example/loginmvvm/login/di/NetworkModule.kt)
 * @see <a href="https://github.com/BirjuVachhani/login-mvvm-final-code/blob/master/app/src/main/java/com/example/loginmvvm/login/di/NetworkModule.kt">Birju Vachhani login mvvm final code</a>
 * @author srdpatel
 * @since 1.0
 */
fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    //Learn more about apply (kotlin-stdlib higher order functions): https://www.journaldev.com/19467/kotlin-let-run-also-apply-with
    return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.e("SERVER", message)
        }
    }).apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /*val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BASIC
    return logger*/
}
