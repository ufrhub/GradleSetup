import com.iamufr.convention.configureKotlinJvm
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val jvmPlugin = libs.findPlugin("jetbrains.kotlin.jvm").orElse(null)?.get()?.pluginId
                ?: "org.jetbrains.kotlin.jvm"

            pluginManager.run {
                pluginManager.apply(jvmPlugin)
            }

            configureKotlinJvm()
        }
    }
}