plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.room)
    alias(libs.plugins.convention.dagger.hilt)
}

android {
    namespace = "com.iamufr.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}