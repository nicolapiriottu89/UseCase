package it.piriottu.usecase.models

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
data class FeaturePostResponse(
    val description: Description,
    val gallery: Gallery,
    val title: Title,
    val subtitle: Subtitle
) {
    data class Description(
        val partOne: String,
        val partThree: String,
        val partTwo: String,
        val title: String
    )

    data class Gallery(
        val images: List<String>,
        val label: String
    )

    data class Title(
        val title: String
    )

    data class Subtitle(
        val subtitle: String
    )
}