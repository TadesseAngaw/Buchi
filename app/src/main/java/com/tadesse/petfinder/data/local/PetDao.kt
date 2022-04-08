package com.tadesse.petfinder.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.tadesse.petfinder.model.Pet

@Dao
interface PetDao {
    @Query("SELECT * FROM pet")
    fun getAll(): LiveData<List<Pet>>

    @Insert(onConflict = IGNORE)
    fun insertAll(vararg pets: Pet)

    @Delete
    fun delete(pet: Pet)
}