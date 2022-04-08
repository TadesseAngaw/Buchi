plugins {
    id(Plugins.IDs.androidApplication)
    id(Plugins.IDs.kotlinAndroid)
    id(Plugins.IDs.kapt)
    id(Plugins.IDs.hilt)
    id(Plugins.IDs.safeArgs)
    id(Plugins.IDs.parcelize)
}


android {
    compileSdk = PetFinderApp.compileSdk

    defaultConfig {
        applicationId = PetFinderApp.applicationId
        minSdk = PetFinderApp.minSdk
        targetSdk = PetFinderApp.targetSdk
        versionCode = PetFinderApp.versionCode
        versionName = PetFinderApp.versionName
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false

            applicationVariants.all {
                val variant = this
                variant.outputs
                    .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
                    .forEach { output ->
                        output.outputFileName = getOutputFileName(variant.productFlavors[0].name)
                    }
            }
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

            applicationVariants.all {
                val variant = this
                variant.outputs
                    .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
                    .forEach { output ->
                        output.outputFileName = getOutputFileName(variant.productFlavors[0].name)
                    }
            }
        }
    }

    flavorDimensions.addAll(listOf("type"))

    productFlavors {
        create("dev") {
            dimension = "type"
            applicationId = PetFinderApp.applicationIdDev
        }

        create("production") {
            dimension = "type"
            applicationId = PetFinderApp.applicationId
        }
    }

    dependencies {

        implementation(Libraries.kotlin)
        implementation(Libraries.materialDesign)

        implementation(Libraries.Android.multidex)
        implementation(Libraries.Android.appcompat)
        implementation(Libraries.Android.core)
        implementation(Libraries.Android.startup)
        implementation(Libraries.Android.activity)
        implementation(Libraries.Android.constraintLayout)
        implementation(Libraries.Android.swipeRefreshLayout)

        implementation(Libraries.Lifecycle.viewModel)
        implementation(Libraries.Lifecycle.liveData)
        implementation(Libraries.Lifecycle.runtime)

        implementation(Libraries.Navigation.fragment)
        implementation(Libraries.Navigation.ui)

        implementation(Libraries.Hilt.hilt)
        kapt(Libraries.Hilt.compiler)

        implementation(Libraries.Retrofit.retrofit)
        implementation(Libraries.Retrofit.moshiRetrofitConverter)
        implementation(Libraries.Okhttp.logging)

        implementation(Libraries.Moshi.moshi)
        kapt(Libraries.Moshi.codeGen)

        implementation(Libraries.Room.room)
        implementation(Libraries.Room.runtime)
        kapt(Libraries.Room.compiler)

        implementation(Libraries.Glide.glide)
        kapt(Libraries.Glide.compiler)

        implementation(Libraries.Coroutines.core)
        implementation(Libraries.Coroutines.android)

        implementation(Libraries.timber)

        implementation(Libraries.imageViewer)

    }
}



