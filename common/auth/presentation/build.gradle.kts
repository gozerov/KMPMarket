plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
    id("io.github.skeptick.libres")
}

libres {
    generatedClassName = "AuthRes"
    generateNamedArguments = true
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:market:domain"))
                implementation(project(":common:auth:domain"))
                implementation(project(":common:core"))

                implementation(compose.runtime)

                implementation(libs.navigation)

                implementation(libs.viewmodel)

                implementation(libs.libres.compose)
            }
        }
    }
}

android {
    namespace = "ru.gozerov.kmpmarket.auth.presentation"
}