package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.piriottu.usecase.databinding.LayoutPostGalleryImageBinding
import it.piriottu.usecase.databinding.LayoutPostImageBinding
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class ImageGalleryViewHolder(private val binding: LayoutPostGalleryImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {

        Glide.with(binding.layoutPostGalleryImageIv).load(item)
            .into(binding.layoutPostGalleryImageIv)

    }

    companion object {
        fun getBinding(parent: ViewGroup): LayoutPostGalleryImageBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostGalleryImageBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}