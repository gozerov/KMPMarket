plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kodein)
            }
        }
    }
}