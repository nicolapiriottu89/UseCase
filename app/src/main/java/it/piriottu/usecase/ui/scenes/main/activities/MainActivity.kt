package it.piriottu.usecase.ui.scenes.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import it.piriottu.usecase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * Binding
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}