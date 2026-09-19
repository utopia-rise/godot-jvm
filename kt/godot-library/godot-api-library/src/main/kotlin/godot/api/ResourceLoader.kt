// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_ARRAY_ret_LONG
import godot.callMethod_STRING_STRING_BOOL_LONG_ret_LONG
import godot.callMethod_STRING_STRING_LONG_ret_OBJECT_REF
import godot.callMethod_STRING_STRING_ret_BOOL
import godot.callMethod_STRING_ret_BOOL
import godot.callMethod_STRING_ret_LONG
import godot.callMethod_STRING_ret_OBJECT_REF
import godot.callMethod_STRING_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_OBJECT_BOOL
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.VariantArray
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * A singleton used to load resource files from the filesystem.
 *
 * It uses the many [ResourceFormatLoader] classes registered in the engine (either built-in or from
 * a plugin) to load files into memory and convert them to a format that can be used by the engine.
 *
 * **Note:** You have to import the files into the engine first to load them using [load]. If you
 * want to load [Image]s at run-time, you may use [Image.load]. If you want to import audio files, you
 * can use the snippet described in [AudioStreamMP3.data].
 *
 * **Note:** Non-resource files such as plain text files cannot be read using [ResourceLoader]. Use
 * [FileAccess] for those files instead, and be aware that non-resource files are not exported by
 * default (see notes in the [FileAccess] class description for instructions on exporting them).
 */
@GodotBaseType
public object ResourceLoader : Object() {
  @JvmField
  public val loadThreadedRequestName:
      MethodStringName4<ResourceLoader, Error, String, String, Boolean, CacheMode> =
      MethodStringName4<ResourceLoader, Error, String, String, Boolean, CacheMode>("load_threaded_request")

  @JvmField
  public val loadThreadedGetStatusName:
      MethodStringName2<ResourceLoader, ThreadLoadStatus, String, VariantArray<Any?>> =
      MethodStringName2<ResourceLoader, ThreadLoadStatus, String, VariantArray<Any?>>("load_threaded_get_status")

  @JvmField
  public val loadThreadedGetName: MethodStringName1<ResourceLoader, Resource?, String> =
      MethodStringName1<ResourceLoader, Resource?, String>("load_threaded_get")

  @JvmField
  public val loadName: MethodStringName3<ResourceLoader, Resource?, String, String, CacheMode> =
      MethodStringName3<ResourceLoader, Resource?, String, String, CacheMode>("load")

  @JvmField
  public val getRecognizedExtensionsForTypeName:
      MethodStringName1<ResourceLoader, PackedStringArray, String> =
      MethodStringName1<ResourceLoader, PackedStringArray, String>("get_recognized_extensions_for_type")

  @JvmField
  public val addResourceFormatLoaderName:
      MethodStringName2<ResourceLoader, Unit, ResourceFormatLoader, Boolean> =
      MethodStringName2<ResourceLoader, Unit, ResourceFormatLoader, Boolean>("add_resource_format_loader")

  @JvmField
  public val removeResourceFormatLoaderName:
      MethodStringName1<ResourceLoader, Unit, ResourceFormatLoader> =
      MethodStringName1<ResourceLoader, Unit, ResourceFormatLoader>("remove_resource_format_loader")

  @JvmField
  public val setAbortOnMissingResourcesName: MethodStringName1<ResourceLoader, Unit, Boolean> =
      MethodStringName1<ResourceLoader, Unit, Boolean>("set_abort_on_missing_resources")

  @JvmField
  public val getDependenciesName: MethodStringName1<ResourceLoader, PackedStringArray, String> =
      MethodStringName1<ResourceLoader, PackedStringArray, String>("get_dependencies")

  @JvmField
  public val hasCachedName: MethodStringName1<ResourceLoader, Boolean, String> =
      MethodStringName1<ResourceLoader, Boolean, String>("has_cached")

  @JvmField
  public val getCachedRefName: MethodStringName1<ResourceLoader, Resource?, String> =
      MethodStringName1<ResourceLoader, Resource?, String>("get_cached_ref")

