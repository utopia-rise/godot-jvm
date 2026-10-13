import versioninfo.fullBuildVersion
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

plugins {
    // prevents the kotlin plugin being applied multiple times (once per subproject) as this is not supported. Done as suggested by the kotlin plugin
    alias(libs.plugins.kotlin.jvm) apply false
    base
    `jvm-ecosystem`
    id("com.utopia-rise.versioninfo")
    id("com.utopia-rise.maven-central")
    id("com.utopia-rise.api-generator")
    alias(libs.plugins.gradleIntelliJPlugin) apply false
    alias(libs.plugins.ideaSync) apply false
}

group = "com.utopia-rise"
version = fullBuildVersion

val versionString = project.version.toString()

subprojects {
    group = "com.utopia-rise"
    version = versionString

    if (path != ":godot-intellij-plugin") {
        pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
            dependencies.add("implementation", dependencies.kotlin("stdlib"))
        }
    }
}

apiGenerator {
    sourceJson.set(project.file("$rootDir/api-generator/src/main/resources/api.json"))
    coreOutputDir.set(project.file("$rootDir/godot-library/godot-core-library/src/main/kotlin/gen"))
    apiOutputDir.set(project.file("$rootDir/godot-library/godot-api-library/src/main/kotlin/"))
    extensionOutputDir.set(project.file("$rootDir/godot-library/godot-extension-library/src/main/kotlin/gen"))
    coroutineOutputDir.set(project.file("$rootDir/godot-library/godot-coroutine-library/src/main/kotlin/gen"))
}

interface Services {
    @get:Inject
    val softwareComponentFactory: SoftwareComponentFactory
}

val buildTypeAttribute = Attribute.of("com.utopia-rise.godot.build-type", String::class.java)
val godotLibrary = objects.newInstance<Services>().softwareComponentFactory.adhoc("godotLibrary")
components.add(godotLibrary)

data class GodotModule(
    val projectName: String,
    val capability: String,
    val flavored: Boolean,
    val tool: Boolean,
    val includedBuild: Boolean,
    val sourceDirectory: String,
)

val godotModules = listOf(
    GodotModule("common", "common", flavored = false, tool = false, includedBuild = true, sourceDirectory = "common"),
    GodotModule("godot-internal-library", "internal", flavored = true, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-internal-library"),
    GodotModule("godot-core-library", "core", flavored = true, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-core-library"),
    GodotModule("godot-api-library", "api", flavored = true, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-api-library"),
    GodotModule("godot-extension-library", "extension", flavored = false, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-extension-library"),
    GodotModule("godot-bootstrap-library", "bootstrap", flavored = false, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-bootstrap-library"),
    GodotModule("godot-coroutine-library", "coroutine", flavored = false, tool = false, includedBuild = false, sourceDirectory = "godot-library/godot-coroutine-library"),
    GodotModule("tools-common", "tools-common", flavored = false, tool = true, includedBuild = true, sourceDirectory = "tools-common"),
    GodotModule("api-generator", "api-generator", flavored = false, tool = true, includedBuild = true, sourceDirectory = "api-generator"),
    GodotModule("godot-class-graph-symbol-processor", "class-graph-symbol-processor", flavored = false, tool = true, includedBuild = false, sourceDirectory = "godot-registration/godot-class-graph-symbol-processor"),
    GodotModule("godot-registration-model", "registration-model", flavored = false, tool = true, includedBuild = false, sourceDirectory = "godot-registration/godot-registration-model"),
    GodotModule("godot-registrar-generator", "registrar-generator", flavored = false, tool = true, includedBuild = false, sourceDirectory = "godot-registration/godot-registrar-generator"),
)
val godotModulesByProjectName = godotModules.associateBy { it.projectName }

fun AttributeContainer.jvmLibrary(usage: String) {
    attribute(Usage.USAGE_ATTRIBUTE, objects.named(usage))
    attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))
    attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
    attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
    attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.STANDARD_JVM))
    attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, libs.versions.toolchain.jvm.get().toInt())
}

fun moduleDependency(module: GodotModule, projectConfiguration: String?): Dependency =
    if (module.includedBuild) {
        project.dependencies.create("com.utopia-rise:${module.projectName}:$fullBuildVersion")
    } else {
        project.dependencies.project(mapOf("path" to ":${module.projectName}", "configuration" to projectConfiguration))
    }

fun String.toVariantName() = split("-").joinToString("") { it.replaceFirstChar(Char::uppercase) }

fun declaredDependencies(module: GodotModule, usage: String): Provider<List<ResolvedDependencyResult>> {
    val name = "godotLibrary${module.capability.toVariantName()}${usage.toVariantName()}Declared"
    val declaration = configurations.dependencyScope("${name}Module") {
        dependencies.add(moduleDependency(module, null))
    }
    return configurations.resolvable(name) {
        extendsFrom(declaration.get())
        attributes.jvmLibrary(usage)
    }.map { graph ->
        graph.incoming.resolutionResult.root.dependencies
            .filterIsInstance<ResolvedDependencyResult>()
            .single()
            .selected
            .dependencies
            .filterIsInstance<ResolvedDependencyResult>()
    }
}

fun capabilityDependency(target: GodotModule, buildType: String): Dependency =
    (project.dependencies.project(":") as ProjectDependency).apply {
        capabilities { requireCapability("com.utopia-rise:godot-library-${target.capability}") }
        if (!target.tool) {
            attributes { attribute(buildTypeAttribute, buildType) }
        }
    }

