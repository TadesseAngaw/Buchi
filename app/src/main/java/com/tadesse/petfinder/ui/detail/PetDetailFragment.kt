package com.tadesse.petfinder.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.FragmentPetDetailBinding
import com.tadesse.petfinder.ui.base.BaseActivity
import com.tadesse.petfinder.ui.base.BaseFragment
import com.tadesse.petfinder.ui.search.PetsAdapter
import com.tadesse.petfinder.util.ktx.getCoverPhoto
import com.tadesse.petfinder.util.ktx.gone
import com.tadesse.petfinder.util.ktx.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PetDetailFragment : BaseFragment<FragmentPetDetailBinding>() {

    private val args: PetDetailFragmentArgs by navArgs()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPetDetailBinding.inflate(inflater, container, false)


    override fun binds() {
        super.binds()
        (activity as BaseActivity<*>).setSupportActionBar(binding?.toolbar)
        val supportActionBar = (activity as BaseActivity<*>).supportActionBar
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding?.toolbar?.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val pet = args.pet
        binding?.type?.text = pet.type
        binding?.gwc?.text =
            if (pet.goodWithChildren) getString(R.string.fragmentPetDetailGwcYes) else getString(R.string.fragmentPetDetailGwcNo)
        binding?.age?.text = getString(R.string.fragmentPetDetailAge, pet.age)
        binding?.gender?.text = getString(R.string.fragmentPetDetailGender, pet.gender)
        binding?.size?.text = getString(R.string.fragmentPetDetailSize, pet.size)

        val errorImage = when (pet.type) {
            "Dog" -> R.drawable.dog_no_image
            "Cat" -> R.drawable.cat_no_image
            "Rabbit" -> R.drawable.dog_no_image
            else -> 0
        }

        if (pet.photos.size > 1) {
            binding?.petImages?.show(false)
            binding?.petImage?.gone(false)
            binding?.swipeMessage?.show(false)
            val adapter = PetPhotosAdapter(pet)
            binding?.petImages?.adapter = adapter
        } else {
            binding?.petImage?.show(false)
            binding?.petImages?.gone(false)
            binding?.swipeMessage?.gone(false)
            binding?.petImage?.apply {
                Glide.with(this)
                    .load(pet.getCoverPhoto())
                    .error(errorImage)
                    .centerCrop()
                    .into(this)
            }
        }

        binding?.adoptMe?.setOnClickListener {
            val direction = PetDetailFragmentDirections.actionPetDetailFragmentToAdoptFragment(pet)
            findNavController().navigate(direction)
        }
    }


}