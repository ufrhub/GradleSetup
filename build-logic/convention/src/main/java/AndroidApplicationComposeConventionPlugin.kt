import com.android.build.api.dsl.ApplicationExtension
import com.iamufr.convention.configureAndroidCompose
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val conventionAndroidApplicationPlugin =
                libs.findPlugin("convention.android.application").orElse(null)?.get()?.pluginId
                    ?: "com.iamufr.gradle-management-system.build-logic.convention.android.application"
            val conventionComposeCompilerPlugin =
                libs.findPlugin("compose.compiler").orElse(null)?.get()?.pluginId
                    ?: "org.jetbrains.kotlin.plugin.compose"

            pluginManager.run {
                apply(conventionAndroidApplicationPlugin)
                apply(conventionComposeCompilerPlugin)
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}