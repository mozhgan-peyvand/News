package com.example.ui_news

import com.example.base.models.Exceptions
import com.example.base.models.NewsListUiState
import com.example.domain_news.usecase.GetLocalNews
import com.example.domain_news.usecase.GetRemoteNews
import com.example.ui_news.util.CoroutineRule
import com.example.ui_news.util.FakeNewsListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NewsListViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    @Test
    fun `creating a viewModel retrieves news list from local`() = runTest {

        // Arrange
        val fakeRepository = FakeNewsListRepository()
        fakeRepository.newsList = flowOf(listOf(news1, news2))

        val viewModel = NewsListViewModel(
            getRemoteNews = GetRemoteNews(fakeRepository),
            getLocalNews = GetLocalNews(fakeRepository)
        )

        val expectedState = NewsListUiState(newsList = listOf(news1, news2))

        // Act
        runCurrent()

        // Assert
        val actualState = viewModel.uiState.value
        assertEquals(expectedState, actualState)
    }

    @Test
    fun `creating a viewModel exposes loading ui state`() = runTest {

        // Arrange
        val fakeRepository = FakeNewsListRepository()

        val viewModel = NewsListViewModel(
            getRemoteNews = GetRemoteNews(fakeRepository),
            getLocalNews = GetLocalNews(fakeRepository)
        )

        val expectedState = NewsListUiState(isLoading = true)

        // Assert
        val actualState = viewModel.uiState.value
        assertEquals(expectedState, actualState)

    }

    @Test
    fun `creating a viewModel updates ui state to not loading and no error after update news from remote successfully`() =
        runTest {

            // Arrange
            val fakeRepository = FakeNewsListRepository()

            val viewModel = NewsListViewModel(
                getRemoteNews = GetRemoteNews(fakeRepository),
                getLocalNews = GetLocalNews(fakeRepository)
            )
            val expectedState = NewsListUiState(isLoading = false, error = null)

            // Act
            runCurrent()

            // Assert
            val actualState = viewModel.uiState.value
            assertEquals(expectedState, actualState)

        }

    @Test
    fun `creating a viewModel updates ui state to not loading with error message in case of failure update news from remote`() =
        runTest {

            // Arrange
            val fakeRepository = FakeNewsListRepository(isSuccessful = false)

            val viewModel = NewsListViewModel(
                getRemoteNews = GetRemoteNews(fakeRepository),
                getLocalNews = GetLocalNews(fakeRepository)
            )

            val expectedState =
                NewsListUiState(isLoading = false, error = Exceptions.GeneralRemoteException())

            // Act
            runCurrent()

            // Assert
            val actualState = viewModel.uiState.value
            assertEquals(expectedState, actualState)

        }
}