package it.piriottu.usecase.repositories.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import it.piriottu.usecase.models.FeaturePostResponse
import it.piriottu.usecase.models.SimplePostResponse
import it.piriottu.usecase.utils.NetworkResponseCode

/**
 * Created by OverApp on 21/09/21.
 *  Visit https://www.overapp.com/
 */
object ApiRepositories {

    private val API_WORKER: ApiWorker = ApiWorker()
    private val networkResponseCode = NetworkResponseCode()

    suspend fun getSimplePost(): NetworkResponse<SimplePostResponse> {

        return try {
            val response: HttpResponse =
                API_WORKER.getClient().get(API_WORKER.BASE_URL + "/simple")
            // Return response
            (NetworkResponse.Success(response.receive()))

        } catch (e: Throwable) {
            (NetworkResponse.Error(networkResponseCode.checkError(e)))
        }
    }

    suspend fun getFeaturePost(): NetworkResponse<FeaturePostResponse> {

        return try {
            val response: HttpResponse =
                API_WORKER.getClient().get(API_WORKER.BASE_URL + "/gallery")
            // Return response
            (NetworkResponse.Success(response.receive()))

        } catch (e: Throwable) {
            (NetworkResponse.Error(networkResponseCode.checkError(e)))
        }
    }
}