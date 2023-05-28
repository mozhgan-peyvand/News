package com.example.news

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.base.models.NewsEntity
import com.example.data_news.repositories.local.NewsDatabase


@Database(
    entities = [NewsEntity::class],
    version = 8
)
abstract class AppDataBase : RoomDatabase(), NewsDatabase