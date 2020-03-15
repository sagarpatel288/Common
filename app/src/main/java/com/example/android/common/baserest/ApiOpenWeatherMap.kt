package com.example.android.common.baserest

import com.example.android.common.basemodels.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiOpenWeatherMap {

    @GET("weather")
    suspend fun getForecast(@Query("q")location: String,
                            @Query("units") unit: String): Weather
}