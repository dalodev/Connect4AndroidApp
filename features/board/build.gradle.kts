plugins {
    androidLibrary()
    connect4Android()
    kotlinKapt()
    daggerHiltAndroid()
}

hilt {
    enableTransformForLocalTests = true
}

dependencies {

    implementation(project(Deps.Local.ui))

    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)
    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
}