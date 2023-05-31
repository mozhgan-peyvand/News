package com.example.ui.news.util

import com.example.base.models.*
import com.example.domain.news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeNewsListRepository(
    private val isSuccessful: Boolean = true
) : NewsRepository {

    var newsList: Flow<List<NewsEntity>> = flowOf()

    override fun getLocalNewsList(): Flow<List<NewsEntity>> {
        return newsList
    }

    var newsDetails: NewsDetails? = null
    override suspend fun getNewsDetails(id: Int): NewsDetails {
        return newsDetails ?: NewsDetails(0, "", "", "", "")
    }

    override suspend fun getRemoteNewsList(): Resource<Unit> {
        return if (isSuccessful) {
            Resource.Success(Unit)
        } else {
            Resource.Error(Exceptions.GeneralRemoteException())
        }
    }
}