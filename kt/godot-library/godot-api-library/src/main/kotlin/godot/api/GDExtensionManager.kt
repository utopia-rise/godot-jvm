// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_ret_BOOL
import godot.callMethod_STRING_ret_LONG
import godot.callMethod_STRING_ret_OBJECT_REF
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedStringArray
import godot.core.Signal0
import godot.core.Signal1
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * The GDExtensionManager loads, initializes, and keeps track of all available [GDExtension]
 * libraries in the project.
 *
 * **Note:** Do not worry about GDExtension unless you know what you are doing.
 */
@GodotBaseType
public object GDExtensionManager : Object() {
  @JvmField
  public val loadExtensionName: MethodStringName1<GDExtensionManager, LoadStatus, String> =
      MethodStringName1<GDExtensionManager, LoadStatus, String>("load_extension")

  @JvmField
  public val reloadExtensionName: MethodStringName1<GDExtensionManager, LoadStatus, String> =
      MethodStringName1<GDExtensionManager, LoadStatus, String>("reload_extension")

  @JvmField
  public val unloadExtensionName: MethodStringName1<GDExtensionManager, LoadStatus, String> =
      MethodStringName1<GDExtensionManager, LoadStatus, String>("unload_extension")

  @JvmField
  public val isExtensionLoadedName: MethodStringName1<GDExtensionManager, Boolean, String> =
      MethodStringName1<GDExtensionManager, Boolean, String>("is_extension_loaded")

  @JvmField
  public val getLoadedExtensionsName: MethodStringName0<GDExtensionManager, PackedStringArray> =
      MethodStringName0<GDExtensionManager, PackedStringArray>("get_loaded_extensions")

  @JvmField
  public val getExtensionName: MethodStringName1<GDExtensionManager, GDExtension?, String> =
      MethodStringName1<GDExtensionManager, GDExtension?, String>("get_extension")

  /**
   * Emitted after the editor has finished reloading one or more extensions.
   */
  @JvmStatic
  public val extensionsReloaded: Signal0 by Signal0

  /**
   * Emitted after the editor has finished loading a new extension.
   *
   * **Note:** This signal is only emitted in editor builds.
   */
  @JvmStatic
  public val extensionLoaded: Signal1<GDExtension> by Signal1

  /**
   * Emitted before the editor starts unloading an extension.
   *
   * **Note:** This signal is only emitted in editor builds.
   */
  @JvmStatic
  public val extensionUnloading: Signal1<GDExtension> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(7)
  }

  /**
   * Loads an extension by absolute file path. The [path] needs to point to a valid [GDExtension].
   * Returns [LOAD_STATUS_OK] if successful.
   */
  @JvmStatic
  public final fun loadExtension(path: String): LoadStatus =
      LoadStatus.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.loadExtensionPtr, path))

  /**
   * Reloads the extension at the given file path. The [path] needs to point to a valid
   * [GDExtension], otherwise this method may return either [LOAD_STATUS_NOT_LOADED] or
   * [LOAD_STATUS_FAILED].
   *
   * **Note:** You can only reload extensions in the editor. In release builds, this method always
   * fails and returns [LOAD_STATUS_FAILED].
   */
  @JvmStatic
  public final fun reloadExtension(path: String): LoadStatus =
      LoadStatus.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.reloadExtensionPtr, path))

  /**
   * Unloads an extension by file path. The [path] needs to point to an already loaded
   * [GDExtension], otherwise this method returns [LOAD_STATUS_NOT_LOADED].
   */
  @JvmStatic
  public final fun unloadExtension(path: String): LoadStatus =
      LoadStatus.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.unloadExtensionPtr, path))

  /**
   * Returns `true` if the extension at the given file [path] has already been loaded successfully.
   * See also [getLoadedExtensions].
   */
  @JvmStatic
  public final fun isExtensionLoaded(path: String): Boolean =
      TransferContext.callMethod_STRING_ret_BOOL(ptr, objectID.id, MethodBindings.isExtensionLoadedPtr, path)

  /**
   * Returns the file paths of all currently loaded extensions.
   */
  @JvmStatic
  public final fun getLoadedExtensions(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getLoadedExtensionsPtr)

  /**
   * Returns the [GDExtension] at the given file [path], or `null` if it has not been loaded or does
   * not exist.
   */
  @JvmStatic
  public final fun getExtension(path: String): GDExtension? =
      (TransferContext.callMethod_STRING_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getExtensionPtr, path) as GDExtension?)

  public enum class LoadStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The extension has loaded successfully.
     */
    OK(0),
    /**
     * The extension has failed to load, possibly because it does not exist or has missing
     * dependencies.
     */
    FAILED(1),
    /**
     * The extension has already been loaded.
     */
    ALREADY_LOADED(2),
    /**
     * The extension has not been loaded.
     */
    NOT_LOADED(3),
    /**
     * The extension requires the application to restart to fully load.
     */
    NEEDS_RESTART(4),
    ;

    public companion object {
      public fun from(`value`: Long): LoadStatus = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val loadExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "load_extension", 4024158731)

    internal val loadExtensionFromFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "load_extension_from_function", 1565094761)

    internal val reloadExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "reload_extension", 4024158731)

    internal val unloadExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "unload_extension", 4024158731)

    internal val isExtensionLoadedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "is_extension_loaded", 3927539163)

    internal val getLoadedExtensionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "get_loaded_extensions", 1139954409)

    internal val getExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtensionManager", "get_extension", 49743343)
  }
}
