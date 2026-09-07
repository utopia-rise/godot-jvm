package godot.gradle.projectExt

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.tasks.GenerateEmbeddedJreTask
import godot.gradle.tasks.android.checkAndroidJarAccessibleTask
import godot.gradle.tasks.android.checkD8ToolAccessibleTask
import godot.gradle.tasks.android.createBootstrapDexJarTask
import godot.gradle.tasks.android.createMainDexFileTask
import godot.gradle.tasks.android.packageMainDexJarTask
import godot.gradle.tasks.createCopyAndroidArtifactsTask
import godot.gradle.tasks.createCopyDesktopJarsTask
import godot.gradle.tasks.createCopyGraalArtifactsTask
import godot.gradle.tasks.createCopyIOSArtifactsTask
import godot.gradle.tasks.custom_api.customApiJarTask
import godot.gradle.tasks.registrarGenerationGenerateFilesTask
import godot.gradle.tasks.registrarGenerationJarTask
import godot.gradle.tasks.registrarGenerationSyncRegistrationFilesTask
import godot.gradle.tasks.registrar_generation.registrarGenerationIndexExistingRegistrationFilesTask
import godot.gradle.tasks.generateGdIgnoreFilesTask
import godot.gradle.tasks.graal.checkNativeImageToolAccessibleTask
import godot.gradle.tasks.graal.copyDefaultGraalJniConfigTask
import godot.gradle.tasks.graal.createGraalNativeImageTask
import godot.gradle.tasks.graal.ios.copyDefaultGraalIOSConfigsTask
import godot.gradle.tasks.graal.ios.createIOSGraalNativeImageTask
import godot.gradle.tasks.graal.ios.createIOSStaticLibraryTask
import godot.gradle.tasks.graal.ios.downloadIOSCapCacheFiles
import godot.gradle.tasks.graal.ios.downloadIOSJdkStaticLibraries
import godot.gradle.tasks.packageBootstrapJarTask
import godot.gradle.tasks.packageMainJarTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskProvider

private data class RegistrarGenerationTasks(
    val generateRegistrarFilesTask: TaskProvider<out Task>,
    val updateRegistrationFilesTask: TaskProvider<out Task>,
    val generatedRegistrarJarTask: TaskProvider<Jar>,
)

private data class DesktopPackagingTasks(
    val packageBootstrapJarTask: TaskProvider<out Task>,
    val packageMainJarTask: TaskProvider<out Task>,
)

private data class AndroidPackagingTasks(
    val createBootstrapDexJarTask: TaskProvider<out Task>,
    val packageMainDexJarTask: TaskProvider<out Task>,
)

private data class NativePackagingTasks(
    val createGraalNativeImageTask: TaskProvider<out Task>,
    val createIOSTask: TaskProvider<out Task>,
)

private data class CopyTasks(
    val generateGdIgnoreFilesTask: TaskProvider<out Task>,
    val copyDesktopJarsTask: TaskProvider<out Task>,
    val copyAndroidArtifactsTask: TaskProvider<out Task>,
    val copyGraalArtifactsTask: TaskProvider<out Task>,
    val copyIOSArtifactsTask: TaskProvider<out Task>,
)

