import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

const val PLUGIN_CONNECT4_ANDROID = "com.dalodev.connect4"
const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"
const val PLUGIN_ANDROID_APPLICATION = "com.android.application"
const val PLUGIN_NAV_SAFE_ARGS_KOTLIN = "androidx.navigation.safeargs.kotlin"
const val PLUGIN_DAGGER_HILT_ANDROID = "dagger.hilt.android.plugin"
const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
const val PLUGIN_ANDROID_LIBRARY = "com.android.library"
const val PLUGIN_KOTLIN = "kotlin"
const val PLUGIN_KOTLINX_SERIALIZATION = "org.jetbrains.kotlin.plugin.serialization"

fun PluginDependenciesSpec.connect4Android(): PluginDependencySpec {
    return id(PLUGIN_CONNECT4_ANDROID)
}

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec {
    return id(PLUGIN_ANDROID_LIBRARY)
}

fun PluginDependenciesSpec.androidApplication(): PluginDependencySpec {
    return id(PLUGIN_ANDROID_APPLICATION)
}

fun PluginDependenciesSpec.kotlinKapt(): PluginDependencySpec {
    return id(PLUGIN_KOTLIN_KAPT)
}

fun PluginDependenciesSpec.navSafeArgsKotlin(): PluginDependencySpec {
    return id(PLUGIN_NAV_SAFE_ARGS_KOTLIN)
}

fun PluginDependenciesSpec.daggerHiltAndroid(): PluginDependencySpec {
    return id(PLUGIN_DAGGER_HILT_ANDROID)
}

fun PluginDependenciesSpec.kotlin(): PluginDependencySpec {
    return id(PLUGIN_KOTLIN)
}

fun PluginDependenciesSpec.kotlinxSerialization(): PluginDependencySpec {
    return (id(PLUGIN_KOTLINX_SERIALIZATION) version Versions.kotlin)
}