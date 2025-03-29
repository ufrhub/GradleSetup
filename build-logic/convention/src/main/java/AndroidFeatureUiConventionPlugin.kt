import com.iamufr.convention.addUiLayerDependencies
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val conventionAndroidLibraryCompose =
                libs.findPlugin("convention.android.library.compose").orElse(null)?.get()?.pluginId
                    ?: "com.iamufr.gradle-management-system.build-logic.convention.android.library.compose"

            pluginManager.run {
                apply(conventionAndroidLibraryCompose)
            }

            dependencies {
                addUiLayerDependencies(target)
            }
        }
    }
}