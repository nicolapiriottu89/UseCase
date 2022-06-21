package it.piriottu.usecase.ui.scenes.main.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.piriottu.usecase.databinding.LayoutPostGalleryItemBinding
import it.piriottu.usecase.ui.scenes.main.adapters.ImageGalleryAdapter
import it.piriottu.usecase.ui.scenes.main.sealed.PostItem

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
class GalleryViewHolder(private val binding: LayoutPostGalleryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Adapter
     */
    private val adapter by lazy {
        ImageGalleryAdapter()
    }

    init {
        //Setup recyclerView
        binding.layoutPostGalleyRv.adapter = adapter
    }

    fun bind(item: PostItem.GalleryUIItem) {
        binding.layoutPostGalleyTitleTv.text = item.title

        adapter.submitList(item.imagesUrl)
    }

    companion object {
        fun getLayoutInflated(parent: ViewGroup): LayoutPostGalleryItemBinding {
            val inflater = LayoutInflater.from(parent.context)

            return LayoutPostGalleryItemBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}