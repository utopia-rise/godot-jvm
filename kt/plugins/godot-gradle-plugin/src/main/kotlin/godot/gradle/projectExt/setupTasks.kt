package godot.gradle.projectExt

import godot.gradle.tasks.GenerateEmbeddedJreTask
import godot.gradle.tasks.addon.installAddonTask
import godot.gradle.tasks.api.registerCustomApiGeneration
import godot.gradle.tasks.api.registerGodotApi
import godot.tools.common.constants.Paths
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.bundling.Jar
import org.gradle.jvm.toolchain.JavaToolchainService

private val ENTRY_TASKS = mapOf(
    "fastBuild" to "Rebuilds the debug user code jar only, reusing the registrars of the last full build.",
    "buildRelease" to "Runs build, then builds and copies the release jar.",
    "buildAndroid" to "Runs build, then builds and copies the debug Android dex jars.",
    "buildAndroidRelease" to "Runs buildRelease, then builds and copies the release Android dex jar.",
    "buildGraalNativeImage" to "Runs build, then builds and copies the debug GraalVM native image.",
    "buildGraalNativeImageRelease" to "Runs buildRelease, then builds and copies the release GraalVM native image.",
    "buildIOS" to "Runs build, then builds and copies the debug iOS static library.",
    "buildIOSRelease" to "Runs buildRelease, then builds and copies the release iOS static library.",
)

fun Project.setupTasks() {
    registerEmbeddedJreTasks()
    for ((name, description) in ENTRY_TASKS) {
        tasks.register(name) { task ->
            task.group = "build"
            task.description = description
        }
    }

    afterEvaluate {
        if (godotJvmExtension.isLibrary.get()) {
            setupLibraryMode()
            return@afterEvaluate
        }

        installAddonTask()
        tasks.named("shadowJar") { task -> task.enabled = false }
        val requestedTasks = gradle.startParameter.taskNames.map { taskName -> taskName.substringAfterLast(':') }
        val fastBuild = "fastBuild" in requestedTasks
        if (fastBuild && requestedTasks.any { taskName -> taskName == "build" || taskName in ENTRY_TASKS.keys - "fastBuild" }) {
            throw GradleException("fastBuild reuses the registrars of the last build, so it cannot run together with another build task.")
        }
        val shared = registerSharedTasks(fastBuild)
        val pipelines = buildTypes.associateWith { buildType -> registerPipeline(buildType, shared) }
        wireEntryTasks(shared, pipelines)

        tasks.named("clean") { task -> task.finalizedBy(shared.project.generateGdIgnoreFiles) }
    }
}

private fun Project.wireEntryTasks(shared: SharedTasks, pipelines: Map<BuildType, Pipeline>) {
    val projectTasks = listOf(shared.project.generateGdIgnoreFiles, shared.project.checkIgnoredScriptSources)
    val debug = pipelines.getValue(BuildType.DEBUG)
    val build = tasks.named("build") { task ->
        task.dependsOn(projectTasks, shared.syncSplitDependencies, debug.desktop)
        shared.registration.syncRegistrationFiles?.let { sync -> task.dependsOn(sync) }
    }
    tasks.named("fastBuild") { task -> task.dependsOn(projectTasks, listOfNotNull(debug.copyUserCode)) }
    tasks.named("buildAndroid") { task -> task.dependsOn(build, debug.android) }
    tasks.named("buildGraalNativeImage") { task -> task.dependsOn(build, debug.graal) }
    tasks.named("buildIOS") { task -> task.dependsOn(build, debug.ios, shared.ios.syncIOSJdk) }

    val release = pipelines[BuildType.RELEASE] ?: return
    val buildRelease = tasks.named("buildRelease") { task -> task.dependsOn(build, release.desktop) }
    tasks.named("buildAndroidRelease") { task -> task.dependsOn(buildRelease, release.android) }
    tasks.named("buildGraalNativeImageRelease") { task -> task.dependsOn(buildRelease, release.graal) }
    tasks.named("buildIOSRelease") { task -> task.dependsOn(buildRelease, release.ios, shared.ios.syncIOSJdk) }
}

private fun Project.setupLibraryMode() {
    val generation = registerCustomApiGeneration()
    for (buildType in buildTypes) {
        registerGodotApi(buildType, generation)
    }
    tasks.named("jar", Jar::class.java) { jarTask ->
        jarTask.group = "godot-jvm"
        jarTask.description = "Builds the reusable Godot-JVM library jar."
        jarTask.archiveBaseName.set(project.name)
        jarTask.archiveVersion.set("")
        jarTask.archiveClassifier.set("")
    }
    val build = tasks.named("build")
    for (name in ENTRY_TASKS.keys) {
        tasks.named(name) { task ->
            if (name == "buildRelease" || name == "fastBuild") {
                task.dependsOn(build)
            } else {
                task.doFirst { throw GradleException("$name is not available when godot.isLibrary = true.") }
            }
        }
    }
}

private fun Project.registerEmbeddedJreTasks() {
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
}
