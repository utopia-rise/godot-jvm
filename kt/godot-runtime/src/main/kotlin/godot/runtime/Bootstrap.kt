package godot.runtime

import godot.core.KtClass
import godot.core.TypeManager
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.FileSystems
import java.nio.file.Paths
import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchService
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class Bootstrap {
    private var registry: ClassRegistry? = null
    private lateinit var classloader: URLClassLoader
    private lateinit var serviceLoader: ServiceLoader<Entry>
    private var executor: ScheduledExecutorService? = null
    private var watchService: WatchService? = null;

    fun init(isEditor: Boolean, projectDir: String) {
        val libsDir = Paths.get(projectDir, "build/libs")
        val mainJarPath = libsDir.resolve("main.jar")

        if (File(mainJarPath.toString()).exists()) {
            doInit(mainJarPath.toUri().toURL())
        }

        if (isEditor) {
            watchService = FileSystems.getDefault().newWatchService()
            val watchKey = libsDir.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
            )

            executor = Executors.newSingleThreadScheduledExecutor { runnable ->
                val thread = Thread(runnable)
                thread.isDaemon = true
                thread
            }

            executor!!.scheduleAtFixedRate({
                val events = watchKey.pollEvents()
                if (events.isNotEmpty()) {
                    if (File(File(libsDir.toString()), "buildLock.lock").exists()) {
                        return@scheduleAtFixedRate
                    }
                    println("Changes detected, reloading classes ...")
                    registry?.let {
                        unloadClasses(it.classes.toTypedArray())
                        it.classes.clear()
                    }

                    if (File(mainJarPath.toString()).exists()) {
                        doInit(mainJarPath.toUri().toURL())
                    }
                }
            }, 3, 3, TimeUnit.SECONDS)
        }
    }

    fun finish() {
        executor?.shutdown()
        watchService?.close()
        registry?.let { unloadClasses(it.classes.toTypedArray()) }
        registry?.classes?.clear()
    }

    /**
     * This must be called when this class is called in editor mode, i.e the game is not running.
     */
    fun bindClassLoader() {
        Thread.currentThread().contextClassLoader = classloader
    }

    private fun doInit(mainJar: URL) {
        registry = ClassRegistry()
        classloader = URLClassLoader(arrayOf(mainJar), this::class.java.classLoader)
        Thread.currentThread().contextClassLoader = classloader
        serviceLoader = ServiceLoader.load(Entry::class.java, classloader)
        val entry = serviceLoader.findFirst()

        if (entry.isPresent) {
            with(entry.get()) {
                val context = Entry.Context(registry!!)
                context.initEngineTypes()
                registerManagedEngineTypes(
                    TypeManager.engineTypeNames.toTypedArray(),
                    TypeManager.engineTypeMethod.map { it.second }.toTypedArray(),
                    TypeManager.engineTypeMethod.map { it.first }.toTypedArray()
                )
                context.init()
            }
            loadClasses(registry!!.classes.toTypedArray())
        } else {
            System.err.println("Unable to find Entry class, no classes will be loaded")
        }
    }

    private external fun loadClasses(classes: Array<KtClass<*>>)
    private external fun unloadClasses(classes: Array<KtClass<*>>)

    private external fun registerManagedEngineTypes(
            engineTypesNames: Array<String>,
            engineTypeMethodNames: Array<String>,
            typeOfMethods: Array<Int>
    )
}
