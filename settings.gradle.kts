pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        // Ensure you're using the correct plugin versions
        id("com.android.application") version "8.1.0"
        id("org.jetbrains.kotlin.android") version "1.9.10"
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DeltaTask1"
include(":app")
