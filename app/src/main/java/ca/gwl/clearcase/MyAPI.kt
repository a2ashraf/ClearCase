package ca.gwl.clearcase

import retrofit2.Response
import retrofit2.http.GET

interface MyAPI {
    @GET("api/v1?new")
    suspend fun makeRequest(): Response<Unit>
}