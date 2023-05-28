package com.example.data_news.di

import com.example.data_news.repositories.NewsRepositoryImpl
import com.example.domain_news.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NewsRepositoryModule {

    @Binds
    @Singleton
    fun provideGetNewsRepository(NewsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}