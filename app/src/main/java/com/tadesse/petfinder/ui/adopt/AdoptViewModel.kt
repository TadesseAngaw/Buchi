package com.tadesse.petfinder.ui.adopt

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdoptViewModel @Inject constructor(
    private val petRepository: PetRepository,
) : ViewModel() {

    fun adopt(pet: Pet) {
        CoroutineScope(Dispatchers.IO).launch {
            petRepository.insertFavoritePet(pet)
        }
    }
}