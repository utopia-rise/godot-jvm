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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Generic 2D position hint for editing. It's just like a plain [Node2D], but it displays as a cross
 * in the 2D editor at all times. You can set the cross' visual size by using the gizmo in the 2D
 * editor while the node is selected.
 */
@GodotBaseType
public open class Marker2D : Node2D() {
  /**
   * Size of the gizmo cross that appears in the editor.
   */
  public final inline var gizmoExtents: Float
    @JvmName("gizmoExtentsProperty")
    get() = getGizmoExtents()
    @JvmName("gizmoExtentsProperty")
    set(`value`) {
      setGizmoExtents(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(367, scriptPtr)
  }

  public final fun setGizmoExtents(extents: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, extents.toDouble())
    TransferContext.callMethod(MethodBindings.setGizmoExtentsPtr)
  }

  public final fun getGizmoExtents(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGizmoExtentsPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setGizmoExtentsName: MethodStringName1<Marker2D, Unit, Float> =
        MethodStringName1<Marker2D, Unit, Float>("set_gizmo_extents")

    @JvmField
    public val getGizmoExtentsName: MethodStringName0<Marker2D, Float> =
        MethodStringName0<Marker2D, Float>("get_gizmo_extents")
  }

  public object MethodBindings {
    internal val setGizmoExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marker2D", "set_gizmo_extents", 373806689)

    internal val getGizmoExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marker2D", "get_gizmo_extents", 1740695150)
  }
}
