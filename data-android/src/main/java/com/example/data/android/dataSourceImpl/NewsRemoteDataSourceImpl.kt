package com.example.data.android.dataSourceImpl

import com.example.base.api.NetworkHandler
import com.example.data.news.models.NewsResponse
import com.example.data.news.repositories.remote.NewsRemoteDataSource
import com.example.data.news.repositories.remote.NewsService
import com.example.base.models.Resource
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val service: NewsService,
    private val networkHandler: NetworkHandler
): NewsRemoteDataSource {
    override suspend fun getNewsList(): Resource<NewsResponse> {
        return networkHandler.call {
            service.getNews()
        }
    }
}