package com.tadesse.petfinder.ui.search

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tadesse.petfinder.R
import com.tadesse.petfinder.model.PetsResponse
import com.tadesse.petfinder.repository.PetRepository
import com.tadesse.petfinder.util.Connectivity
import com.tadesse.petfinder.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val petRepository: PetRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val searching: MutableLiveData<Boolean> = MutableLiveData(false)
    val type: MutableLiveData<String> = MutableLiveData("Dog")
    val gwc: MutableLiveData<String> = MutableLiveData()
    val age: MutableLiveData<String> = MutableLiveData()
    val gender: MutableLiveData<String> = MutableLiveData()
    val size: MutableLiveData<String> = MutableLiveData()

    val searchResource: MutableLiveData<Resource<PetsResponse>> = MutableLiveData()

    fun stopSearch() {
        searching.postValue(false)
        searchResource.postValue(Resource.Success(null))
    }

    fun startSearch() = viewModelScope.launch {
        searching.postValue(true)
        safeSearchPets()
    }

    private suspend fun safeSearchPets() {
        searchResource.postValue(Resource.Loading())
        try {
            if (Connectivity.isDeviceConnected(context)) {
                val response = petRepository.searchPets(
                    petType = type.value!!,
                    gwc = gwc.value?.lowercase(),
                    age = age.value?.lowercase(),
                    gender = gender.value?.lowercase(),
                    size = size.value?.lowercase(),
                    limit = 20
                )
                response.body()?.let {
                    searchResource.postValue(Resource.Success(it))
                }
            } else {
                searchResource.postValue(Resource.Error(context.getString(R.string.fragmentSearchErrorDisconnected)))
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            when (ex) {
                is IOException -> searchResource.postValue(Resource.Error(context.getString(R.string.fragmentSearchErrorDisconnected)))
                else -> searchResource.postValue(Resource.Error(context.getString(R.string.fragmentSearchErrorServerProblem)))
            }
        }
    }

}