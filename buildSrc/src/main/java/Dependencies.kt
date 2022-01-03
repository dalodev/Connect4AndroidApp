import org.gradle.api.JavaVersion

object AppConfig {

    const val compileSdkVersion = 31
    const val targetSdkVersion = 31
    const val minSdkVersion = 26
    const val buildToolsVersion = "30.0.2"
    const val applicationId = "com.dalodev.connect4"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val javaCompatibilityVersion = JavaVersion.VERSION_1_8
    val kotlinCompatibilityVersion = JavaVersion.VERSION_1_8

}

object Versions {

    const val kotlin = "1.5.31" // also in buildSrc build.gradle.kts file
    const val navigation = "2.3.5"
    const val daggerHilt = "2.38.1"
    const val coroutines = "1.5.2"
    const val room = "2.3.0-rc01"
}

object Deps {

    object Plugins {

        private const val gradlePluginVersion = "7.0.4" // also in buildSrc build.gradle.kts file

        const val androidGradle = "com.android.tools.build:gradle:${gradlePluginVersion}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val navSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        const val daggerHiltGradle =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
    }

    object Local {

        const val app = ":app"
    }

    object Kotlin {

        private const val serializationVersion = "1.3.0"

        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"

    }

    object AndroidX {

        private const val appCompatVersion = "1.4.0"
        private const val constraintLayoutVersion = "2.0.4"
        private const val recyclerViewVersion = "1.2.0"
        private const val viewPager2Version = "1.0.0"
        private const val lifecycleVersion = "2.4.0-alpha01"
        private const val coreKtxVersion = "1.7.0"
        private const val fragmentKtxVersion = "1.3.2"
        private const val pagingVersion = "2.1.2"
        const val compose_version = "1.0.1"

        const val appCompat = "androidx.appcompat:appcompat:${appCompatVersion}"
        const val navFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${recyclerViewVersion}"
        const val viewPager2 = "androidx.viewpager2:viewpager2:${viewPager2Version}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}"
         const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${lifecycleVersion}"
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val coreKtx = "androidx.core:core-ktx:${coreKtxVersion}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${fragmentKtxVersion}"
        const val paging = "androidx.paging:paging-runtime:${pagingVersion}"
        const val composeUi = "androidx.compose.ui:ui:$compose_version"
        const val composeMaterial = "androidx.compose.material:material:$compose_version"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:$compose_version"
        const val composeActivity = "androidx.activity:activity-compose:1.3.0-alpha06"
        const val composeActivityUiTooling = "androidx.compose.ui:ui-tooling:$compose_version"
    }

    object Google {

        private const val materialComponentsVersion = "1.3.0"
        private const val dataBindingVersion = "3.1.4"

        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val daggerHiltCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
        const val materialComponents =
            "com.google.android.material:material:${materialComponentsVersion}"
        const val dataBinding = "com.android.databinding:cinouker:$dataBindingVersion"

    }

    object Square {
        private const val picassoVersion = "2.8"
        const val picasso = "com.squareup.picasso:picasso:${picassoVersion}"
    }


    object Testing {

        private const val jUnitVersion = "4.13.2"
        private const val jUnitExtVersion = "1.1.2"
        private const val assertJVersion = "3.21.0"
        private const val mockkVersion = "1.12.0"
        private const val turbineVersion = "0.6.0"
        private const val testRunnerVersion = "1.3.0"
        private const val archCoreVersion = "2.1.0"
        private const val mockWebServerVersion = "4.9.2"
        private const val roboelectricVersion = "4.6.1"
        private const val mockitoVersion = "2.2.0"
        private const val mockitoKotlinVersion = "4.0.0"
        private const val rulesVersion = "1.3.0"
        private const val testCoreVersion = "1.3.0"
        private const val fragmentVersion = "1.3.0-beta01"
        private const val playCoreVerion = "1.8.3"
        private const val mavenAntTaskVersion = "2.1.3"

        const val jUnit = "junit:junit:$jUnitVersion"
        const val jUnitExt = "androidx.test.ext:junit:$jUnitExtVersion"
        const val assertJ = "org.assertj:assertj-core:$assertJVersion"
        const val mockk = "io.mockk:mockk:$mockkVersion"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val turbine = "app.cash.turbine:turbine:$turbineVersion"
        const val testRunner = "androidx.test:runner:$testRunnerVersion"
        const val archCore = "androidx.arch.core:core-testing:$archCoreVersion"
        const val daggerHilt = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
        const val room = "androidx.room:room-testing:${Versions.room}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"
        const val testRoboelectric = "org.robolectric:robolectric:$roboelectricVersion"
        const val mockitoKotlin2 = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoVersion"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion"
        const val mockitoCore = "org.mockito:mockito-core:$mockitoKotlinVersion"
        const val testRules = "androidx.test:rules:$rulesVersion"
        const val coreTest = "androidx.test:core:$testCoreVersion"
        const val fragmentTest = "androidx.fragment:fragment-testing:$fragmentVersion"
        const val playCore = "com.google.android.play:core:$playCoreVerion"
        const val mavenAntTask = "org.apache.maven:maven-ant-tasks:$mavenAntTaskVersion"
    }

    object Misc {
        private const val kotlinResultVersion = "1.1.11"
        private const val hiltBinderVersion = "1.0.0-alpha02"
        private const val timberVersion = "5.0.1"

        const val kotlinResult =
            "com.michael-bull.kotlin-result:kotlin-result:${kotlinResultVersion}"
        const val hiltBinder = "com.paulrybitskyi:hilt-binder:$hiltBinderVersion"
        const val hiltBinderCompiler = "com.paulrybitskyi:hilt-binder-compiler:$hiltBinderVersion"
        const val timber = "com.jakewharton.timber:timber:$timberVersion"
    }

}