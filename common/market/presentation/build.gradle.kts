plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
    id("io.github.skeptick.libres")
}

libres {
    generatedClassName = "MarketRes"
    generateNamedArguments = true
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:market:domain"))
                implementation(project(":common:market:domain"))
                implementation(project(":common:core"))

                implementation(compose.runtime)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)

                implementation(libs.libres.compose)
                implementation(libs.coil.compose)
                implementation(libs.coil.compose.core)
                implementation(libs.coil.mp)
                implementation(libs.coil.network.ktor)
            }
        }
    }
}

android {
    namespace = "ru.gozerov.kmpmarket.market.presentation"
}