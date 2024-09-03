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
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    implementation("com.android.tools.build:gradle:8.2.2")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.6.11")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.22")
    implementation("androidx.room:room-gradle-plugin:2.7.0-alpha06")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.22-1.0.16")
    implementation("io.github.skeptick.libres:gradle-plugin:1.2.2")
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}