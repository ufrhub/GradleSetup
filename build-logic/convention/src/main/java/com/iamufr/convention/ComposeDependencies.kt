package com.iamufr.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.addUiLayerDependencies(project: Project) {
    val corePresentationUi = project(":core:presentation:ui")
    val corePresentationDesignsystem = project(":core:presentation:designsystem")
    val koinCompose = project.libs.findBundle("koin.compose").get()
    val compose = project.libs.findBundle("compose").get()
    val composeDebug = project.libs.findBundle("compose.debug").get()
    val androidxUiTestJunit4 = project.libs.findLibrary("androidx.ui.test.junit4").get()

    add("implementation", corePresentationUi)
    add("implementation", corePresentationDesignsystem)
    add("implementation", koinCompose)
    add("implementation", compose)
    add("debugImplementation", composeDebug)
    add("androidTestImplementation", androidxUiTestJunit4)
}