package it.piriottu.usecase.ui.scenes.main.adapters

import android.view.ViewGroup
import it.piriottu.usecase.ui.scenes.main.uiitems.PostUIItem
import it.piriottu.usecase.ui.scenes.main.viewholders.PostViewHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class PostsListAdapter :
    ListAdapter<PostUIItem, PostViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {

        return PostViewHolder(
            binding = PostViewHolder.getBinding(parent)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
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