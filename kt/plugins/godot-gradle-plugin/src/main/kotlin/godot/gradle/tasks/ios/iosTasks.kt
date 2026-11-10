package godot.gradle.tasks.ios

import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.libsDirectory
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.SyncIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.copy.registerSyncIntoGodotProject
import godot.gradle.tasks.graal.GraalTools
import godot.gradle.tasks.graal.configureNativeImage
import godot.tools.common.IOS_GRAAL_NATIVE_IMAGE_VERSION
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider

class IosTools(
    val downloadIOSGraalToolchain: TaskProvider<DownloadIOSGraalToolchainTask>,
    val writeIOSGraalConfigs: TaskProvider<WriteIOSGraalConfigsTask>,
    val syncIOSJdk: TaskProvider<SyncIntoGodotProjectTask>,
)

fun Project.registerIosTools(): IosTools {
    val download = tasks.register("downloadIOSGraalToolchain", DownloadIOSGraalToolchainTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Downloads the iOS static JDK libraries and the CAP cache needed by GraalVM native-image."
        task.iosJdkDirectory.set(layout.buildDirectory.dir("libs/${Paths.IOS_DIR}/${Paths.IOS_JDK_DIR}"))
        task.capCacheDirectory.set(layout.buildDirectory.dir("graal/ios/capcache/$IOS_GRAAL_NATIVE_IMAGE_VERSION"))
        task.bundleUrl.set(
            "https://github.com/utopia-rise/ios-graal-native-image/releases/download/" +
                "$IOS_GRAAL_NATIVE_IMAGE_VERSION/ios-graal-$IOS_GRAAL_NATIVE_IMAGE_VERSION.zip"
        )
    }
    val configs = tasks.register("writeIOSGraalConfigs", WriteIOSGraalConfigsTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Writes the native-image configuration Godot-JVM itself needs on iOS."
        task.graalDirectory.set(layout.buildDirectory.dir("graal-ios-configs"))
        task.resourcePaths.set(listOf("ios/$iosJniConfig", "ios/$iosReflectionConfig", "ios/$iosResourceConfig"))
    }
    val syncIOSJdk = registerSyncIntoGodotProject(
        name = "syncIOSJdk",
        description = "Copies the iOS JDK static libraries, shared by both build types, into the Godot project.",
        source = download.flatMap(DownloadIOSGraalToolchainTask::iosJdkDirectory),
        target = godotJvmDirectory().resolve(Paths.IOS_DIR).resolve(Paths.IOS_JDK_DIR),
    )
    return IosTools(download, configs, syncIOSJdk)
}

fun Project.registerIosTasks(
    buildType: BuildType,
    gameJars: List<Provider<RegularFile>>,
    graalTools: GraalTools,
    iosTools: IosTools,
): TaskProvider<CopyIntoGodotProjectTask> {
    val nativeImage = tasks.register(buildType.named("compileIOSNativeImage"), CompileIOSNativeImageTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Converts the packaged jars into a GraalVM iOS native image."
        configureNativeImage(task, buildType, gameJars, graalTools)
        task.iosNativeImageDirectory.set(libsDirectory(buildType).map { directory -> directory.dir("ios/native-image") })
        task.iosConfigDirectory.set(iosTools.writeIOSGraalConfigs.flatMap(WriteIOSGraalConfigsTask::graalDirectory))
        task.capCacheDirectory.set(iosTools.downloadIOSGraalToolchain.flatMap(DownloadIOSGraalToolchainTask::capCacheDirectory))
    }
    val staticLibrary = tasks.register(buildType.named("packageIOSStaticLibrary"), PackageIOSStaticLibraryTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Packs the iOS native image object file into a static library."
        task.iosNativeImageDirectory.set(nativeImage.flatMap(CompileIOSNativeImageTask::iosNativeImageDirectory))
        task.userCodeArchive.set(libsDirectory(buildType).map { directory -> directory.file(ArtifactNames.IOS_STATIC_LIBRARY) })
    }
    return registerCopyIntoGodotProject(
        name = buildType.named("copyIOSStaticLibrary"),
        description = "Copies the iOS static library of this build type into the Godot project.",
        staticLibrary.flatMap(PackageIOSStaticLibraryTask::userCodeArchive) to
            godotJvmDirectory().resolve(buildType.id).resolve(ArtifactNames.IOS_STATIC_LIBRARY),
    )
}
