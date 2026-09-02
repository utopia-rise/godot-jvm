import godot.gradle.GodotLanguage
import godot.registrar.generator.RegistrationFileLayoutMode
import org.jetbrains.kotlin.konan.target.HostManager
import java.util.concurrent.TimeUnit

plugins {
    // no need to apply kotlin jvm plugin. Our plugin already applies the correct version for you
//    kotlin("jvm") version "1.7.10"
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

godot {
    registration {
        gdjFilesDirectory.set(projectDir.resolve("scripts"))
        gdjFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
    }
    isGodotCoroutinesEnabled.set(true)


    val androidSdkRoot = System.getenv("ANDROID_SDK_ROOT")
    val d8Executable = if (HostManager.hostIsMingw) "d8.bat" else "d8"
    android {
        d8ToolPath.set(System.getenv("ANDROID_D8") ?: "$androidSdkRoot/build-tools/37.0.0/$d8Executable")
        compileSdkDirectory.set(System.getenv("ANDROID_COMPILE_SDK_DIRECTORY") ?: "$androidSdkRoot/platforms/android-36.1/")
    }

    graal {
        homeDirectory.set(System.getenv("GRAALVM_HOME"))
        additionalResourceConfigurationFiles.set(
            arrayOf(
                projectDir.resolve("graal").resolve("resource-config.json").absolutePath,
            )
        )
        additionalReflectionConfigurationFiles.set(
            arrayOf(
                projectDir.resolve("graal").resolve("reflect-config.json").absolutePath,
            )
        )
        windowsDeveloperVcVarsPath.set(System.getenv("VC_VARS_PATH"))
    }

}

dependencies {
    implementation("joda-time:joda-time:2.10.6") // external dependency to test dependency inclusion in mainCompilation

    implementation("com.godot.tests:third-party-library")


    // reflection test cases: see GH-571
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}


kotlin.sourceSets.main {
    kotlin.srcDirs("otherSourceDir")
}

fun bundledBinDirectories(): List<File> = listOf(
    projectDir.resolve("../../../../bin"),
    projectDir.resolve("bin"),
    rootProject.layout.projectDirectory.asFile.resolve("bin"),
)

fun resolveBundledBinaries(): List<File> =
    bundledBinDirectories().flatMap { directory -> (directory.listFiles() ?: emptyArray()).toList() }

fun provideEditorExecutable(): File = System.getenv("GODOT_EDITOR")
    ?.let(::File)
    ?.takeIf(File::isFile)
    ?: resolveBundledBinaries()
        .also { println("[${it.joinToString()}]") }
        .firstOrNull { it.name.startsWith("godot.") && it.name.contains("editor") && !it.name.contains("console") }
        .also { println("Godot executable selected: $it") }
        ?: error("Could not find editor executable")

fun currentExportTarget(): String = when {
    HostManager.hostIsLinux -> "tests_linux"
    HostManager.hostIsMac -> "tests_macos"
    HostManager.hostIsMingw -> "tests_windows"
    else -> throw IllegalStateException("Unsupported OS for exporting")
}

fun File.ensureEmptyDirectory() {
    deleteRecursively()
    mkdirs()
}

fun findExportedExecutable(): File? {
    val exportedFiles = projectDir.resolve("export").listFiles()?.toList().orEmpty()
    println("Test executables: [${exportedFiles.joinToString()}]")
    exportedFiles.forEach { it.setExecutable(true) }

    val exportedExecutable = when {
        HostManager.hostIsMingw -> exportedFiles.firstOrNull { it.name.endsWith(".console.exe") }
        HostManager.hostIsMac -> exportedFiles.firstOrNull { it.name.endsWith(".app") }
        // The GDExtension shared library sits next to the exported binary and also carries the
        // architecture in its name, so matching on "x86_64" alone can select it instead of the
        // executable (directory order decides) -- running a .so exits with SIGSEGV and no output.
        else -> exportedFiles.firstOrNull { it.isFile && it.name.contains("x86_64") && it.extension != "so" }
    } ?: exportedFiles.firstOrNull { it.name.endsWith(".exe") }

    return if (exportedExecutable?.name?.endsWith(".app") == true) {
        exportedExecutable.resolve("Contents/MacOS").listFiles()?.firstOrNull()
    } else {
        exportedExecutable
    }
}

fun requireExportedExecutable(): File =
    findExportedExecutable()
        ?: error("No exported test executable found in ${projectDir.resolve("export")}. Run exportDebug or exportRelease first.")

fun registerExportTask(name: String, exportFlag: String, description: String) = tasks.register<Exec>(name) {
    group = "verification"
    this.description = description

    environment("JAVA_HOME", System.getProperty("java.home"))
    workingDir = projectDir

    doFirst {
        projectDir.resolve("export").ensureEmptyDirectory()
    }

    doFirst {
        commandLine(
            provideEditorExecutable().absolutePath,
            "--headless",
            exportFlag,
            currentExportTarget(),
        )
    }
}

fun registerAndroidExportTask(name: String, exportFlag: String, description: String) = tasks.register<Exec>(name) {
    group = "verification"
    this.description = description

    environment("JAVA_HOME", System.getProperty("java.home"))
    workingDir = projectDir

    doFirst {
        projectDir.resolve("export").ensureEmptyDirectory()
    }

    doFirst {
        commandLine(
            provideEditorExecutable().absolutePath,
            "--headless",
            exportFlag,
            "tests_android",
            "export/tests.apk",
        )
    }
}

fun registerIOSExportTask(name: String, exportFlag: String, description: String) = tasks.register<Exec>(name) {
    group = "verification"
    this.description = description

    environment("JAVA_HOME", System.getProperty("java.home"))
    workingDir = projectDir
    isIgnoreExitValue = true

    doFirst {
        projectDir.resolve("export").ensureEmptyDirectory()
    }

    doFirst {
        commandLine(
            provideEditorExecutable().absolutePath,
            "--headless",
            exportFlag,
            "iOS",
            "export/tests.ipa",
        )
    }

    doLast {
        val exportProject = projectDir.resolve("export/tests.xcodeproj/project.pbxproj")
        val exitValue = executionResult.get().exitValue
        check(exitValue == 0 || exitValue == 134 && exportProject.isFile) {
            "Godot failed to export the iOS test project (exit code $exitValue)"
        }
    }
}

fun registerGraalTestTask(
    name: String,
    description: String,
    executableProvider: () -> File,
    useProjectPathOverride: Boolean,
    scriptArgs: List<String>,
) = tasks.register<Exec>(name) {
    group = "verification"
    this.description = description

    setupTestExecution {
        TestExecutionCommand(
            executable = executableProvider().absolutePath,
            useProjectPathOverride = useProjectPathOverride,
            scriptArgs = scriptArgs,
        )
    }
}

tasks {
    register("importResources") {
        group = "verification"
        description = "Imports the Godot project after rebuilding JVM registrations."
        dependsOn(build)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir

        doLast {
            // Godot writes megabytes of verbose output while importing, so send it to a
            // file rather than a pipe: nothing here drains a pipe while waiting, and a
            // full pipe buffer would deadlock the editor on its very first prints.
            val logFile = layout.buildDirectory.file("import-resources.log").get().asFile
            logFile.parentFile.mkdirs()

            val process = ProcessBuilder(provideEditorExecutable().absolutePath, "--headless", "--import")
                .directory(workingDirectory)
                .redirectErrorStream(true)
                .redirectOutput(logFile)
                .apply { environment()["JAVA_HOME"] = javaHome }
                .start()

            // Godot sometimes never exits once the import is done, which used to wedge CI
            // until the job itself timed out. The imported files are already on disk by
            // then, so stop waiting and kill it instead.
            val exited = process.waitFor(5, TimeUnit.MINUTES)
            if (!exited) {
                process.destroyForcibly()
                process.waitFor(1, TimeUnit.MINUTES)
            }

            println(logFile.readText())
            if (!exited) {
                logger.warn("Godot did not exit after importing the project, terminating it.")
            }

            val classCache = workingDirectory.resolve(".godot/global_script_class_cache.cfg")
            check(classCache.isFile) {
                "Godot did not finish importing the test project: $classCache is missing."
            }
        }
    }
    val exportDebug = registerExportTask("exportDebug", "--export-debug", "Exports the tests for the current host OS in debug mode")
    val exportRelease = registerExportTask("exportRelease", "--export-release", "Exports the tests for the current host OS in release mode")
    val exportAndroidDebug = registerAndroidExportTask("exportAndroidDebug", "--export-debug", "Exports the tests as an Android debug APK")
    val exportAndroidRelease = registerAndroidExportTask("exportAndroidRelease", "--export-release", "Exports the tests as an Android release APK")
    val exportIOSDebug = registerIOSExportTask("exportIOSDebug", "--export-debug", "Exports the tests as an iOS debug project")
    val exportIOSRelease = registerIOSExportTask("exportIOSRelease", "--export-release", "Exports the tests as an iOS release project")

    register<Exec>("runGDTests") {
        group = "verification"
        description = "Runs GDUnit tests from the source Godot project. Requires build and importResources first."

        setupTestExecution {
            TestExecutionCommand(
                executable = provideEditorExecutable().absolutePath,
                useProjectPathOverride = true,
                // Source tests run via the editor, where GdUnitCmdTool works fine.
                scriptArgs = listOf(
                    "-s",
                    "res://addons/gdUnit4/bin/GdUnitCmdTool.gd",
                    "-a",
                    "test",
                    "-c",
                    "--ignoreHeadlessMode",
                ),
            )
        }
    }
    registerGraalTestTask(
        name = "runGraalGDTests",
        description = "Runs GDUnit tests in the editor using GraalVM Native Image. Requires build, importResources, and buildGraalNativeImage first.",
        executableProvider = ::provideEditorExecutable,
        useProjectPathOverride = true,
        scriptArgs = listOf(
            "--jvm-vm-type=graal_native_image",
            "-s",
            "res://addons/gdUnit4/bin/GdUnitCmdTool.gd",
            "-a",
            "test",
            "-c",
            "--ignoreHeadlessMode",
        ),
    )
    register<Exec>("runExportedGDTests") {
        group = "verification"
        description = "Runs GDUnit tests from the exported package. Requires exportDebug or exportRelease first."

        setupTestExecution {
            TestExecutionCommand(
                executable = requireExportedExecutable().absolutePath,
                useProjectPathOverride = false,
                scriptArgs = emptyList(),
            )
        }
    }
    registerGraalTestTask(
        name = "runExportedGraalGDTests",
        description = "Runs GDUnit tests from the exported package using GraalVM Native Image. Requires buildGraalNativeImage and exportDebug or exportRelease first.",
        executableProvider = ::requireExportedExecutable,
        useProjectPathOverride = false,
        scriptArgs = listOf("--jvm-vm-type=graal_native_image"),
    )
}

data class TestExecutionCommand(
    val executable: String,
    val useProjectPathOverride: Boolean,
    val scriptArgs: List<String>,
)

fun shouldUseHeadlessTestExecution(): Boolean =
    HostManager.hostIsLinux &&
        System.getenv("DISPLAY").isNullOrBlank() &&
        System.getenv("WAYLAND_DISPLAY").isNullOrBlank()

fun Exec.setupTestExecution(commandProvider: () -> TestExecutionCommand) {
    this.isIgnoreExitValue = false

    doFirst {
        val command = commandProvider()
        val projectPathArgs = if (command.useProjectPathOverride) {
            listOf("--path", projectDir.absolutePath)
        } else {
            emptyList()
        }
        val runtimeArgs = buildList {
            if (shouldUseHeadlessTestExecution()) {
                add("--headless")
            }
            addAll(projectPathArgs)
            addAll(command.scriptArgs)
        }

        if (HostManager.hostIsMingw) {
            this@setupTestExecution.commandLine(
                "cmd",
                "/c",
                buildString {
                    append(windowsQuote(command.executable))
                    append(' ')
                    append(runtimeArgs.joinToString(" ", transform = ::windowsQuote))
                },
            )
        } else if (HostManager.hostIsLinux) {
            // Force line-buffered stdout/stderr so CI shows progress in real time.
            // Godot block-buffers when piped, so on a timeout-kill the buffered tail
            // (where an exported run actually stalls) is otherwise lost.
            this@setupTestExecution.commandLine(
                "stdbuf", "-oL", "-eL", command.executable, *runtimeArgs.toTypedArray(),
            )
        } else {
            this@setupTestExecution.commandLine(command.executable, *runtimeArgs.toTypedArray())
        }
    }
}

fun windowsQuote(argument: String): String {
    if (!argument.contains(" ")) {
        return argument
    }
    return "\"$argument\""
}
