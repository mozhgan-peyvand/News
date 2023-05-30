package com.example.data_news

import com.example.base.models.*
import com.example.domain_news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeNewsListRepository(
    private val isSuccessful: Boolean = true
) : NewsRepository {

    var newsList: Flow<List<NewsEntity>> = flowOf()

    override fun getTopHeadlines(): Flow<List<NewsEntity>> {
        return newsList
    }

    override suspend fun updateTopHeadlines(): Result<Unit> {
        return if (isSuccessful) {
            Result.Success(Unit)
        } else {
            Result.Error(Exceptions.GeneralRemoteException())
        }
    }

    var newsDetails: NewsDetails? = null
    override suspend fun getNewsDetails(id: Int): NewsDetails {
        return newsDetails ?: NewsDetails(0, "", "", "", "")
    }
}