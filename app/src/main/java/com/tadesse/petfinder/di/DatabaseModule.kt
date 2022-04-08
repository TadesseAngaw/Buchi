package com.tadesse.petfinder.di

import android.app.Application
import androidx.room.Room
import com.tadesse.petfinder.data.local.BuchiDatabase
import com.tadesse.petfinder.data.local.PetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): BuchiDatabase {
        return Room.databaseBuilder(application, BuchiDatabase::class.java, "buchi")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticleDao(db: BuchiDatabase): PetDao {
        return db.getPetDao()
    }
}