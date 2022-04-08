package com.tadesse.petfinder.data.remote

import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.model.PetsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PetFinderApi {

    companion object {
        const val BASE_URL = "http://209.97.133.58:8000"
    }

    @GET("/pet/get_pets")
    suspend fun getPets(
        @Query("type") petType: String,
        @Query("good_with_children") gwt: String?,
        @Query("age") age: String?,
        @Query("gender") gender: String?,
        @Query("size") size: String?,
        @Query("limit") limit: Int = 10,
    ): Response<PetsResponse>
}