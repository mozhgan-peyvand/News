package com.example.data_news.repositories

import com.example.base.models.NewsDetails
import com.example.base.models.NewsEntity
import com.example.data_news.repositories.local.NewsLocalDataSource
import com.example.data_news.repositories.remote.NewsRemoteDataSource
import com.example.domain_news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import com.example.base.models.Result
import com.example.data_news.models.toNewsEntity
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    override fun getTopHeadlines(): Flow<List<NewsEntity>> {
        return newsLocalDataSource.getTopHeadLines()
    }

    override suspend fun updateTopHeadlines(): Result<Unit> {
        return when (val result = newsRemoteDataSource.getNewsList()) {
            is Result.Success -> {

                newsLocalDataSource.removeTopHeadlines()

                newsLocalDataSource.insertTopHeadLines(result.data.articles.map {
                    it.toNewsEntity()
                })

                Result.Success(Unit)

            }
            is Result.Error -> {
                Result.Error(result.error)
            }

        }
    }

    override suspend fun getNewsDetails(id: Int): NewsDetails {
        return newsLocalDataSource.getNewsDetails(id).toNewsDetails()
    }


}