package com.tadesse.petfinder.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.MaterialToolbar
import com.stfalcon.imageviewer.StfalconImageViewer
import com.stfalcon.imageviewer.listeners.OnImageChangeListener
import com.tadesse.petfinder.R
import com.tadesse.petfinder.model.Pet
import com.tadesse.petfinder.model.Photo

class PetPhotosAdapter(val pet: Pet) : RecyclerView.Adapter<PetPhotosAdapter.PetPhotoViewHolder>() {

    lateinit var imageViewer: StfalconImageViewer<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetPhotoViewHolder {
        val view: View = ImageView(parent.context)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        view.isClickable = true
        view.isFocusable = true
        return PetPhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetPhotoViewHolder, position: Int) {
        holder.bind(pet.photos[position], position)
    }

    override fun getItemCount() = pet.photos.size

    inner class PetPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var petPhoto: ImageView


        fun bind(photo: Photo, position: Int) {
            val errorImage = when (pet.type) {
                "Dog" -> R.drawable.dog_no_image
                "Cat" -> R.drawable.cat_no_image
                "Rabbit" -> R.drawable.dog_no_image
                else -> 0
            }

            petPhoto = itemView as ImageView
            Glide.with(petPhoto)
                .load(photo.url)
                .error(errorImage)
                .centerCrop()
                .into(petPhoto)

            val overlayView = LayoutInflater.from(itemView.context)
                .inflate(R.layout.view_overlay_image, null, false)
            val overlayToolbar: MaterialToolbar = overlayView.findViewById(R.id.overlayToolbar)
            val overlayDescription: TextView = overlayView.findViewById(R.id.overlayDescription)


            overlayToolbar.setNavigationOnClickListener {
                imageViewer.close()
            }

            imageViewer = StfalconImageViewer.Builder(
                petPhoto.context,
                pet.photos.map { it.url }) { view, image ->
                Glide.with(view)
                    .load(image)
                    .error(errorImage)
                    .into(view)
            }.withTransitionFrom(petPhoto)
                .withOverlayView(overlayView)
                .withImageChangeListener { page ->
                    overlayDescription.text = "${page + 1}/${pet.photos.size}"
                }
                .build()
            imageViewer.setCurrentPosition(position)
            itemView.setOnClickListener {
                imageViewer.setCurrentPosition(position)
                overlayDescription.text = "${position + 1}/${pet.photos.size}"
                imageViewer.show()
            }


        }
    }
}