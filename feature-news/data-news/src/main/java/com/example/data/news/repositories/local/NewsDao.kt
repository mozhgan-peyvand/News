package com.example.data.news.repositories.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.base.models.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity ORDER BY publishedAt Desc")
    fun getNewsList(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(news: List<NewsEntity>)

    @Query("DELETE FROM NewsEntity")
    suspend fun deleteNewsList()

    @Query("SELECT * FROM NewsEntity WHERE id = :id")
    suspend fun getNewsDetails(id: Int): NewsEntity
}
