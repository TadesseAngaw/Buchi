package com.tadesse.petfinder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.FragmentMainBinding
import com.tadesse.petfinder.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    val mainViewModel: MainViewModel by activityViewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)


    override fun binds() {
        super.binds()
        binding?.pager?.adapter = MainFragmentsAdapter(this)

        binding?.pager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val menuId = getMenuFromPage(position)
                if (menuId > 0) {
                    binding?.bottomNav?.selectedItemId = menuId
                }
            }
        })

        binding?.bottomNav?.setOnItemSelectedListener { menu ->
            val page = getPageFromMenu(menu)
            if (page >= 0) {
                binding?.pager?.currentItem = page
                return@setOnItemSelectedListener true
            }
            false
        }
    }


    private fun getPageFromMenu(menu: MenuItem): Int {
        return when (menu.itemId) {
            R.id.homeFragment -> 0
            R.id.searchFragment -> 1
            R.id.favoriteFragment -> 2
            else -> -1
        }
    }

    private fun getMenuFromPage(page: Int): Int {
        return when (page) {
            0 -> R.id.homeFragment
            1 -> R.id.searchFragment
            2 -> R.id.favoriteFragment
            else -> -1
        }
    }

    fun navigateTo(page: Int) {
        binding!!.pager.currentItem = page
    }
}