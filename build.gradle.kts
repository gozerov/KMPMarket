plugins {
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.androidLibrary.get().pluginId) apply false
    id(libs.plugins.jetbrainsCompose.get().pluginId) apply false
    id(libs.plugins.kotlinMultiplatform.get().pluginId) apply false
    id(libs.plugins.serialization.get().pluginId) apply false
    id(libs.plugins.room.get().pluginId) apply false
    id(libs.plugins.ksp.get().pluginId) apply false
    id(libs.plugins.libres.get().pluginId) apply false
    id("multiplatform-setup") apply false
    id("compose-multiplatform-setup") apply false
    id("android-setup") apply false
}