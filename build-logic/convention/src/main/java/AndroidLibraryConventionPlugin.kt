import com.android.build.api.dsl.LibraryExtension
import com.iamufr.convention.ExtensionType
import com.iamufr.convention.configureBuildTypes
import com.iamufr.convention.configureKotlinAndroid
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val androidLibraryPlugin =
                libs.findPlugin("android.library").orElse(null)?.get()?.pluginId
                    ?: "com.android.library"
            val kotlinAndroidPlugin =
                libs.findPlugin("jetbrains.kotlin.android").orElse(null)?.get()?.pluginId
                    ?: "org.jetbrains.kotlin.android"

            pluginManager.run {
                apply(androidLibraryPlugin)
                apply(kotlinAndroidPlugin)
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                add("testImplementation", kotlin("test"))
            }
        }
    }
}