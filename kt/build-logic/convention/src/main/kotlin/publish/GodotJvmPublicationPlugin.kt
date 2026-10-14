package publish

import org.gradle.api.DomainObjectSet
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.artifacts.component.ProjectComponentIdentifier
import org.gradle.api.artifacts.result.ResolvedDependencyResult
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.AttributeContainer
import org.gradle.api.attributes.Bundling
import org.gradle.api.attributes.Category
import org.gradle.api.attributes.DocsType
import org.gradle.api.attributes.LibraryElements
import org.gradle.api.attributes.Usage
import org.gradle.api.attributes.java.TargetJvmEnvironment
import org.gradle.api.attributes.java.TargetJvmVersion
import org.gradle.api.component.AdhocComponentWithVariants
import org.gradle.api.component.SoftwareComponentFactory
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Provider
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.TaskProvider
import org.gradle.jvm.tasks.Jar
import java.io.File
import javax.inject.Inject

const val GODOT_JVM_ARTIFACT_ID = "godot-jvm"
val BUILD_TYPE_ATTRIBUTE: Attribute<String> = Attribute.of("com.utopia-rise.godot.build-type", String::class.java)

// Must match GODOT_ADDON_CATEGORY in the gradle plugin, which requests the addon with it.
const val GODOT_ADDON_CATEGORY = "godot-addon"

enum class GodotJvmModuleKind {
    /** Compiled once per build type, each build type with its own jar. */
    FLAVORED,

    /** One jar behind a debug and a release variant. */
    SHARED,

    /** Runs in the Gradle plugin, which has no build type: one jar and one variant. */
    TOOL,
}

class GodotJvmModule(
    val name: String,
    /** A project path such as `:godot-core-library`, or the name of an included build. */
    val source: String,
    val kind: GodotJvmModuleKind,
    /** Consumers add this module themselves, so the modules depending on it never publish that dependency. */
    val isOmittedFromDependents: Boolean,
) {
    val isIncludedBuild: Boolean
        get() = !source.startsWith(":")

    val projectName: String
        get() = source.substringAfterLast(':')

    val buildTypes: List<String?>
        get() = if (kind == GodotJvmModuleKind.TOOL) listOf(null) else listOf("debug", "release")
}

sealed interface PublishedDependency {
    data class Module(val module: GodotJvmModule, val buildType: String?) : PublishedDependency
    data class External(val group: String, val name: String, val version: String) : PublishedDependency
}

/** One jar of the publication: a module in one build type, or the single build of a tool module. */
class GodotJvmJar(
    val module: GodotJvmModule,
    val buildType: String?,
    val task: TaskProvider<Jar>,
    val apiDependencies: Provider<List<PublishedDependency>>,
    val runtimeDependencies: Provider<List<PublishedDependency>>,
)

abstract class GodotJvmPublicationExtension @Inject constructor(objects: ObjectFactory) {
    internal val modules: DomainObjectSet<GodotJvmModule> = objects.domainObjectSet(GodotJvmModule::class.java)
    internal val jars: DomainObjectSet<GodotJvmJar> = objects.domainObjectSet(GodotJvmJar::class.java)

    fun flavored(name: String, source: String, omitFromDependents: Boolean = false) {
        modules.add(GodotJvmModule(name, source, GodotJvmModuleKind.FLAVORED, omitFromDependents))
    }

    fun shared(name: String, source: String) {
        modules.add(GodotJvmModule(name, source, GodotJvmModuleKind.SHARED, false))
    }

    fun tool(name: String, source: String) {
        modules.add(GodotJvmModule(name, source, GodotJvmModuleKind.TOOL, false))
    }
}

/**
 * Publishes the declared modules as one GAV, `com.utopia-rise:godot-jvm`: one jar per module and build type, each
 * selected through its capability `com.utopia-rise:godot-jvm-<module>` and, outside tools, the build-type attribute.
 */
