package com.example.data.news.repositories

import com.example.base.models.NewsDetails
import com.example.base.models.NewsEntity
import com.example.data.news.repositories.local.NewsLocalDataSource
import com.example.data.news.repositories.remote.NewsRemoteDataSource
import com.example.domain.news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import com.example.base.models.Resource
import com.example.data.news.models.toNewsEntity
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    override fun getLocalNewsList(): Flow<List<NewsEntity>> {
        return newsLocalDataSource.getTopHeadLines()
    }

    override suspend fun getRemoteNewsList(): Resource<Unit> {
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