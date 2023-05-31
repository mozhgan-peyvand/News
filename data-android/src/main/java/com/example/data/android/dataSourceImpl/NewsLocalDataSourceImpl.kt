package com.example.data.android.dataSourceImpl

import com.example.base.models.NewsEntity
import com.example.data.news.repositories.local.NewsDao
import com.example.data.news.repositories.local.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao
): NewsLocalDataSource {
    override fun getTopHeadLines(): Flow<List<NewsEntity>> {
        return newsDao.getNewsList()
    }

    override suspend fun insertTopHeadLines(news: List<NewsEntity>) {
        newsDao.insertNewsList(news)
    }

    override suspend fun removeTopHeadlines() {
        newsDao.deleteNewsList()
    }

    override suspend fun getNewsDetails(id: Int): NewsEntity {
        return newsDao.getNewsDetails(id)
    }

}