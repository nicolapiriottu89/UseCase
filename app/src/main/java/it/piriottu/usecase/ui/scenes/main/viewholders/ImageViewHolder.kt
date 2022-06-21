package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.piriottu.usecase.databinding.LayoutPostImageBinding
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class ImageViewHolder(private val binding: LayoutPostImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostItem.ImageUIItem) {

        Glide.with(binding.layoutPostImageIv).load(item.imageUrl)
            .into(binding.layoutPostImageIv)

    }

    companion object {
        fun getLayoutInflated(parent: ViewGroup): LayoutPostImageBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostImageBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}