import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import versioninfo.fullBuildVersion
import versioninfo.isSnapshot

plugins {
    // Java support
    id("java")
    // Kotlin support
    // gradle-intellij-plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
    alias(libs.plugins.gradleIntelliJPlugin)
    // gradle-changelog-plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
    alias(libs.plugins.changelog)

    id("com.utopia-rise.versioninfo")
}

apply(plugin = "org.jetbrains.kotlin.jvm")

// needed as the intellij plugin does add its own repositories and thus the ones defined in the settings.gradle.kts are ignored. Hence, we need to redefine them here
repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven { url = uri("https://plugins.gradle.org/m2/") } // needed for shadowJar plugin dependency implementation in `godot-gradle-plugin`

    intellijPlatform {
        defaultRepositories()
    }
}

version = fullBuildVersion
group = "com.utopia-rise"

val intellijVersion: String = project.properties["godot.plugins.intellij.version"]?.toString() ?: libs.versions.ideaPluginDefaultIntellijVersion.get()

extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
    jvmToolchain(21)
}

dependencies {
    implementation("com.utopia-rise:tools-common:$fullBuildVersion")
    implementation(project(":godot-bootstrap-library"))
    implementation(project(":godot-core-library"))
    compileOnly(kotlin("stdlib"))
    testImplementation(project(":godot-api-library"))
    testImplementation(project(":godot-extension-library"))
    testImplementation("junit:junit:4.13.2")

    // https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
    intellijPlatform {
        intellijIdeaCommunity(intellijVersion)

        bundledPlugin("com.intellij.java")
        bundledPlugin("org.jetbrains.kotlin")
        plugin("org.intellij.scala", "2025.1.4")

        testFramework(TestFrameworkType.Platform)
        testFramework(TestFrameworkType.Plugin.Java)
        pluginVerifier()
        zipSigner()
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginVerification {
        ides {
            // The oldest supported IDE, plus the versions the Marketplace verifies against.
            create(IntelliJPlatformType.IntellijIdeaCommunity, "2025.1")
            create(IntelliJPlatformType.IntellijIdea, "2025.2.6.3")
            create(IntelliJPlatformType.IntellijIdea, "2026.1.5")
            create(IntelliJPlatformType.IntellijIdea, "2026.2.1")
        }
    }
}

tasks {
    processResources {
        val logoDirectory = rootProject.projectDir.parentFile.resolve("logo")

        from(logoDirectory) {
            include("godot-jvm-mascot.svg")
            rename("godot-jvm-mascot.svg", "pluginIcon.svg")
            into("META-INF")
        }
        from(logoDirectory) {
            include("godot-jvm-mascot.svg")
            rename("godot-jvm-mascot.svg", "pluginIcon_small.svg")
        }
    }

    runIde {
        jvmArgs("-Xmx2000m")

        jvmArgumentProviders += CommandLineArgumentProvider {
            listOf("-Didea.kotlin.plugin.use.k2=true")
        }
    }

    patchPluginXml {
        if (isSnapshot) {
            val projectVersion = project.version as String
            this.pluginVersion.set(
                if (projectVersion.endsWith("-SNAPSHOT")) {
                    "${projectVersion.removeSuffix("-SNAPSHOT")}-IJ$intellijVersion-SNAPSHOT"
                } else {
                    "$projectVersion-IJ$intellijVersion"
                }
            )
        } else {
            this.pluginVersion.set("${project.version}-IJ$intellijVersion")
        }
        sinceBuild.set("251.1")

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(
            File("$projectDir/README.md").readText().lines().run {
                val start = "<!-- Plugin description -->"
                val end = "<!-- Plugin description end -->"

                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end))
            }.joinToString("\n").run { markdownToHTML(this) }
        )

        // Ship the changelog as the plugin's "What's New". `patchChangelog` turns the [Unreleased] section into a
        // versioned one, so look for the released version first and fall back to [Unreleased] when it has not run yet.
        changeNotes.set(
            provider {
                with(changelog) {
                    renderItem(
                        (getOrNull(project.version.toString()) ?: getUnreleased())
                            .withHeader(false)
                            .withEmptySections(false),
                        Changelog.OutputType.HTML
                    )
                }
            }
        )
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("GODOT_JVM_INTELLIJ_PLUGIN_PUBLISH"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://jetbrains.org/intellij/sdk/docs/tutorials/build_system/deployment.html#specifying-a-release-channel
        if (isSnapshot) {
            channels.set(listOf("alpha"))
        } else {
            channels.set(listOf("stable"))
        }
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-jvm-default=no-compatibility")
            freeCompilerArgs.add("-Xcontext-parameters") // The analysis API requires context support; Kotlin 2.3 uses context parameters.
        }
    }

    test {
        systemProperty(
            "godot.intellij.fixture.root",
            rootProject.projectDir.parentFile.resolve("harness/intellij-check").absolutePath
        )
        jvmArgumentProviders += CommandLineArgumentProvider {
            listOf("-Didea.kotlin.plugin.use.k2=true")
        }
    }
}
