package it.piriottu.usecase.ui.scenes.main.adapters

import android.view.ViewGroup
import it.piriottu.usecase.ui.scenes.main.viewholders.PostViewHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.ui.scenes.main.sealed.PostsItem
import it.piriottu.usecase.ui.scenes.main.sealed.PostsItem.PostsType.*
import it.piriottu.usecase.ui.scenes.main.viewholders.ImageViewHolder
import it.piriottu.usecase.ui.scenes.main.viewholders.TitleViewHolder

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class PostsListAdapter :
    ListAdapter<PostsItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return when (values()[viewType]) {
            TITLE -> {
                TitleViewHolder(
                    binding = TitleViewHolder.getBinding(parent)
                )
            }
            IMAGE -> {
                ImageViewHolder(
                    binding = ImageViewHolder.getBinding(parent)
                )
            }
            POST -> {
                PostViewHolder(
                    binding = PostViewHolder.getBinding(parent)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItem(position).type) {
            TITLE -> {
                (holder as TitleViewHolder).bind(getItem(position) as PostsItem.TitleUIItem)
            }
            IMAGE -> {
                (holder as ImageViewHolder).bind(getItem(position) as PostsItem.ImageUIItem)
            }
            POST -> {
                (holder as PostViewHolder).bind(getItem(position) as PostsItem.PostUIItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = getItem(position).type.ordinal

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostsItem>() {
            override fun areItemsTheSame(oldItem: PostsItem, newItem: PostsItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: PostsItem, newItem: PostsItem) =
                oldItem == newItem
        }
    }
}