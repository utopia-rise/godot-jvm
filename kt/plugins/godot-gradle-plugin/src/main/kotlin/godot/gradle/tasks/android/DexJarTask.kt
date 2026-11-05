package godot.gradle.tasks.android

import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

abstract class DexJarTask : D8Task() {
    @get:InputFile
    abstract val inputJar: RegularFileProperty

    // ART cannot load plain jars, so split dependencies are dexed together with the program jar.
    @get:InputFiles
    abstract val additionalInputJars: ConfigurableFileCollection

    @get:OutputFile
    abstract val dexJar: RegularFileProperty

    @TaskAction
    fun createDexJar() {
        val inputJarFile = inputJar.get().asFile
        val workingDirectory = inputJarFile.parentFile
        val dexOutputJar = dexJar.get().asFile
        val dexOutputDirectory = workingDirectory.resolve(dexOutputJar.nameWithoutExtension)

        dexOutputDirectory.deleteRecursively()
        dexOutputDirectory.mkdirs()

        val inputJars = listOf(inputJarFile) + additionalInputJars.files.sortedBy(File::getName)
        runD8(
            inputJars.map(File::getAbsolutePath),
            dexOutputDirectory,
            temporaryDir.resolve("main-dex-rules.proguard"),
            workingDirectory,
            dexOutputJar.name,
        )

        dexOutputJar.delete()
        ZipOutputStream(FileOutputStream(dexOutputJar)).use { zipOutput ->
            dexOutputDirectory.walkTopDown()
                .filter(File::isFile)
                .forEach { file ->
                    val entryName = file.relativeTo(dexOutputDirectory).invariantSeparatorsPath
                    zipOutput.putNextEntry(ZipEntry(entryName))
                    file.inputStream().use { it.copyTo(zipOutput) }
                    zipOutput.closeEntry()
                }

            val writtenEntries = mutableSetOf<String>()
            inputJars.forEach { inputJar ->
                ZipFile(inputJar).use { input ->
                    input.entries().asSequence()
                        .filter { entry ->
                            !entry.isDirectory &&
                                !entry.name.endsWith(".class") &&
                                entry.name != "META-INF/MANIFEST.MF" &&
                                writtenEntries.add(entry.name)
                        }
                        .forEach { entry ->
                            zipOutput.putNextEntry(ZipEntry(entry.name))
                            input.getInputStream(entry).use { it.copyTo(zipOutput) }
                            zipOutput.closeEntry()
                        }
                }
            }
        }
        dexOutputDirectory.deleteRecursively()
    }
}
