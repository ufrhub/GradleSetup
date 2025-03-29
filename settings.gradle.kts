pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

gradle.startParameter.excludedTaskNames.addAll(
    listOf(":build-logic:convention:testClasses")
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "GradleSetup"
include(":app")
include(":core:data")
include(":core:database")
include(":core:domain")
include(":core:presentation:designsystem")
include(":core:presentation:ui")