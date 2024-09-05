plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:auth:domain"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:market:presentation"))
                api(project(":common:market:api"))

                implementation(libs.kodein)
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }
        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}