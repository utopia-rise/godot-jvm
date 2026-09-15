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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Class representing a torus [PrimitiveMesh].
 */
@GodotBaseType
public open class TorusMesh : PrimitiveMesh() {
  /**
   * The inner radius of the torus.
   */
  public final inline var innerRadius: Float
    @JvmName("innerRadiusProperty")
    get() = getInnerRadius()
    @JvmName("innerRadiusProperty")
    set(`value`) {
      setInnerRadius(value)
    }

  /**
   * The outer radius of the torus.
   */
  public final inline var outerRadius: Float
    @JvmName("outerRadiusProperty")
    get() = getOuterRadius()
    @JvmName("outerRadiusProperty")
    set(`value`) {
      setOuterRadius(value)
    }

  /**
   * The number of slices the torus is constructed of.
   */
  public final inline var rings: Int
    @JvmName("ringsProperty")
    get() = getRings()
    @JvmName("ringsProperty")
    set(`value`) {
      setRings(value)
    }

  /**
   * The number of edges each ring of the torus is constructed of.
   */
  public final inline var ringSegments: Int
    @JvmName("ringSegmentsProperty")
    get() = getRingSegments()
    @JvmName("ringSegmentsProperty")
    set(`value`) {
      setRingSegments(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(766, scriptPtr)
  }

  public final fun setInnerRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setInnerRadiusPtr, 0)
  }

  public final fun getInnerRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInnerRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setOuterRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setOuterRadiusPtr, 0)
  }

  public final fun getOuterRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOuterRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRings(rings: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, rings.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRingsPtr, 0)
  }

  public final fun getRings(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRingsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setRingSegments(rings: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, rings.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRingSegmentsPtr, 0)
  }

  public final fun getRingSegments(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRingSegmentsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setInnerRadiusName: MethodStringName1<TorusMesh, Unit, Float> =
        MethodStringName1<TorusMesh, Unit, Float>("set_inner_radius")

    @JvmField
    public val getInnerRadiusName: MethodStringName0<TorusMesh, Float> =
        MethodStringName0<TorusMesh, Float>("get_inner_radius")

    @JvmField
    public val setOuterRadiusName: MethodStringName1<TorusMesh, Unit, Float> =
        MethodStringName1<TorusMesh, Unit, Float>("set_outer_radius")

    @JvmField
    public val getOuterRadiusName: MethodStringName0<TorusMesh, Float> =
        MethodStringName0<TorusMesh, Float>("get_outer_radius")

    @JvmField
    public val setRingsName: MethodStringName1<TorusMesh, Unit, Int> =
        MethodStringName1<TorusMesh, Unit, Int>("set_rings")

    @JvmField
    public val getRingsName: MethodStringName0<TorusMesh, Int> =
        MethodStringName0<TorusMesh, Int>("get_rings")

    @JvmField
    public val setRingSegmentsName: MethodStringName1<TorusMesh, Unit, Int> =
        MethodStringName1<TorusMesh, Unit, Int>("set_ring_segments")

    @JvmField
    public val getRingSegmentsName: MethodStringName0<TorusMesh, Int> =
        MethodStringName0<TorusMesh, Int>("get_ring_segments")
  }

  public object MethodBindings {
    internal val setInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "set_inner_radius", 373806689)

    internal val getInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "get_inner_radius", 1740695150)

    internal val setOuterRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "set_outer_radius", 373806689)

    internal val getOuterRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "get_outer_radius", 1740695150)

    internal val setRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "set_rings", 1286410249)

    internal val getRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "get_rings", 3905245786)

    internal val setRingSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "set_ring_segments", 1286410249)

    internal val getRingSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TorusMesh", "get_ring_segments", 3905245786)
  }
}
