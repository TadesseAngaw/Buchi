package com.tadesse.petfinder.ui.adopt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.FragmentAdoptBinding
import com.tadesse.petfinder.ui.base.BaseActivity
import com.tadesse.petfinder.ui.base.BaseFragment
import com.tadesse.petfinder.util.KeyboardUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdoptFragment : BaseFragment<FragmentAdoptBinding>() {

    private val args: AdoptFragmentArgs by navArgs()
    private val adoptViewModel: AdoptViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAdoptBinding.inflate(inflater, container, false)

    override fun binds() {
        super.binds()
        (activity as BaseActivity<*>).setSupportActionBar(binding?.toolbar)
        val supportActionBar = (activity as BaseActivity<*>).supportActionBar
        supportActionBar?.setTitle(R.string.fragmentAdoptTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding?.toolbar?.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val pet = args.pet

        binding?.nameEdit?.doOnTextChanged { text, start, before, count ->
            binding?.nameLayout?.error = ""
        }

        binding?.phoneEdit?.doOnTextChanged { text, start, before, count ->
            binding?.phoneLayout?.error = ""
        }

        binding?.send?.setOnClickListener {
            val name = binding?.nameEdit?.text.toString()
            val phone = binding?.phoneEdit?.text.toString()

            if (name.trim().isEmpty()) {
                binding?.nameLayout?.error = getString(R.string.fragmentAdoptNameEmptyError)
                return@setOnClickListener
            }

            if (phone.trim().isEmpty()) {
                binding?.phoneLayout?.error = getString(R.string.fragmentAdoptPhoneNumberEmptyError)
                return@setOnClickListener
            }

            KeyboardUtils.forceCloseKeyboard(binding?.root!!)

            adoptViewModel.adopt(pet)

            Snackbar.make(binding?.root!!, R.string.fragmentAdoptSuccess, Snackbar.LENGTH_SHORT)
                .show()
            findNavController().navigateUp()

        }
    }

}