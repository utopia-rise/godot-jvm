package godot.runtime

import godot.common.GODOT_JVM_VERSION
import godot.core.VariantParser
import godot.core.addVariantMapping
import godot.core.clearVariantMappings
import godot.internal.logging.JVMLogging
import godot.internal.reflection.TypeManager
import godot.registerEngineTypes
import godot.registerVariantMapping
import godot.registration.ClassRegistrar
import godot.registration.KtClass
import godot.warmEngineTypes
import java.util.*

internal class Bootstrap {
    private lateinit var serviceLoader: ServiceLoader<ClassRegistrar>

    fun initJar(loader: ClassLoader) {
        serviceLoader = ServiceLoader.load(ClassRegistrar::class.java, loader)
        initializeUsingEntry()
    }

    fun initNativeImage() {
        serviceLoader = ServiceLoader.load(ClassRegistrar::class.java)
        initializeUsingEntry()
    }

    fun getVersion(): String {
        return GODOT_JVM_VERSION
    }

    fun finish() {
        clearClassesCache()
        serviceLoader.reload()
    }

    fun initializeEngineTypes() {
        registerVariantMapping()
        registerEngineTypes()

        registerManagedEngineTypes(
            TypeManager.engineTypeNames.toTypedArray(),
            TypeManager.engineSingletonsNames.toTypedArray()
        )
    }

    private fun initializeUsingEntry() {
        val entryIterator = serviceLoader.iterator()
        if (!entryIterator.hasNext()) {
            JVMLogging.error("Unable to find class registrars, no classes will be loaded")
        }

        val registrars = buildList {
            while (entryIterator.hasNext()) {
                add(entryIterator.next())
            }
        }

        val classes = buildList {
            registrars.forEach { registrar ->
                val ktClass = registrar.register()
                TypeManager.registerUserType(ktClass.registeredName, ktClass.kClass)
                addVariantMapping(ktClass.kClass, VariantParser.OBJECT)
                add(ktClass)
            }
        }

        // START: order matters!
        loadClasses(classes.toTypedArray())

        TypeManager.clearScriptClassCache()

        warmEngineTypes()
        forceJvmInitializationOfSingletons()
        // END: order matters!

        fun forceJvmInitializationOfScripts() {
            // Has to run after all classes are initialized in case a static block needs a Godot type
            classes.forEach { ktClass ->
                val clazz = ktClass.kClass
                // Force init of the class so any static block runs.
                Class.forName(clazz.java.name, true, clazz.java.classLoader)
            }
        }

        forceJvmInitializationOfScripts()
    }

    private fun clearClassesCache() {
        TypeManager.clearUserTypes()
        clearVariantMappings()
        registerVariantMapping()
    }

    private fun forceJvmInitializationOfSingletons() {
        TypeManager.singletonsConstructors.forEach {
            it()
        }
    }

    private external fun loadClasses(classes: Array<KtClass<*>>)

    private external fun registerManagedEngineTypes(
        engineTypesNames: Array<String>,
        engineSingletonNames: Array<String>
    )
}
