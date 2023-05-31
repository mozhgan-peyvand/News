package com.example.news.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.news.repositories.local.NewsDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Binds
    @Singleton
    abstract fun bindNewsDataBase(appDatabase: AppDataBase): NewsDatabase

    @Binds
    @Singleton
    abstract fun bindDataBase(appDatabase: AppDataBase): RoomDatabase

    companion object {
        @Singleton
        @Provides
        fun provideDb(@ApplicationContext context: Context): AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, "com.mozhgan.peivandian.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}