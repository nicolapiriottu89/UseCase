package it.piriottu.usecase.ui.scenes.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import it.piriottu.usecase.databinding.FragmentPostBinding
import it.piriottu.usecase.managers.SessionManager
import it.piriottu.usecase.ui.scenes.main.adapters.PostAdapter
import it.piriottu.usecase.ui.scenes.main.viewmodels.PostViewModel

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
class PostFragment : Fragment() {

    /**
     * Binding
     */
    private lateinit var binding: FragmentPostBinding

    /**
     * ViewModel
     * */
    private val viewModel: PostViewModel by viewModels()

    /**
     * Args
     * */
    private val args: PostFragmentArgs by navArgs()

    /**
     * Adapter
     */
    private val adapter by lazy {
        PostAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate & Bind
        binding = FragmentPostBinding.inflate(inflater, container, false)

        // Setup Observer
        setupObservers()

        //TODO copy your token here
        SessionManager.userToken = "COPY-YOUR-TOKEN-HERE"

        //Setup recyclerView
        binding.recyclerView.adapter = adapter

        //Get posts
        viewModel.showPost(args.isShowSimplePost)

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
            findNavController().navigate(PostFragmentDirections.toErrorFragment())
            binding.progress.isVisible = false
        }
    }
    //endregion Private methods
}