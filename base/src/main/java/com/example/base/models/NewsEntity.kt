package com.example.base.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val content: String,
    val publishedAt: String,
    val urlToImage: String
){
    fun toNewsDetails() = NewsDetails(
        id = id,
        title = title,
        description = description,
        content = content,
        urlToImage = urlToImage
    )
}
