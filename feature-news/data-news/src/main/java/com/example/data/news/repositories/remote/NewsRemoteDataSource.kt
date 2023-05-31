package com.example.data.news.repositories.remote

import com.example.data.news.models.NewsResponse
import com.example.base.models.Resource

interface NewsRemoteDataSource {
    suspend fun getNewsList(): Resource<NewsResponse>
}