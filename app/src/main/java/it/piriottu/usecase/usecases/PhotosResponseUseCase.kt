package it.piriottu.usecase.usecases

import it.piriottu.usecase.models.PhotosResponse
import it.piriottu.usecase.repositories.api.NetworkResponse

interface PhotosResponseUseCase {
    suspend fun getPhotoByUserId(userId:Int): NetworkResponse<PhotosResponse>
}