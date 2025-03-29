plugins {
    `kotlin-dsl`
}

group = "com.iamufr.gradle-management-system.build-logic"

version = "1.0.0"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id =
                "com.iamufr.gradle-management-system.build-logic.convention.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id =
                "com.iamufr.gradle-management-system.build-logic.convention.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeatureUi") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.android.feature.ui"
            implementationClass = "AndroidFeatureUiConventionPlugin"
        }

        register("androidRoom") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("jvmLibrary") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("jvmKtor") {
            id = "com.iamufr.gradle-management-system.build-logic.convention.jvm.ktor"
            implementationClass = "JvmKtorConventionPlugin"
        }

        register("daggerHilt"){
            id = "com.iamufr.gradle-management-system.build-logic.convention.dagger.hilt"
            implementationClass = "DependencyInjectionConventionPlugin"
        }
    }
}