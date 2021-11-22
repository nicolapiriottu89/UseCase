package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.databinding.LayoutPostItemBinding
import it.piriottu.usecase.ui.scenes.main.uiitems.PostUIItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class PostViewHolder(private val binding: LayoutPostItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostUIItem) {
        binding.title.text = item.title
        binding.body.text = item.body
    }

    companion object {
        fun getBinding(parent: ViewGroup): LayoutPostItemBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostItemBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}