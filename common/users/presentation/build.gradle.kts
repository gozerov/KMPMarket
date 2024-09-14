plugins {
    id("multiplatform-setup")
    id("compose-multiplatform-setup")
    id("android-setup")
    id("io.github.skeptick.libres")
}

libres {
    generatedClassName = "UsersRes"
    generateNamedArguments = true
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:users:domain"))
                implementation(project(":common:core"))

                implementation(compose.runtime)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.cupertino)
                implementation(libs.cupertino.adaptive)
                implementation(libs.cupertino.native)

                implementation(libs.viewmodel)

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
    namespace = "ru.gozerov.kmpmarket.users.presentation"
}