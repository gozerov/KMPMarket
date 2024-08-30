plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("compose-multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:domain"))
                implementation(Libraries.Kodein.kodeinDI)
            }
        }
    }
}