package com.example.data.news.di

import com.example.data.news.repositories.local.NewsDao
import com.example.data.news.repositories.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NewsDaoModule {
    @Provides
    fun bindNewsDataBase(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao()
    }

}
