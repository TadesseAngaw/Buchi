package com.tadesse.petfinder.util.ktx

import com.tadesse.petfinder.model.Pet

fun Pet.getCoverPhoto(): String {
    return if (photos.isEmpty())
        ""
    else
        photos[0].url

}