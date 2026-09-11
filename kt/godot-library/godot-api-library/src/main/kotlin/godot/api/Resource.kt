// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser._RID
import kotlin.Boolean
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Resource is the base class for all Godot-specific resource types, serving primarily as data
 * containers. Since they inherit from [RefCounted], resources are reference-counted and freed when no
 * longer in use. They can also be nested within other resources, and saved on disk. [PackedScene], one
 * of the most common [Object]s in a Godot project, is also a resource, uniquely capable of storing and
 * instantiating the [Node]s it contains as many times as desired.
 *
 * In GDScript, resources can loaded from disk by their [resourcePath] using [@GDScript.load] or
 * [@GDScript.preload].
 *
 * The engine keeps a global cache of all loaded resources, referenced by paths (see
 * [ResourceLoader.hasCached]). A resource will be cached when loaded for the first time and removed
 * from cache once all references are released. When a resource is cached, subsequent loads using its
 * path will return the cached reference.
 *
 * **Note:** In C#, resources will not be freed instantly after they are no longer in use. Instead,
 * garbage collection will run periodically and will free resources that are no longer in use. This
 * means that unused resources will remain in memory for a while before being removed.
 */
@GodotBaseType
public open class Resource : RefCounted() {
  /**
   * Emitted when the resource changes, usually when one of its properties is modified. See also
   * [emitChanged].
   *
   * **Note:** This signal is not emitted automatically for properties of custom resources. If
   * necessary, a setter needs to be created to emit the signal.
   */
  public val changed: Signal0 by Signal0

  /**
   * Emitted by a newly duplicated resource with [resourceLocalToScene] set to `true`.
   */
  public val setupLocalToSceneRequested: Signal0 by Signal0

  /**
   * If `true`, the resource is duplicated for each instance of all scenes using it. At run-time,
   * the resource can be modified in one scene without affecting other instances (see
   * [PackedScene.instantiate]).
   *
   * **Note:** Changing this property at run-time has no effect on already created duplicate
   * resources.
   */
  public final inline var resourceLocalToScene: Boolean
    @JvmName("resourceLocalToSceneProperty")
    get() = isLocalToScene()
    @JvmName("resourceLocalToSceneProperty")
    set(`value`) {
      setLocalToScene(value)
    }

  /**
   * The unique path to this resource. If it has been saved to disk, the value will be its filepath.
   * If the resource is exclusively contained within a scene, the value will be the [PackedScene]'s
   * filepath, followed by a unique identifier.
   *
   * **Note:** Setting this property manually may fail if a resource with the same path has already
   * been previously loaded. If necessary, use [takeOverPath].
   */
  public final inline var resourcePath: String
    @JvmName("resourcePathProperty")
    get() = getPath()
    @JvmName("resourcePathProperty")
    set(`value`) {
      setPath(value)
    }

  /**
   * An optional name for this resource. When defined, its value is displayed to represent the
   * resource in the Inspector dock. For built-in scripts, the name is displayed as part of the tab
   * name in the script editor.
   *
   * **Note:** Some resource formats do not support resource names. You can still set the name in
   * the editor or via code, but it will be lost when the resource is reloaded. For example, only
   * built-in scripts can have a resource name, while scripts stored in separate files cannot.
   */
  public final inline var resourceName: String
    @JvmName("resourceNameProperty")
    get() = getName()
    @JvmName("resourceNameProperty")
    set(`value`) {
      setName(value)
    }