fun publishedDependency(dependency: ResolvedDependencyResult, buildType: String): Dependency? =
    when (val id = dependency.selected.id) {
        is ModuleComponentIdentifier -> project.dependencies.create("${id.group}:${id.module}:${id.version}")
        is ProjectComponentIdentifier -> godotModulesByProjectName.getValue(id.projectName)
            .takeIf { target -> target.capability != "api" }
            ?.let { target -> capabilityDependency(target, buildType) }
        else -> null
    }

fun registerModuleJar(module: GodotModule, buildType: String?): TaskProvider<Jar> {
    val classifier = listOfNotNull(module.capability, buildType).joinToString("-")
    val name = classifier.toVariantName()
    val declaration = configurations.dependencyScope("godotLibrary${name}ModuleJar") {
        dependencies.add(moduleDependency(module, if (buildType == "release") "releaseElements" else "runtimeElements"))
    }
    val moduleJar = configurations.resolvable("godotLibrary${name}ModuleJarFile") {
        extendsFrom(declaration.get())
        isTransitive = false
        attributes.jvmLibrary(Usage.JAVA_RUNTIME)
    }
    return tasks.register<Jar>("godotLibrary${name}Jar") {
        archiveBaseName.set("godot-library")
        archiveClassifier.set(classifier)
        from(moduleJar.flatMap { it.elements }.map { jars -> jars.map { jarFile -> zipTree(jarFile) } })
        exclude("META-INF/gradle-plugins/**")
    }
}

for (module in godotModules) {
    val declaredByUsage = listOf(Usage.JAVA_API, Usage.JAVA_RUNTIME).associateWith { usage -> declaredDependencies(module, usage) }
    val jarByBuildType = if (module.flavored) {
        mapOf("debug" to registerModuleJar(module, "debug"), "release" to registerModuleJar(module, "release"))
    } else {
        registerModuleJar(module, null).let { jar -> mapOf("debug" to jar, "release" to jar) }
    }
    val buildTypes = if (module.tool) listOf(null) else listOf("debug", "release")

    for (buildType in buildTypes) {
        val variantName = listOfNotNull(module.capability, buildType).joinToString("-").toVariantName()
        val jar = jarByBuildType.getValue(buildType ?: "release")

        for ((usage, declared) in declaredByUsage) {
            val usageName = usage.toVariantName()
            val variantDependencies = configurations.dependencyScope("godotLibrary${variantName}${usageName}Dependencies") {
                dependencies.addAllLater(declared.map { list -> list.mapNotNull { dependency -> publishedDependency(dependency, buildType ?: "release") } })
            }
            val elements = configurations.consumable("godotLibrary${variantName}${usageName}Elements") {
                extendsFrom(variantDependencies.get())
                attributes.jvmLibrary(usage)
                if (buildType != null) {
                    attributes.attribute(buildTypeAttribute, buildType)
                }
                outgoing.artifact(jar)
                outgoing.capability("com.utopia-rise:godot-library-${module.capability}:$version")
            }
            godotLibrary.addVariantsFromConfiguration(elements.get()) {
                mapToMavenScope(if (usage == Usage.JAVA_API) "compile" else "runtime")
                mapToOptional()
            }
        }
    }
}

fun registerDocumentation(docsType: String, jar: TaskProvider<Jar>) {
    val elements = configurations.consumable("godotLibrary${docsType.replaceFirstChar(Char::uppercase)}Elements") {
        attributes {
            attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
            attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
            attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named(docsType))
        }
        outgoing.artifact(jar)
    }
    godotLibrary.addVariantsFromConfiguration(elements.get()) {
        mapToMavenScope("runtime")
        mapToOptional()
    }
}

registerDocumentation(DocsType.SOURCES, tasks.register<Jar>("godotLibrarySourcesJar") {
    dependsOn(tasks.generateAPI)
    archiveBaseName.set("godot-library")
    archiveClassifier.set(DocsType.SOURCES)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    godotModules.forEach { module -> from("$rootDir/${module.sourceDirectory}/src/main/kotlin") }
})
registerDocumentation(DocsType.JAVADOC, tasks.register<Jar>("godotLibraryJavadocJar") {
    archiveBaseName.set("godot-library")
    archiveClassifier.set(DocsType.JAVADOC)
})

publishing {
    publications {
        register<MavenPublication>("godotLibrary") {
            artifactId = "godot-library"
            from(godotLibrary)
            suppressAllPomMetadataWarnings()
            pom {
                name.set("godot-library")
                description.set("Godot-JVM modules, one jar per module and build type, selected through Gradle capabilities.")
            }
        }
    }
}

tasks {
    @Suppress("UNUSED_VARIABLE")
    val publishArtifactsToMavenLocal by registering {
        group = "publishing"
        description = "Publishes all artifacts needed to consume Godot-JVM from mavenLocal."
        dependsOn(":publishToMavenLocal", ":godot-gradle-plugin:publishToMavenLocal")
    }

    @Suppress("UNUSED_VARIABLE")
    val publishArtifacts by registering {
        group = "publishing"
        description = "Publishes godot-library and the Gradle plugin to Maven Central, snapshots included, and plugin releases to the Gradle Plugin Portal."
        dependsOn(":publish", ":godot-gradle-plugin:publish")
        if (!versionString.endsWith("-SNAPSHOT")) {
            dependsOn(":godot-gradle-plugin:publishPlugins")
        }
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
