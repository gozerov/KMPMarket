plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(Libraries.Kotlin.gradlePlugin)
    implementation(Libraries.AndroidX.gradlePlugin)
    implementation(Libraries.Compose.gradlePlugin)
    implementation(Libraries.Room.gradlePlugin)
    implementation(Libraries.Kotlin.Serialization.gradlePlugin)
    implementation(Libraries.Ksp.gradlePlugin)
    implementation(Libraries.Libres.gradlePlugin)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}