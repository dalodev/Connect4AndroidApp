buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Deps.Plugins.androidGradle)
        classpath(Deps.Plugins.kotlinGradle)
        classpath(Deps.Plugins.navSafeArgs)
        classpath(Deps.Plugins.daggerHiltGradle)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io") }
    }
}