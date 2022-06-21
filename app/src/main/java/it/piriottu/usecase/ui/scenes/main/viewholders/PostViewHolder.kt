package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.databinding.LayoutPostItemBinding
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class PostViewHolder(private val binding: LayoutPostItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostItem.DescriptionUIItem) {
        binding.layoutPostItemTitleTv.text = item.title
        binding.layoutPostItemBodyTv.text = item.body
    }

    companion object {
        fun getLayoutInflated(parent: ViewGroup): LayoutPostItemBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostItemBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}