package com.tadesse.petfinder.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.ItemPetSearchBinding
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.util.Screen
import com.tadesse.petfinder.util.ktx.getCoverPhoto

class PetsAdapter(val petItemListener: PetItemListener) :
    ListAdapter<Pet, PetsAdapter.PetViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val binding =
            ItemPetSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    inner class PetViewHolder(val binding: ItemPetSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.apply {

                val errorImage = when (pet.type) {
                    "Dog" -> R.drawable.dog_no_image
                    "Cat" -> R.drawable.cat_no_image
                    "Rabbit" -> R.drawable.dog_no_image
                    else -> 0
                }

                Glide.with(petImage)
                    .load(pet.getCoverPhoto())
                    .error(errorImage)
                    .centerCrop()
                    .into(petImage)

                typeValue.text = pet.type[0].uppercase()
                itemView.setOnClickListener {
                    petItemListener.onPetClicked(pet)
                }
            }
        }
    }


}

class DiffCallback : DiffUtil.ItemCallback<Pet>() {
    override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
        return oldItem.petId == newItem.petId
    }

    override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
        return oldItem == newItem
    }

}

interface PetItemListener {
    fun onPetClicked(pet: Pet)
}