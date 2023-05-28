package com.example.domain_news.repository

import com.example.base.models.NewsDetails
import com.example.base.models.NewsEntity
import kotlinx.coroutines.flow.Flow
import com.example.base.models.Result


interface NewsRepository {

    fun getTopHeadlines(): Flow<List<NewsEntity>>

    suspend fun updateTopHeadlines(): Result<Unit>

    suspend fun getNewsDetails(id: Int): NewsDetails

}