package it.piriottu.usecase.usecases

import it.piriottu.usecase.models.PhotosResponse
import it.piriottu.usecase.repositories.api.NetworkResponse

interface PhotosResponseUseCase {
    suspend fun getPhoto(userId:Int): NetworkResponse<PhotosResponse>
}