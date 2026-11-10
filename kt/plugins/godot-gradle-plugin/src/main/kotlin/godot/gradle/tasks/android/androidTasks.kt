package godot.gradle.tasks.android

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.libsDirectory
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.dependencies.splitDependencyJars
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider
import java.io.File

class AndroidTools(
    val checkD8Tool: TaskProvider<CheckD8ToolTask>,
    val checkAndroidJar: TaskProvider<CheckAndroidJarTask>,
)

fun Project.registerAndroidTools(): AndroidTools {
    val checkD8Tool = tasks.register("checkD8Tool", CheckD8ToolTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Checks if the d8 tool is accessible and executable. Needed for android builds only"
        task.d8ToolPath.set(godotJvmExtension.android.d8ToolPath)
    }
    val checkAndroidJar = tasks.register("checkAndroidJar", CheckAndroidJarTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Checks if android.jar is present in the configured compileSdkDirectory. Needed for Android builds only"
        task.androidCompileSdkDirectory.set(godotJvmExtension.android.compileSdkDirectory)
    }
    return AndroidTools(checkD8Tool, checkAndroidJar)
}

fun Project.registerDebugAndroidTasks(
    bootstrapJar: TaskProvider<ShadowJar>,
    userCodeJar: TaskProvider<ShadowJar>,
    tools: AndroidTools,
): TaskProvider<CopyIntoGodotProjectTask> {
    val bootstrapDexJar = registerDexJar(
        name = "dexBootstrapJar",
        description = "Converts the godot-bootstrap.jar to an android compatible version. Needed for android builds only",
        inputJar = bootstrapJar.flatMap(ShadowJar::getArchiveFile),
        buildType = BuildType.DEBUG,
        dexJarName = ArtifactNames.Debug.BOOTSTRAP_DEX_JAR,
        tools = tools,
    )
    val dexUserCode = tasks.register("dexUserCode", DexUserCodeTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Converts the usercode.jar to an android dex file. Needed for android builds only"
        task.dependsOn(tools.checkD8Tool, tools.checkAndroidJar)
        task.userCodeJar.set(userCodeJar.flatMap(ShadowJar::getArchiveFile))
        task.bootstrapJar.set(bootstrapJar.flatMap(ShadowJar::getArchiveFile))
        task.splitDependencyJars.from(splitDependencyJars())
        task.mainDexRulesFile.set(layout.buildDirectory.file("main-dex-rules.proguard"))
        task.dexOutputDirectory.set(layout.buildDirectory.dir("intermediates/user-code-dex/${BuildType.DEBUG.id}"))
        configureD8(task)
    }
    val userCodeDexJar = tasks.register("packageUserCodeDexJar", ShadowJar::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Packs the android dex file of main, together with the needed registrar service file into a jar. Needed for android builds only"
        task.archiveBaseName.set(ArtifactNames.Debug.USER_CODE_DEX_JAR.removeSuffix(".jar"))
        task.destinationDirectory.set(libsDirectory(BuildType.DEBUG))
        task.from(dexUserCode.flatMap(DexUserCodeTask::dexOutputDirectory))
        task.from(zipTree(userCodeJar.flatMap(ShadowJar::getArchiveFile))) { spec -> spec.exclude("**/*.class") }
        task.dependsOn(dexUserCode, userCodeJar)
    }
    val debugDirectory = godotJvmDirectory().resolve(BuildType.DEBUG.id)
    return registerCopyIntoGodotProject(
        name = "copyDexJars",
        description = "Copies the debug Android dex jars into the Godot project.",
        bootstrapDexJar.flatMap(DexJarTask::dexJar) to debugDirectory.resolve(ArtifactNames.Debug.BOOTSTRAP_DEX_JAR),
        userCodeDexJar.flatMap(ShadowJar::getArchiveFile) to debugDirectory.resolve(ArtifactNames.Debug.USER_CODE_DEX_JAR),
    )
}

fun Project.registerReleaseAndroidTasks(
    gameJar: TaskProvider<ShadowJar>,
    tools: AndroidTools,
): TaskProvider<CopyIntoGodotProjectTask> {
    val gameDexJar = registerDexJar(
        name = "dexGameJar",
        description = "Converts the release ${ArtifactNames.Release.JAR} to an android compatible version. Needed for android builds only",
        inputJar = gameJar.flatMap(ShadowJar::getArchiveFile),
        buildType = BuildType.RELEASE,
        dexJarName = ArtifactNames.Release.DEX_JAR,
        tools = tools,
    )
    return registerCopyIntoGodotProject(
        name = "copyDexJarsRelease",
        description = "Copies the release Android dex jar into the Godot project.",
        gameDexJar.flatMap(DexJarTask::dexJar) to
            godotJvmDirectory().resolve(BuildType.RELEASE.id).resolve(ArtifactNames.Release.DEX_JAR),
    )
}

private fun Project.registerDexJar(
    name: String,
    description: String,
    inputJar: Provider<RegularFile>,
    buildType: BuildType,
    dexJarName: String,
    tools: AndroidTools,
): TaskProvider<DexJarTask> = tasks.register(name, DexJarTask::class.java) { task ->
    task.group = "godot-jvm"
    task.description = description
    task.dependsOn(tools.checkD8Tool, tools.checkAndroidJar)
    task.inputJar.set(inputJar)
    task.additionalInputJars.from(splitDependencyJars())
    task.dexJar.set(libsDirectory(buildType).map { directory -> directory.file(dexJarName) })
    configureD8(task)
}

private fun Project.configureD8(task: D8Task) {
    task.d8ToolPath.set(godotJvmExtension.android.d8ToolPath)
    task.androidJarPath.set(godotJvmExtension.android.compileSdkDirectory.map { directory -> File(directory).resolve("android.jar").absolutePath })
    task.androidMinApiLevel.set(godotJvmExtension.android.minApiLevel)
}
