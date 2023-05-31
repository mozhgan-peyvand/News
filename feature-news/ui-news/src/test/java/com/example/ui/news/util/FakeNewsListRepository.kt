package com.example.ui_news.util

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

    override suspend fun updateTopHeadlines(): Resource<Unit> {
        return if (isSuccessful) {
            Resource.Success(Unit)
        } else {
            Resource.Error(Exceptions.GeneralRemoteException())
        }
    }

    var newsDetails: NewsDetails? = null
    override suspend fun getNewsDetails(id: Int): NewsDetails {
        return newsDetails ?: NewsDetails(0, "", "", "", "")
    }
}