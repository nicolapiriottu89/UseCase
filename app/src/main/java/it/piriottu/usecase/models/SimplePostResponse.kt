package it.piriottu.usecase.models

/**
 * UseCase
 *
 * Created by Nicola Luigi Piriottu on 15/11/21.
 * Copyright © 2021 UseCase. All rights reserved.
 */
data class SimplePostResponse(
    val description: Description,
    val title: Title,
    val image: String
) {
    data class Description(
        val body: String,
        val title: String
    )

    data class Title(
        val subtitle: String,
        val title: String
    )
}