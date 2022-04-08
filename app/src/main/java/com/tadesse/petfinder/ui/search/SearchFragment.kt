package com.tadesse.petfinder.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.FragmentSearchBinding
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.ui.base.BaseFragment
import com.tadesse.petfinder.ui.main.MainFragmentDirections
import com.tadesse.petfinder.ui.main.MainViewModel
import com.tadesse.petfinder.util.Resource
import com.tadesse.petfinder.util.SearchPetsItemDecoration
import com.tadesse.petfinder.util.ktx.gone
import com.tadesse.petfinder.util.ktx.show
import com.tadesse.petfinder.util.ktx.showPopup
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(), PetItemListener {

    private val searchViewModel: SearchViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)


    override fun binds() {
        super.binds()

        binding?.searchFormContainer?.show(false)

        val petsAdapter = PetsAdapter(this)
        binding?.apply {
            pets.apply {
                adapter = petsAdapter
                setHasFixedSize(true)
                if (itemDecorationCount == 0) {
                    addItemDecoration(SearchPetsItemDecoration())
                }
            }
        }

        binding?.typeCard?.setOnClickListener {
            binding!!.typeCard.showPopup(R.menu.popup_pet_type) { item ->
                binding?.typeValue?.text = item.title
                searchViewModel.type.postValue(item.title.toString())
                true
            }
        }

        binding?.gwcCard?.setOnClickListener {
            binding!!.gwcCard.showPopup(R.menu.popup_pet_gwc) { item ->
                binding?.gwcValue?.text = item.title
                searchViewModel.gwc.postValue(item.title.toString())
                true
            }
        }

        binding?.ageCard?.setOnClickListener {
            binding!!.ageCard.showPopup(R.menu.popup_pet_age) { item ->
                binding?.ageValue?.text = item.title
                searchViewModel.age.postValue(item.title.toString())
                true
            }
        }

        binding?.genderCard?.setOnClickListener {
            binding!!.genderCard.showPopup(R.menu.popup_pet_gender) { item ->
                binding?.genderValue?.text = item.title
                searchViewModel.gender.postValue(item.title.toString())
                true
            }
        }

        binding?.sizeCard?.setOnClickListener {
            binding!!.sizeCard.showPopup(R.menu.popup_pet_size) { item ->
                binding?.sizeValue?.text = item.title
                searchViewModel.size.postValue(item.title.toString())
                true
            }
        }

        mainViewModel.type.observe(this) {
            binding?.typeValue?.text = it
            searchViewModel.type.postValue(it)
        }

        binding?.start?.setOnClickListener {
            searchViewModel.startSearch()
        }

        binding?.tryAgain?.setOnClickListener {
            searchViewModel.startSearch()
        }

        binding?.searchAgain?.setOnClickListener {
            searchViewModel.stopSearch()
        }

        binding?.swipe?.setOnRefreshListener {
            searchViewModel.startSearch()
        }

        searchViewModel.searchResource.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding?.swipe?.isRefreshing = true
                    binding?.errorContainer?.gone()
                    binding?.emptyContainer?.gone()
                }
                is Resource.Success -> {
                    val data = it.data?.pets
                    binding?.swipe?.isRefreshing = false
                    when {
                        data == null -> {
                            petsAdapter.submitList(emptyList())
                        }
                        data.isEmpty() -> {
                            binding?.emptyContainer?.show()
                        }
                        else -> {
                            petsAdapter.submitList(it.data.pets)
                        }
                    }
                }
                is Resource.Error -> {
                    binding?.swipe?.isRefreshing = false
                    binding?.errorContainer?.show()
                    Snackbar.make(binding?.root!!, it.message!!, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }

        searchViewModel.searching.observe(this) { searching ->
            if (searching) {
                binding?.resultContainer?.show(false)
                binding?.searchFormContainer?.gone(false)
            } else {
                binding?.resultContainer?.gone(false)
                binding?.searchFormContainer?.show(false)
            }
        }

        binding?.clearSearch?.setOnClickListener {
            searchViewModel.stopSearch()
        }


    }

    override fun onPetClicked(pet: Pet) {
        val direction = MainFragmentDirections.actionMainFragmentToPetDetailFragment(pet)
        findNavController().navigate(direction)
    }
}