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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * Resource UIDs (Unique IDentifiers) allow the engine to keep references between resources intact,
 * even if files are renamed or moved. They can be accessed with `uid://`.
 *
 * [ResourceUID] keeps track of all registered resource UIDs in a project, generates new UIDs, and
 * converts between their string and integer representations.
 */
@GodotBaseType
public object ResourceUID : Object() {
  @JvmField
  public val idToTextName: MethodStringName1<ResourceUID, String, Long> =
      MethodStringName1<ResourceUID, String, Long>("id_to_text")

  @JvmField
  public val textToIdName: MethodStringName1<ResourceUID, Long, String> =
      MethodStringName1<ResourceUID, Long, String>("text_to_id")

  @JvmField
  public val createIdName: MethodStringName0<ResourceUID, Long> =
      MethodStringName0<ResourceUID, Long>("create_id")

  @JvmField
  public val createIdForPathName: MethodStringName1<ResourceUID, Long, String> =
      MethodStringName1<ResourceUID, Long, String>("create_id_for_path")

  @JvmField
  public val hasIdName: MethodStringName1<ResourceUID, Boolean, Long> =
      MethodStringName1<ResourceUID, Boolean, Long>("has_id")

  @JvmField
  public val addIdName: MethodStringName2<ResourceUID, Unit, Long, String> =
      MethodStringName2<ResourceUID, Unit, Long, String>("add_id")

  @JvmField
  public val setIdName: MethodStringName2<ResourceUID, Unit, Long, String> =
      MethodStringName2<ResourceUID, Unit, Long, String>("set_id")

  @JvmField
  public val getIdPathName: MethodStringName1<ResourceUID, String, Long> =
      MethodStringName1<ResourceUID, String, Long>("get_id_path")

  @JvmField
  public val removeIdName: MethodStringName1<ResourceUID, Unit, Long> =
      MethodStringName1<ResourceUID, Unit, Long>("remove_id")

  @JvmField
  public val uidToPathName: MethodStringName1<ResourceUID, String, String> =
      MethodStringName1<ResourceUID, String, String>("uid_to_path")

  @JvmField
  public val pathToUidName: MethodStringName1<ResourceUID, String, String> =
      MethodStringName1<ResourceUID, String, String>("path_to_uid")

  @JvmField
  public val ensurePathName: MethodStringName1<ResourceUID, String, String> =
      MethodStringName1<ResourceUID, String, String>("ensure_path")

  /**
   * The value to use for an invalid UID, for example if the resource could not be loaded.
   *
   * Its text representation is `uid://<invalid>`.
   */
  public final const val INVALID_ID: Long = -1

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(32)
  }

  /**
   * Converts the given UID to a `uid://` string value.
   */
  @JvmStatic
  public final fun idToText(id: Long): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.idToTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Extracts the UID value from the given `uid://` string.
   */
  @JvmStatic
  public final fun textToId(textId: String): Long {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, textId)
    TransferContext.callMethod(MethodBindings.textToIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Generates a random resource UID which is guaranteed to be unique within the list of currently
   * loaded UIDs.
   *
   * In order for this UID to be registered, you must call [addId] or [setId].
   */
  @JvmStatic
  public final fun createId(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Like [createId], but the UID is seeded with the provided [path] and project name. UIDs
   * generated for that path will be always the same within the current project.
   */
  @JvmStatic
  public final fun createIdForPath(path: String): Long {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.createIdForPathPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns whether the given UID value is known to the cache.
   */
  @JvmStatic
  public final fun hasId(id: Long): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.hasIdPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds a new UID value which is mapped to the given resource path.
   *
   * Fails with an error if the UID already exists, so be sure to check [hasId] beforehand, or use
   * [setId] instead.
   */
  @JvmStatic
  public final fun addId(id: Long, path: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, id, path)
    TransferContext.callMethod(MethodBindings.addIdPtr)
  }

  /**
   * Updates the resource path of an existing UID.
   *
   * Fails with an error if the UID does not exist, so be sure to check [hasId] beforehand, or use
   * [addId] instead.
   */
  @JvmStatic
  public final fun setId(id: Long, path: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, id, path)
    TransferContext.callMethod(MethodBindings.setIdPtr)
  }

  /**
   * Returns the path that the given UID value refers to.
   *
   * Fails with an error if the UID does not exist, so be sure to check [hasId] beforehand.
   */
  @JvmStatic
  public final fun getIdPath(id: Long): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.getIdPathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Removes a loaded UID value from the cache.
   *
   * Fails with an error if the UID does not exist, so be sure to check [hasId] beforehand.
   */
  @JvmStatic
  public final fun removeId(id: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.removeIdPtr)
  }

  /**
   * Converts the provided [uid] to a path. Prints an error if the UID is invalid.
   */
  @JvmStatic
  public final fun uidToPath(uid: String): String {
    TransferContext.writeMethodArguments_STRING(0L, 0L, uid)
    TransferContext.callMethod(MethodBindings.uidToPathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Converts the provided resource [path] to a UID. Returns the unchanged path if it has no
   * associated UID.
   */
  @JvmStatic
  public final fun pathToUid(path: String): String {
    TransferContext.writeMethodArguments_STRING(0L, 0L, path)
    TransferContext.callMethod(MethodBindings.pathToUidPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a path, converting [pathOrUid] if necessary. Fails and returns an empty string if an
   * invalid UID is provided.
   */
  @JvmStatic
  public final fun ensurePath(pathOrUid: String): String {
    TransferContext.writeMethodArguments_STRING(0L, 0L, pathOrUid)
    TransferContext.callMethod(MethodBindings.ensurePathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public object MethodBindings {
    internal val idToTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "id_to_text", 844755477)

    internal val textToIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "text_to_id", 1321353865)

    internal val createIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "create_id", 2455072627)

    internal val createIdForPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "create_id_for_path", 1597066294)

    internal val hasIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "has_id", 1116898809)

    internal val addIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "add_id", 501894301)

    internal val setIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "set_id", 501894301)

    internal val getIdPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "get_id_path", 844755477)

    internal val removeIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "remove_id", 1286410249)

    internal val uidToPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "uid_to_path", 1703090593)

    internal val pathToUidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "path_to_uid", 1703090593)

    internal val ensurePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourceUID", "ensure_path", 1703090593)
  }
}
