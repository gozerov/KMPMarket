import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidApplication.get().pluginId)
    id(libs.plugins.jetbrainsCompose.get().pluginId)
    id(libs.plugins.serialization.get().pluginId)
    id(libs.plugins.ksp.get().pluginId)
    id(libs.plugins.room.get().pluginId)
    kotlin("native.cocoapods")
}

version = "1.0.0"

kotlin {
    androidTarget {

    }
    cocoapods {
        summary = "Sample KMP Project"
        homepage = "https://github.com/sample/KMP-Project"

        ios.deploymentTarget = "17.0"

        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "composeApp"
            isStatic = true
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            transitiveExport = false
            export(project(":common:core"))
            export(project(":common:umbrella-compose"))
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }

        val commonMain by getting {
            dependencies {
                implementation(project(":common:umbrella-compose"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)

                implementation(libs.cupertino)
                implementation(libs.cupertino.adaptive)
                implementation(libs.cupertino.native)

                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)

                implementation(libs.coil.compose.core)
                implementation(libs.coil.mp)
                implementation(libs.coil.network.ktor)
                implementation(libs.coil.compose)
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)

                implementation(libs.kodein)

                implementation(libs.viewmodel)

                implementation(libs.sqlite.driver)
                implementation(libs.sqlite.bundled)
                implementation(libs.room.runtime)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.darwin)
                api(project(":common:core"))
                api(project(":common:umbrella-compose"))
            }
        }


    }
}

android {
    namespace = "ru.gozerov.kmpmarket"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "ru.gozerov.kmpmarket"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

}


room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    afterEvaluate {
        add("kspIosSimulatorArm64", libs.room.compiler)
        add("kspIosX64", libs.room.compiler)
        add("kspIosArm64", libs.room.compiler)
    }
    implementation(project(":common:umbrella-compose"))
    implementation(project(":common:core"))
    implementation(project(":common:auth:domain"))
}