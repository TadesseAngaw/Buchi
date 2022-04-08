package com.tadesse.petfinder.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Photo(
    @Json(name = "url")
    val url: String
) : Parcelable