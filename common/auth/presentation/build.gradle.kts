plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:domain"))
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)
            }
        }
    }
}