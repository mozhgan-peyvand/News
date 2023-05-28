package com.example.data_news.repositories.remote

import com.example.data_news.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsService {
    @GET
    suspend fun getNews(
        @Url url: String,
        @Query ("sources") source : String = "bbc-news",
        @Query ("apiKey") apiKey : String = "89c9aef708b247ec8959e9fd054905f1"
    ): Response<NewsResponse>
}