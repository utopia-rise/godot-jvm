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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base class of [SkeletonModifier3D]s that has some joint lists and applies inverse kinematics.
 * This class has some structs, enums, and helper methods which are useful to solve inverse kinematics.
 */
@GodotBaseType
public open class IKModifier3D internal constructor() : SkeletonModifier3D() {
  /**
   * If `true`, the solver retrieves the bone axis from the bone pose every frame.
   *
   * If `false`, the solver retrieves the bone axis from the bone rest and caches it, which
   * increases performance slightly, but position changes in the bone pose made before processing this
   * [IKModifier3D] are ignored.
   */
  public final inline var mutableBoneAxes: Boolean
    @JvmName("mutableBoneAxesProperty")
    get() = areBoneAxesMutable()
    @JvmName("mutableBoneAxesProperty")
    set(`value`) {
      setMutableBoneAxes(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(296, scriptPtr)
  }

  /**
   * Sets the number of settings.
   */
  public final fun setSettingCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setSettingCountPtr)
  }

  /**
   * Returns the number of settings.
   */
  public final fun getSettingCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSettingCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Clears all settings.
   */
  public final fun clearSettings(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearSettingsPtr)
  }

  public final fun setMutableBoneAxes(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setMutableBoneAxesPtr)
  }

  public final fun areBoneAxesMutable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areBoneAxesMutablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Resets a state with respect to the current bone pose.
   */
  public final fun reset(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetPtr)
  }

  public companion object {
    @JvmField
    public val setSettingCountName: MethodStringName1<IKModifier3D, Unit, Int> =
        MethodStringName1<IKModifier3D, Unit, Int>("set_setting_count")

    @JvmField
    public val getSettingCountName: MethodStringName0<IKModifier3D, Int> =
        MethodStringName0<IKModifier3D, Int>("get_setting_count")

    @JvmField
    public val clearSettingsName: MethodStringName0<IKModifier3D, Unit> =
        MethodStringName0<IKModifier3D, Unit>("clear_settings")

    @JvmField
    public val setMutableBoneAxesName: MethodStringName1<IKModifier3D, Unit, Boolean> =
        MethodStringName1<IKModifier3D, Unit, Boolean>("set_mutable_bone_axes")

    @JvmField
    public val areBoneAxesMutableName: MethodStringName0<IKModifier3D, Boolean> =
        MethodStringName0<IKModifier3D, Boolean>("are_bone_axes_mutable")

    @JvmField
    public val resetName: MethodStringName0<IKModifier3D, Unit> =
        MethodStringName0<IKModifier3D, Unit>("reset")
  }

  public object MethodBindings {
    internal val setSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "set_setting_count", 1286410249)

    internal val getSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "get_setting_count", 3905245786)

    internal val clearSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "clear_settings", 3218959716)

    internal val setMutableBoneAxesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "set_mutable_bone_axes", 2586408642)

    internal val areBoneAxesMutablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "are_bone_axes_mutable", 36873697)

    internal val resetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IKModifier3D", "reset", 3218959716)
  }
}
