import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Properties
import java.util.concurrent.TimeUnit
import kotlin.math.abs

plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

// Godot reports failures as error lines on stdout and keeps running, so a task has to read them. Only lines printed
// before the result marker count: Godot's own shutdown prints RID and ObjectDB leaks of its servers.
val failurePatterns = listOf(
    Regex("^ERROR: "), Regex("^SCRIPT ERROR: "), Regex("^USER ERROR: "), Regex("Error calling JVM"),
)
val resultMarker = "BULLETMARK_RESULT:"

// What a snapshot holds: everything Godot reads when it runs the project, and nothing it rebuilds.
val snapshotEntries = listOf(
    ".godot", "addons", "jvm", "src", "cs", "gd", "runner", "project.godot", "godot_jvm_configuration.json", "Bulletmark.csproj",
)
val abDirectory: File = layout.buildDirectory.dir("ab").get().asFile

/**
 * The Godot 4 editor to run: GODOT_EDITOR when set, otherwise the standard macOS install or a godot command on the
 * PATH. A C# run needs the .NET build of the editor instead, found the same way through GODOT_EDITOR_MONO. The error
 * says how to point at it when none is found.
 */
fun editorExecutable(dotnet: Boolean = false): File {
    val variable = if (dotnet) "GODOT_EDITOR_MONO" else "GODOT_EDITOR"
    System.getenv(variable)?.let { path ->
        return File(path).takeIf(File::isFile) ?: error("$variable points at $path, which is not a file.")
    }
    val standard = if (dotnet) "/Applications/Godot_mono.app/Contents/MacOS/Godot" else "/Applications/Godot.app/Contents/MacOS/Godot"
    val names = if (dotnet) listOf("godot-mono", "godot_mono", "godot-mono.exe") else listOf("godot", "godot4", "godot.exe")
    val onPath = System.getenv("PATH").orEmpty().split(File.pathSeparator).flatMap { directory ->
        names.map { File(directory, it) }
    }
    val build = if (dotnet) "the .NET build of the Godot 4 editor" else "the Godot 4 editor"
    return (listOf(File(standard)) + onPath).firstOrNull(File::isFile) ?: error(
        "Godot was not found. Set $variable to $build, for example:\n" +
            "  macOS:   export $variable=$standard\n" +
            "  Linux:   export $variable=/path/to/Godot_v4.7.2-stable${if (dotnet) "_mono" else ""}_linux.x86_64\n" +
            "  Windows: set $variable=C:\\path\\to\\Godot_v4.7.2-stable${if (dotnet) "_mono" else ""}_win64.exe"
    )
}

// The dotnet command that builds the C# scripts: on the PATH, or where Microsoft's install script puts it.
fun dotnetExecutable(): File =
    (System.getenv("PATH").orEmpty().split(File.pathSeparator).map { File(it, "dotnet") } +
        File(System.getProperty("user.home"), ".dotnet/dotnet")).firstOrNull(File::isFile)
        ?: error("dotnet was not found: install the .NET 8 SDK to build the C# scripts.")

// The newest file under these directories, in milliseconds since the epoch, or 0 when none exists.
fun newestModification(directories: List<File>, skip: (File) -> Boolean = { false }): Long = directories
    .filter(File::isDirectory)
    .flatMap { directory -> directory.walk().filter { it.isFile && !skip(it) }.toList() }
    .maxOfOrNull(File::lastModified) ?: 0L

// Sources the API generator writes. Gradle can rewrite them unchanged on any build that includes the libraries, so their
// dates say nothing; the generator's own sources stand in for them.
fun isGeneratedSource(file: File): Boolean = file.invariantSeparatorsPath.let {
    "/godot-api-library/src/main/" in it || "/src/main/kotlin/gen/" in it
}

fun gitCommit(): String {
    val process = ProcessBuilder("git", "rev-parse", "--short", "HEAD").redirectErrorStream(true).start()
    val output = process.inputStream.bufferedReader().readText().trim()
    return if (process.waitFor() == 0 && output.isNotEmpty()) output else "unknown"
}

/**
 * Fails when the project's jars or native library are older than the sources they are built from, so neither a run
 * nor a snapshot can measure the previous build by accident.
 */
