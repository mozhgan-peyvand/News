package com.example.domain_news.usecase

import com.example.domain_news.repository.NewsRepository
import javax.inject.Inject
import com.example.base.models.Resource

class GetRemoteNews @Inject constructor(
    private val newsRepository: NewsRepository
){
    suspend operator fun invoke(): Resource<Unit>{
        return newsRepository.updateTopHeadlines()
    }
}