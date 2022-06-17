package it.piriottu.usecase.ui.scenes.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import it.piriottu.usecase.databinding.FragmentPostsBinding
import it.piriottu.usecase.managers.SessionManager
import it.piriottu.usecase.ui.scenes.main.adapters.PostsListAdapter
import it.piriottu.usecase.ui.scenes.main.viewmodels.PostsFragmentViewModel


class PostsFragment : Fragment() {

    /**
     * Binding
     */
    private lateinit var binding: FragmentPostsBinding

    /**
     * ViewModel
     * */
    private val viewModel: PostsFragmentViewModel by viewModels()

    /**
     * Adapter
     */
    private val adapter by lazy {
        PostsListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate & Bind
        binding = FragmentPostsBinding.inflate(inflater, container, false)

        // Setup Observer
        setupObservers()

        //TODO copy your token here
        SessionManager.userToken = "COPY-YOUR-TOKEN-HERE"

        //Setup recyclerView
        binding.recyclerView.adapter = adapter

        //Get posts
        viewModel.getPosts()

        // Return root view
        return binding.root

    }

    //region Private methods

    private fun setupObservers() {
        // Use Case

        viewModel.postLiveData.observe(viewLifecycleOwner) { items ->
            // Update Items
            adapter.submitList(items)
            binding.progress.isVisible = false
        }

        viewModel.errorAPILiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(PostsFragmentDirections.toErrorFragment())
            binding.progress.isVisible = false
        }

        viewModel.useCaseLiveData.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { useCase ->
                binding.progress.isVisible = false
                when (useCase) {

                    is PostsFragmentViewModel.UseCaseLiveData.ShowPosts -> {
                        // Update Items
                        adapter.submitList(useCase.items)

                        Log.d("MainActivity", "ShowItems ${useCase.items}")
                    }

                    is PostsFragmentViewModel.UseCaseLiveData.Error -> {
                        Log.d("MainActivity", "Error ${useCase.code}")
                        findNavController().navigate(PostsFragmentDirections.toErrorFragment())
                    }

                }
            }
        }
    }
    //endregion Private methods
}