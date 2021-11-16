package it.piriottu.usecase.ui.scenes.main.adapters

import android.view.ViewGroup
import it.piriottu.usecase.ui.scenes.main.uiitems.PostUIItem
import it.piriottu.usecase.ui.scenes.main.viewholders.MainPostViewHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class MainListAdapter :
    ListAdapter<PostUIItem, MainPostViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainPostViewHolder {

        return MainPostViewHolder(
            binding = MainPostViewHolder.getBinding(parent)
        )
    }

    override fun onBindViewHolder(holder: MainPostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostUIItem>() {
            override fun areItemsTheSame(oldItem: PostUIItem, newItem: PostUIItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: PostUIItem, newItem: PostUIItem) =
                oldItem == newItem
        }
    }
}