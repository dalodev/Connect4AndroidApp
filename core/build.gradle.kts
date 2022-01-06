plugins {
    androidLibrary()
    connect4Android()
    kotlinKapt()
    daggerHiltAndroid()
}

dependencies {

    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)

    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
}