package com.tadesse.petfinder.ui.decider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import com.tadesse.petfinder.databinding.FragmentDeciderBinding
import com.tadesse.petfinder.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DeciderFragment : BaseFragment<FragmentDeciderBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDeciderBinding.inflate(inflater, container, false)


    override fun binds() {
        super.binds()
    }
}