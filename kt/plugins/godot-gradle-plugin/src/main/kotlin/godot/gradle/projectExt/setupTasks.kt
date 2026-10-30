package godot.gradle.projectExt

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.tasks.ClassGraphGenerateRegistrarFilesTask
import godot.gradle.tasks.GenerateEmbeddedJreTask
import godot.gradle.tasks.addon.installAddonTask
import godot.gradle.tasks.android.CreateDexJarTask
import godot.gradle.tasks.android.checkAndroidJarAccessibleTask
import godot.gradle.tasks.android.checkD8ToolAccessibleTask
import godot.gradle.tasks.android.createBootstrapDexJarTask
import godot.gradle.tasks.android.createMainDexFileTask
import godot.gradle.tasks.android.createGameDexJarTask
import godot.gradle.tasks.android.packageUserCodeDexJarTask
import godot.gradle.tasks.createCopyAndroidArtifactsTask
import godot.gradle.tasks.createCopyDesktopJarsTask
import godot.gradle.tasks.createCopyGraalArtifactsTask
import godot.gradle.tasks.createCopyIOSArtifactsTask
import godot.gradle.tasks.createCopyIOSJdkTask
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
import godot.gradle.tasks.graal.ios.downloadIOSGraalToolchain
import godot.tools.common.constants.Paths
import godot.gradle.tasks.packageBootstrapJarTask
import godot.gradle.tasks.packageUserCodeJarTask
import godot.gradle.tasks.packageReleaseJarTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaToolchainService

private data class RegistrarGenerationTasks(
    val generateRegistrarFilesTask: TaskProvider<ClassGraphGenerateRegistrarFilesTask>,
    val updateRegistrationFilesTask: TaskProvider<out Task>,
    val generatedRegistrarJarTask: TaskProvider<Jar>,
)

private data class DesktopPackagingTasks(
    val packageBootstrapJarTask: TaskProvider<ShadowJar>,
    val packageUserCodeJarTask: TaskProvider<ShadowJar>,
    /** Only registered for release builds, which ship the merged jar instead of the pair. */
    val packageReleaseJarTask: TaskProvider<ShadowJar>?,
) {
    val gameJarTasksByJarName: Map<String, TaskProvider<ShadowJar>>
        get() = packageReleaseJarTask?.let { mapOf("GameJar" to it) }
            ?: mapOf("BootstrapJar" to packageBootstrapJarTask, "UserCodeJar" to packageUserCodeJarTask)

    val gameJarTasks: List<TaskProvider<ShadowJar>>
        get() = gameJarTasksByJarName.values.toList()
}

private data class AndroidPackagingTasks(
    val createBootstrapDexJarTask: TaskProvider<CreateDexJarTask>,
    val packageUserCodeDexJarTask: TaskProvider<ShadowJar>,
    /** Only registered for release builds, which dex the merged jar instead of the pair. */
    val createGameDexJarTask: TaskProvider<CreateDexJarTask>?,
) {
    val gameDexJarTasksByJarName: Map<String, TaskProvider<out Task>>
        get() = createGameDexJarTask?.let { mapOf("GameDexJar" to it) }
            ?: mapOf("BootstrapDexJar" to createBootstrapDexJarTask, "UserCodeDexJar" to packageUserCodeDexJarTask)

    val gameDexJarTasks: List<TaskProvider<out Task>>
        get() = gameDexJarTasksByJarName.values.toList()
}

private data class NativePackagingTasks(
    val createGraalNativeImageTask: TaskProvider<out Task>,
    val createIOSTask: TaskProvider<out Task>,
    val downloadIOSGraalToolchainTask: TaskProvider<out Task>,
)

private data class CopyTasks(
    val generateGdIgnoreFilesTask: TaskProvider<out Task>,
    val copyDesktopJarsTask: TaskProvider<out Task>,
    val copyAndroidArtifactsTask: TaskProvider<out Task>,
    val copyGraalArtifactsTask: TaskProvider<out Task>,
    val copyIOSArtifactsTask: TaskProvider<out Task>,
    val copyIOSJdkTask: TaskProvider<out Task>,
)

