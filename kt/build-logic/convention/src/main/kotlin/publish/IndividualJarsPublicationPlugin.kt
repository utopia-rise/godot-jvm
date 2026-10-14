package publish

import groovy.util.Node
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

/**
 * Publishes every jar of `godot-jvm` again as its own POM-only artifact, named after its module with a `-debug` or
 * `-release` suffix outside tools, whose POM depends on the other artifacts of the same build type. This is the layout
 * JitPack can serve: it rewrites the Gradle module metadata it serves and loses the classifiers, file names and
 * requested capabilities that `godot-jvm` relies on. JitPack serves them under the repository's group,
 * `com.github.utopia-rise.godot-jvm`, so the names carry no `godot-jvm-` prefix.
 */
@Suppress("unused")
class IndividualJarsPublicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply(GodotJvmPublicationPlugin::class.java)
        val extension = target.extensions.getByType(GodotJvmPublicationExtension::class.java)
        val publishAll = target.tasks.register("publishIndividualJarsToMavenLocal") { task ->
            task.group = "publishing"
            task.description = "Publishes every godot-jvm jar as its own artifact to the local Maven repository."
        }

        extension.jars.all { jar ->
            val artifactId = artifactId(jar.module, jar.buildType)
            val publicationName = "individual${variantName(artifactId)}"
            target.extensions.configure(PublishingExtension::class.java) { publishing ->
                publishing.publications.register(publicationName, MavenPublication::class.java) { publication ->
                    publication.artifactId = artifactId
                    publication.artifact(jar.task) { artifact -> artifact.classifier = null }
                    publication.pom { pom ->
                        pom.name.set(artifactId)
                        pom.description.set("The ${jar.module.name} module of Godot-JVM${jar.buildType?.let { " ($it build)" } ?: ""}.")
                        pom.withXml { xml ->
                            val dependencies = xml.asNode().appendNode("dependencies")
                            val api = jar.apiDependencies.get().toSet()
                            for (dependency in api) {
                                appendDependency(dependencies, target, dependency, "compile")
                            }
                            for (dependency in jar.runtimeDependencies.get().toSet() - api) {
                                appendDependency(dependencies, target, dependency, "runtime")
                            }
                        }
                    }
                }
            }
            publishAll.configure { task -> task.dependsOn("publish${variantName(publicationName)}PublicationToMavenLocal") }
        }
    }

    private fun appendDependency(dependencies: Node, project: Project, dependency: PublishedDependency, scope: String) {
        val (group, name, version) = when (dependency) {
            is PublishedDependency.External -> Triple(dependency.group, dependency.name, dependency.version)
            is PublishedDependency.Module -> Triple(project.group.toString(), artifactId(dependency.module, dependency.buildType), project.version.toString())
        }
        dependencies.appendNode("dependency").apply {
            appendNode("groupId", group)
            appendNode("artifactId", name)
            appendNode("version", version)
            appendNode("scope", scope)
        }
    }

    private fun artifactId(module: GodotJvmModule, buildType: String?): String =
        listOfNotNull(module.name, buildType).joinToString("-")
}
