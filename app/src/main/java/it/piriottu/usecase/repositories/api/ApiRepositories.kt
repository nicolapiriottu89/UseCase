package it.piriottu.usecase.repositories.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import it.piriottu.usecase.models.PhotosResponse
import it.piriottu.usecase.models.PostResponse
import it.piriottu.usecase.utils.NetworkResponseCode

object ApiRepositories {

    private val API_WORKER: ApiWorker = ApiWorker()
    private val networkResponseCode = NetworkResponseCode()

    suspend fun getPost(userId:Int): NetworkResponse<PostResponse> {

        return try {
            val response: HttpResponse =
                API_WORKER.getClient().get(API_WORKER.BASE_URL + "/posts/"+userId)

            // Return response
            NetworkResponse.Success(response.body())

        } catch (e: Throwable) {
            (NetworkResponse.Error(networkResponseCode.checkError(e)))
        }
    }

    suspend fun getPhoto(userId:Int): NetworkResponse<PhotosResponse> {

        return try {
            val response: HttpResponse =
                API_WORKER.getClient().get(API_WORKER.BASE_URL + "/photos/"+userId)

            // Return response
            NetworkResponse.Success(response.body())

        } catch (e: Throwable) {
            (NetworkResponse.Error(networkResponseCode.checkError(e)))
        }
    }
}