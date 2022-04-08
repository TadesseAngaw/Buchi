package com.tadesse.petfinder.util

import android.content.Context
import com.tadesse.petfinder.PetFinderApplication
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Screen {

    companion object {
        private var density: Float = 0.toFloat()
        private var scaledDensity: Float = 0.toFloat()


        fun dp(dp: Float): Int {
            if (density == 0f) {
                density =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.density ?: 0.toFloat();
            }

            return (dp * density + .5f).toInt()
        }

        fun dp(dp: Int): Int {
            if (density == 0f) {
                density =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.density ?: 0.toFloat();
            }

            return (dp * density + .5f).toInt()
        }


        fun dpF(dp: Int): Float {
            if (density == 0f) {
                density =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.density ?: 0.toFloat();
            }

            return (dp * density + .5f)
        }

        fun sp(sp: Float): Int {
            if (scaledDensity == 0f)
                scaledDensity =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.scaledDensity
                        ?: 0.toFloat();

            return (sp * scaledDensity + .5f).toInt()
        }

        fun sp(sp: Int): Int {
            if (scaledDensity == 0f)
                scaledDensity =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.scaledDensity
                        ?: 0.toFloat();

            return (sp * scaledDensity + .5f).toInt()
        }

        fun spF(sp: Int): Float {
            if (scaledDensity == 0f)
                scaledDensity =
                    PetFinderApplication.CONTEXT.resources?.displayMetrics?.scaledDensity
                        ?: 0.toFloat();

            return (sp * scaledDensity + .5f)
        }

        fun getWidth(): Int {
            return PetFinderApplication.CONTEXT.resources?.displayMetrics?.widthPixels ?: 0
        }

        fun getHeight(): Int {
            return PetFinderApplication.CONTEXT.resources?.displayMetrics?.heightPixels ?: 0
        }

        fun getStatusBarHeight(): Int {

            var result = 0
            val resourceId =
                PetFinderApplication.CONTEXT.resources?.getIdentifier(
                    "status_bar_height",
                    "dimen",
                    "android"
                )
            if (resourceId != null) {
                if (resourceId > 0) {
                    result =
                        PetFinderApplication.CONTEXT.resources?.getDimensionPixelSize(resourceId)!!
                }
            }
            return result
        }

        fun getNavbarHeight(): Int {
            if (hasNavigationBar()) {
                val resourceId =
                    PetFinderApplication.CONTEXT.resources?.getIdentifier(
                        "navigation_bar_height",
                        "dimen",
                        "android"
                    )
                if (resourceId != null) {
                    if (resourceId > 0) {
                        return PetFinderApplication.CONTEXT.resources?.getDimensionPixelSize(
                            resourceId
                        )!!
                    }
                }
            }
            return 0
        }

        private fun hasNavigationBar(): Boolean {
            val resources = PetFinderApplication.CONTEXT.resources
            val id = resources?.getIdentifier("config_showNavigationBar", "bool", "android")
            if (id != null) {
                return id > 0 && resources.getBoolean(id)
            }
            return false
        }

        fun getDensity(): Float {
            return density
        }
    }
}