package com.example.data_android.dataSourceImpl

import com.example.base.api.NetworkCallHandler
import com.example.data_news.models.NewsResponse
import com.example.data_news.repositories.remote.NewsRemoteDataSource
import com.example.data_news.repositories.remote.NewsService
import com.example.base.models.Resource
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val service: NewsService,
    private val networkCallHandler: NetworkCallHandler
): NewsRemoteDataSource  {
    override suspend fun getNewsList(): Resource<NewsResponse> {
        return networkCallHandler.call {
            service.getNews()
        }
    }
}