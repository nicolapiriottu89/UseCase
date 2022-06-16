package it.piriottu.usecase.ui.scenes.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import it.piriottu.usecase.databinding.FragmentMainBinding
import it.piriottu.usecase.ui.scenes.main.viewmodels.MainFragmentViewModel


class MainFragment : Fragment() {
    /**
     * Binding
     */
    private lateinit var binding: FragmentMainBinding

    /**
     * ViewModel
     * */
    private val viewModel: MainFragmentViewModel by viewModels()

    //region Fragment Life-Cycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate & Bind
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Setup view
        setupView()
        // Setup Observer
        setupObservers()
        // Return root view
        return binding.root
    }

    //endregion Fragment Life-Cycle
    //region Private methods
    private fun setupView() {
        //Set Continue Button
        binding.fragmentGetPosts.setOnClickListener {
            viewModel.onPostsClicked()
        }

        binding.fragmentError.setOnClickListener {
            viewModel.onErrorClicked()
        }
    }

    private fun setupObservers() {
        // Use Case
        viewModel.useCaseLiveData.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { useCase ->
                when (useCase) {
                    is MainFragmentViewModel.UseCaseLiveData.GoToPostsFragment -> {
                        findNavController().navigate(MainFragmentDirections.toPostsFragment())
                    }

                    is MainFragmentViewModel.UseCaseLiveData.GoToErrorFragment -> {
                        findNavController().navigate(MainFragmentDirections.toErrorFragment())
                    }
                }
            }
        }
    }
    //endregion Private methods
}