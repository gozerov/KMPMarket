plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("compose-multiplatform-setup")
    id("kotlinx-serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:domain"))
                implementation(project(":common:core"))

                implementation(libs.kodein)
                implementation(libs.ktor.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }
    }
}