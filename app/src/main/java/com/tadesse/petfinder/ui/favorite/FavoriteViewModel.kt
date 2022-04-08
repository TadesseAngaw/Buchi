package com.tadesse.petfinder.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val petRepository: PetRepository,
) : ViewModel() {

    fun getAllFavoritePets(): LiveData<List<Pet>> {
        return petRepository.getAllFavorites()
    }

}