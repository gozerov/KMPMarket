plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
    id("io.github.skeptick.libres")
}

libres {
    generateNamedArguments = true // false by default
    baseLocaleLanguageCode = "ru"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:domain"))
                implementation(project(":common:core"))

                implementation(compose.runtime)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)

                implementation(libs.libres.compose)
            }
        }
    }
}