package com.tadesse.petfinder.data.local

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.tadesse.petfinder.model.Photo

class Converters {
    private val moshi = Moshi.Builder().build()
    private val petsPhotoType = Types.newParameterizedType(
        List::class.java,
        Photo::class.java
    )
    private val adapter: JsonAdapter<List<Photo>> = moshi.adapter(petsPhotoType)

    @TypeConverter
    fun fromString(value: String): List<Photo>? {
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromArrayList(list: List<Photo>): String {
        return adapter.toJson(list)
    }
}