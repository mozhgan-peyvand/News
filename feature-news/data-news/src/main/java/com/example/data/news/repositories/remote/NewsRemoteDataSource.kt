package com.example.data_news.repositories.remote

import com.example.data_news.models.NewsResponse
import com.example.base.models.Resource

interface NewsRemoteDataSource {
    suspend fun getNewsList(): Resource<NewsResponse>
}