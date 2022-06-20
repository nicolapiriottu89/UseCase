package it.piriottu.usecase.ui.scenes.main.sealed

/**
 * Created by Nicola Luigi Piriottu on 16/06/22.
 */
sealed class PostItem(val type: PostType) {

    enum class PostType {
        TITLE,
        IMAGE,
        DESCRIPTION,
        GALLERY
    }

    data class TitleUIItem(
         val title: String,
         val subtitle: String
    ) : PostItem(PostType.TITLE)

    data class ImageUIItem(
         val imageUrl: String
    ) : PostItem(PostType.IMAGE)

    data class DescriptionUIItem(
        val title: String,
        val body: String
    ) : PostItem(PostType.DESCRIPTION)

    //Feature
    data class GalleryUIItem(
        val title: String,
        val imagesUrl: List<String>
    ) : PostItem(PostType.GALLERY)
}
