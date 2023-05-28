package com.example.ui_news

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.models.NewsDetailsUiState
import com.example.domain_news.usecase.GetLocalDetailNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val getLocalDetailNews: GetLocalDetailNews,
    state: SavedStateHandle
) : ViewModel() {

//    private val newsId = NewsDetailFragmentArgs.fromSavedStateHandle(state).id

    private val _uiState = MutableStateFlow(NewsDetailsUiState())
    val uiState: StateFlow<NewsDetailsUiState> = _uiState.asStateFlow()

    init {
        getNewsDetails()
    }

    private fun getNewsDetails() {

        viewModelScope.launch {
            val result = getLocalDetailNews(/*newsId*/120)
            _uiState.update { it.copy(newsDetails = result) }
        }
    }

}