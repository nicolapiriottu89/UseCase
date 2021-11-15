package it.piriottu.usecase.ui.scenes.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import it.piriottu.usecase.ui.scenes.main.viewmodels.MainActivityViewModel
import it.piriottu.usecase.databinding.ActivityMainBinding
import it.piriottu.usecase.managers.SessionManager
import it.piriottu.usecase.ui.scenes.main.adapters.MainListAdapter

/**
 * Created by OverApp on 15/11/21.
 *  Visit https://www.overapp.com/
 */
class MainActivity : AppCompatActivity() {


    /**
     * Binding
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * ViewModel
     **/
    private val viewModel: MainActivityViewModel by viewModels()

    /**
     * Adapter
     */
    private val adapter: MainListAdapter by lazy {
        MainListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup
        setupObserver()
        //TODO copy your token here
        SessionManager.userToken = "COPY-YOUR-TOKEN-HERE"

        //Setup recyclerView
        binding.recyclerView.adapter = adapter

        //Get posts
        viewModel.getPosts()
    }

    private fun setupObserver() {
        // Use Case
        viewModel.useCaseLiveData.observe(this, {
            it.getContentIfNotHandled()?.let { useCase ->
                binding.progress.isVisible = false
                when (useCase) {

                    is MainActivityViewModel.UseCaseLiveData.ShowPosts -> {
                        // Update Items
                        adapter.submitList(useCase.items)

                        Log.d("MainActivity", "ShowItems ${useCase.items}")
                    }

                    is MainActivityViewModel.UseCaseLiveData.Error -> {
                        Log.d("MainActivity", "Error ${useCase.code}")
                    }

                }
            }
        })
    }


}