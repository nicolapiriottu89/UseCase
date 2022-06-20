package it.piriottu.usecase.ui.scenes.main.adapters

import android.view.ViewGroup
import it.piriottu.usecase.ui.scenes.main.viewholders.PostViewHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem.PostType.*
import it.piriottu.usecase.ui.scenes.main.viewholders.GalleryViewHolder
import it.piriottu.usecase.ui.scenes.main.viewholders.ImageViewHolder
import it.piriottu.usecase.ui.scenes.main.viewholders.TitleViewHolder

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class PostAdapter :
    ListAdapter<PostItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

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
            DESCRIPTION -> {
                PostViewHolder(
                    binding = PostViewHolder.getBinding(parent)
                )
            }
            //Feature
            GALLERY -> {
                GalleryViewHolder(binding = GalleryViewHolder.getBinding(parent))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItem(position).type) {
            TITLE -> {
                (holder as TitleViewHolder).bind(getItem(position) as PostItem.TitleUIItem)
            }
            IMAGE -> {
                (holder as ImageViewHolder).bind(getItem(position) as PostItem.ImageUIItem)
            }
            DESCRIPTION -> {
                (holder as PostViewHolder).bind(getItem(position) as PostItem.DescriptionUIItem)
            }
            //Feature
            GALLERY -> {
                (holder as GalleryViewHolder).bind(getItem(position) as PostItem.GalleryUIItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = getItem(position).type.ordinal

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostItem>() {
            override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem) =
                oldItem == newItem
        }
    }
}