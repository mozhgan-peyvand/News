package com.example.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.base.util.collectOn
import com.example.base.util.safeNavigate
import com.example.base.util.viewBinding
import com.example.ui_news.R
import com.example.ui_news.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private val binding by viewBinding(FragmentNewsListBinding::bind)
    private val viewModel by viewModels<NewsListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // region initView
        binding.retry.btnRetry.setOnClickListener {
            viewModel.updateTopHeadLines()
        }
        // endregion initView

        // region initRecyclerView
        val adapter = NewsListAdapter { news ->
            safeNavigate(
                NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                    news.id
                )
            )
        }
        binding.newsList.let { newsList ->
            newsList.adapter = adapter
            newsList.setHasFixedSize(true)
        }
        // endregion initRecyclerView

        // region initObservation
        viewModel.uiState.collectOn(viewLifecycleOwner) { uiState ->

            binding.apply {
                progress.isVisible = uiState.isLoading
                newsList.isVisible = !uiState.isLoading
                retry.root.isVisible = !uiState.isLoading && uiState.error != null
                uiState.error?.let { retry.errorMessage.text = getText(it.messageId) }
            }

            adapter.submitList(uiState.newsList)
        }
        // endregion initObservation
    }
}