  /**
   * A unique identifier relative to this resource's scene. If left empty, the ID is automatically
   * generated when this resource is saved inside a [PackedScene]. If the resource is not inside a
   * scene, this property is empty by default.
   *
   * **Note:** When the [PackedScene] is saved, if multiple resources in the same scene use the same
   * ID, only the earliest resource in the scene hierarchy keeps the original ID. The other resources
   * are assigned new IDs from [generateSceneUniqueId].
   *
   * **Note:** Setting this property does not emit the [signal changed] signal.
   *
   * **Warning:** When setting, the ID must only consist of letters, numbers, and underscores.
   * Otherwise, it will fail and default to a randomly generated ID.
   */
  public final inline var resourceSceneUniqueId: String
    @JvmName("resourceSceneUniqueIdProperty")
    get() = getSceneUniqueId()
    @JvmName("resourceSceneUniqueIdProperty")
    set(`value`) {
      setSceneUniqueId(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(621, scriptPtr)
  }

  /**
   * Override this method to customize the newly duplicated resource created from
   * [PackedScene.instantiate], if the original's [resourceLocalToScene] is set to `true`.
   *
   * **Example:** Set a random `damage` value to every local resource from an instantiated scene:
   *
   * ```
   * extends Resource
   *
   * var damage = 0
   *
   * func _setup_local_to_scene():
   * 	damage = randi_range(10, 40)
   * ```
   */
  public open fun _setupLocalToScene(): Unit {
    throw NotImplementedError("Resource::_setupLocalToScene is not implemented.")
  }

  /**
   * Override this method to return a custom [RID] when [getRid] is called.
   */
  public open fun _getRid(): RID {
    throw NotImplementedError("Resource::_getRid is not implemented.")
  }

  /**
   * For resources that store state in non-exported properties, such as via
   * [Object.ValidateProperty] or [Object.GetPropertyList], this method must be implemented to clear
   * them.
   */
  public open fun _resetState(): Unit {
    throw NotImplementedError("Resource::_resetState is not implemented.")
  }

  /**
   * Override this method to execute additional logic after [setPathCache] is called on this object.
   */
  public open fun _setPathCache(path: String): Unit {
    throw NotImplementedError("Resource::_setPathCache is not implemented.")
  }

  public final fun setPath(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.setPathPtr)
  }

