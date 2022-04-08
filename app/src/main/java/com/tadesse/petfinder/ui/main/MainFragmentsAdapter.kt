package com.tadesse.petfinder.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tadesse.petfinder.ui.favorite.FavoriteFragment
import com.tadesse.petfinder.ui.home.HomeFragment
import com.tadesse.petfinder.ui.search.SearchFragment
import javax.inject.Inject
import javax.inject.Singleton

class MainFragmentsAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> HomeFragment()
            1 -> SearchFragment()
            2 -> FavoriteFragment()
            else -> HomeFragment()
        }
    }
}