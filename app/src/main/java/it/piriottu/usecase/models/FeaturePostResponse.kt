package it.piriottu.usecase.models

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
data class FeaturePostResponse(
    val body: Body,
    val gallery: Gallery,
    val heading: Heading,
    val sub: Sub
) {
    data class Body(
        val partOne: String,
        val partThree: String,
        val partTwo: String,
        val title: String
    )

    data class Gallery(
        val images: List<String>,
        val label: String
    )

    data class Heading(
        val title: String
    )

    data class Sub(
        val subtitle: String
    )
}