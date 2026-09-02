package publish

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.plugin.devel.GradlePluginDevelopmentExtension
import org.gradle.plugins.signing.Sign
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

@Suppress("unused") // false positive
class PublishToMavenCentralPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply(MavenPublishBasePlugin::class.java)

        val mavenCentralUser = target.propOrEnv("ORG_GRADLE_PROJECT_mavenCentralUsername") ?: target.propOrEnv("mavenCentralUsername")
        val mavenCentralPassword = target.propOrEnv("ORG_GRADLE_PROJECT_mavenCentralPassword") ?: target.propOrEnv("mavenCentralPassword")
        val gpgInMemoryKey = target.propOrEnv("ORG_GRADLE_PROJECT_signingInMemoryKey") ?: target.propOrEnv("signingInMemoryKey")
        val gpgPassword = target.propOrEnv("ORG_GRADLE_PROJECT_signingInMemoryKeyPassword") ?: target.propOrEnv("signingInMemoryKeyPassword")

        val canSign = mavenCentralUser != null && mavenCentralPassword != null && gpgInMemoryKey != null && gpgPassword != null

        target.extensions.getByType(JavaPluginExtension::class.java).apply {
            withSourcesJar()
            withJavadocJar()
        }

        if (canSign) {
            target.logger.info("Will sign artifact for project \"${target.name}\" and setup publishing")

            target.extensions.getByType(MavenPublishBaseExtension::class.java).apply {
                publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
                signAllPublications()
            }

            target.afterEvaluate { evaluatedProject ->
                evaluatedProject
                    .tasks
                    .filter { task -> task.name.startsWith("publish") }
                    .forEach { task ->
                        task.dependsOn(target.tasks.withType(Sign::class.java))
                    }
            }
        } else {
            target.logger.warn("Cannot sign project \"${target.name}\" as credentials are missing. Will not setup signing and remote publishing credentials. Publishing will only work to maven local!")
        }

        target.afterEvaluate { evaluatedProject ->
            evaluatedProject.extensions.getByType(PublishingExtension::class.java).apply {
                publications { publicationContainer ->
                    publicationContainer.all { publication ->
                        if (publication is MavenPublication) {
                            val isPluginMarkerPublication = publication.name.endsWith("PluginMarkerMaven")

                            if (isPluginMarkerPublication) {
                                val pluginDeclarationName = publication.name.removeSuffix("PluginMarkerMaven")
                                val pluginDeclaration = evaluatedProject
                                    .extensions
                                    .findByType(GradlePluginDevelopmentExtension::class.java)
                                    ?.plugins
                                    ?.findByName(pluginDeclarationName)

                                if (pluginDeclaration != null) {
                                    val pluginId = pluginDeclaration.id
                                    publication.groupId = pluginId
                                    publication.artifactId = "$pluginId.gradle.plugin"
                                }
                            } else {
                                publication.groupId = "com.utopia-rise"
                                val artifactId = publication.artifactId
                                publication.artifactId = if (artifactId.isNullOrEmpty()) evaluatedProject.name else artifactId
                            }
                            publication.version = evaluatedProject.version as String

                            publication.pom { mavenPom ->
                                mavenPom.url.set("https://github.com/utopia-rise/godot-jvm.git")

                                if (mavenPom.name.getOrElse("").isEmpty()) {
                                    mavenPom.name.set(evaluatedProject.name)
                                }
                                if (mavenPom.description.getOrElse("").isEmpty()) {
                                    mavenPom.description.set(evaluatedProject.description ?: "Godot-JVM module")
                                }

                                mavenPom.scm { mavenPomScm ->
                                    mavenPomScm.connection.set("scm:git:https://github.com/utopia-rise/godot-jvm")
                                    mavenPomScm.developerConnection.set("scm:git:github.com:utopia-rise/godot-jvm.git")
                                    mavenPomScm.tag.set("master") //FIXME
                                    mavenPomScm.url.set("https://github.com/utopia-rise/godot-jvm")
                                }

                                mavenPom.licenses { mavenPomLicenseSpec ->
                                    mavenPomLicenseSpec.license { mavenPomLicense ->
                                        mavenPomLicense.name.set("MIT License")
                                        mavenPomLicense.url.set("https://github.com/utopia-rise/godot-jvm/blob/master/LICENSE")
                                        mavenPomLicense.distribution.set("repo")
                                    }
                                }

                                mavenPom.developers { mavenPomDevelopersSpec ->
                                    mavenPomDevelopersSpec.developer { mavenPomDeveloper ->
                                        mavenPomDeveloper.id.set("core")
                                        mavenPomDeveloper.name.set("Ranie Jade Ramiso")
                                        mavenPomDeveloper.url.set("https://github.com/raniejade")
                                        mavenPomDeveloper.email.set("raniejaderamiso@gmail.com")
                                    }
                                    mavenPomDevelopersSpec.developer { mavenPomDeveloper ->
                                        mavenPomDeveloper.id.set("core")
                                        mavenPomDeveloper.name.set("Pierre-Thomas Meisels")
                                        mavenPomDeveloper.url.set("https://github.com/piiertho")
                                        mavenPomDeveloper.email.set("meisels27@yahoo.fr")
                                    }
                                    mavenPomDevelopersSpec.developer { mavenPomDeveloper ->
                                        mavenPomDeveloper.id.set("core")
                                        mavenPomDeveloper.name.set("Cedric Hippmann")
                                        mavenPomDeveloper.url.set("https://github.com/chippmann")
                                        mavenPomDeveloper.email.set("cedric.hippmann@hotmail.com")
                                    }
                                    mavenPomDevelopersSpec.developer { mavenPomDeveloper ->
                                        mavenPomDeveloper.id.set("core")
                                        mavenPomDeveloper.name.set("Tristan Grespinet")
                                        mavenPomDeveloper.url.set("https://github.com/CedNaru")
                                        mavenPomDeveloper.email.set("ced.naru@gmail.com")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

fun Project.propOrEnv(name: String): String? {
    return findProperty(name) as? String?
        ?: System.getenv(name)?.ifEmpty { null }
        ?: providers.systemProperty(name).orNull
}
