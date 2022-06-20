package it.piriottu.usecase.models

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
data class SimplePostResponse(
    val body: Body,
    val heading: Heading,
    val image: String
) {
    data class Body(
        val body: String,
        val title: String
    )

    data class Heading(
        val subtitle: String,
        val title: String
    )
}