  @JvmField
  public val existsName: MethodStringName2<ResourceLoader, Boolean, String, String> =
      MethodStringName2<ResourceLoader, Boolean, String, String>("exists")

  @JvmField
  public val getResourceUidName: MethodStringName1<ResourceLoader, Long, String> =
      MethodStringName1<ResourceLoader, Long, String>("get_resource_uid")

  @JvmField
  public val listDirectoryName: MethodStringName1<ResourceLoader, PackedStringArray, String> =
      MethodStringName1<ResourceLoader, PackedStringArray, String>("list_directory")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(30)
  }

  /**
   * Loads the resource using threads. If [useSubThreads] is `true`, multiple threads will be used
   * to load the resource, which makes loading faster, but may affect the main thread (and thus cause
   * game slowdowns).
   *
   * The [cacheMode] parameter defines whether and how the cache should be used or updated when
   * loading the resource.
   */
  @JvmOverloads
  @JvmStatic
  public final fun loadThreadedRequest(
    path: String,
    typeHint: String = "",
    useSubThreads: Boolean = false,
    cacheMode: CacheMode = ResourceLoader.CacheMode.REUSE,
  ): Error =
      Error.from(TransferContext.callMethod_STRING_STRING_BOOL_LONG_ret_LONG(ptr, objectID.id, MethodBindings.loadThreadedRequestPtr, path, typeHint, useSubThreads, cacheMode.value))

  /**
   * Returns the status of a threaded loading operation started with [loadThreadedRequest] for the
   * resource at [path].
   *
   * An array variable can optionally be passed via [progress], and will return a one-element array
   * containing the ratio of completion of the threaded loading (between `0.0` and `1.0`).
   *
   * **Note:** The recommended way of using this method is to call it during different frames (e.g.,
   * in [Node.Process], instead of a loop).
   */
  @JvmOverloads
  @JvmStatic
  public final fun loadThreadedGetStatus(path: String, progress: VariantArray<Any?> =
      godot.core.variantArrayOf()): ThreadLoadStatus =
      ThreadLoadStatus.from(TransferContext.callMethod_STRING_ARRAY_ret_LONG(ptr, objectID.id, MethodBindings.loadThreadedGetStatusPtr, path, progress))

  /**
   * Returns the resource loaded by [loadThreadedRequest].
   *
   * If this is called before the loading thread is done (i.e. [loadThreadedGetStatus] is not
   * [THREAD_LOAD_LOADED]), the calling thread will be blocked until the resource has finished loading.
   * However, it's recommended to use [loadThreadedGetStatus] to known when the load has actually
   * completed.
   */
  @JvmStatic
  public final fun loadThreadedGet(path: String): Resource? =
      (TransferContext.callMethod_STRING_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.loadThreadedGetPtr, path) as Resource?)

  /**
   * Loads a resource at the given [path], caching the result for further access.
   *
   * The registered [ResourceFormatLoader]s are queried sequentially to find the first one which can
   * handle the file's extension, and then attempt loading. If loading fails, the remaining
   * ResourceFormatLoaders are also attempted.
   *
   * An optional [typeHint] can be used to further specify the [Resource] type that should be
   * handled by the [ResourceFormatLoader]. Anything that inherits from [Resource] can be used as a
   * type hint, for example [Image].
   *
   * The [cacheMode] property defines whether and how the cache should be used or updated when
   * loading the resource.
   *
   * Returns an empty resource if no [ResourceFormatLoader] could handle the file, and prints an
   * error if no file is found at the specified path.
   *
   * GDScript has a simplified [@GDScript.load] built-in method which can be used in most
   * situations, leaving the use of [ResourceLoader] for more advanced scenarios.
   *
   * **Note:** If [ProjectSettings.editor/export/convertTextResourcesToBinary] is `true`,
   * [@GDScript.load] will not be able to read converted files in an exported project. If you rely on
   * run-time loading of files present within the PCK, set
   * [ProjectSettings.editor/export/convertTextResourcesToBinary] to `false`.
   *
   * **Note:** Relative paths will be prefixed with `"res://"` before loading, to avoid unexpected
   * results make sure your paths are absolute.
   */
  @JvmOverloads
  @JvmStatic
  public final fun load(
    path: String,
    typeHint: String = "",
    cacheMode: CacheMode = ResourceLoader.CacheMode.REUSE,
  ): Resource? =
      (TransferContext.callMethod_STRING_STRING_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.loadPtr, path, typeHint, cacheMode.value) as Resource?)

  /**
   * Returns the list of recognized extensions for a resource type.
   */
  @JvmStatic
  public final fun getRecognizedExtensionsForType(type: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getRecognizedExtensionsForTypePtr, type)

  /**
   * Registers a new [ResourceFormatLoader]. The ResourceLoader will use the ResourceFormatLoader as
   * described in [load].
   *
   * This method is performed implicitly for ResourceFormatLoaders written in GDScript (see
   * [ResourceFormatLoader] for more information).
   */
  @JvmOverloads
  @JvmStatic
  public final fun addResourceFormatLoader(formatLoader: ResourceFormatLoader, atFront: Boolean =
      false): Unit {
    TransferContext.callPtrMethod_OBJECT_BOOL(ptr, objectID.id, MethodBindings.addResourceFormatLoaderPtr, formatLoader, atFront)
  }

  /**
   * Unregisters the given [ResourceFormatLoader].
   */
  @JvmStatic
  public final fun removeResourceFormatLoader(formatLoader: ResourceFormatLoader): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.removeResourceFormatLoaderPtr, formatLoader)
  }

  /**
   * Changes the behavior on missing sub-resources. The default behavior is to abort loading.
   */
  @JvmStatic
  public final fun setAbortOnMissingResources(abort: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAbortOnMissingResourcesPtr, abort)
  }

  /**
   * Returns the dependencies for the resource at the given [path].
   *
   * Each dependency is a string that can be divided into sections by `::`. There can be either one
   * section or three sections, with the second section always being empty. When there is one section,
   * it contains the file path. When there are three sections, the first section contains the UID and
   * the third section contains the fallback path.
   *
   * ```
   * for dependency in ResourceLoader.get_dependencies(path):
   * 	if dependency.contains("::"):
   * 		print(dependency.get_slice("::", 0)) # Prints the UID.
   * 		print(dependency.get_slice("::", 2)) # Prints the fallback path.
   * 	else:
   * 		print(dependency) # Prints the path.
   * ```
   */
  @JvmStatic
  public final fun getDependencies(path: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getDependenciesPtr, path)

  /**
   * Returns whether a cached resource is available for the given [path].
   *
   * Once a resource has been loaded by the engine, it is cached in memory for faster access, and
   * future calls to the [load] method will use the cached version. The cached resource can be
   * overridden by using [Resource.takeOverPath] on a new resource for that same path.
   */
  @JvmStatic
  public final fun hasCached(path: String): Boolean =
      TransferContext.callMethod_STRING_ret_BOOL(ptr, objectID.id, MethodBindings.hasCachedPtr, path)

  /**
   * Returns the cached resource reference for the given [path].
   *
   * **Note:** If the resource is not cached, the returned [Resource] will be invalid.
   */
  @JvmStatic
  public final fun getCachedRef(path: String): Resource? =
      (TransferContext.callMethod_STRING_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getCachedRefPtr, path) as Resource?)

  /**
   * Returns whether a recognized resource exists for the given [path].
   *
   * An optional [typeHint] can be used to further specify the [Resource] type that should be
   * handled by the [ResourceFormatLoader]. Anything that inherits from [Resource] can be used as a
   * type hint, for example [Image].
   *
   * **Note:** If you use [Resource.takeOverPath], this method will return `true` for the taken path
   * even if the resource wasn't saved (i.e. exists only in resource cache).
   */
  @JvmOverloads
  @JvmStatic
  public final fun exists(path: String, typeHint: String = ""): Boolean =
      TransferContext.callMethod_STRING_STRING_ret_BOOL(ptr, objectID.id, MethodBindings.existsPtr, path, typeHint)

  /**
   * Returns the ID associated with a given resource path, or `-1` when no such ID exists.
   */
  @JvmStatic
  public final fun getResourceUid(path: String): Long =
      TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.getResourceUidPtr, path)

  /**
   * Lists a directory, returning all resources and subdirectories contained within. The resource
   * files have the original file names as visible in the editor before exporting. The directories have
   * `"/"` appended.
   *
   * ```
   * # Prints ["extra_data/", "model.gltf", "model.tscn", "model_slime.png"]
   * print(ResourceLoader.list_directory("res://assets/enemies/slime"))
   * ```
   *
   * **Note:** The order of files and directories returned by this method is not deterministic, and
   * can vary between operating systems.
   *
   * **Note:** To normally traverse the filesystem, see [DirAccess].
   */
  @JvmStatic
  public final fun listDirectory(directoryPath: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.listDirectoryPtr, directoryPath)

  public enum class ThreadLoadStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The resource is invalid, or has not been loaded with [loadThreadedRequest].
     */
    INVALID_RESOURCE(0),
    /**
     * The resource is still being loaded.
     */
    IN_PROGRESS(1),
    /**
     * Some error occurred during loading and it failed.
     */
    FAILED(2),
    /**
     * The resource was loaded successfully and can be accessed via [loadThreadedGet].
     */
    LOADED(3),
    ;

    public companion object {
      public fun from(`value`: Long): ThreadLoadStatus = entries.single { it.`value` == `value` }
    }
  }

  public enum class CacheMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Neither the main resource (the one requested to be loaded) nor any of its subresources are
     * retrieved from cache nor stored into it. Dependencies (external resources) are loaded with
     * [CACHE_MODE_REUSE].
     */
    IGNORE(0),
    /**
     * The main resource (the one requested to be loaded), its subresources, and its dependencies
     * (external resources) are retrieved from cache if present, instead of loaded. Those not cached
     * are loaded and then stored into the cache. The same rules are propagated recursively down the
     * tree of dependencies (external resources).
     */
    REUSE(1),
    /**
     * Like [CACHE_MODE_REUSE], but the cache is checked for the main resource (the one requested to
     * be loaded) as well as for each of its subresources. Those already in the cache, as long as the
     * loaded and cached types match, have their data refreshed from storage into the already existing
     * instances. Otherwise, they are recreated as completely new objects.
     */
    REPLACE(2),
    /**
     * Like [CACHE_MODE_IGNORE], but propagated recursively down the tree of dependencies (external
     * resources).
     */
    IGNORE_DEEP(3),
    /**
     * Like [CACHE_MODE_REPLACE], but propagated recursively down the tree of dependencies (external
     * resources).
     */
    REPLACE_DEEP(4),
    ;

    public companion object {
      public fun from(`value`: Long): CacheMode = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val loadThreadedRequestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "load_threaded_request", 3614384323)

    internal val loadThreadedGetStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "load_threaded_get_status", 4137685479)

    internal val loadThreadedGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "load_threaded_get", 1748875256)

    internal val loadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "load", 3358495409)

    internal val getRecognizedExtensionsForTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "get_recognized_extensions_for_type", 3538744774)

    internal val addResourceFormatLoaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "add_resource_format_loader", 2896595483)

    internal val removeResourceFormatLoaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "remove_resource_format_loader", 405397102)

    internal val setAbortOnMissingResourcesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "set_abort_on_missing_resources", 2586408642)

    internal val getDependenciesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "get_dependencies", 3538744774)

    internal val hasCachedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "has_cached", 2323990056)

    internal val getCachedRefPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "get_cached_ref", 1748875256)

    internal val existsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "exists", 4185558881)

    internal val getResourceUidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "get_resource_uid", 1597066294)

    internal val listDirectoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceLoader", "list_directory", 3538744774)
  }
}
