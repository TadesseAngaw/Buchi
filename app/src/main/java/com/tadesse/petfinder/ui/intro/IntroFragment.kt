package com.tadesse.petfinder.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import androidx.navigation.fragment.findNavController
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.FragmentIntroBinding
import com.tadesse.petfinder.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : BaseFragment<FragmentIntroBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentIntroBinding.inflate(inflater, container, false)

    override fun binds() {
        super.binds()

        val animate = TranslateAnimation(0F, 0F, 600F, 0F)
        animate.duration = 600
        animate.fillAfter = true
        binding?.introBannerText?.startAnimation(animate)

        binding?.start?.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_mainFragment)
        }
    }
}