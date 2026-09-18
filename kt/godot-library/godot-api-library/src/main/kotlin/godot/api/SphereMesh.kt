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
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Class representing a spherical [PrimitiveMesh].
 */
@GodotBaseType
public open class SphereMesh : PrimitiveMesh() {
  /**
   * Radius of sphere.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * Full height of the sphere.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * Number of radial segments on the sphere.
   */
  public final inline var radialSegments: Int
    @JvmName("radialSegmentsProperty")
    get() = getRadialSegments()
    @JvmName("radialSegmentsProperty")
    set(`value`) {
      setRadialSegments(value)
    }

  /**
   * Number of segments along the height of the sphere.
   */
  public final inline var rings: Int
    @JvmName("ringsProperty")
    get() = getRings()
    @JvmName("ringsProperty")
    set(`value`) {
      setRings(value)
    }

  /**
   * If `true`, a hemisphere is created rather than a full sphere.
   *
   * **Note:** To get a regular hemisphere, the height and radius of the sphere must be equal.
   */
  public final inline var isHemisphere: Boolean
    @JvmName("isHemisphereProperty")
    get() = getIsHemisphere()
    @JvmName("isHemisphereProperty")
    set(`value`) {
      setIsHemisphere(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(686, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRadiusPtr, 0)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setHeight(height: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, height.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setHeightPtr, 0)
  }

  public final fun getHeight(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHeightPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRadialSegments(radialSegments: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, radialSegments.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRadialSegmentsPtr, 0)
  }

  public final fun getRadialSegments(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadialSegmentsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
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

  public final fun setIsHemisphere(isHemisphere: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, isHemisphere)
    TransferContext.callPtrMethod(MethodBindings.setIsHemispherePtr, 0)
  }

  public final fun getIsHemisphere(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIsHemispherePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<SphereMesh, Unit, Float> =
        MethodStringName1<SphereMesh, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<SphereMesh, Float> =
        MethodStringName0<SphereMesh, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<SphereMesh, Unit, Float> =
        MethodStringName1<SphereMesh, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<SphereMesh, Float> =
        MethodStringName0<SphereMesh, Float>("get_height")

    @JvmField
    public val setRadialSegmentsName: MethodStringName1<SphereMesh, Unit, Int> =
        MethodStringName1<SphereMesh, Unit, Int>("set_radial_segments")

    @JvmField
    public val getRadialSegmentsName: MethodStringName0<SphereMesh, Int> =
        MethodStringName0<SphereMesh, Int>("get_radial_segments")

    @JvmField
    public val setRingsName: MethodStringName1<SphereMesh, Unit, Int> =
        MethodStringName1<SphereMesh, Unit, Int>("set_rings")

    @JvmField
    public val getRingsName: MethodStringName0<SphereMesh, Int> =
        MethodStringName0<SphereMesh, Int>("get_rings")

    @JvmField
    public val setIsHemisphereName: MethodStringName1<SphereMesh, Unit, Boolean> =
        MethodStringName1<SphereMesh, Unit, Boolean>("set_is_hemisphere")

    @JvmField
    public val getIsHemisphereName: MethodStringName0<SphereMesh, Boolean> =
        MethodStringName0<SphereMesh, Boolean>("get_is_hemisphere")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "get_height", 1740695150)

    internal val setRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "set_radial_segments", 1286410249)

    internal val getRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "get_radial_segments", 3905245786)

    internal val setRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "set_rings", 1286410249)

    internal val getRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "get_rings", 3905245786)

    internal val setIsHemispherePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "set_is_hemisphere", 2586408642)

    internal val getIsHemispherePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereMesh", "get_is_hemisphere", 36873697)
  }
}
