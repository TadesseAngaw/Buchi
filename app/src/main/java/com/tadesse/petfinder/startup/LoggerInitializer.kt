package com.tadesse.petfinder.startup

import android.content.Context
import androidx.startup.Initializer
import com.tadesse.petfinder.BuildConfig
import timber.log.Timber

class LoggerInitializer : Initializer<Context> {
    override fun create(context: Context): Context {

        // Initialize timber if the build is only debug
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        return context
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}