plugins {
    androidLibrary()
    connect4Android()
    kotlinKapt()
}

dependencies {

    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.navFragmentKtx)
    implementation(Deps.AndroidX.lifecycleRuntime)

    api(Deps.AndroidX.composeUi)
    api(Deps.AndroidX.composeMaterial)
    api(Deps.AndroidX.composePreview)
    api(Deps.AndroidX.composeActivity)
    api(Deps.AndroidX.composeNavigation)
    api(Deps.Google.materialComponents)

    api(Deps.Google.hiltNavigationCompose)
    api(Deps.Google.hiltLifecycleViewModel)
    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)
    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
    implementation(Deps.Misc.timber)

    testImplementation(Deps.Testing.jUnit)
    androidTestImplementation(Deps.Testing.jUnitExt)
}