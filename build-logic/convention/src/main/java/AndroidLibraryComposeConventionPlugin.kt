import com.android.build.api.dsl.LibraryExtension
import com.iamufr.convention.configureAndroidCompose
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val conventionAndroidLibraryPlugin =
                libs.findPlugin("convention.android.library").orElse(null)?.get()?.pluginId
                    ?: "com.iamufr.gradle-management-system.build-logic.convention.android.library"
            val conventionComposeCompilerPlugin =
                libs.findPlugin("compose.compiler").orElse(null)?.get()?.pluginId
                    ?: "org.jetbrains.kotlin.plugin.compose"

            pluginManager.run {
                apply(conventionAndroidLibraryPlugin)
                apply(conventionComposeCompilerPlugin)
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}