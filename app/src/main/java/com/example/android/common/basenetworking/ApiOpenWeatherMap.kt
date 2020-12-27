package com.example.android.common.basenetworking

import com.example.android.common.basedto.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiOpenWeatherMap {

    @GET("weather")
    suspend fun getForecast(@Query("q")location: String,
                            @Query("units") unit: String): Weather
}