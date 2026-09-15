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
import godot.core.VariantParser.DOUBLE
import kotlin.Double
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Generic 3D position hint for editing. It's just like a plain [Node3D], but it displays as a cross
 * in the 3D editor at all times.
 */
@GodotBaseType
public open class Marker3D : Node3D() {
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
    createNativeObject(368, scriptPtr)
  }

  public final fun setGizmoExtents(extents: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to extents.toDouble())
    TransferContext.callMethod(MethodBindings.setGizmoExtentsPtr)
  }

  public final fun getGizmoExtents(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGizmoExtentsPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setGizmoExtentsName: MethodStringName1<Marker3D, Unit, Float> =
        MethodStringName1<Marker3D, Unit, Float>("set_gizmo_extents")

    @JvmField
    public val getGizmoExtentsName: MethodStringName0<Marker3D, Float> =
        MethodStringName0<Marker3D, Float>("get_gizmo_extents")
  }

  public object MethodBindings {
    internal val setGizmoExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marker3D", "set_gizmo_extents", 373806689)

    internal val getGizmoExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marker3D", "get_gizmo_extents", 1740695150)
  }
}
