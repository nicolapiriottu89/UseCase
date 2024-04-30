package it.piriottu.usecase.models

import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)