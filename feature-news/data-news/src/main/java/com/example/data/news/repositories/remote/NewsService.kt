package com.example.data.news.repositories.remote

import com.example.data.news.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    //    @Headers("X-Api-Key: ${BuildConfig.API_KEY}")
    @GET("top-headlines")
    suspend fun getNews(
        @Query("sources") source: String = "bbc-news",
        @Query("apiKey") apiKey: String = "89c9aef708b247ec8959e9fd054905f1"
    ): Response<NewsResponse>
}