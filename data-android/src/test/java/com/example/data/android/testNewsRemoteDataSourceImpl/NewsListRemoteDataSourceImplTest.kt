package com.example.data_android.testNewsRemoteDataSourceImpl

import com.example.base.api.NetworkCallHandler
import com.example.data_news.repositories.remote.NewsService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.example.base.models.Resource
import com.example.base.models.Exceptions
import com.example.data_android.dataSourceImpl.NewsRemoteDataSourceImpl
import com.example.data_android.testNewsRemoteDataSourceImpl.api.FakeConnectionManager
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class NewsListRemoteDataSourceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: NewsService

    private val client = OkHttpClient.Builder().build()

    @Before
    fun createServer() {
        mockWebServer = MockWebServer()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // setting a dummy url
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
            .create(NewsService::class.java)
    }

    @After
    fun shutdownServer() {
        mockWebServer.shutdown()
    }

    @Test
    fun `correct news list response is parsed into success result`() = runTest {

        // Arrange
        val response = MockResponse()
            .setBody(newsListSuccessfulResponse)
            .setResponseCode(200)

        mockWebServer.enqueue(response)

        val remoteDataSource = NewsRemoteDataSourceImpl(
            apiService,
            NetworkCallHandler(FakeConnectionManager())
        )
        val expectedNewsList = listOf(newsResponse1, newsResponse2)

        // Act
        val result = remoteDataSource.getNewsList()

        // Assert
        assert(result is Resource.Success)
        assertEquals((result as Resource.Success).data.articles, expectedNewsList)
    }

    @Test
    fun `malformed news list response returns error`() = runTest {

        // Arrange
        val response = MockResponse()
            .setBody(errorResponse)
            .setResponseCode(200)

        mockWebServer.enqueue(response)

        val remoteDataSource = NewsRemoteDataSourceImpl(
            apiService,
            NetworkCallHandler(FakeConnectionManager())
        )

        // Act
        val result = remoteDataSource.getNewsList()

        // Assert
        assert(result is Resource.Error)
        assert((result as Resource.Error).error is Exceptions.GeneralRemoteException)
    }

    @Test
    fun `error news list response returns error result`() = runTest {

        // Arrange
        val response = MockResponse()
            .setBody(newsListSuccessfulResponse)
            .setResponseCode(400)

        mockWebServer.enqueue(response)

        val remoteDataSource = NewsRemoteDataSourceImpl(
            apiService,
            NetworkCallHandler(FakeConnectionManager())
        )

        // Act
        val result = remoteDataSource.getNewsList()

        // Assert
        assert(result is Resource.Error)
        assert((result as Resource.Error).error is Exceptions.GeneralRemoteException)
    }

}