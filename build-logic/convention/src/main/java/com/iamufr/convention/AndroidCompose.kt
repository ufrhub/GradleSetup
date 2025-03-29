package com.iamufr.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        val androidxUiToolingPreview = libs.findLibrary("androidx-ui-tooling-preview").get()

        buildFeatures {
            compose = true
        }

        dependencies {
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("debugImplementation", androidxUiToolingPreview)
        }
    }
}