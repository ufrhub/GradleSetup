plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.jvm.ktor)
}

android {
    namespace = "com.iamufr.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}