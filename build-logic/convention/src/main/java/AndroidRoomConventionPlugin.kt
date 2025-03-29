import androidx.room.gradle.RoomExtension
import com.iamufr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val roomPlugin =
                libs.findPlugin("room").orElse(null)?.get()?.pluginId ?: "androidx.room"
            val kspPlugin =
                libs.findPlugin("ksp").orElse(null)?.get()?.pluginId ?: "com.google.devtools.ksp"
            val roomRuntime = libs.findLibrary("room.runtime").get()
            val roomKtx = libs.findLibrary("room.ktx").get()
            val roomCompiler = libs.findLibrary("room.compiler").get()

            pluginManager.run {
                apply(roomPlugin)
                apply(kspPlugin)
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add("implementation", roomRuntime)
                add("implementation", roomKtx)
                add("ksp", roomCompiler)
            }
        }
    }
}