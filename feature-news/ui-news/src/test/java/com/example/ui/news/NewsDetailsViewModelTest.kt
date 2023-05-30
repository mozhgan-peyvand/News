package com.example.ui_news

import androidx.lifecycle.SavedStateHandle
import com.example.base.models.NewsDetailsUiState
import com.example.domain_news.usecase.GetLocalDetailNews
import com.example.ui_news.util.CoroutineRule
import com.example.ui_news.util.FakeNewsListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NewsDetailsViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    @Test
    fun `creating a viewModel retrieves news details from local`() = runTest {

        // Arrange
        val fakeRepository = FakeNewsListRepository()
        fakeRepository.newsDetails = newsDetails

        val saveState = SavedStateHandle(mapOf("id" to 1))

        val viewModel = NewsDetailsViewModel(
            GetLocalDetailNews(fakeRepository),
            saveState
        )

        val expectedState = NewsDetailsUiState(newsDetails = newsDetails)

        // Act
        runCurrent()

        // Assert
        val actualState = viewModel.uiState.value
        assertEquals(expectedState, actualState)

    }
}