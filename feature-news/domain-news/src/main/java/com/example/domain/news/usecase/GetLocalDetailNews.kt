package com.example.domain.news.usecase

import com.example.base.models.NewsDetails
import com.example.domain.news.repository.NewsRepository
import javax.inject.Inject

class GetLocalDetailNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(id: Int): NewsDetails {
        return newsRepository.getNewsDetails(id)
    }
}