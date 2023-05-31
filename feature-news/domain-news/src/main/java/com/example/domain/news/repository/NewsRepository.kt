package com.example.domain.news.repository

import com.example.base.models.NewsDetails
import com.example.base.models.NewsEntity
import kotlinx.coroutines.flow.Flow
import com.example.base.models.Resource


interface NewsRepository {

    fun getLocalNewsList(): Flow<List<NewsEntity>>

    suspend fun getRemoteNewsList(): Resource<Unit>

    suspend fun getNewsDetails(id: Int): NewsDetails

}