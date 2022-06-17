package it.piriottu.usecase.repositories.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import it.piriottu.usecase.models.PostResponse
import it.piriottu.usecase.utils.NetworkResponseCode

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
object ApiRepositories {

    private val API_WORKER: ApiWorker = ApiWorker()
    private val networkResponseCode = NetworkResponseCode()

    suspend fun getPost(): NetworkResponse<PostResponse> {

        return try {
            val response: HttpResponse =
                API_WORKER.getClient().get(API_WORKER.BASE_URL + "/posts/1")
            // Return response
            (NetworkResponse.Success(response.receive()))

        } catch (e: Throwable) {
            (NetworkResponse.Error(networkResponseCode.checkError(e)))
        }
    }
}