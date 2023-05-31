package com.example.data_news.repositories

import com.example.base.models.NewsDetails
import com.example.base.models.NewsEntity
import com.example.data_news.repositories.local.NewsLocalDataSource
import com.example.data_news.repositories.remote.NewsRemoteDataSource
import com.example.domain_news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import com.example.base.models.Resource
import com.example.data_news.models.toNewsEntity
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    override fun getTopHeadlines(): Flow<List<NewsEntity>> {
        return newsLocalDataSource.getTopHeadLines()
    }

    override suspend fun updateTopHeadlines(): Resource<Unit> {
        return when (val result = newsRemoteDataSource.getNewsList()) {
            is Resource.Success -> {

                newsLocalDataSource.removeTopHeadlines()

                newsLocalDataSource.insertTopHeadLines(result.data.articles.map {
                    it.toNewsEntity()
                })

                Resource.Success(Unit)

            }
            is Resource.Error -> {
                Resource.Error(result.error)
            }

        }
    }

    override suspend fun getNewsDetails(id: Int): NewsDetails {
        return newsLocalDataSource.getNewsDetails(id).toNewsDetails()
    }


}