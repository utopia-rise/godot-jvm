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
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Positional tracker for our OpenXR spatial entity anchor extension, it tracks a user defined
 * location in real space and maps it to our virtual space.
 */
@GodotBaseType
public open class OpenXRAnchorTracker : OpenXRSpatialEntityTracker() {
  /**
   * Emitted when the UUID for this anchor was changed.
   */
  public val uuidChanged: Signal0 by Signal0

  /**
   * The UUID provided for persistent anchors.
   */
  public final inline var uuid: String
    @JvmName("uuidProperty")
    get() = getUuid()
    @JvmName("uuidProperty")
    set(`value`) {
      setUuid(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(442, scriptPtr)
  }

  /**
   * Returns `true` if a non-zero UUID is set.
   */
  public final fun hasUuid(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasUuidPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setUuid(uuid: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, uuid)
    TransferContext.callMethod(MethodBindings.setUuidPtr)
  }

  public final fun getUuid(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUuidPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val hasUuidName: MethodStringName0<OpenXRAnchorTracker, Boolean> =
        MethodStringName0<OpenXRAnchorTracker, Boolean>("has_uuid")

    @JvmField
    public val setUuidName: MethodStringName1<OpenXRAnchorTracker, Unit, String> =
        MethodStringName1<OpenXRAnchorTracker, Unit, String>("set_uuid")

    @JvmField
    public val getUuidName: MethodStringName0<OpenXRAnchorTracker, String> =
        MethodStringName0<OpenXRAnchorTracker, String>("get_uuid")
  }

  public object MethodBindings {
    internal val hasUuidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAnchorTracker", "has_uuid", 36873697)

    internal val setUuidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAnchorTracker", "set_uuid", 83702148)

    internal val getUuidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAnchorTracker", "get_uuid", 201670096)
  }
}
