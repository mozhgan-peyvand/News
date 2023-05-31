package com.example.domain.news.usecase

import com.example.base.models.NewsEntity
import com.example.domain.news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalNews @Inject constructor(
    private val newsRepository: NewsRepository
){
    operator fun invoke(): Flow<List<NewsEntity>>{
        return newsRepository.getLocalNewsList()
    }
}