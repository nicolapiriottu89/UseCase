package it.piriottu.usecase.ui.scenes.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.piriottu.usecase.databinding.FragmentErrorBinding
import it.piriottu.usecase.databinding.FragmentMainBinding
import it.piriottu.usecase.databinding.FragmentPostsBinding


class ErrorFragment : Fragment() {

    /**
     * Binding
     */
    private lateinit var binding: FragmentErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate & Bind
        binding = FragmentErrorBinding.inflate(inflater, container, false)
        // Return root view
        return binding.root
    }
    //endregion Private methods
}