fun Project.setupTasks() {
    tasks.register("generateEmbeddedJre", GenerateEmbeddedJreTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Generates an embedded jre using jlink"
    }
    registerUserFacingBuildTasks()

    afterEvaluate {
        with(it) {
            val customApiJarTask = if (godotJvmExtension.isCustomApiEnabled.get()) {
                customApiJarTask()
            } else {
                null
            }
            if (godotJvmExtension.isLibrary.get()) {
                val mainSourceSet = extensions
                    .getByType(SourceSetContainer::class.java)
                    .getByName("main")

                tasks.named("jar", Jar::class.java) { jarTask ->
                    jarTask.group = "godot-jvm"
                    jarTask.description = "Builds the reusable Godot-JVM library jar."
                    jarTask.archiveBaseName.set(project.name)
                    jarTask.archiveVersion.set("")
                    jarTask.archiveClassifier.set("")
                    jarTask.duplicatesStrategy = DuplicatesStrategy.EXCLUDE

                    val runtimeClasspath = configurations.getByName(mainSourceSet.runtimeClasspathConfigurationName)
                    val bundledDependencies = runtimeClasspath.filter { dependencyFile ->
                        dependencyFile.isFile && dependencyFile.name !in setOf(
                            "$godotInternalArtifactName.jar",
                            "$godotCoreArtifactName.jar",
                            "$godotApiArtifactName.jar",
                            "$godotBootstrapArtifactName.jar",
                            "$godotExtensionArtifactName.jar",
                        )
                    }

                    jarTask.from(bundledDependencies.map { dependencyJar ->
                        zipTree(dependencyJar)
                    })
                }
                setupLibraryModeBuildLifecycleTasks()
                return@with
            }

            val checkIgnoredScriptSourcesTask = checkIgnoredScriptSourcesTask()

            val classesTask = tasks.named("classes")
            val registrarGenerationTasks = setupRegistrarGenerationTasks(classesTask)
            val desktopPackagingTasks = setupDesktopPackagingTasks(classesTask, registrarGenerationTasks, customApiJarTask)
            val androidPackagingTasks = setupAndroidPackagingTasks(desktopPackagingTasks)
            val nativePackagingTasks = setupNativePackagingTasks(desktopPackagingTasks)
            val copyTasks = setupCopyTasks(
                desktopPackagingTasks = desktopPackagingTasks,
                androidPackagingTasks = androidPackagingTasks,
                nativePackagingTasks = nativePackagingTasks,
            )

            setupBuildLifecycleTasks(
                desktopPackagingTasks = desktopPackagingTasks,
                androidPackagingTasks = androidPackagingTasks,
                nativePackagingTasks = nativePackagingTasks,
                copyTasks = copyTasks,
                checkIgnoredScriptSourcesTask = checkIgnoredScriptSourcesTask,
            )

            setupCleanLifecycleTasks(copyTasks)
        }
    }
}

private fun Project.registerUserFacingBuildTasks() {
    tasks.register("buildRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jars."
    }

    tasks.register("fastBuild") { task ->
        task.group = "build"
        task.description =
            "Builds fresh desktop jars while reusing the last generated registrar-registration artifacts instead of rescanning registrations."
    }

    tasks.register("buildAndroid") { task ->
        task.group = "build"
        task.description = "Builds the desktop jars and Android dex artifacts."
    }

    tasks.register("buildAndroidRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jars and Android dex artifacts."
    }

    tasks.register("buildGraalNativeImage") { task ->
        task.group = "build"
        task.description = "Builds the desktop jars and GraalVM native image."
    }

    tasks.register("buildGraalNativeImageRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jars and GraalVM native image."
    }

    tasks.register("buildIOS") { task ->
        task.group = "build"
        task.description = "Builds the desktop jars and iOS static library."
    }

    tasks.register("buildIOSRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jars and iOS static library."
    }
}

private fun Project.setupRegistrarGenerationTasks(
    classesTask: TaskProvider<out Task>,
): RegistrarGenerationTasks {
    val fastBuildRequested = isFastBuildRequested()
    val generateRegistrarFilesTask = registrarGenerationGenerateFilesTask(
        classesTask = classesTask,
    )
    generateRegistrarFilesTask.configure { task ->
        task.onlyIf { !fastBuildRequested }
    }

    val updateRegistrationFilesTask = if (godotJvmExtension.disableGdj.get()) {
        generateRegistrarFilesTask
    } else {
        val indexExistingRegistrationFilesTask = registrarGenerationIndexExistingRegistrationFilesTask()
        indexExistingRegistrationFilesTask.configure { task ->
            task.onlyIf { !fastBuildRequested }
        }
        registrarGenerationSyncRegistrationFilesTask(
            generateRegistrarFilesTask = generateRegistrarFilesTask,
            indexExistingRegistrationFilesTask = indexExistingRegistrationFilesTask,
        ).also { taskProvider ->
            taskProvider.configure { task ->
                task.onlyIf { !fastBuildRequested }
            }
        }
    }

    val generatedRegistrarJarTask = registrarGenerationJarTask(
        generateRegistrarFilesTask = generateRegistrarFilesTask,
    )
    generatedRegistrarJarTask.configure { task ->
        task.onlyIf { !fastBuildRequested }
    }

    return RegistrarGenerationTasks(
        generateRegistrarFilesTask = generateRegistrarFilesTask,
        updateRegistrationFilesTask = updateRegistrationFilesTask,
        generatedRegistrarJarTask = generatedRegistrarJarTask,
    )
}

