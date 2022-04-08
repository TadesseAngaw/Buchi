package com.tadesse.petfinder

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetFinderApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }

    companion object {
        lateinit var CONTEXT: PetFinderApplication
    }
}