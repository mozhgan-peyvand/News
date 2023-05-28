package com.example.data_news.repositories.local


interface NewsDatabase {
    fun newsDao(): NewsDao
}