package com.example.data_android.di

import com.example.data_android.dataSourceImpl.NewsLocalDataSourceImpl
import com.example.data_android.dataSourceImpl.NewsRemoteDataSourceImpl
import com.example.data_news.repositories.local.NewsLocalDataSource
import com.example.data_news.repositories.remote.NewsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NewsDataSourceModule  {

    @Binds
    fun provideNewsRemote(newsRemoteDataSource: NewsRemoteDataSourceImpl) : NewsRemoteDataSource

    @Binds
    fun provideNewsLocal(newsLocalDataSourceImpl: NewsLocalDataSourceImpl) : NewsLocalDataSource

}