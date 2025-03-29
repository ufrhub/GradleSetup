import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DependencyInjectionConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val conventionDaggerHiltPlugin =
                libs.findPlugin("dagger.hilt").orElse(null)?.get()?.pluginId
                    ?: "com.google.dagger.hilt.android"
            val daggerHilt = libs.findBundle("dagger.hilt").get()
            val daggerHiltCompiler = libs.findBundle("dagger.hilt.compiler").get()

            pluginManager.run {
                apply(conventionDaggerHiltPlugin)
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                add("implementation", daggerHilt)
                add("kapt", daggerHiltCompiler)
            }
        }
    }
}