private fun Project.setupDesktopPackagingTasks(
    classesTask: TaskProvider<out Task>,
    registrarGenerationTasks: RegistrarGenerationTasks,
    customApiJarTask: TaskProvider<Jar>?,
): DesktopPackagingTasks {
    val packageBootstrapJarTask = packageBootstrapJarTask(customApiJarTask)
    val packageMainJarTask = packageMainJarTask(
        generatedRegistrarJarTask = registrarGenerationTasks.generatedRegistrarJarTask,
        updateRegistrationFilesTask = registrarGenerationTasks.updateRegistrationFilesTask,
        userClassesTask = classesTask,
    )

    return DesktopPackagingTasks(
        packageBootstrapJarTask = packageBootstrapJarTask,
        packageMainJarTask = packageMainJarTask,
    )
}

private fun Project.setupAndroidPackagingTasks(
    desktopPackagingTasks: DesktopPackagingTasks,
): AndroidPackagingTasks {
    val checkD8ToolAccessibleTask = checkD8ToolAccessibleTask()
    val checkAndroidJarAccessibleTask = checkAndroidJarAccessibleTask()
    val createBootstrapDexJarTask = createBootstrapDexJarTask(
        checkAndroidJarAccessibleTask = checkAndroidJarAccessibleTask,
        checkD8ToolAccessibleTask = checkD8ToolAccessibleTask,
        packageBootstrapJarTask = desktopPackagingTasks.packageBootstrapJarTask,
    )
    val createMainDexFileTask = createMainDexFileTask(
        checkAndroidJarAccessibleTask = checkAndroidJarAccessibleTask,
        checkD8ToolAccessibleTask = checkD8ToolAccessibleTask,
        createBootstrapDexJarTask = createBootstrapDexJarTask,
        packageMainJarTask = desktopPackagingTasks.packageMainJarTask,
    )
    val packageMainDexJarTask = packageMainDexJarTask(
        createMainDexFileTask = createMainDexFileTask
    )

    return AndroidPackagingTasks(
        createBootstrapDexJarTask = createBootstrapDexJarTask,
        packageMainDexJarTask = packageMainDexJarTask,
    )
}

private fun Project.setupNativePackagingTasks(
    desktopPackagingTasks: DesktopPackagingTasks,
): NativePackagingTasks {
    val checkNativeImageToolAccessibleTask = checkNativeImageToolAccessibleTask()
    val copyDefaultGraalJniConfigTask = copyDefaultGraalJniConfigTask()
    val copyDefaultGraalIOSConfigsTask = copyDefaultGraalIOSConfigsTask(
        copyDefaultGraalJniConfigTask
    )
    val createGraalNativeImageTask = createGraalNativeImageTask(
        checkNativeImageToolAccessibleTask = checkNativeImageToolAccessibleTask,
        checkPresenceOfDefaultGraalJniConfigTask = copyDefaultGraalJniConfigTask,
        packageMainJarTask = desktopPackagingTasks.packageMainJarTask,
        packageBootstrapJarTask = desktopPackagingTasks.packageBootstrapJarTask
    )
    val createIOSGraalNativeImageTask = createIOSGraalNativeImageTask(
        checkNativeImageToolAccessibleTask = checkNativeImageToolAccessibleTask,
        copyDefaultGraalIOSConfigsTask = copyDefaultGraalIOSConfigsTask,
        downloadIOSCapCacheTask = downloadIOSCapCacheFiles(),
        packageMainJarTask = desktopPackagingTasks.packageMainJarTask,
        packageBootstrapJarTask = desktopPackagingTasks.packageBootstrapJarTask
    )
    val createIOSTask = createIOSStaticLibraryTask(
        downloadStaticJdkLibrariesTask = downloadIOSJdkStaticLibraries(),
        createIOSGraalNativeImageTask = createIOSGraalNativeImageTask
    )

    return NativePackagingTasks(
        createGraalNativeImageTask = createGraalNativeImageTask,
        createIOSTask = createIOSTask,
    )
}

