// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()  // Required for Android Gradle Plugin
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.3.2")  // The Android Gradle Plugin version you're using
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")  // Kotlin plugin version
    }
}

allprojects {
    repositories {
        google()  // Required for Android dependencies
        mavenCentral()
    }
}
