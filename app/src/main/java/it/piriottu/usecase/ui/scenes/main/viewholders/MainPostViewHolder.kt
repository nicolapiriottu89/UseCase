package it.piriottu.usecase.ui.scenes.main.viewholders

import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.databinding.LayoutPostItemBinding
import it.piriottu.usecase.ui.scenes.main.uiitems.PostUIItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class MainPostViewHolder(private val binding: LayoutPostItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostUIItem) {
        binding.title.text = item.title
        binding.body.text = item.body
    }
}