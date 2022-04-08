package com.tadesse.petfinder.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tadesse.petfinder.databinding.FragmentHomeBinding
import com.tadesse.petfinder.ui.base.BaseFragment
import com.tadesse.petfinder.ui.main.MainFragment
import com.tadesse.petfinder.ui.main.MainViewModel
import com.tadesse.petfinder.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModels: HomeViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun binds() {
        super.binds()

        binding?.dogContainer?.setOnClickListener {
            startSearch("Dog")
        }

        binding?.catContainer?.setOnClickListener {
            startSearch("Cat")
        }

        binding?.otherContainer?.setOnClickListener {
            startSearch("Other")
        }
    }

    private fun startSearch(type: String) {
        (parentFragment as MainFragment).navigateTo(1)
        mainViewModel.type.postValue(type)
    }

}