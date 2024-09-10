rootProject.name = "KMPMarket"

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":common:auth:data")
include(":common:auth:domain")
include(":common:auth:presentation")
include(":common:users:data")
include(":common:users:domain")
include(":common:users:presentation")
include(":common:market:data")
include(":common:market:domain")
include(":common:market:presentation")
include(":common:umbrella-compose")
include(":common:core")