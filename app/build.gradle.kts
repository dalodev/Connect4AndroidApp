plugins {
    androidApplication()
    connect4Android()
    kotlinKapt()
    daggerHiltAndroid()
    navSafeArgsKotlin()
}

android {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        dataBinding = true
    }
}

hilt {
    enableExperimentalClasspathAggregation = true
}

dependencies {

    implementation(Deps.AndroidX.navFragmentKtx)

    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)
    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
    implementation(Deps.Misc.timber)

    testImplementation(Deps.Testing.jUnit)
    androidTestImplementation(Deps.Testing.jUnitExt)
}

/*plugins {
    id 'com.android.application'
    id 'kotlin-android'
}

android {
    compileSdk 31

    defaultConfig {
        applicationId "com.dalodev.connect4"
        minSdk 26
        targetSdk 31
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
        useIR = true
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion compose_version
        kotlinCompilerVersion '1.5.21'
    }
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}


dependencies {

    implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.0-alpha06'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
}*/
