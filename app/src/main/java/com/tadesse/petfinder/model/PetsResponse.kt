package com.tadesse.petfinder.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PetsResponse(
    @Json(name = "pets")
    val pets: MutableList<Pet>,
    @Json(name = "status")
    val status: String,
)