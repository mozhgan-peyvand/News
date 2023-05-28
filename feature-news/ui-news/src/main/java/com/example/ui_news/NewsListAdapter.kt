package com.example.ui_news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.base.models.NewsEntity
import com.example.ui_news.databinding.ItemNewsBinding


class NewsListAdapter(
    private val onItemClick: (NewsEntity) -> Unit
) : ListAdapter<NewsEntity, NewsListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<NewsEntity>() {
        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            binding.listItem.setOnClickListener {
                onItemClick.invoke(getItem(bindingAdapterPosition))
            }
        }

        fun bind(news: NewsEntity) {
            binding.newsTitle.text = news.title
            binding.newsImage.load(news.urlToImage)
        }

    }
}