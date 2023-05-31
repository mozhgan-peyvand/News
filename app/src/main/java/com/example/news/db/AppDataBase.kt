package com.example.news.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.base.models.NewsEntity
import com.example.data.news.repositories.local.NewsDatabase


@Database(
    entities = [NewsEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase(), NewsDatabase