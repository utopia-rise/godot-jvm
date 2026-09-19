// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Class representing a capsule-shaped [PrimitiveMesh].
 */
@GodotBaseType
public open class CapsuleMesh : PrimitiveMesh() {
  /**
   * Radius of the capsule mesh.
   *
   * **Note:** The [radius] of a capsule cannot be greater than half of its [height]. Otherwise, the
   * capsule becomes a circle. If the [radius] is greater than half of the [height], the properties
   * adjust to a valid value.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * Total height of the capsule mesh (including the hemispherical ends).
   *
   * **Note:** The [height] of a capsule must be at least twice its [radius]. Otherwise, the capsule
   * becomes a circle. If the [height] is less than twice the [radius], the properties adjust to a
   * valid value.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * Number of radial segments on the capsule mesh.
   */
  public final inline var radialSegments: Int
    @JvmName("radialSegmentsProperty")
    get() = getRadialSegments()
    @JvmName("radialSegmentsProperty")
    set(`value`) {
      setRadialSegments(value)
    }

  /**
   * Number of rings along the height of the capsule.
   */
  public final inline var rings: Int
    @JvmName("ringsProperty")
    get() = getRings()
    @JvmName("ringsProperty")
    set(`value`) {
      setRings(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(147, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRadiusPtr, radius.toDouble())
  }

  public final fun getRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRadiusPtr).toFloat()

  public final fun setHeight(height: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setHeightPtr, height.toDouble())
  }

  public final fun getHeight(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getHeightPtr).toFloat()

  public final fun setRadialSegments(segments: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRadialSegmentsPtr, segments.toLong())
  }

  public final fun getRadialSegments(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRadialSegmentsPtr).toInt()

  public final fun setRings(rings: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRingsPtr, rings.toLong())
  }

  public final fun getRings(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRingsPtr).toInt()

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CapsuleMesh, Unit, Float> =
        MethodStringName1<CapsuleMesh, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CapsuleMesh, Float> =
        MethodStringName0<CapsuleMesh, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<CapsuleMesh, Unit, Float> =
        MethodStringName1<CapsuleMesh, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<CapsuleMesh, Float> =
        MethodStringName0<CapsuleMesh, Float>("get_height")

    @JvmField
    public val setRadialSegmentsName: MethodStringName1<CapsuleMesh, Unit, Int> =
        MethodStringName1<CapsuleMesh, Unit, Int>("set_radial_segments")

    @JvmField
    public val getRadialSegmentsName: MethodStringName0<CapsuleMesh, Int> =
        MethodStringName0<CapsuleMesh, Int>("get_radial_segments")

    @JvmField
    public val setRingsName: MethodStringName1<CapsuleMesh, Unit, Int> =
        MethodStringName1<CapsuleMesh, Unit, Int>("set_rings")

    @JvmField
    public val getRingsName: MethodStringName0<CapsuleMesh, Int> =
        MethodStringName0<CapsuleMesh, Int>("get_rings")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "get_height", 1740695150)

    internal val setRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "set_radial_segments", 1286410249)

    internal val getRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "get_radial_segments", 3905245786)

    internal val setRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "set_rings", 1286410249)

    internal val getRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleMesh", "get_rings", 3905245786)
  }
}
