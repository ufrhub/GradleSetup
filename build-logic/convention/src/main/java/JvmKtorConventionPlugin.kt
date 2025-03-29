import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class JvmKtorConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val kotlinSerialization =
                libs.findPlugin("kotlin.serialization").orElse(null)?.get()?.pluginId
                    ?: "org.jetbrains.kotlin.plugin.serialization"
            val ktor = libs.findBundle("ktor").get()

            pluginManager.run {
                pluginManager.apply(kotlinSerialization)
            }

            dependencies {
                add("implementation", ktor)
            }
        }
    }
}