fun checkBuildIsFresh(projectDirectory: File) {
    val repository = projectDirectory.resolve("../..")
    val jars = listOf("usercode.jar", "godot-bootstrap.jar").map { projectDirectory.resolve("jvm/debug/$it") }
    check(jars.all(File::isFile)) { "No jars to run: run importResources first." }
    val kotlinSources = listOf(projectDirectory.resolve("src/main/kotlin"), repository.resolve("kt/api-generator/src/main")) +
        repository.resolve("kt/godot-library").listFiles().orEmpty().map { it.resolve("src/main") }
    check(newestModification(kotlinSources, ::isGeneratedSource) <= jars.minOf(File::lastModified)) {
        "Kotlin sources changed since the jars were built: run importResources first."
    }
    val nativeLibrary = newestModification(listOf(projectDirectory.resolve("addons/jvm/libs")))
    check(nativeLibrary > 0L) { "No native library in addons/jvm: build it into harness/tests, then run importResources." }
    check(newestModification(listOf(repository.resolve("cpp"))) <= nativeLibrary) {
        "C++ sources changed since the native library was built: run scons, then importResources."
    }
}

/**
 * Runs the project in [projectDirectory] with the runner [arguments], echoing its output to the console and [logFile].
 * Fails on a non-zero exit or on any engine error printed before the result.
 *
 * A measured run uses [fixedFps]: every frame then advances the game by exactly 1/60 s however long it takes to compute,
 * so every run simulates the same game whatever the machine. [headless] also keeps the rendering out of the frame time.
 * A run to watch drops both, to play in a window in real time.
 */
fun runGodot(
    projectDirectory: File,
    arguments: List<String>,
    logFile: File,
    javaHome: String,
    headless: Boolean,
    fixedFps: Boolean = true,
    dotnet: Boolean = false,
) {
    val command = listOf(editorExecutable(dotnet).absolutePath) +
        (if (headless) listOf("--headless") else emptyList()) +
        (if (fixedFps) listOf("--fixed-fps", "60") else emptyList()) +
        listOf("--path", projectDirectory.absolutePath, "--") +
        arguments
    println(command.joinToString(" "))

    val process = ProcessBuilder(command)
        .directory(projectDirectory)
        .redirectErrorStream(true)
        .apply {
            environment()["JAVA_HOME"] = javaHome
            // The .NET editor finds its runtime through the dotnet command, so the run does not depend on the caller's PATH.
            if (dotnet) environment()["PATH"] = dotnetExecutable().parent + File.pathSeparator + System.getenv("PATH").orEmpty()
        }
        .start()
    logFile.parentFile.mkdirs()
    val offending = mutableListOf<String>()
    var running = true
    var passed = false
    logFile.bufferedWriter().use { log ->
        process.inputStream.bufferedReader().forEachLine { line ->
            println(line)
            log.write(line)
            log.newLine()
            log.flush()
            if (running && failurePatterns.any { it.containsMatchIn(line) }) offending.add(line)
            if (line.startsWith(resultMarker)) {
                running = false
                passed = line == "${resultMarker}PASS"
            }
        }
    }
    val exitCode = process.waitFor()
    check(offending.isEmpty()) {
        "Godot reported ${offending.size} error line(s) during the run:\n" + offending.joinToString("\n")
    }
    // The .NET editor also loads the JVM extension, and with both runtimes in the process Godot 4.7.2 crashes while
    // quitting, after the runner has written its results; the crash does not depend on the scene's language.
    if (dotnet && exitCode != 0 && passed) {
        println("The .NET editor exited with code $exitCode after the run passed: its known crash on quit, ignored.")
        return
    }
    check(exitCode == 0) { "The bulletmark runner exited with code $exitCode, see the summary above." }
}

// The runner's options, each passed to a task as a Gradle property of the same name: -Pframes=600 for --frames=600, and
// -Praw-samples with no value for the --raw-samples flag.
val runnerOptions = listOf(
    "label", "frames", "warmup-frames", "seed", "bullets-per-frame", "lifetime-frames", "max-live", "render", "hits",
    "reactions", "bookkeeping", "baseline", "results-dir", "raw-samples", "screenshots", "lang",
)

fun Project.runnerArguments(): List<String> = runnerOptions.mapNotNull { name ->
    findProperty(name)?.toString()?.let { value -> if (value.isEmpty()) "--$name" else "--$name=$value" }
}

