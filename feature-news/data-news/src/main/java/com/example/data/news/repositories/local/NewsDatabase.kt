package com.example.data.news.repositories.local


interface NewsDatabase {
    fun newsDao(): NewsDao
}
