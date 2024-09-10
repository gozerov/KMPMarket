plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("io.github.skeptick.libres")
}

compose.resources {
    publicResClass = false
    packageOfResClass = "ru.gozerov.kmpmarket.common.umbrella-compose.resources"
    generateResClass = auto
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
                implementation(project(":common:market:domain"))
                implementation(project(":common:market:data"))
                implementation(project(":common:users:presentation"))
                implementation(project(":common:users:domain"))
                implementation(project(":common:users:data"))


                implementation(libs.kodein)
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(compose.ui)
                implementation(compose.components.resources)

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