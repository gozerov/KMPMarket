object Versions {
    const val kotlin = "1.9.22"
    const val serialization = "1.9.22"
    const val agp = "8.2.2"
    const val androidCompileSdk = "34"
    const val androidMinSdk = "24"
    const val androidTargetSdk = "34"
    const val composePlugin = "1.6.11"
    const val androidxActivityCompose = "1.9.1"
    const val androidxAppCompat = "1.7.0"
    const val androidxConstraintLayout = "2.1.4"
    const val androidxCoreKtx = "1.13.1"
    const val androidxEspressoCore = "3.6.1"
    const val androidxLifecycle = "2.8.0"
    const val androidxMaterial = "1.12.0"
    const val androidxTestJunit = "1.2.1"
    const val junit = "4.13.2"
    const val odyssey = "1.3.60"
    const val kviewmodel = "0.13"
    const val libres = "1.2.2"
    const val koin = "3.3.2"
    const val ksp = "1.9.22-1.0.16"
    const val sqlite = "2.5.0-alpha06"
    const val coil3 = "3.0.0-alpha06"
    const val ktor = "2.3.7"
    const val room = "2.7.0-alpha06"
    const val kodeinDI = "7.22.0"
}

object Libraries {

    object JUnit {
        const val junit = "junit:junit:${Versions.junit}"
    }

    object Kotlin {

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

        const val test = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        const val testJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

        object Serialization {

            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.serialization}"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}"
        }

    }

    object AndroidX {

        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.agp}"

        const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtx}"
        const val testJUnit = "androidx.test.ext:junit:${Versions.androidxTestJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.androidxEspressoCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
        const val material = "com.google.android.material:material:${Versions.androidxMaterial}"
        const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.androidxConstraintLayout}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.androidxActivityCompose}"
        const val lifecycleViewmodel = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel:${Versions.androidxLifecycle}"
        const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.androidxLifecycle}"

    }

    object Compose {

        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:${Versions.composePlugin}"

    }

    object Room {

        const val gradlePlugin = "androidx.room:room-gradle-plugin:${Versions.room}"

    }

    object Ksp {

        const val gradlePlugin = "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.ksp}"

    }

    object Libres {

        const val gradlePlugin = "io.github.skeptick.libres:gradle-plugin:${Versions.libres}"

    }

    object Ktor {

        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"

    }

    object Kodein {

        const val kodeinDI = "org.kodein.di:kodein-di:${Versions.kodeinDI}"

    }

}

object Plugins {

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val jetbrainsCompose = "org.jetbrains.compose"
    const val composeCompiler = "org.jetbrains.kotlin.plugin.compose"
    const val kotlinMultiplatform = "org.jetbrains.kotlin.multiplatform"
    const val serialization = "org.jetbrains.kotlin.plugin.serialization"
    const val libres = "io.github.skeptick.libres"
    const val ksp = "com.google.devtools.ksp"
    const val room = "androidx.room"

}