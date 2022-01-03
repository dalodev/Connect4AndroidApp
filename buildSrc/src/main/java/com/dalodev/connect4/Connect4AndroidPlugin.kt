package com.dalodev.connect4

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import PLUGIN_ANDROID_APPLICATION
import PLUGIN_KOTLIN_ANDROID
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.kotlin.dsl.findByType

class Connect4AndroidPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        configurePlugins()
        configureAndroid()
    }

    private fun Project.configurePlugins() {
        plugins.apply(PLUGIN_KOTLIN_ANDROID)
    }

    private fun Project.configureAndroid() {
        configureAndroidCommonInfo()
        configureAndroidApplicationId()
    }

    private fun Project.configureAndroidCommonInfo() {
        extensions.findByType<BaseExtension>()?.run {
            compileSdkVersion(AppConfig.compileSdkVersion)
            buildToolsVersion(AppConfig.buildToolsVersion)

            defaultConfig {
                minSdk = AppConfig.minSdkVersion
                targetSdk = AppConfig.targetSdkVersion
                versionCode = AppConfig.versionCode
                versionName = AppConfig.versionName

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }
            buildFeatures.compose = true

            composeOptions {
                kotlinCompilerExtensionVersion = Deps.AndroidX.compose_version
            }

            buildTypes {
                // Enabling accessing sites with http schemas for testing (especially
                // instrumented tests using MockWebServer) and disabling it in the
                // production to avoid security issues
                getByName("debug") {
                    versionNameSuffix = "-DEBUG"
                    isDebuggable = true
                    manifestPlaceholders["usesCleartextTraffic"] = true
                    isTestCoverageEnabled = true
                }

                getByName("release") {
                    manifestPlaceholders["usesCleartextTraffic"] = false
                    isMinifyEnabled = true
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }

            compileOptions {
                sourceCompatibility = AppConfig.javaCompatibilityVersion
                targetCompatibility = AppConfig.javaCompatibilityVersion
            }

            // Without the below block, a build failure was happening when running ./gradlew connectedAndroidTest
            // See: https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-debug#debug-agent-and-android
            packagingOptions {
                // for JNA and JNA-platform
                excludes.add("META-INF/AL2.0")
                excludes.add("META-INF/LGPL2.1")
                // for byte-buddy
                excludes.add("META-INF/licenses/ASM")
                pickFirsts.add("win32-x86-64/attach_hotspot_windows.dll")
                pickFirsts.add("win32-x86/attach_hotspot_windows.dll")
            }

            // https://dagger.dev/hilt/gradle-setup#classpath-aggregation
            lintOptions {
                isCheckReleaseBuilds = false
                isAbortOnError = false
            }
            testOptions {
                unitTests.isIncludeAndroidResources = true
                unitTests.isReturnDefaultValues = true
            }
        }
    }

    private fun Project.configureAndroidApplicationId() {
        plugins.withId(PLUGIN_ANDROID_APPLICATION) {
            extensions.findByType<BaseAppModuleExtension>()?.run {
                defaultConfig {
                    applicationId = AppConfig.applicationId
                }
            }
        }
    }

}