tasks {
    // A plain copy rather than a Sync task: the registration tasks scan the project directory, and a declared output
    // inside it would make Gradle demand a dependency between them.
    val syncAddon = register("syncAddon") {
        group = "verification"
        description = "Copies the GDExtension addon built into harness/tests, so the native library is built once."
        val source = projectDir.resolve("../tests/addons/jvm").toPath()
        val target = projectDir.resolve("addons/jvm").toPath()
        doLast {
            target.toFile().deleteRecursively()
            Files.walk(source).forEach { path ->
                val destination = target.resolve(source.relativize(path))
                if (Files.isDirectory(path)) Files.createDirectories(destination)
                else Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    register("importResources") {
        group = "verification"
        description = "Imports the Godot project after rebuilding the JVM registrations. Run it after every Kotlin change."
        dependsOn(build, syncAddon)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir

        doLast {
            val logFile = layout.buildDirectory.file("import-resources.log").get().asFile
            logFile.parentFile.mkdirs()
            val process = ProcessBuilder(editorExecutable().absolutePath, "--headless", "--import")
                .directory(workingDirectory)
                .redirectErrorStream(true)
                .redirectOutput(logFile)
                .apply { environment()["JAVA_HOME"] = javaHome }
                .start()
            // Godot sometimes never exits once the import is done; the imported files are already on disk by then.
            if (!process.waitFor(5, TimeUnit.MINUTES)) {
                process.destroyForcibly()
                process.waitFor(1, TimeUnit.MINUTES)
            }
            println(logFile.readText())
            check(workingDirectory.resolve(".godot/global_script_class_cache.cfg").isFile) {
                "Godot did not finish importing the project."
            }
        }
    }

    val buildCSharp = register<Exec>("buildCSharp") {
        group = "verification"
        description = "Builds the C# scripts the .NET editor runs with -Plang=cs."
        workingDir = projectDir
        doFirst { commandLine(dotnetExecutable().absolutePath, "build", "Bulletmark.csproj", "-nologo", "-v", "quiet") }
    }

    // The language a task runs: -Plang=kt (the default), cs or gd. A C# run needs the .NET editor and its scripts built.
    val dotnet = findProperty("lang") == "cs"

    register("runBulletmark") {
        group = "verification"
        description = "Measures bulletmark at a fixed 60 fps of game time, in a window; -Pheadless measures without one. " +
            "Requires importResources first. Runner options are Gradle properties, for example -Plabel=base -Prender=draw."
        dependsOn(syncAddon)
        if (dotnet) dependsOn(buildCSharp)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir
        val arguments = project.runnerArguments()
        val headless = findProperty("headless") != null
        val logFile = layout.buildDirectory.file("bulletmark.log").get().asFile

        doLast {
            checkBuildIsFresh(workingDirectory)
            runGodot(
                workingDirectory, listOf("--commit=${gitCommit()}") + arguments, logFile, javaHome,
                headless = headless, dotnet = dotnet,
            )
        }
    }

    register("watchBulletmark") {
        group = "verification"
        description = "Opens bulletmark in a window to watch, in real time, for a minute; not a measurement, since each " +
            "frame advances the game by however long it took. Takes the same options as runBulletmark."
        dependsOn(syncAddon)
        if (dotnet) dependsOn(buildCSharp)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir
        // Later options win in the runner, so these defaults give way to any the command passes.
        val arguments = listOf("--label=watch", "--warmup-frames=0", "--frames=3600") + project.runnerArguments()
        val logFile = layout.buildDirectory.file("watch.log").get().asFile

        doLast {
            checkBuildIsFresh(workingDirectory)
            runGodot(
                workingDirectory, listOf("--commit=${gitCommit()}") + arguments, logFile, javaHome,
                headless = false, fixedFps = false, dotnet = dotnet,
            )
        }
    }

    register("snapshotBuild") {
        group = "verification"
        description = "Freezes the current build of the project into build/ab/<name> for abBulletmark. " +
            "Pass -Psnapshot=<name>. Requires the native library and importResources to be current."
        val workingDirectory = projectDir
        val name = findProperty("snapshot") as String?

        doLast {
            check(!name.isNullOrBlank()) { "Name the snapshot with -Psnapshot=<name>." }
            checkBuildIsFresh(workingDirectory)
            val target = abDirectory.resolve(name)
            target.deleteRecursively()
            for (entry in snapshotEntries) {
                val source = workingDirectory.resolve(entry)
                if (source.isDirectory) source.copyRecursively(target.resolve(entry))
                else source.copyTo(target.resolve(entry))
            }
            val metadata = Properties()
            metadata["name"] = name
            metadata["commit"] = gitCommit()
            metadata["created"] = LocalDateTime.now().toString()
            target.resolve("snapshot.properties").writer().use { metadata.store(it, null) }
            println("Snapshot $name of ${metadata["commit"]} written to $target")
        }
    }

    register("abBulletmark") {
        group = "verification"
        description = "Runs two snapshots interleaved and reports whether B is faster, slower or no different from A. " +
            "Pass -Pa=<snapshot> -Pb=<snapshot>; optional -Pheadless (recommended), -Prounds=5, -Pthreshold=2 (percent), " +
            "runner options for both sides such as -Prender=draw, and -Prejudge=<results folder> to judge again."
        val javaHome = System.getProperty("java.home")
        val names = listOf(findProperty("a") as String?, findProperty("b") as String?)
        val rounds = (findProperty("rounds") as String?)?.toInt() ?: 5
        val thresholdPercent = (findProperty("threshold") as String?)?.toDouble() ?: 2.0
        // The A/B names each run itself, so a label passed on the command line would only collide with those.
        val arguments = project.runnerArguments().filterNot { it.startsWith("--label=") }
        val earlierResults = findProperty("rejudge") as String?
        val headless = findProperty("headless") != null

        doLast {
            check(names.none { it.isNullOrBlank() }) { "Name both snapshots with -Pa=<snapshot> and -Pb=<snapshot>." }
            val (nameA, nameB) = names.map { it!! }
            val sides = listOf(nameA, nameB).associateWith { abDirectory.resolve(it) }
            for ((name, directory) in sides) {
                check(directory.resolve("snapshot.properties").isFile) { "No snapshot $name: run snapshotBuild first." }
            }
            val commits = sides.mapValues { (_, directory) ->
                Properties().also { p -> directory.resolve("snapshot.properties").reader().use(p::load) }["commit"] as String
            }

            val stamp = earlierResults ?: LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"))
            val results = abDirectory.resolve("results/$stamp")
            // ABBA order: each build runs first in half the rounds, so neither is always measured on a machine the other
            // has just warmed up or left busy.
            val order = (1..rounds).flatMap { round ->
                if (round % 2 == 1) listOf(nameA to round, nameB to round) else listOf(nameB to round, nameA to round)
            }
            for ((name, round) in if (earlierResults == null) order else emptyList()) {
                runGodot(
                    sides.getValue(name),
                    listOf("--commit=${commits.getValue(name)}", "--label=${name}_$round", "--results-dir=${results.absolutePath}") +
                        arguments,
                    results.resolve("${name}_$round.log"),
                    javaHome,
                    headless = headless,
                    dotnet = dotnet,
                )
            }

            @Suppress("UNCHECKED_CAST")
            val reports = listOf(nameA, nameB).associateWith { name ->
                generateSequence(1) { it + 1 }
                    .map { round -> results.resolve("${name}_$round.json") }
                    .takeWhile(File::isFile)
                    .map { JsonSlurper().parse(it) as Map<String, Any?> }
                    .toList()
            }
            check(reports.values.map { it.size }.distinct().size == 1 && reports.getValue(nameA).isNotEmpty()) {
                "Both sides need the same number of reports in $results."
            }
            val verdict = abVerdict(nameA, nameB, commits, reports, thresholdPercent)
            results.resolve("verdict.json").writeText(JsonOutput.prettyPrint(JsonOutput.toJson(verdict)))
            println(verdict["summary"])
            println("Reports and verdict written to $results")
            check(verdict["comparable"] == true) { "The two builds did not play the same game; see the verdict above." }
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun Map<String, Any?>.section(name: String): Map<String, Any?> = this[name] as Map<String, Any?>? ?: emptyMap()

fun median(values: List<Double>): Double {
    val sorted = values.sorted()
    val middle = sorted.size / 2
    return if (sorted.size % 2 == 1) sorted[middle] else (sorted[middle - 1] + sorted[middle]) / 2
}

/**
 * The verdict of an A/B. Runs are compared in pairs: the two runs of a round ran back to back on the same machine
 * state, so the ratio between them cancels the drift that moves both, which between rounds reached 12% in testing.
 * For p50 and the mean, the change is the median of the rounds' ratios, called real only when it exceeds
 * [thresholdPercent] and at least four rounds in five move the same way; p95 and p99 are reported but never decide.
 * The JVM counters are compared by their medians, with no verdict of their own. Every run on both sides must have used
 * the same settings and played the same game, otherwise nothing is compared.
 */
fun abVerdict(
    nameA: String,
    nameB: String,
    commits: Map<String, String>,
    reports: Map<String, List<Map<String, Any?>>>,
    thresholdPercent: Double,
): Map<String, Any?> {
    val all = reports.values.flatten()
    val reasons = mutableListOf<String>()
    if (all.map { it.section("settings") }.distinct().size > 1) reasons.add("the runs used different settings")
    if (all.map { it.section("game") }.distinct().size > 1) reasons.add("the runs played out differently")
    val calls = all.map { (it.section("runtime")["script_calls_per_frame"] as Number).toDouble() }.distinct()
    if (calls.size > 1) reasons.add("the runs made different numbers of script calls per frame: $calls")

    val rounds = reports.getValue(nameA).size
    val lines = mutableListOf("A/B: $nameA (${commits[nameA]}) -> $nameB (${commits[nameB]}), $rounds rounds each")
    if (reasons.isNotEmpty()) {
        lines.add("NOT COMPARABLE: " + reasons.joinToString("; "))
        return mapOf("comparable" to false, "reasons" to reasons, "summary" to lines.joinToString("\n"))
    }

    val threshold = thresholdPercent / 100.0
    val agreementNeeded = Math.ceil(rounds * 0.8).toInt()
    val statistics = mutableMapOf<String, Any?>()
    for ((stat, decides) in listOf("p50" to true, "mean" to true, "p95" to false, "p99" to false, "p99_9" to false)) {
        val a = reports.getValue(nameA).mapNotNull { (it.section("frames_us")[stat] as Number?)?.toDouble() }
        val b = reports.getValue(nameB).mapNotNull { (it.section("frames_us")[stat] as Number?)?.toDouble() }
        // Reports written before a statistic existed lack it.
        if (a.size != rounds || b.size != rounds) continue
        val ratios = a.indices.map { b[it] / a[it] }
        val change = median(ratios) - 1.0
        val agreeing = ratios.count { (it - 1.0) * change > 0 }
        val call = when {
            !decides -> "indicative only"
            abs(change) <= threshold -> "no detectable change"
            agreeing < agreementNeeded -> "not settled: $agreeing of $rounds rounds agree"
            change < 0 -> "FASTER"
            else -> "SLOWER"
        }
        statistics[stat] = mapOf(
            "median_a_us" to median(a), "median_b_us" to median(b), "change_percent" to change * 100,
            "round_changes_percent" to ratios.map { (it - 1.0) * 100 }, "verdict" to call,
        )
        lines.add(
            "%-5s %7.0f -> %7.0f us  %+5.1f%%  rounds %s  %s".format(
                stat, median(a), median(b), change * 100,
                ratios.joinToString(" ") { "%+.1f".format((it - 1.0) * 100) }, call,
            )
        )
    }

    val counters = mutableMapOf<String, Any?>()
    val hitchesA = reports.getValue(nameA).mapNotNull { (it.section("frames_us")["hitches"] as Number?)?.toDouble() }
    val hitchesB = reports.getValue(nameB).mapNotNull { (it.section("frames_us")["hitches"] as Number?)?.toDouble() }
    if (hitchesA.isNotEmpty() && hitchesB.isNotEmpty()) {
        counters["hitches"] = mapOf("median_a" to median(hitchesA), "median_b" to median(hitchesB))
        lines.add("%-26s %10.1f -> %10.1f".format("hitches", median(hitchesA), median(hitchesB)))
    }
    for (counter in listOf("allocated_bytes_per_frame", "gc_count", "gc_time_ms")) {
        val a = reports.getValue(nameA).mapNotNull { (it.section("runtime")[counter] as Number?)?.toDouble() }
        val b = reports.getValue(nameB).mapNotNull { (it.section("runtime")[counter] as Number?)?.toDouble() }
        if (a.isEmpty() || b.isEmpty()) continue
        counters[counter] = mapOf("median_a" to median(a), "median_b" to median(b))
        lines.add("%-26s %10.1f -> %10.1f".format(counter, median(a), median(b)))
    }
    lines.add("script calls per frame     %10.1f, the same game on both sides".format(calls.single()))

    return mapOf(
        "comparable" to true,
        "a" to mapOf("name" to nameA, "commit" to commits[nameA]),
        "b" to mapOf("name" to nameB, "commit" to commits[nameB]),
        "threshold_percent" to thresholdPercent,
        "frames_us" to statistics,
        "jvm" to counters,
        "summary" to lines.joinToString("\n"),
    )
}