@Suppress("unused")
abstract class GodotJvmPublicationPlugin @Inject constructor(
    private val softwareComponentFactory: SoftwareComponentFactory,
) : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("maven-publish")
        val extension = target.extensions.create("godotJvm", GodotJvmPublicationExtension::class.java)
        val component = softwareComponentFactory.adhoc("godotJvm")
        target.components.add(component)

        extension.modules.all { module -> registerModule(target, extension, component, module) }

        registerDocumentation(target, component, DocsType.SOURCES, target.tasks.register("godotJvmSourcesJar", Jar::class.java) { jar ->
            jar.archiveBaseName.set(GODOT_JVM_ARTIFACT_ID)
            jar.archiveClassifier.set(DocsType.SOURCES)
            jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            jar.from(target.provider { extension.modules.map { module -> sourceDirectory(target, module) } })
        })
        registerDocumentation(target, component, DocsType.JAVADOC, target.tasks.register("godotJvmJavadocJar", Jar::class.java) { jar ->
            jar.archiveBaseName.set(GODOT_JVM_ARTIFACT_ID)
            jar.archiveClassifier.set(DocsType.JAVADOC)
        })

        target.providers.gradleProperty("godotJvmAddon").orNull?.let { path -> registerAddon(target, component, target.file(path)) }

        target.extensions.configure(PublishingExtension::class.java) { publishing ->
            publishing.publications.register("godotJvm", MavenPublication::class.java) { publication ->
                publication.artifactId = GODOT_JVM_ARTIFACT_ID
                publication.from(component)
                publication.suppressAllPomMetadataWarnings()
                publication.pom { pom ->
                    pom.name.set(GODOT_JVM_ARTIFACT_ID)
                    pom.description.set("Godot-JVM modules, one jar per module and build type, selected through Gradle capabilities.")
                }
            }
        }
    }

    private fun registerModule(
        project: Project,
        extension: GodotJvmPublicationExtension,
        component: AdhocComponentWithVariants,
        module: GodotJvmModule,
    ) {
        val apiDependencies = declaredDependencies(project, module, Usage.JAVA_API)
        val runtimeDependencies = declaredDependencies(project, module, Usage.JAVA_RUNTIME)
        val jarByBuildType = if (module.kind == GodotJvmModuleKind.FLAVORED) {
            mapOf("debug" to registerModuleJar(project, module, "debug"), "release" to registerModuleJar(project, module, "release"))
        } else {
            registerModuleJar(project, module, null).let { jar -> mapOf("debug" to jar, "release" to jar) }
        }

        for (buildType in module.buildTypes) {
            val pinnedBuildType = buildType ?: "release"
            val jar = GodotJvmJar(
                module = module,
                buildType = buildType,
                task = jarByBuildType.getValue(pinnedBuildType),
                apiDependencies = apiDependencies.map { list -> list.mapNotNull { publishedDependency(extension, it, pinnedBuildType) } },
                runtimeDependencies = runtimeDependencies.map { list -> list.mapNotNull { publishedDependency(extension, it, pinnedBuildType) } },
            )
            registerVariant(project, component, jar, Usage.JAVA_API, jar.apiDependencies)
            registerVariant(project, component, jar, Usage.JAVA_RUNTIME, jar.runtimeDependencies)
            extension.jars.add(jar)
        }
    }

    private fun registerVariant(
        project: Project,
        component: AdhocComponentWithVariants,
        jar: GodotJvmJar,
        usage: String,
        dependencies: Provider<List<PublishedDependency>>,
    ) {
        val name = variantName(listOfNotNull(jar.module.name, jar.buildType, usage).joinToString("-"))
        val variantDependencies = project.configurations.dependencyScope("godotJvm${name}Dependencies") { configuration ->
            configuration.dependencies.addAllLater(dependencies.map { list -> list.map { capabilityDependency(project, it) } })
        }
        val elements = project.configurations.consumable("godotJvm${name}Elements") { configuration ->
            configuration.extendsFrom(variantDependencies.get())
            jvmLibrary(project, configuration.attributes, usage)
            jar.buildType?.let { configuration.attributes.attribute(BUILD_TYPE_ATTRIBUTE, it) }
            configuration.outgoing.artifact(jar.task)
            configuration.outgoing.capability("${project.group}:$GODOT_JVM_ARTIFACT_ID-${jar.module.name}:${project.version}")
        }
        component.addVariantsFromConfiguration(elements.get()) { details ->
            details.mapToMavenScope(if (usage == Usage.JAVA_API) "compile" else "runtime")
            details.mapToOptional()
        }
    }

    /** A module of the publication becomes a capability dependency on `godot-jvm` itself. */
    private fun capabilityDependency(project: Project, dependency: PublishedDependency): Dependency =
        when (dependency) {
            is PublishedDependency.External -> project.dependencies.create("${dependency.group}:${dependency.name}:${dependency.version}")
            is PublishedDependency.Module -> (project.dependencies.project(mapOf("path" to project.path)) as ProjectDependency).apply {
                capabilities { it.requireCapability("${project.group}:$GODOT_JVM_ARTIFACT_ID-${dependency.module.name}") }
                dependency.buildType?.let { buildType -> attributes { it.attribute(BUILD_TYPE_ATTRIBUTE, buildType) } }
            }
        }

    /** Dependencies between modules stay in [buildType], except on tools, which have none. */
    private fun publishedDependency(
        extension: GodotJvmPublicationExtension,
        dependency: ResolvedDependencyResult,
        buildType: String,
    ): PublishedDependency? =
        when (val id = dependency.selected.id) {
            is ModuleComponentIdentifier -> PublishedDependency.External(id.group, id.module, id.version)
            is ProjectComponentIdentifier -> extension.modules.single { module -> module.projectName == id.projectName }
                .takeUnless { module -> module.isOmittedFromDependents }
                ?.let { module -> PublishedDependency.Module(module, buildType.takeUnless { module.kind == GodotJvmModuleKind.TOOL }) }
            else -> null
        }

    /** The module's own direct dependencies, as resolved for [usage], with included builds substituted. */
    private fun declaredDependencies(project: Project, module: GodotJvmModule, usage: String): Provider<List<ResolvedDependencyResult>> {
        val name = "godotJvm${variantName(module.name)}${variantName(usage)}Declared"
        val declaration = project.configurations.dependencyScope("${name}Module") { configuration ->
            configuration.dependencies.add(moduleDependency(project, module, null))
        }
        return project.configurations.resolvable(name) { configuration ->
            configuration.extendsFrom(declaration.get())
            jvmLibrary(project, configuration.attributes, usage)
        }.map { graph ->
            graph.incoming.resolutionResult.root.dependencies
                .filterIsInstance<ResolvedDependencyResult>()
                .single()
                .selected
                .dependencies
                .filterIsInstance<ResolvedDependencyResult>()
        }
    }

    // Repackaged rather than published as built: the tool jars carry Gradle plugin descriptors that must not reach the
    // plugin classpath of user projects.
    private fun registerModuleJar(project: Project, module: GodotJvmModule, buildType: String?): TaskProvider<Jar> {
        val classifier = listOfNotNull(module.name, buildType).joinToString("-")
        val name = variantName(classifier)
        val declaration = project.configurations.dependencyScope("godotJvm${name}ModuleJar") { configuration ->
            configuration.dependencies.add(moduleDependency(project, module, if (buildType == "release") "releaseElements" else "runtimeElements"))
        }
        val moduleJar = project.configurations.resolvable("godotJvm${name}ModuleJarFile") { configuration ->
            configuration.extendsFrom(declaration.get())
            configuration.isTransitive = false
            jvmLibrary(project, configuration.attributes, Usage.JAVA_RUNTIME)
        }
        return project.tasks.register("godotJvm${name}Jar", Jar::class.java) { jar ->
            jar.archiveBaseName.set(GODOT_JVM_ARTIFACT_ID)
            jar.archiveClassifier.set(classifier)
            jar.from(moduleJar.flatMap { it.elements }.map { jars -> jars.map { jarFile -> project.zipTree(jarFile) } })
            jar.exclude("META-INF/gradle-plugins/**")
        }
    }

    /**
     * The Godot addon zip, `addons/jvm` with the native libraries of every platform. Only a release has all of them, so
     * it is published only when the `godotJvmAddon` Gradle property points at the zip the release built.
     */
    private fun registerAddon(project: Project, component: AdhocComponentWithVariants, archive: File) {
        val elements = project.configurations.consumable("godotJvmAddonElements") { configuration ->
            configuration.attributes.attribute(Category.CATEGORY_ATTRIBUTE, project.objects.named(Category::class.java, GODOT_ADDON_CATEGORY))
            configuration.outgoing.artifact(archive) { artifact ->
                artifact.classifier = "addon"
                artifact.extension = "zip"
                artifact.type = "zip"
            }
            configuration.outgoing.capability("${project.group}:$GODOT_JVM_ARTIFACT_ID-addon:${project.version}")
        }
        component.addVariantsFromConfiguration(elements.get()) { details ->
            details.mapToMavenScope("runtime")
            details.mapToOptional()
        }
    }

    private fun registerDocumentation(project: Project, component: AdhocComponentWithVariants, docsType: String, jar: TaskProvider<Jar>) {
        val elements = project.configurations.consumable("godotJvm${variantName(docsType)}Elements") { configuration ->
            configuration.attributes.attribute(Usage.USAGE_ATTRIBUTE, project.objects.named(Usage::class.java, Usage.JAVA_RUNTIME))
            configuration.attributes.attribute(Category.CATEGORY_ATTRIBUTE, project.objects.named(Category::class.java, Category.DOCUMENTATION))
            configuration.attributes.attribute(Bundling.BUNDLING_ATTRIBUTE, project.objects.named(Bundling::class.java, Bundling.EXTERNAL))
            configuration.attributes.attribute(DocsType.DOCS_TYPE_ATTRIBUTE, project.objects.named(DocsType::class.java, docsType))
            configuration.outgoing.artifact(jar)
        }
        component.addVariantsFromConfiguration(elements.get()) { details ->
            details.mapToMavenScope("runtime")
            details.mapToOptional()
        }
    }

    private fun moduleDependency(project: Project, module: GodotJvmModule, configuration: String?): Dependency =
        if (module.isIncludedBuild) {
            project.dependencies.create("${project.group}:${module.projectName}:${project.version}")
        } else {
            project.dependencies.project(mapOf("path" to module.source, "configuration" to configuration))
        }

    private fun sourceDirectory(project: Project, module: GodotJvmModule): File {
        val moduleDirectory = if (module.isIncludedBuild) project.gradle.includedBuild(module.source).projectDir else project.project(module.source).projectDir
        return moduleDirectory.resolve("src/main/kotlin")
    }

    private fun jvmLibrary(project: Project, attributes: AttributeContainer, usage: String) {
        val jvmVersion = project.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
            .findVersion("toolchain-jvm").get().requiredVersion.toInt()
        attributes.attribute(Usage.USAGE_ATTRIBUTE, project.objects.named(Usage::class.java, usage))
        attributes.attribute(Category.CATEGORY_ATTRIBUTE, project.objects.named(Category::class.java, Category.LIBRARY))
        attributes.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, project.objects.named(LibraryElements::class.java, LibraryElements.JAR))
        attributes.attribute(Bundling.BUNDLING_ATTRIBUTE, project.objects.named(Bundling::class.java, Bundling.EXTERNAL))
        attributes.attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, project.objects.named(TargetJvmEnvironment::class.java, TargetJvmEnvironment.STANDARD_JVM))
        attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, jvmVersion)
    }
}

fun variantName(name: String): String = name.split("-").joinToString("") { it.replaceFirstChar(Char::uppercase) }
