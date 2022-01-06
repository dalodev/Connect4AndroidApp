plugins {
    androidApplication()
    connect4Android()
    kotlinKapt()
    daggerHiltAndroid()
    navSafeArgsKotlin()
}

hilt {
    enableExperimentalClasspathAggregation = true
}

dependencies {
    implementation(project(Deps.Local.ui))
    implementation(project(Deps.Local.navigation))
    implementation(project(Deps.Local.dashboard))
    implementation(project(Deps.Local.board))

    implementation(Deps.Google.daggerHilt)
    kapt(Deps.Google.daggerHiltCompiler)
    implementation(Deps.Misc.hiltBinder)
    kapt(Deps.Misc.hiltBinderCompiler)
    implementation(Deps.Misc.timber)

    testImplementation(Deps.Testing.jUnit)
    androidTestImplementation(Deps.Testing.jUnitExt)
}
