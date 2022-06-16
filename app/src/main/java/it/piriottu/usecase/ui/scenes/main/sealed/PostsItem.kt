package it.piriottu.usecase.ui.scenes.main.sealed

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Nicola Luigi Piriottu on 16/06/22.
 */
sealed class PostsItem(val type: PostsType) {

    enum class PostsType {
        TITLE,
        IMAGE,
        POST
    }

    data class TitleUIItem(
        @StringRes val titleResId: Int,
        @StringRes val descriptionResId: Int
    ) : PostsItem(PostsType.TITLE)

    data class ImageUIItem(
        @DrawableRes val imageResId: Int
    ) : PostsItem(PostsType.IMAGE)

    data class PostUIItem(
        val title: String,
        val body: String
    ) : PostsItem(PostsType.POST)
}
