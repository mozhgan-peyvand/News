package com.example.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.base.util.collectOn
import com.example.base.util.viewBinding
import com.example.ui.news.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    private val binding by viewBinding(FragmentNewsDetailBinding::bind)
    private val viewModel by viewModels<NewsDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.collectOn(viewLifecycleOwner) { uiState ->
            binding.apply {
                uiState.newsDetails?.let {
                    newsTitle.text = it.title
                    newsDescription.text = it.description
                    newsContent.text = it.content
                    newsImage.load(it.urlToImage)
                }

            }
        }
    }
}