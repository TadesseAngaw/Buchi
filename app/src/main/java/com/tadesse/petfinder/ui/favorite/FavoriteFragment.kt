package com.tadesse.petfinder.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tadesse.petfinder.databinding.FragmentFavoriteBinding
import com.tadesse.petfinder.ui.base.BaseFragment
import com.tadesse.petfinder.ui.main.MainFragment
import com.tadesse.petfinder.util.SearchPetsItemDecoration
import com.tadesse.petfinder.util.ktx.gone
import com.tadesse.petfinder.util.ktx.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFavoriteBinding.inflate(inflater, container, false)

    override fun binds() {
        super.binds()
        val favoritesAdapter = FavoritesAdapter()

        binding?.favoritePets?.apply {
            adapter = favoritesAdapter
            if (itemDecorationCount == 0) {
                addItemDecoration(SearchPetsItemDecoration())
            }
        }

        binding?.search?.setOnClickListener {
            (parentFragment as MainFragment).navigateTo(1)
        }

        favoriteViewModel.getAllFavoritePets().observe(this) { pets ->
            if (pets.isEmpty()) {
                binding?.emptyContainer?.show()
                binding?.favoritePets?.gone()
            } else {
                binding?.emptyContainer?.gone()
                binding?.favoritePets?.show()
                favoritesAdapter.submitList(pets)
            }
        }

    }

}