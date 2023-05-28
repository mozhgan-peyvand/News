package com.example.data_news.di

import com.example.data_news.repositories.local.NewsDao
import com.example.data_news.repositories.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsDaoModule {

    companion object {
        @Provides
        fun bindNewsDataBase(newsDatabase: NewsDatabase): NewsDao {
            return newsDatabase.newsDao()
        }
    }

}