private fun Project.setupCopyTasks(
    desktopPackagingTasks: DesktopPackagingTasks,
    androidPackagingTasks: AndroidPackagingTasks,
    nativePackagingTasks: NativePackagingTasks,
): CopyTasks {
    val generateGdIgnoreFilesTask = generateGdIgnoreFilesTask()
    val copyDesktopJarsTask = createCopyDesktopJarsTask(
        packageBootstrapJarTask = desktopPackagingTasks.packageBootstrapJarTask,
        packageMainJarTask = desktopPackagingTasks.packageMainJarTask,
    )
    val copyAndroidArtifactsTask = createCopyAndroidArtifactsTask(
        createBootstrapDexJarTask = androidPackagingTasks.createBootstrapDexJarTask,
        packageMainDexJarTask = androidPackagingTasks.packageMainDexJarTask,
    )
    val copyGraalArtifactsTask = createCopyGraalArtifactsTask(
        createGraalNativeImageTask = nativePackagingTasks.createGraalNativeImageTask,
    )
    val copyIOSArtifactsTask = createCopyIOSArtifactsTask(
        createIOSTask = nativePackagingTasks.createIOSTask,
    )

    return CopyTasks(
        generateGdIgnoreFilesTask = generateGdIgnoreFilesTask,
        copyDesktopJarsTask = copyDesktopJarsTask,
        copyAndroidArtifactsTask = copyAndroidArtifactsTask,
        copyGraalArtifactsTask = copyGraalArtifactsTask,
        copyIOSArtifactsTask = copyIOSArtifactsTask,
    )
}

private fun Project.setupBuildLifecycleTasks(
    desktopPackagingTasks: DesktopPackagingTasks,
    androidPackagingTasks: AndroidPackagingTasks,
    nativePackagingTasks: NativePackagingTasks,
    copyTasks: CopyTasks,
    checkIgnoredScriptSourcesTask: TaskProvider<out Task>,
) {
    tasks
        .withType(Jar::class.java)
        .filter { jarTask -> jarTask !is ShadowJar }
        .forEach { task ->
            task.dependsOn(copyTasks.generateGdIgnoreFilesTask)
            task.finalizedBy(
                copyTasks.copyDesktopJarsTask,
                desktopPackagingTasks.packageBootstrapJarTask,
                desktopPackagingTasks.packageMainJarTask
            )
        }

    val buildTask = tasks.named("build") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask)
    }

    tasks.named("buildRelease") { task ->
        task.dependsOn(buildTask)
    }

    tasks.named("fastBuild") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            copyTasks.generateGdIgnoreFilesTask,
            desktopPackagingTasks.packageBootstrapJarTask,
            desktopPackagingTasks.packageMainJarTask,
            copyTasks.copyDesktopJarsTask,
        )
    }

    tasks.named("buildAndroid") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            androidPackagingTasks.createBootstrapDexJarTask,
            androidPackagingTasks.packageMainDexJarTask,
            copyTasks.copyAndroidArtifactsTask
        )
    }

    tasks.named("buildAndroidRelease") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            androidPackagingTasks.createBootstrapDexJarTask,
            androidPackagingTasks.packageMainDexJarTask,
            copyTasks.copyAndroidArtifactsTask
        )
    }

    tasks.named("buildGraalNativeImage") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createGraalNativeImageTask, copyTasks.copyGraalArtifactsTask)
    }

    tasks.named("buildGraalNativeImageRelease") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createGraalNativeImageTask, copyTasks.copyGraalArtifactsTask)
    }

    tasks.named("buildIOS") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createIOSTask, copyTasks.copyIOSArtifactsTask)
    }

    tasks.named("buildIOSRelease") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createIOSTask, copyTasks.copyIOSArtifactsTask)
    }
}

private fun Project.setupLibraryModeBuildLifecycleTasks() {
    val buildTask = tasks.named("build")

    tasks.named("buildRelease") { task ->
        task.dependsOn(buildTask)
    }
    tasks.named("fastBuild") { task ->
        task.dependsOn(buildTask)
    }

    listOf(
        "buildAndroid",
        "buildAndroidRelease",
        "buildGraalNativeImage",
        "buildGraalNativeImageRelease",
        "buildIOS",
        "buildIOSRelease",
    ).forEach { taskName ->
        tasks.named(taskName) { task ->
            task.doFirst {
                throw GradleException("$taskName is not available when godot.isLibrary = true.")
            }
        }
    }
}

private fun Project.setupCleanLifecycleTasks(
    copyTasks: CopyTasks
) {
    tasks.named("clean") { task ->
        task.finalizedBy(copyTasks.generateGdIgnoreFilesTask)
    }
}

private fun Project.isFastBuildRequested(): Boolean =
    gradle.startParameter.taskNames.any { taskName ->
        taskName == "fastBuild" || taskName.endsWith(":fastBuild")
    }
