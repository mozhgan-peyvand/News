package com.example.news.testNewsDatabase

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.example.data.android.dataSourceImpl.NewsLocalDataSourceImpl
import com.example.data.news.repositories.local.NewsDao
import com.example.news.db.AppDataBase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class NewsLocalDataSourceImplTest {
    private lateinit var database: AppDataBase
    private lateinit var newsListDao: NewsDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java).build()
        newsListDao = database.newsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    fun canReadNewsDetailsFromTheDb() = runTest {

        // Arrange
        val newsListDataSource = NewsLocalDataSourceImpl(newsListDao)
        newsListDataSource.insertTopHeadLines(listOf(newsEntity1))
        val expectedNewsDetails = newsEntity1

        // Act
        val actualNewsDetails = newsListDataSource.getNewsDetails(1)


        // Assert
        assertEquals(expectedNewsDetails, actualNewsDetails)
    }

    @Test
    fun canSaveNewsListToTheDbAndObserveData() = runTest {

        // Arrange
        val localDataSource = NewsLocalDataSourceImpl(newsListDao)
        val expectedList = listOf(newsEntity1, newsEntity2)

        // Act
        val newsListFlow = localDataSource.getTopHeadLines()
        localDataSource.insertTopHeadLines(listOf(newsEntity1, newsEntity2))

        // Assert
        newsListFlow.test {
            assertEquals(expectedList, awaitItem())
        }
    }

    @Test
    fun canRemoveNewsListFromTheDb() = runTest {

        // Arrange
        val localDataSource = NewsLocalDataSourceImpl(newsListDao)
        localDataSource.insertTopHeadLines(listOf(newsEntity1, newsEntity2))

        // Act
        val newsFlow = localDataSource.getTopHeadLines()
        localDataSource.removeTopHeadlines()


        // Assert
        newsFlow.test {
            assertEquals(0, awaitItem().size)
        }
    }
}