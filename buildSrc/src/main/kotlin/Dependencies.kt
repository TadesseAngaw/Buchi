object Versions {
    const val androidPlugin = "7.1.2"
    const val kotlin = "1.6.10"
    const val multidex = "2.0.1"
    const val appcompat = "1.4.1"
    const val core = "1.7.0"
    const val startup = "1.1.1"
    const val activity = "1.4.0"
    const val constraintLayout = "2.1.3"
    const val swipeRefresh = "1.1.0"
    const val lifecycle = "2.4.1"
    const val navigation = "2.4.1"
    const val hilt = "2.38.1"
    const val moshi = "1.13.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.7.2"
    const val coroutines = "1.6.0"
    const val room = "2.4.2"
    const val glide = "4.13.0"
    const val material = "1.5.0"
    const val timber = "5.0.1"
    const val imageViewer = "v1.0.1"
}

object PetFinderApp {
    const val applicationId = "com.tadesse.petfinder"
    const val applicationIdDev = "com.tadesse.petfinder.dev"
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Libraries {

    object Android {
        const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val startup = "androidx.startup:startup-runtime:${Versions.startup}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshiRetrofitConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Okhttp {
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object Room {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:glide:${Versions.glide}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21-2"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val imageViewer = "com.github.stfalcon-studio:StfalconImageViewer:${Versions.imageViewer}"
}

object Plugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"


    object IDs {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val kapt = "kotlin-kapt"
        const val hilt = "dagger.hilt.android.plugin"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
        const val parcelize = "kotlin-parcelize"
    }
}


