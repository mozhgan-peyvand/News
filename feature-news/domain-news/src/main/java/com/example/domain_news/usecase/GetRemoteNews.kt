package com.example.domain_news.usecase

import com.example.domain_news.repository.NewsRepository
import javax.inject.Inject
import com.example.base.models.Result

class GetRemoteNews @Inject constructor(
    private val newsRepository: NewsRepository
){
    suspend operator fun invoke(): Result<Unit>{
        return newsRepository.updateTopHeadlines()
    }
}