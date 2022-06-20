package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.databinding.LayoutPostTitleBinding
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class TitleViewHolder(private val binding: LayoutPostTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostItem.TitleUIItem) {
        binding.layoutPostTitleTv.text = item.title
        binding.layoutPostTitleDescriptionTv.text = item.subtitle
    }

    companion object {
        fun getBinding(parent: ViewGroup): LayoutPostTitleBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostTitleBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}