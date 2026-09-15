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
import godot.core.BitFieldBase
import godot.core.Error
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_BOOL
import godot.writeMethodArguments_OBJECT_STRING_LONG
import godot.writeMethodArguments_STRING_BOOL
import godot.writeMethodArguments_STRING_LONG
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

public infix fun Long.or(other: ResourceSaver.SaverFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: ResourceSaver.SaverFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: ResourceSaver.SaverFlags): Long = this.and(other.flag)

/**
 * A singleton for saving resource types to the filesystem.
 *
 * It uses the many [ResourceFormatSaver] classes registered in the engine (either built-in or from
 * a plugin) to save resource data to text-based (e.g. `.tres` or `.tscn`) or binary files (e.g. `.res`
 * or `.scn`).
 */
@GodotBaseType
public object ResourceSaver : Object() {
  @JvmField
  public val saveName: MethodStringName3<ResourceSaver, Error, Resource, String, SaverFlags> =
      MethodStringName3<ResourceSaver, Error, Resource, String, SaverFlags>("save")

  @JvmField
  public val setUidName: MethodStringName2<ResourceSaver, Error, String, Long> =
      MethodStringName2<ResourceSaver, Error, String, Long>("set_uid")

  @JvmField
  public val getRecognizedExtensionsName:
      MethodStringName1<ResourceSaver, PackedStringArray, Resource> =
      MethodStringName1<ResourceSaver, PackedStringArray, Resource>("get_recognized_extensions")

  @JvmField
  public val addResourceFormatSaverName:
      MethodStringName2<ResourceSaver, Unit, ResourceFormatSaver, Boolean> =
      MethodStringName2<ResourceSaver, Unit, ResourceFormatSaver, Boolean>("add_resource_format_saver")

  @JvmField
  public val removeResourceFormatSaverName:
      MethodStringName1<ResourceSaver, Unit, ResourceFormatSaver> =
      MethodStringName1<ResourceSaver, Unit, ResourceFormatSaver>("remove_resource_format_saver")

  @JvmField
  public val getResourceIdForPathName: MethodStringName2<ResourceSaver, Long, String, Boolean> =
      MethodStringName2<ResourceSaver, Long, String, Boolean>("get_resource_id_for_path")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(31)
  }

  /**
   * Saves a resource to disk to the given path, using a [ResourceFormatSaver] that recognizes the
   * resource object. If [path] is empty, [ResourceSaver] will try to use [Resource.resourcePath].
   *
   * The [flags] bitmask can be specified to customize the save behavior.
   *
   * Returns [OK] on success.
   *
   * **Note:** When the project is running, any generated UID associated with the resource will not
   * be saved as the required code is only executed in editor mode.
   */
  @JvmOverloads
  @JvmStatic
  public final fun save(
    resource: Resource,
    path: String = "",
    flags: SaverFlags = ResourceSaver.SaverFlags.FLAG_NONE,
  ): Error {
    TransferContext.writeMethodArguments_OBJECT_STRING_LONG(ptr, objectID.id, resource, path, flags.flag)
    TransferContext.callMethod(MethodBindings.savePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the UID of the given [resource] path to [uid]. You can generate a new UID using
   * [ResourceUID.createId].
   *
   * Since resources will normally get a UID automatically, this method is only useful in very
   * specific cases.
   */
  @JvmStatic
  public final fun setUid(resource: String, uid: Long): Error {
    TransferContext.writeMethodArguments_STRING_LONG(ptr, objectID.id, resource, uid)
    TransferContext.callMethod(MethodBindings.setUidPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the list of extensions available for saving a resource of a given type.
   */
  @JvmStatic
  public final fun getRecognizedExtensions(type: Resource): PackedStringArray {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, type)
    TransferContext.callMethod(MethodBindings.getRecognizedExtensionsPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Registers a new [ResourceFormatSaver]. The ResourceSaver will use the ResourceFormatSaver as
   * described in [save].
   *
   * This method is performed implicitly for ResourceFormatSavers written in GDScript (see
   * [ResourceFormatSaver] for more information).
   */
  @JvmOverloads
  @JvmStatic
  public final fun addResourceFormatSaver(formatSaver: ResourceFormatSaver, atFront: Boolean =
      false): Unit {
    TransferContext.writeMethodArguments_OBJECT_BOOL(ptr, objectID.id, formatSaver, atFront)
    TransferContext.callPtrMethod(MethodBindings.addResourceFormatSaverPtr, 0)
  }

  /**
   * Unregisters the given [ResourceFormatSaver].
   */
  @JvmStatic
  public final fun removeResourceFormatSaver(formatSaver: ResourceFormatSaver): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, formatSaver)
    TransferContext.callPtrMethod(MethodBindings.removeResourceFormatSaverPtr, 0)
  }

  /**
   * Returns the resource ID for the given path. If [generate] is `true`, a new resource ID will be
   * generated if one for the path is not found. If [generate] is `false` and the path is not found,
   * [ResourceUID.INVALID_ID] is returned.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getResourceIdForPath(path: String, generate: Boolean = false): Long {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, path, generate)
    TransferContext.callMethod(MethodBindings.getResourceIdForPathPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public class SaverFlags(
    flag: Long,
  ) : BitFieldBase<SaverFlags>(flag) {
    protected override fun wrap(flag: Long): SaverFlags = SaverFlags(flag)

    public companion object {
      /**
       * No resource saving option.
       */
      @JvmField
      public val FLAG_NONE: SaverFlags = SaverFlags(0)

      /**
       * Save the resource with a path relative to the scene which uses it.
       */
      @JvmField
      public val FLAG_RELATIVE_PATHS: SaverFlags = SaverFlags(1)

      /**
       * Bundles external resources.
       */
      @JvmField
      public val FLAG_BUNDLE_RESOURCES: SaverFlags = SaverFlags(2)

      /**
       * Changes the [Resource.resourcePath] of the saved resource to match its new location.
       */
      @JvmField
      public val FLAG_CHANGE_PATH: SaverFlags = SaverFlags(4)

      /**
       * Do not save editor-specific metadata (identified by their `__editor` prefix).
       */
      @JvmField
      public val FLAG_OMIT_EDITOR_PROPERTIES: SaverFlags = SaverFlags(8)

      /**
       * Save as big endian (see [FileAccess.bigEndian]).
       */
      @JvmField
      public val FLAG_SAVE_BIG_ENDIAN: SaverFlags = SaverFlags(16)

      /**
       * Compress the resource on save using [FileAccess.COMPRESSION_ZSTD]. Only available for
       * binary resource types.
       */
      @JvmField
      public val FLAG_COMPRESS: SaverFlags = SaverFlags(32)

      /**
       * Take over the paths of the saved subresources (see [Resource.takeOverPath]).
       */
      @JvmField
      public val FLAG_REPLACE_SUBRESOURCE_PATHS: SaverFlags = SaverFlags(64)
    }
  }

  public object MethodBindings {
    internal val savePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "save", 2983274697)

    internal val setUidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "set_uid", 993915709)

    internal val getRecognizedExtensionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "get_recognized_extensions", 4223597960)

    internal val addResourceFormatSaverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "add_resource_format_saver", 362894272)

    internal val removeResourceFormatSaverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "remove_resource_format_saver", 3373026878)

    internal val getResourceIdForPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceSaver", "get_resource_id_for_path", 150756522)
  }
}
