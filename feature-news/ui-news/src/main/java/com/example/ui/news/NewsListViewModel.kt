package com.example.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.models.NewsListUiState
import com.example.base.util.collectOn
import com.example.domain_news.usecase.GetLocalNews
import com.example.domain_news.usecase.GetRemoteNews
import com.example.base.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getRemoteNews: GetRemoteNews,
    private val getLocalNews: GetLocalNews
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsListUiState())
    val uiState: StateFlow<NewsListUiState> = _uiState.asStateFlow()


    init {
        getTopHeadlines()
        updateTopHeadLines()
    }

    fun getTopHeadlines() {

        getLocalNews().collectOn(viewModelScope) { newsList ->
            _uiState.update { it.copy(newsList = newsList) }
        }
    }

    fun updateTopHeadLines() {

        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            when (val result = getRemoteNews()) {
                is Resource.Success -> {
                    _uiState.update { it.copy(isLoading = false, error = null) }
                }
                is Resource.Error -> {
                    _uiState.update { it.copy(isLoading = false, error = result.error) }
                }
            }
        }
    }

}