package com.tadesse.petfinder.ui.favorite


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tadesse.petfinder.R
import com.tadesse.petfinder.databinding.ItemPetFavoriteBinding
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.util.ktx.getCoverPhoto

class FavoritesAdapter() :
    ListAdapter<Pet, FavoritesAdapter.PetViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val binding =
            ItemPetFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    inner class PetViewHolder(val binding: ItemPetFavoriteBinding) :
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

                itemView.setOnClickListener {
                }

                type.text = pet.type
                gwc.text =
                    if (pet.goodWithChildren) itemView.context.getString(R.string.fragmentPetDetailGwcYes)
                    else itemView.context.getString(R.string.fragmentPetDetailGwcNo)
                age.text = itemView.context.getString(R.string.fragmentPetDetailAge, pet.age)
                gender.text = itemView.context.getString(R.string.fragmentPetDetailGender, pet.gender)
                size.text = itemView.context.getString(R.string.fragmentPetDetailSize, pet.size)
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
