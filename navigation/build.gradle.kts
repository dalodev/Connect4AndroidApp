plugins {
    androidLibrary()
    connect4Android()
    kotlinKapt()
    daggerHiltAndroid()
}

dependencies {

    implementation(project(Deps.Local.ui))
    implementation(project(Deps.Local.dashboard))
    implementation(project(Deps.Local.board))

    implementation(Deps.Google.hiltNavigationCompose)

    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)

    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
}