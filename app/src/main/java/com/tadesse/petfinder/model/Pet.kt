package com.tadesse.petfinder.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity
@JsonClass(generateAdapter = true)
@Parcelize
data class Pet(
    @ColumnInfo(name = "age")
    @Json(name = "age")
    val age: String,
    @ColumnInfo(name = "gender")
    @Json(name = "gender")
    val gender: String,
    @ColumnInfo(name = "good_with_children")
    @Json(name = "good_with_children")
    val goodWithChildren: Boolean,
    @Json(name = "pet_id")
    @ColumnInfo(name = "pet_id")
    @PrimaryKey
    val petId: String,
    @Json(name = "photos")
    val photos: List<Photo>,
    @Json(name = "size")
    val size: String,
    @Json(name = "source")
    val source: String,
    @Json(name = "type")
    val type: String
) : Parcelable