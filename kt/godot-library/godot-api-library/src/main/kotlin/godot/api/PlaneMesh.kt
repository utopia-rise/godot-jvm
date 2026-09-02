// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Class representing a planar [PrimitiveMesh]. This flat mesh does not have a thickness. By
 * default, this mesh is aligned on the X and Z axes; this default rotation isn't suited for use with
 * billboarded materials. For billboarded materials, change [orientation] to [FACE_Z].
 *
 * **Note:** When using a large textured [PlaneMesh] (e.g. as a floor), you may stumble upon UV
 * jittering issues depending on the camera angle. To solve this, increase [subdivideDepth] and
 * [subdivideWidth] until you no longer notice UV jittering.
 */
@GodotBaseType
public open class PlaneMesh : PrimitiveMesh() {
  /**
   * Size of the generated plane.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector2
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * Number of subdivision along the X axis.
   */
  public final inline var subdivideWidth: Int
    @JvmName("subdivideWidthProperty")
    get() = getSubdivideWidth()
    @JvmName("subdivideWidthProperty")
    set(`value`) {
      setSubdivideWidth(value)
    }

  /**
   * Number of subdivision along the Z axis.
   */
  public final inline var subdivideDepth: Int
    @JvmName("subdivideDepthProperty")
    get() = getSubdivideDepth()
    @JvmName("subdivideDepthProperty")
    set(`value`) {
      setSubdivideDepth(value)
    }

  /**
   * Offset of the generated plane. Useful for particles.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var centerOffset: Vector3
    @JvmName("centerOffsetProperty")
    get() = getCenterOffset()
    @JvmName("centerOffsetProperty")
    set(`value`) {
      setCenterOffset(value)
    }

  /**
   * Direction that the [PlaneMesh] is facing.
   */
  public final inline var orientation: Orientation
    @JvmName("orientationProperty")
    get() = getOrientation()
    @JvmName("orientationProperty")
    set(`value`) {
      setOrientation(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(560, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = planemesh.size
   * //Your changes
   * planemesh.size = myCoreType
   * ``````
   *
   * Size of the generated plane.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector2.() -> Unit): Vector2 = size.apply {
     block(this)
     size = this
  }

  /**
   * This is a helper function for [centerOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = planemesh.centerOffset
   * //Your changes
   * planemesh.centerOffset = myCoreType
   * ``````
   *
   * Offset of the generated plane. Useful for particles.
   */
  @CoreTypeHelper
  public final fun centerOffsetMutate(block: Vector3.() -> Unit): Vector3 = centerOffset.apply {
     block(this)
     centerOffset = this
  }

  public final fun setSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setSubdivideWidth(subdivide: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to subdivide.toLong())
    TransferContext.callMethod(MethodBindings.setSubdivideWidthPtr)
  }

  public final fun getSubdivideWidth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubdivideWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSubdivideDepth(subdivide: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to subdivide.toLong())
    TransferContext.callMethod(MethodBindings.setSubdivideDepthPtr)
  }

  public final fun getSubdivideDepth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubdivideDepthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCenterOffset(offset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to offset)
    TransferContext.callMethod(MethodBindings.setCenterOffsetPtr)
  }

  public final fun getCenterOffset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setOrientation(orientation: Orientation): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to orientation.value)
    TransferContext.callMethod(MethodBindings.setOrientationPtr)
  }

  public final fun getOrientation(): Orientation {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOrientationPtr)
    return Orientation.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class Orientation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * [PlaneMesh] will face the positive X-axis.
     */
    FACE_X(0),
    /**
     * [PlaneMesh] will face the positive Y-axis. This matches the behavior of the [PlaneMesh] in
     * Godot 3.x.
     */
    FACE_Y(1),
    /**
     * [PlaneMesh] will face the positive Z-axis. This matches the behavior of the QuadMesh in Godot
     * 3.x.
     */
    FACE_Z(2),
    ;

    public companion object {
      public fun from(`value`: Long): Orientation = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<PlaneMesh, Unit, Vector2> =
        MethodStringName1<PlaneMesh, Unit, Vector2>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<PlaneMesh, Vector2> =
        MethodStringName0<PlaneMesh, Vector2>("get_size")

    @JvmField
    public val setSubdivideWidthName: MethodStringName1<PlaneMesh, Unit, Int> =
        MethodStringName1<PlaneMesh, Unit, Int>("set_subdivide_width")

    @JvmField
    public val getSubdivideWidthName: MethodStringName0<PlaneMesh, Int> =
        MethodStringName0<PlaneMesh, Int>("get_subdivide_width")

    @JvmField
    public val setSubdivideDepthName: MethodStringName1<PlaneMesh, Unit, Int> =
        MethodStringName1<PlaneMesh, Unit, Int>("set_subdivide_depth")

    @JvmField
    public val getSubdivideDepthName: MethodStringName0<PlaneMesh, Int> =
        MethodStringName0<PlaneMesh, Int>("get_subdivide_depth")

    @JvmField
    public val setCenterOffsetName: MethodStringName1<PlaneMesh, Unit, Vector3> =
        MethodStringName1<PlaneMesh, Unit, Vector3>("set_center_offset")

    @JvmField
    public val getCenterOffsetName: MethodStringName0<PlaneMesh, Vector3> =
        MethodStringName0<PlaneMesh, Vector3>("get_center_offset")

    @JvmField
    public val setOrientationName: MethodStringName1<PlaneMesh, Unit, Orientation> =
        MethodStringName1<PlaneMesh, Unit, Orientation>("set_orientation")

    @JvmField
    public val getOrientationName: MethodStringName0<PlaneMesh, Orientation> =
        MethodStringName0<PlaneMesh, Orientation>("get_orientation")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "set_size", 743155724)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "get_size", 3341600327)

    internal val setSubdivideWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "set_subdivide_width", 1286410249)

    internal val getSubdivideWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "get_subdivide_width", 3905245786)

    internal val setSubdivideDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "set_subdivide_depth", 1286410249)

    internal val getSubdivideDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "get_subdivide_depth", 3905245786)

    internal val setCenterOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "set_center_offset", 3460891852)

    internal val getCenterOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "get_center_offset", 3360562783)

    internal val setOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "set_orientation", 2751399687)

    internal val getOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaneMesh", "get_orientation", 3227599250)
  }
}
