package com.tadesse.petfinder.repository

import com.tadesse.petfinder.data.local.PetDao
import com.tadesse.petfinder.data.remote.PetFinderApi
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.model.PetsResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PetRepository @Inject constructor(
    private val petFinderApi: PetFinderApi,
    private val petDao: PetDao
) {

    suspend fun searchPets(
        petType: String,
        gwc: String?,
        age: String?,
        gender: String?,
        size: String?,
        limit: Int
    ): Response<PetsResponse> {
        return petFinderApi.getPets(petType, gwc, age, gender, size, limit)
    }

    fun getAllFavorites() = petDao.getAll()

    fun insertFavoritePet(pet: Pet) = petDao.insertAll(pet)

    fun deletePet(pet: Pet) = petDao.delete(pet)

}