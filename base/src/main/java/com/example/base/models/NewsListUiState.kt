package com.example.base.models

data class NewsListUiState(
    val newsList: List<NewsEntity> = emptyList(),
    val error: Exceptions? = null,
    val isLoading: Boolean = false
)