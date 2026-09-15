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
import godot.readReturnValue_BOOL
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An animation node used to combine, mix, or blend two or more animations together while keeping
 * them synchronized within an [AnimationTree].
 */
@GodotBaseType
public open class AnimationNodeSync : AnimationNode() {
  /**
   * If `false`, the blended animations' frame are stopped when the blend value is `0`.
   *
   * If `true`, forcing the blended animations to advance frame.
   */
  public final inline var sync: Boolean
    @JvmName("syncProperty")
    get() = isUsingSync()
    @JvmName("syncProperty")
    set(`value`) {
      setUseSync(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(31, scriptPtr)
  }

  public final fun setUseSync(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setUseSyncPtr)
  }

  public final fun isUsingSync(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingSyncPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setUseSyncName: MethodStringName1<AnimationNodeSync, Unit, Boolean> =
        MethodStringName1<AnimationNodeSync, Unit, Boolean>("set_use_sync")

    @JvmField
    public val isUsingSyncName: MethodStringName0<AnimationNodeSync, Boolean> =
        MethodStringName0<AnimationNodeSync, Boolean>("is_using_sync")
  }

  public object MethodBindings {
    internal val setUseSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeSync", "set_use_sync", 2586408642)

    internal val isUsingSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeSync", "is_using_sync", 36873697)
  }
}
