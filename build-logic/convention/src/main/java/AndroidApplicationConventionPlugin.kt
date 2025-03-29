import com.android.build.api.dsl.ApplicationExtension
import com.iamufr.convention.ExtensionType
import com.iamufr.convention.configureBuildTypes
import com.iamufr.convention.configureKotlinAndroid
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val androidApplicationPlugin =
                libs.findPlugin("android.application").orElse(null)?.get()?.pluginId
                    ?: "com.android.application"
            val kotlinAndroidPlugin =
                libs.findPlugin("jetbrains.kotlin.android").orElse(null)?.get()?.pluginId
                    ?: "org.jetbrains.kotlin.android"
            val projectApplicationId = libs.findVersion("projectApplicationId").get().toString()
            val projectTargetSdkVersion =
                libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
            val projectVersionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
            val projectVersionName = libs.findVersion("projectVersionName").get().toString()

            pluginManager.run {
                apply(androidApplicationPlugin)
                apply(kotlinAndroidPlugin)
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = projectApplicationId
                    targetSdk = projectTargetSdkVersion
                    versionCode = projectVersionCode
                    versionName = projectVersionName
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }
                configureKotlinAndroid(this)
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )
            }
        }
    }
}