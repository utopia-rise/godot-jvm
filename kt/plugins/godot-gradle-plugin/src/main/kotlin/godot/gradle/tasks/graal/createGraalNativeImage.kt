package godot.gradle.tasks.graal

import godot.gradle.exception.GraalNativeImageToolNotFountException
import godot.gradle.ext.existingFileOrNull
import godot.gradle.ext.resolveExecutable
import godot.gradle.projectExt.GODOT_SINGLE_CONFIGURATION
import godot.gradle.projectExt.godotJvmExtension
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

fun Project.createGraalNativeImageTask(
    checkNativeImageToolAccessibleTask: TaskProvider<out Task>,
    checkPresenceOfDefaultGraalJniConfigTask: TaskProvider<out Task>,
    packageMainJarTask: TaskProvider<out Task>,
    packageBootstrapJarTask: TaskProvider<out Task>
): TaskProvider<out Task> {
    val libsDirectory = layout.buildDirectory.dir("libs")
    val graalDirectory = layout.buildDirectory.dir("graal")
    val graalVmHomeDirectory = godotJvmExtension.graal.homeDirectory
    val windowsDeveloperVcVarsPath = godotJvmExtension.graal.windowsDeveloperVcVarsPath
    val isVerboseEnabled = godotJvmExtension.graal.verbose
    val isStrictImageHeapEnabled = godotJvmExtension.graal.strictImageHeapEnabled
    val projectBaseDir = projectDir
    val additionalJniConfigurationFiles = godotJvmExtension.graal.additionalJniConfigurationFiles.map { configFiles ->
        configFiles.joinToString(",") { configFile ->
            projectBaseDir.resolve("graal").resolve(configFile).absolutePath
        }
    }
    val additionalReflectionConfigurationFiles = godotJvmExtension
        .graal.additionalReflectionConfigurationFiles
        .map { configFiles -> configFiles.joinToString(",") }
    val additionalResourceConfigurationFiles = godotJvmExtension
        .graal.additionalResourceConfigurationFiles
        .map { configFiles -> configFiles.joinToString(",") }

    return tasks.register("createGraalNativeImage", Exec::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Converts main.jar and bootstrap.jar into a GraalVM native image."

            dependsOn(
                checkNativeImageToolAccessibleTask,
                checkPresenceOfDefaultGraalJniConfigTask,
                packageMainJarTask,
                packageBootstrapJarTask
            )

            inputs.dir(libsDirectory)
            inputs.dir(graalDirectory)
            inputs.files(configurations.getByName(GODOT_SINGLE_CONFIGURATION))
            inputs.property("graalVmHomeDirectory", graalVmHomeDirectory)
            inputs.property("windowsDeveloperVcVarsPath", windowsDeveloperVcVarsPath.orElse(""))
            inputs.property("isGraalNativeImageVerboseEnabled", isVerboseEnabled)
            inputs.property("isGraalNativeImageStrictImageHeapEnabled", isStrictImageHeapEnabled)
            inputs.property("additionalGraalJniConfigurationFiles", additionalJniConfigurationFiles)
            inputs.property("additionalGraalReflectionConfigurationFiles", additionalReflectionConfigurationFiles)
            inputs.property("additionalGraalResourceConfigurationFiles", additionalResourceConfigurationFiles)

            doFirst {
                val libsDir = libsDirectory.get().asFile

                // A native image cannot load jars at runtime, so godotSingle dependencies are compiled in as well.
                val classPath = listOf(File(libsDir, "godot-bootstrap.jar"), File(libsDir, "main.jar")) +
                    configurations.getByName(GODOT_SINGLE_CONFIGURATION).files
                        .filter { file -> file.extension == "jar" }
                        .sortedBy { file -> file.name }

                workingDir = libsDir

                val graalBuildDirectory = graalDirectory.get().asFile

                val jniConfigurationFilesArgument = "-H:JNIConfigurationFiles=" +
                    graalBuildDirectory.resolve("godot-jvm-graal-jni-config.json").absolutePath + "," +
                    additionalJniConfigurationFiles.get()


                val additionalConfigFiles = additionalReflectionConfigurationFiles.get()
                val reflectionConfigurationFilesArgument = if (additionalConfigFiles.isNotEmpty()) {
                    "-H:ReflectionConfigurationFiles=$additionalConfigFiles"
                } else {
                    ""
                }

                val resourceConfigFiles = additionalResourceConfigurationFiles.get()
                val resourceConfigurationFilesArgument = if (resourceConfigFiles.isNotEmpty()) {
                    "-H:ResourceConfigurationFiles=$resourceConfigFiles"
                } else {
                    ""
                }

                val verboseArgument = if (isVerboseEnabled.get()) {
                    "--verbose"
                } else {
                    ""
                }

                val graalHome = graalVmHomeDirectory.orNull?.trim()
                    ?.takeUnless(String::isEmpty)
                    ?: throw GraalNativeImageToolNotFountException("GraalVM home directory is not configured")
                val graalHomeDir = File(graalHome)
                val graalBinDir = graalHomeDir.resolve("bin")


                val arguments = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
                    val vcVarsPath = windowsDeveloperVcVarsPath.orNull?.trim()
                        ?.takeUnless(String::isEmpty)
                        ?: throw IllegalArgumentException(
                            "Windows developer vcvars path is not configured. Set it to the Visual Studio vcvars script before building a GraalVM native image on Windows."
                        )
                    val vcVarsFile = File(vcVarsPath).existingFileOrNull()
                        ?: throw IllegalArgumentException(
                            "The configured Visual Studio vcvars script does not exist or is not a file: ${File(vcVarsPath).absolutePath}"
                        )
                    mutableListOf(
                        "cmd",
                        "/c",

                        "(",

                        vcVarsFile.absolutePath,

                        "&&",

                        graalBinDir
                            .resolve("native-image.cmd"),
                        "-cp",
                        classPath.joinToString(";") { file -> "\"${file.absolutePath}\"" },
                        "--shared",
                        "-H:Name=usercode",
                        jniConfigurationFilesArgument,
                        "--no-fallback",
                        verboseArgument
                    )

                } else {
                    mutableListOf(
                        graalHomeDir.resolveExecutable("native-image"),
                        "-cp",
                        classPath.joinToString(":") { file -> file.absolutePath },
                        "--shared",
                        "-H:Name=usercode",
                        jniConfigurationFilesArgument,
                        "--no-fallback",
                        verboseArgument,
                    )
                }

                if (additionalConfigFiles.isNotEmpty()) {
                    arguments.add(reflectionConfigurationFilesArgument)
                }

                if (resourceConfigFiles.isNotEmpty()) {
                    arguments.add(resourceConfigurationFilesArgument)
                }

                if (isStrictImageHeapEnabled.get()) {
                    arguments.add("--strict-image-heap")
                }

                if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
                    arguments.add(")")
                }

                println(arguments.joinToString(" "))

                commandLine(
                    arguments
                )
            }
        }
    }
}
