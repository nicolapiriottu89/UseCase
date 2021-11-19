package it.piriottu.usecase.ui.scenes.main.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.fragment.NavHostFragment
import it.piriottu.usecase.R
import it.piriottu.usecase.ui.scenes.main.viewmodels.PostsFragmentViewModel
import it.piriottu.usecase.databinding.ActivityMainBinding
import it.piriottu.usecase.ui.scenes.main.adapters.PostsListAdapter

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
     * Nav Controller
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}