  /**
   * Sets the [resourcePath] to [path], potentially overriding an existing cache entry for this
   * path. Further attempts to load an overridden resource by path will instead return this resource.
   */
  public final fun takeOverPath(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.takeOverPathPtr)
  }

  public final fun getPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the resource's path to [path] without involving the resource cache. Useful for handling
   * [ResourceFormatLoader.CacheMode] values when implementing a custom resource format by extending
   * [ResourceFormatLoader] and [ResourceFormatSaver].
   */
  public final fun setPathCache(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.setPathCachePtr)
  }

  public final fun setName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setNamePtr)
  }

  public final fun getName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the [RID] of this resource (or an empty RID). Many resources (such as [Texture2D],
   * [Mesh], and so on) are high-level abstractions of resources stored in a specialized server
   * ([DisplayServer], [RenderingServer], etc.), so this function will return the original [RID].
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setLocalToScene(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setLocalToScenePtr)
  }

  public final fun isLocalToScene(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLocalToScenePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If [resourceLocalToScene] is set to `true` and the resource has been loaded from a
   * [PackedScene] instantiation, returns the root [Node] of the scene where this resource is used.
   * Otherwise, returns `null`.
   */
  public final fun getLocalScene(): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalScenePtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Calls [_setupLocalToScene]. If [resourceLocalToScene] is set to `true`, this method is
   * automatically called from [PackedScene.instantiate] by the newly duplicated resource within the
   * scene instance.
   */
  public final fun setupLocalToScene(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.setupLocalToScenePtr)
  }

  /**
   * Makes the resource clear its non-exported properties. See also [_resetState]. Useful when
   * implementing a custom resource format by extending [ResourceFormatLoader] and
   * [ResourceFormatSaver].
   */
  public final fun resetState(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetStatePtr)
  }

  /**
   * In the internal cache for scene-unique IDs, sets the ID of this resource to [id] for the scene
   * at [path]. If [id] is empty, the cache entry for [path] is cleared. Useful to keep scene-unique
   * IDs the same when implementing a VCS-friendly custom resource format by extending
   * [ResourceFormatLoader] and [ResourceFormatSaver].
   *
   * **Note:** This method is only implemented when running in an editor context.
   */
  public final fun setIdForPath(path: String, id: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, STRING to id)
    TransferContext.callMethod(MethodBindings.setIdForPathPtr)
  }

  /**
   * From the internal cache for scene-unique IDs, returns the ID of this resource for the scene at
   * [path]. If there is no entry, an empty string is returned. Useful to keep scene-unique IDs the
   * same when implementing a VCS-friendly custom resource format by extending [ResourceFormatLoader]
   * and [ResourceFormatSaver].
   *
   * **Note:** This method is only implemented when running in an editor context. At runtime, it
   * returns an empty string.
   */
  public final fun getIdForPath(path: String): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.getIdForPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the resource is saved on disk as a part of another resource's file.
   */
  public final fun isBuiltIn(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBuiltInPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSceneUniqueId(id: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to id)
    TransferContext.callMethod(MethodBindings.setSceneUniqueIdPtr)
  }

  public final fun getSceneUniqueId(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSceneUniqueIdPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Emits the [signal changed] signal. This method is called automatically for some built-in
   * resources.
   *
   * **Note:** For custom resources, it's recommended to call this method whenever a meaningful
   * change occurs, such as a modified property. This ensures that custom [Object]s depending on the
   * resource are properly updated.
   *
   * ```
   * var damage:
   * 	set(new_value):
   * 		if damage != new_value:
   * 			damage = new_value
   * 			emit_changed()
   * ```
   */
  public final fun emitChanged(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.emitChangedPtr)
  }

  /**
   * Duplicates this resource, returning a new resource with its `export`ed or
   * [PROPERTY_USAGE_STORAGE] properties copied from the original.
   *
   * If [deep] is `false`, a **shallow** copy is returned: nested [VariantArray], [Dictionary], and
   * [Resource] properties are not duplicated and are shared with the original resource.
   *
   * If [deep] is `true`, a **deep** copy is returned: all nested arrays, dictionaries, and packed
   * arrays are also duplicated (recursively). Any [Resource] found inside will only be duplicated if
   * it's local, like [DEEP_DUPLICATE_INTERNAL] used with [duplicateDeep].
   *
   * The following exceptions apply:
   *
   * - Subresource properties with the [PROPERTY_USAGE_ALWAYS_DUPLICATE] flag are always duplicated
   * (recursively or not, depending on [deep]).
   *
   * - Subresource properties with the [PROPERTY_USAGE_NEVER_DUPLICATE] flag are never duplicated.
   *
   * **Note:** For custom resources, this method will fail if [Object.Init] has been defined with
   * required parameters.
   *
   * **Note:** When duplicating with [deep] set to `true`, each resource found, including the one on
   * which this method is called, will be only duplicated once and referenced as many times as needed
   * in the duplicate. For instance, if you are duplicating resource A that happens to have resource B
   * referenced twice, you'll get a new resource A' referencing a new resource B' twice.
   */
  @JvmOverloads
  public final fun duplicate(deep: Boolean = false): Resource? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to deep)
    TransferContext.callMethod(MethodBindings.duplicatePtr)
    return (TransferContext.readReturnValue(OBJECT) as Resource?)
  }

  /**
   * Duplicates this resource, deeply, like [duplicate] when passing `true`, with extra control over
   * how subresources are handled.
   */
  @JvmOverloads
  public final fun duplicateDeep(deepSubresourcesMode: DeepDuplicateMode =
      Resource.DeepDuplicateMode.INTERNAL): Resource? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to deepSubresourcesMode.value)
    TransferContext.callMethod(MethodBindings.duplicateDeepPtr)
    return (TransferContext.readReturnValue(OBJECT) as Resource?)
  }

  /**
   * Copies the data from [resource] into this resource. Both resources must share the same class.
   */
  public final fun copyFromResource(resource: Resource?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to resource)
    TransferContext.callMethod(MethodBindings.copyFromResourcePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class DeepDuplicateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No subresources at all are duplicated. This is useful even in a deep duplication to have all
     * the arrays and dictionaries duplicated but still pointing to the original resources.
     */
    NONE(0),
    /**
     * Only subresources without a path or with a scene-local path will be duplicated.
     */
    INTERNAL(1),
    /**
     * Every subresource found will be duplicated, even if it has a non-local path. In other words,
     * even potentially big resources stored separately will be duplicated.
     */
    ALL(2),
    ;

    public companion object {
      public fun from(`value`: Long): DeepDuplicateMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPathName: MethodStringName1<Resource, Unit, String> =
        MethodStringName1<Resource, Unit, String>("set_path")

    @JvmField
    public val takeOverPathName: MethodStringName1<Resource, Unit, String> =
        MethodStringName1<Resource, Unit, String>("take_over_path")

    @JvmField
    public val getPathName: MethodStringName0<Resource, String> =
        MethodStringName0<Resource, String>("get_path")

    @JvmField
    public val setPathCacheName: MethodStringName1<Resource, Unit, String> =
        MethodStringName1<Resource, Unit, String>("set_path_cache")

    @JvmField
    public val setNameName: MethodStringName1<Resource, Unit, String> =
        MethodStringName1<Resource, Unit, String>("set_name")

    @JvmField
    public val getNameName: MethodStringName0<Resource, String> =
        MethodStringName0<Resource, String>("get_name")

    @JvmField
    public val getRidName: MethodStringName0<Resource, RID> =
        MethodStringName0<Resource, RID>("get_rid")

    @JvmField
    public val setLocalToSceneName: MethodStringName1<Resource, Unit, Boolean> =
        MethodStringName1<Resource, Unit, Boolean>("set_local_to_scene")

    @JvmField
    public val isLocalToSceneName: MethodStringName0<Resource, Boolean> =
        MethodStringName0<Resource, Boolean>("is_local_to_scene")

    @JvmField
    public val getLocalSceneName: MethodStringName0<Resource, Node?> =
        MethodStringName0<Resource, Node?>("get_local_scene")

    @JvmField
    public val setupLocalToSceneName: MethodStringName0<Resource, Unit> =
        MethodStringName0<Resource, Unit>("setup_local_to_scene")

    @JvmField
    public val resetStateName: MethodStringName0<Resource, Unit> =
        MethodStringName0<Resource, Unit>("reset_state")

    @JvmField
    public val setIdForPathName: MethodStringName2<Resource, Unit, String, String> =
        MethodStringName2<Resource, Unit, String, String>("set_id_for_path")

    @JvmField
    public val getIdForPathName: MethodStringName1<Resource, String, String> =
        MethodStringName1<Resource, String, String>("get_id_for_path")

    @JvmField
    public val isBuiltInName: MethodStringName0<Resource, Boolean> =
        MethodStringName0<Resource, Boolean>("is_built_in")

    @JvmField
    public val generateSceneUniqueIdName: MethodStringName0<Resource, String> =
        MethodStringName0<Resource, String>("generate_scene_unique_id")

    @JvmField
    public val setSceneUniqueIdName: MethodStringName1<Resource, Unit, String> =
        MethodStringName1<Resource, Unit, String>("set_scene_unique_id")

    @JvmField
    public val getSceneUniqueIdName: MethodStringName0<Resource, String> =
        MethodStringName0<Resource, String>("get_scene_unique_id")

    @JvmField
    public val emitChangedName: MethodStringName0<Resource, Unit> =
        MethodStringName0<Resource, Unit>("emit_changed")

    @JvmField
    public val duplicateName: MethodStringName1<Resource, Resource?, Boolean> =
        MethodStringName1<Resource, Resource?, Boolean>("duplicate")

    @JvmField
    public val duplicateDeepName: MethodStringName1<Resource, Resource?, DeepDuplicateMode> =
        MethodStringName1<Resource, Resource?, DeepDuplicateMode>("duplicate_deep")

    @JvmField
    public val copyFromResourceName: MethodStringName1<Resource, Error, Resource?> =
        MethodStringName1<Resource, Error, Resource?>("copy_from_resource")

    /**
     * Generates a unique identifier for a resource to be contained inside a [PackedScene], based on
     * the current date, time, and a random value. The returned string is only composed of letters (`a`
     * to `y`) and numbers (`0` to `8`). See also [resourceSceneUniqueId].
     */
    @JvmStatic
    public final fun generateSceneUniqueId(): String {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.generateSceneUniqueIdPtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }
  }

  public object MethodBindings {
    internal val setPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_path", 83702148)

    internal val takeOverPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "take_over_path", 83702148)

    internal val getPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_path", 201670096)

    internal val setPathCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_path_cache", 83702148)

    internal val setNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_name", 83702148)

    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_name", 201670096)

    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_rid", 2944877500)

    internal val setLocalToScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_local_to_scene", 2586408642)

    internal val isLocalToScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "is_local_to_scene", 36873697)

    internal val getLocalScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_local_scene", 3160264692)

    internal val setupLocalToScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "setup_local_to_scene", 3218959716)

    internal val resetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "reset_state", 3218959716)

    internal val setIdForPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_id_for_path", 3186203200)

    internal val getIdForPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_id_for_path", 3135753539)

    internal val isBuiltInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "is_built_in", 36873697)

    internal val generateSceneUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "generate_scene_unique_id", 2841200299)

    internal val setSceneUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "set_scene_unique_id", 83702148)

    internal val getSceneUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "get_scene_unique_id", 201670096)

    internal val emitChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "emit_changed", 3218959716)

    internal val duplicatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "duplicate", 482882304)

    internal val duplicateDeepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "duplicate_deep", 905779109)

    internal val copyFromResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Resource", "copy_from_resource", 3338311164)
  }
}
