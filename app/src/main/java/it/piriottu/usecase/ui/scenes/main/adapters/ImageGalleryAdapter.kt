package it.piriottu.usecase.ui.scenes.main.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import it.piriottu.usecase.ui.scenes.main.viewholders.ImageGalleryViewHolder

/**
 * Created by Nicola Luigi Piriottu on 20/06/22.
 */
class ImageGalleryAdapter :
    ListAdapter<String, ImageGalleryViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageGalleryViewHolder {

        return ImageGalleryViewHolder(
            binding = ImageGalleryViewHolder.getBinding(parent)
        )
    }

    override fun onBindViewHolder(holder: ImageGalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
    }
}
