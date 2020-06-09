/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.android.common.baserest

import com.example.android.common.basedto.RedditApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiReddit {

    /**
     * 3/15/2020
     * Better use suspend function [ApiOpenWeatherMap]
     * <p>
     *
     * </p>
     * @see <a href="https://www.raywenderlich.com/6948-paging-library-for-android-with-kotlin-creating-infinite-lists#toc-anchor-006">RayWenderLich</a>
     * [RayWenderLich](https://www.raywenderlich.com/6948-paging-library-for-android-with-kotlin-creating-infinite-lists#toc-anchor-006 "RayWenderLich")
     * @author srdpatel
     * @since 1.0
     */
  @GET("/r/aww/hot.json")
  fun getPosts(@Query("limit") loadSize: Int = 30,
               @Query("after") after: String? = null,
               @Query("before") before: String? = null): Call<RedditApiResponse>

  companion object {
    private const val BASE_URL = "https://www.reddit.com/"

    fun createService(): ApiReddit {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(ApiReddit::class.java)
    }
  }
}