fun Project.setupTasks() {
    tasks.register("generateEmbeddedJre", GenerateEmbeddedJreTask::class.java, GenerateEmbeddedJreTask.hostArch()).configure { task ->
        task.group = "godot-jvm"
        task.description = "Generates an embedded jre for the host architecture using jlink"
    }
    if (GenerateEmbeddedJreTask.hostOs() == "macos") {
        for (arch in listOf("arm64", "amd64")) {
            tasks.register("generateEmbeddedJre${arch.replaceFirstChar(Char::uppercase)}", GenerateEmbeddedJreTask::class.java, arch).configure { task ->
                task.group = "godot-jvm"
                task.description = "Generates an embedded $arch macOS jre using jlink"
            }
        }
    }
    val toolchainJavaHome = extensions.getByType(JavaToolchainService::class.java)
        .compilerFor(extensions.getByType(JavaPluginExtension::class.java).toolchain)
        .map { compiler -> compiler.metadata.installationPath.asFile.absolutePath }
    tasks.withType(GenerateEmbeddedJreTask::class.java).configureEach { task ->
        task.javaHome.convention(toolchainJavaHome)
        task.outputDir.convention(
            godotJvmExtension.godotProjectDirectory.dir("${Paths.GODOT_JVM_DIR}/jre-${task.targetArch}-${GenerateEmbeddedJreTask.hostOs()}")
        )
        task.gradleUserHome.set(gradle.gradleUserHomeDir)
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
                tasks.named("jar", Jar::class.java) { jarTask ->
                    jarTask.group = "godot-jvm"
                    jarTask.description = "Builds the reusable Godot-JVM library jar."
                    jarTask.archiveBaseName.set(project.name)
                    jarTask.archiveVersion.set("")
                    jarTask.archiveClassifier.set("")
                }
                setupLibraryModeBuildLifecycleTasks()
                return@with
            }

            installAddonTask()
            val checkIgnoredScriptSourcesTask = checkIgnoredScriptSourcesTask()

            val classesTask = tasks.named("classes")
            val registrarGenerationTasks = setupRegistrarGenerationTasks(classesTask)
            val desktopPackagingTasks = setupDesktopPackagingTasks(classesTask, registrarGenerationTasks, customApiJarTask)
            val androidPackagingTasks = setupAndroidPackagingTasks(desktopPackagingTasks)
            val nativePackagingTasks = setupNativePackagingTasks(desktopPackagingTasks)
            val copyTasks = setupCopyTasks(
                registrarGenerationTasks = registrarGenerationTasks,
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
        task.description = "Builds the desktop release jar."
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
        task.description = "Builds the desktop release jar and Android dex artifact."
    }

    tasks.register("buildGraalNativeImage") { task ->
        task.group = "build"
        task.description = "Builds the desktop jars and GraalVM native image."
    }

    tasks.register("buildGraalNativeImageRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jar and GraalVM native image."
    }

    tasks.register("buildIOS") { task ->
        task.group = "build"
        task.description = "Builds the desktop jars and iOS static library."
    }

    tasks.register("buildIOSRelease") { task ->
        task.group = "build"
        task.description = "Builds the desktop release jar and iOS static library."
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

    val updateRegistrationFilesTask = if (godotJvmExtension.registration.disableGdj.get()) {
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
    val packageUserCodeJarTask = packageUserCodeJarTask(
        generatedRegistrarJarTask = registrarGenerationTasks.generatedRegistrarJarTask,
        updateRegistrationFilesTask = registrarGenerationTasks.updateRegistrationFilesTask,
        userClassesTask = classesTask,
    )
    val packageReleaseJarTask = if (isRelease) {
        packageReleaseJarTask(
            packageBootstrapJarTask = packageBootstrapJarTask,
            packageUserCodeJarTask = packageUserCodeJarTask,
        )
    } else {
        null
    }

    return DesktopPackagingTasks(
        packageBootstrapJarTask = packageBootstrapJarTask,
        packageUserCodeJarTask = packageUserCodeJarTask,
        packageReleaseJarTask = packageReleaseJarTask,
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
        packageUserCodeJarTask = desktopPackagingTasks.packageUserCodeJarTask,
        packageBootstrapJarTask = desktopPackagingTasks.packageBootstrapJarTask,
    )
    val packageUserCodeDexJarTask = packageUserCodeDexJarTask(
        createMainDexFileTask = createMainDexFileTask,
        packageUserCodeJarTask = desktopPackagingTasks.packageUserCodeJarTask,
    )

    val packageReleaseJarTask = desktopPackagingTasks.packageReleaseJarTask
    val createGameDexJarTask = if (packageReleaseJarTask != null) {
        createGameDexJarTask(
            checkAndroidJarAccessibleTask = checkAndroidJarAccessibleTask,
            checkD8ToolAccessibleTask = checkD8ToolAccessibleTask,
            packageReleaseJarTask = packageReleaseJarTask,
        )
    } else {
        null
    }

    return AndroidPackagingTasks(
        createBootstrapDexJarTask = createBootstrapDexJarTask,
        packageUserCodeDexJarTask = packageUserCodeDexJarTask,
        createGameDexJarTask = createGameDexJarTask,
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
        gameJarTasks = desktopPackagingTasks.gameJarTasks,
    )
    val downloadIOSGraalToolchainTask = downloadIOSGraalToolchain()
    val createIOSGraalNativeImageTask = createIOSGraalNativeImageTask(
        checkNativeImageToolAccessibleTask = checkNativeImageToolAccessibleTask,
        copyDefaultGraalIOSConfigsTask = copyDefaultGraalIOSConfigsTask,
        downloadIOSGraalToolchainTask = downloadIOSGraalToolchainTask,
        gameJarTasks = desktopPackagingTasks.gameJarTasks,
    )
    val createIOSTask = createIOSStaticLibraryTask(
        downloadIOSGraalToolchainTask = downloadIOSGraalToolchainTask,
        createIOSGraalNativeImageTask = createIOSGraalNativeImageTask,
    )

    return NativePackagingTasks(
        createGraalNativeImageTask = createGraalNativeImageTask,
        createIOSTask = createIOSTask,
        downloadIOSGraalToolchainTask = downloadIOSGraalToolchainTask,
    )
}

private fun Project.setupCopyTasks(
    registrarGenerationTasks: RegistrarGenerationTasks,
    desktopPackagingTasks: DesktopPackagingTasks,
    androidPackagingTasks: AndroidPackagingTasks,
    nativePackagingTasks: NativePackagingTasks,
): CopyTasks {
    val generateGdIgnoreFilesTask = generateGdIgnoreFilesTask()
    val copyDesktopJarsTask = createCopyDesktopJarsTask(
        gameJarTasksByJarName = desktopPackagingTasks.gameJarTasksByJarName,
        generateRegistrarFilesTask = registrarGenerationTasks.generateRegistrarFilesTask,
    )
    val copyAndroidArtifactsTask = createCopyAndroidArtifactsTask(
        gameDexJarTasksByJarName = androidPackagingTasks.gameDexJarTasksByJarName,
    )
    val copyGraalArtifactsTask = createCopyGraalArtifactsTask(
        createGraalNativeImageTask = nativePackagingTasks.createGraalNativeImageTask,
    )
    val copyIOSArtifactsTask = createCopyIOSArtifactsTask(
        createIOSTask = nativePackagingTasks.createIOSTask,
    )
    val copyIOSJdkTask = createCopyIOSJdkTask(
        downloadIOSGraalToolchainTask = nativePackagingTasks.downloadIOSGraalToolchainTask,
    )

    return CopyTasks(
        generateGdIgnoreFilesTask = generateGdIgnoreFilesTask,
        copyDesktopJarsTask = copyDesktopJarsTask,
        copyAndroidArtifactsTask = copyAndroidArtifactsTask,
        copyGraalArtifactsTask = copyGraalArtifactsTask,
        copyIOSArtifactsTask = copyIOSArtifactsTask,
        copyIOSJdkTask = copyIOSJdkTask,
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
            task.finalizedBy(copyTasks.copyDesktopJarsTask)
        }

    val buildTask = tasks.named("build") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask)
    }

    tasks.named("buildRelease") { task ->
        task.dependsOn(buildTask, copyTasks.copyDesktopJarsTask)
    }

    if (isFastBuildRequested() && isRelease) {
        throw GradleException("fastBuild only produces debug artifacts. Use buildRelease instead for release builds.")
    }
    tasks.named("fastBuild") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            copyTasks.generateGdIgnoreFilesTask,
            copyTasks.copyDesktopJarsTask,
        )
    }

    tasks.named("buildAndroid") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            androidPackagingTasks.gameDexJarTasks,
            copyTasks.copyAndroidArtifactsTask
        )
    }

    tasks.named("buildAndroidRelease") { task ->
        task.dependsOn(
            checkIgnoredScriptSourcesTask,
            androidPackagingTasks.gameDexJarTasks,
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
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createIOSTask, copyTasks.copyIOSArtifactsTask, copyTasks.copyIOSJdkTask)
    }

    tasks.named("buildIOSRelease") { task ->
        task.dependsOn(checkIgnoredScriptSourcesTask, nativePackagingTasks.createIOSTask, copyTasks.copyIOSArtifactsTask, copyTasks.copyIOSJdkTask)
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
