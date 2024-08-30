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

                implementation(Libraries.Kodein.kodeinDI)
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)
            }
        }
    }
}