package godot.tools.common.constants

//Common
const val godotInteropPackage = "godot.common.interop"
const val godotUtilPackage = "godot.common.util"

//Internal
const val godotMemoryPackage = "godot.internal.memory"
const val godotReflectionPackage = "godot.internal.reflection"

//Core
const val godotPackage = "godot"
const val godotInternalPackage = "godot.internal"
const val godotCorePackage = "godot.core"
const val godotApiPackage = "godot.api"
const val godotExtensionPackage = "godot.extension"

//Bootstrap
const val godotAnnotationPackage = "godot.annotation"
const val godotRegistrationPackage = "godot.registration"
const val godotRegistrarBasePackage = "godot.registrar"

//Lang
const val kotlinPackage = "kotlin"
const val javaPackage = "java"
const val javaUtilPackage = "java.util"
const val kotlinCollectionsPackage = "kotlin.collections"
const val kotlinReflectPackage = "kotlin.reflect"
const val kotlinTextPackage = "kotlin.text"

//Coroutines
const val godotCoroutinePackage = "godot.coroutines"
const val kotlinCoroutinePackage = "kotlin.coroutines"
const val kotlinxCoroutinePackage = "kotlinx.coroutines"

fun String.isFromPackage(packageName: String) = this.startsWith(packageName)
