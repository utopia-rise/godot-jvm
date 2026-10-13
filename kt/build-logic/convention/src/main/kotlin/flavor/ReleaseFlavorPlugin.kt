package flavor

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

const val RELEASE_COMPILATION = "release"
const val RELEASE_ELEMENTS = "releaseElements"

@Suppress("unused")
class ReleaseFlavorPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
            val release = target.extensions
                .getByType(KotlinJvmProjectExtension::class.java)
                .target
                .compilations
                .create(RELEASE_COMPILATION)

            release.compileTaskProvider.configure { task ->
                task as KotlinCompile
                task.source(target.layout.projectDirectory.dir("src/main/kotlin"))
                task.compilerOptions.moduleName.set(target.name)
                task.mustRunAfter("compileKotlin")
            }

            mirrorDependencies(target, listOf("api", "implementation"), release.implementationConfigurationName)
            mirrorDependencies(target, listOf("compileOnly"), release.compileOnlyConfigurationName)

            val releaseJar = target.tasks.register("releaseJar", Jar::class.java) { jar ->
                jar.from(release.output.allOutputs)
                jar.archiveClassifier.set(RELEASE_COMPILATION)
            }

            target.configurations.consumable(RELEASE_ELEMENTS) { configuration ->
                configuration.extendsFrom(target.configurations.getByName(release.implementationConfigurationName))
                configuration.outgoing.artifact(releaseJar)
                configuration.outgoing.capability("${target.group}:${target.name}-$RELEASE_COMPILATION:${target.version}")
            }
        }
    }

    private fun mirrorDependencies(target: Project, mainConfigurations: List<String>, releaseConfiguration: String) {
        target.configurations.getByName(releaseConfiguration).dependencies.addAllLater(
            target.provider {
                mainConfigurations
                    .flatMap { name -> target.configurations.getByName(name).dependencies }
                    .map { dependency -> releaseDependency(target, dependency) }
            }
        )
    }

    private fun releaseDependency(target: Project, dependency: Dependency): Dependency =
        if (dependency is ProjectDependency) {
            target.dependencies.project(mapOf("path" to dependency.path, "configuration" to RELEASE_ELEMENTS))
        } else {
            dependency.copy()
        }
}
