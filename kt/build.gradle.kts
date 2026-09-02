import versioninfo.fullBuildVersion
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

plugins {
    // prevents the kotlin plugin being applied multiple times (once per subproject) as this is not supported. Done as suggested by the kotlin plugin
    alias(libs.plugins.kotlin.jvm) apply false
    id("com.utopia-rise.versioninfo")
    alias(libs.plugins.gradleIntelliJPlugin) apply false
    alias(libs.plugins.ideaSync) apply false
}

version = fullBuildVersion

val versionString = project.version.toString()

fun gradleWrapperCommand(vararg args: String): List<String> = when {
    DefaultNativePlatform.getCurrentOperatingSystem().isWindows -> listOf("cmd", "/c", "gradlew.bat", *args)
    else -> listOf("./gradlew", *args)
}

subprojects {
    group = "com.utopia-rise"
    version = versionString

    if (path != ":godot-intellij-plugin") {
        pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
            dependencies.add("implementation", dependencies.kotlin("stdlib"))
        }
    }
}

tasks {
    val publishCommonToMavenLocal by registering(Exec::class) {
        group = "publishing"
        description = "Publishes the common included build to mavenLocal."
        workingDir = projectDir
        commandLine(gradleWrapperCommand("-p", "common", "publishToMavenLocal"))
    }

    val publishToolsCommonToMavenLocal by registering(Exec::class) {
        group = "publishing"
        description = "Publishes the tools-common included build to mavenLocal."
        workingDir = projectDir
        commandLine(gradleWrapperCommand("-p", "tools-common", "publishToMavenLocal"))
        mustRunAfter(publishCommonToMavenLocal)
    }

    val publishApiGeneratorToMavenLocal by registering(Exec::class) {
        group = "publishing"
        description = "Publishes the API generator included build to mavenLocal."
        workingDir = projectDir
        commandLine(gradleWrapperCommand("-p", "api-generator", "publishToMavenLocal"))
        mustRunAfter(publishToolsCommonToMavenLocal)
    }

    val publishMainBuildToMavenLocal by registering(Exec::class) {
        group = "publishing"
        description = "Publishes the main Kotlin/JVM build to mavenLocal."
        workingDir = projectDir
        commandLine(gradleWrapperCommand("publishToMavenLocal"))
        mustRunAfter(publishApiGeneratorToMavenLocal)
    }

    val publishReleaseBuildToMavenLocal by registering(Exec::class) {
        group = "publishing"
        description = "Publishes the release-flavored main Kotlin/JVM build to mavenLocal."
        workingDir = projectDir
        commandLine(gradleWrapperCommand("publishToMavenLocal", "-Prelease=true"))
        mustRunAfter(publishMainBuildToMavenLocal)
    }

    @Suppress("UNUSED_VARIABLE")
    val publishArtifactsToMavenLocal by registering {
        group = "publishing"
        description = "Publishes all artifacts needed to consume Godot-JVM from mavenLocal."
        dependsOn(
            publishCommonToMavenLocal,
            publishToolsCommonToMavenLocal,
            publishApiGeneratorToMavenLocal,
            publishMainBuildToMavenLocal,
            publishReleaseBuildToMavenLocal
        )
    }

    val buildEngineDebug by registering(Exec::class) {
        group = "godot-jvm"

        workingDir = File(rootProject.projectDir, "../../..")
        environment("JAVA_HOME", System.getProperty("java.home"))

        val platform = when {
            DefaultNativePlatform.getCurrentOperatingSystem().isWindows -> "windows"
            DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX -> "osx"
            DefaultNativePlatform.getCurrentOperatingSystem().isLinux -> "x11"
            else -> throw kotlin.IllegalStateException("Cannot build engine on this os. Build it manually...")
        }
        val coresAvailable = Runtime.getRuntime().availableProcessors()

        if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            commandLine("cmd", "/c", "scons", "p=$platform", "-j$coresAvailable")
        } else {
            commandLine("scons", "p=$platform", "-j$coresAvailable")
        }
    }
    val buildEngineReleaseDebug by registering(Exec::class) {
        group = "godot-jvm"

        workingDir = File(rootProject.projectDir, "../../..")
        environment("JAVA_HOME", System.getProperty("java.home"))

        val platform = when {
            DefaultNativePlatform.getCurrentOperatingSystem().isWindows -> "windows"
            DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX -> "osx"
            DefaultNativePlatform.getCurrentOperatingSystem().isLinux -> "x11"
            else -> throw kotlin.IllegalStateException("Cannot build engine on this os. Build it manually...")
        }
        val coresAvailable = Runtime.getRuntime().availableProcessors()

        if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            commandLine("cmd", "/c", "scons", "p=$platform", "target=template_debug", "-j$coresAvailable")
        } else {
            commandLine("scons", "p=$platform", "target=template_debug", "-j$coresAvailable")
        }
    }
    val runEngineDebug by registering(Exec::class) {
        group = "godot-jvm"

        workingDir = File(rootProject.projectDir, "../../../bin")
        environment("JAVA_HOME", System.getProperty("java.home"))

        when {
            DefaultNativePlatform.getCurrentOperatingSystem().isWindows ->
                commandLine(
                    "cmd",
                    "/c",
                    "${workingDir.absolutePath}${File.pathSeparator}godot.windows.tools.64.exe",
                    "-v"
                )
            DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX ->
                commandLine("${workingDir.absolutePath}/godot.osx.tools.64", "-v")
            DefaultNativePlatform.getCurrentOperatingSystem().isLinux ->
                commandLine("${workingDir.absolutePath}/godot.x11.tools.64", "-v")
        }
    }
    val runEngineReleaseDebug by registering(Exec::class) {
        group = "godot-jvm"

        workingDir = File(rootProject.projectDir, "../../../bin")
        environment("JAVA_HOME", System.getProperty("java.home"))

        when {
            DefaultNativePlatform.getCurrentOperatingSystem().isWindows ->
                commandLine(
                    "cmd",
                    "/c",
                    "${workingDir.absolutePath}${File.pathSeparator}godot.windows.opt.tools.64.exe",
                    "-v"
                )
            DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX ->
                commandLine("${workingDir.absolutePath}/godot.osx.opt.tools.64", "-v")
            DefaultNativePlatform.getCurrentOperatingSystem().isLinux ->
                commandLine("${workingDir.absolutePath}/godot.x11.opt.tools.64", "-v")
        }
    }
    @Suppress("UNUSED_VARIABLE")
    val buildAndRunEngineDebug by registering {
        group = "godot-jvm"
        dependsOn(buildEngineDebug)
        finalizedBy(runEngineDebug)
    }
    @Suppress("UNUSED_VARIABLE")
    val buildAndRunEngineReleaseDebug by registering {
        group = "godot-jvm"
        dependsOn(buildEngineReleaseDebug)
        finalizedBy(runEngineReleaseDebug)
    }
}
