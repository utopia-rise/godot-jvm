package publish

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication

@Suppress("unused")
class MavenCentralPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply(MavenPublishBasePlugin::class.java)

        val hasCredentials = listOf(
            "mavenCentralUsername",
            "mavenCentralPassword",
            "signingInMemoryKey",
            "signingInMemoryKeyPassword",
        ).all { name -> target.providers.gradleProperty(name).isPresent }

        if (hasCredentials) {
            target.extensions.configure(MavenPublishBaseExtension::class.java) { extension ->
                extension.publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
                extension.signAllPublications()
            }
        } else {
            target.logger.warn("Maven Central credentials or signing key missing: ${target.name} can only be published to mavenLocal.")
        }

        target.extensions.configure(PublishingExtension::class.java) { publishing ->
            publishing.publications.withType(MavenPublication::class.java).configureEach { publication ->
                publication.pom { pom -> configurePom(target, pom) }
            }
        }
    }

    private fun configurePom(target: Project, pom: MavenPom) {
        pom.name.convention(target.name)
        pom.description.convention(target.provider { target.description ?: target.name })
        pom.url.set("https://github.com/utopia-rise/godot-jvm.git")
        pom.scm { scm ->
            scm.connection.set("scm:git:https://github.com/utopia-rise/godot-jvm")
            scm.developerConnection.set("scm:git:github.com:utopia-rise/godot-jvm.git")
            scm.tag.set("master")
            scm.url.set("https://github.com/utopia-rise/godot-jvm")
        }
        pom.licenses { licenses ->
            licenses.license { license ->
                license.name.set("MIT License")
                license.url.set("https://github.com/utopia-rise/godot-jvm/blob/master/LICENSE")
                license.distribution.set("repo")
            }
        }
        pom.developers { developers ->
            for ((name, url, email) in DEVELOPERS) {
                developers.developer { developer ->
                    developer.id.set("core")
                    developer.name.set(name)
                    developer.url.set(url)
                    developer.email.set(email)
                }
            }
        }
    }

    private companion object {
        val DEVELOPERS = listOf(
            Triple("Pierre-Thomas Meisels", "https://github.com/piiertho", "meisels27@yahoo.fr"),
            Triple("Tristan Grespinet", "https://github.com/CedNaru", "ced.naru@gmail.com"),
            Triple("Cedric Hippmann", "https://github.com/chippmann", "cedric.hippmann@hotmail.com"),
            Triple("Ranie Jade Ramiso", "https://github.com/raniejade", "raniejaderamiso@gmail.com"),
        )
    }
}
