package it.piriottu.usecase.interactors

import it.piriottu.usecase.models.PhotosResponse
import it.piriottu.usecase.repositories.api.ApiRepositories
import it.piriottu.usecase.repositories.api.NetworkResponse
import it.piriottu.usecase.usecases.PhotosResponseUseCase

class GetPhotosResponse(private val repository: ApiRepositories): PhotosResponseUseCase {

    override suspend fun getPhotoByUserId(userId: Int): NetworkResponse<PhotosResponse> {
      return repository.getPhotoByUserId(userId)
    }

}