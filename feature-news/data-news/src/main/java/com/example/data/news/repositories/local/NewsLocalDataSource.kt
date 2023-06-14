package com.example.data.news.repositories.local

import com.example.base.models.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    fun getTopHeadLines(): Flow<List<NewsEntity>>

    suspend fun insertTopHeadLines(news: List<NewsEntity>)

    suspend fun removeTopHeadlines()

    suspend fun getNewsDetails(id: Int): NewsEntity
}
