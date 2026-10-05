// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_BOOL_ret_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName4
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This resource provides an interface that can be expanded so code that operates on [Bone2D] nodes
 * in a [Skeleton2D] can be mixed and matched together to create complex interactions.
 *
 * This is used to provide Godot with a flexible and powerful Inverse Kinematics solution that can
 * be adapted for many different uses.
 */
@GodotBaseType
public open class SkeletonModification2D : Resource() {
  /**
   * If `true`, the modification's [_execute] function will be called by the
   * [SkeletonModificationStack2D].
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = getEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The execution mode for the modification. This tells the modification stack when to execute the
   * modification. Some modifications have settings that are only available in certain execution modes.
   */
  public final inline var executionMode: Int
    @JvmName("executionModeProperty")
    get() = getExecutionMode()
    @JvmName("executionModeProperty")
    set(`value`) {
      setExecutionMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(667, scriptPtr)
  }

  /**
   * Executes the given modification. This is where the modification performs whatever function it
   * is designed to do.
   */
  public open fun _execute(delta: Double): Unit {
    throw NotImplementedError("SkeletonModification2D::_execute is not implemented.")
  }

  /**
   * Called when the modification is setup. This is where the modification performs initialization.
   */
  public open fun _setupModification(modificationStack: SkeletonModificationStack2D?): Unit {
    throw NotImplementedError("SkeletonModification2D::_setupModification is not implemented.")
  }

  /**
   * Used for drawing **editor-only** modification gizmos. This function will only be called in the
   * Godot editor and can be overridden to draw custom gizmos.
   *
   * **Note:** You will need to use the Skeleton2D from [SkeletonModificationStack2D.getSkeleton]
   * and it's draw functions, as the [SkeletonModification2D] resource cannot draw on its own.
   */
  public open fun _drawEditorGizmo(): Unit {
    throw NotImplementedError("SkeletonModification2D::_drawEditorGizmo is not implemented.")
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnabledPtr, enabled)
  }

  public final fun getEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnabledPtr)

  /**
   * Returns the [SkeletonModificationStack2D] that this modification is bound to. Through the
   * modification stack, you can access the Skeleton2D the modification is operating on.
   */
  public final fun getModificationStack(): SkeletonModificationStack2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getModificationStackPtr) as SkeletonModificationStack2D?)

  /**
   * Manually allows you to set the setup state of the modification. This function should only
   * rarely be used, as the [SkeletonModificationStack2D] the modification is bound to should handle
   * setting the modification up.
   */
  public final fun setIsSetup(isSetup: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setIsSetupPtr, isSetup)
  }

  /**
   * Returns whether this modification has been successfully setup or not.
   */
  public final fun getIsSetup(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getIsSetupPtr)

  public final fun setExecutionMode(executionMode: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setExecutionModePtr, executionMode.toLong())
  }

  public final fun getExecutionMode(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getExecutionModePtr).toInt()

  /**
   * Takes an angle and clamps it so it is within the passed-in [min] and [max] range. [invert] will
   * inversely clamp the angle, clamping it to the range outside of the given bounds.
   */
  public final fun clampAngle(
    angle: Float,
    min: Float,
    max: Float,
    invert: Boolean,
  ): Float =
      TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_BOOL_ret_DOUBLE(ptr, objectID.id, MethodBindings.clampAnglePtr, angle.toDouble(), min.toDouble(), max.toDouble(), invert).toFloat()

  /**
   * Sets whether this modification will call [_drawEditorGizmo] in the Godot editor to draw
   * modification-specific gizmos.
   */
  public final fun setEditorDrawGizmo(drawGizmo: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEditorDrawGizmoPtr, drawGizmo)
  }

  /**
   * Returns whether this modification will call [_drawEditorGizmo] in the Godot editor to draw
   * modification-specific gizmos.
   */
  public final fun getEditorDrawGizmo(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEditorDrawGizmoPtr)

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<SkeletonModification2D, Unit, Boolean> =
        MethodStringName1<SkeletonModification2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val getEnabledName: MethodStringName0<SkeletonModification2D, Boolean> =
        MethodStringName0<SkeletonModification2D, Boolean>("get_enabled")

    @JvmField
    public val getModificationStackName:
        MethodStringName0<SkeletonModification2D, SkeletonModificationStack2D?> =
        MethodStringName0<SkeletonModification2D, SkeletonModificationStack2D?>("get_modification_stack")

    @JvmField
    public val setIsSetupName: MethodStringName1<SkeletonModification2D, Unit, Boolean> =
        MethodStringName1<SkeletonModification2D, Unit, Boolean>("set_is_setup")

    @JvmField
    public val getIsSetupName: MethodStringName0<SkeletonModification2D, Boolean> =
        MethodStringName0<SkeletonModification2D, Boolean>("get_is_setup")

    @JvmField
    public val setExecutionModeName: MethodStringName1<SkeletonModification2D, Unit, Int> =
        MethodStringName1<SkeletonModification2D, Unit, Int>("set_execution_mode")

    @JvmField
    public val getExecutionModeName: MethodStringName0<SkeletonModification2D, Int> =
        MethodStringName0<SkeletonModification2D, Int>("get_execution_mode")

    @JvmField
    public val clampAngleName:
        MethodStringName4<SkeletonModification2D, Float, Float, Float, Float, Boolean> =
        MethodStringName4<SkeletonModification2D, Float, Float, Float, Float, Boolean>("clamp_angle")

    @JvmField
    public val setEditorDrawGizmoName: MethodStringName1<SkeletonModification2D, Unit, Boolean> =
        MethodStringName1<SkeletonModification2D, Unit, Boolean>("set_editor_draw_gizmo")

    @JvmField
    public val getEditorDrawGizmoName: MethodStringName0<SkeletonModification2D, Boolean> =
        MethodStringName0<SkeletonModification2D, Boolean>("get_editor_draw_gizmo")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "set_enabled", 2586408642)

    internal val getEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "get_enabled", 2240911060)

    internal val getModificationStackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "get_modification_stack", 2137761694)

    internal val setIsSetupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "set_is_setup", 2586408642)

    internal val getIsSetupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "get_is_setup", 36873697)

    internal val setExecutionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "set_execution_mode", 1286410249)

    internal val getExecutionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "get_execution_mode", 3905245786)

    internal val clampAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "clamp_angle", 1229502682)

    internal val setEditorDrawGizmoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "set_editor_draw_gizmo", 2586408642)

    internal val getEditorDrawGizmoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2D", "get_editor_draw_gizmo", 36873697)
  }
}
