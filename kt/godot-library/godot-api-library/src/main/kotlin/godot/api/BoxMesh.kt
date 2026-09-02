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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Generate an axis-aligned box [PrimitiveMesh].
 *
 * The box's UV layout is arranged in a 3×2 layout that allows texturing each face individually. To
 * apply the same texture on all faces, change the material's UV property to `Vector3(3, 2, 1)`. This
 * is equivalent to adding `UV *= vec2(3.0, 2.0)` in a vertex shader.
 *
 * **Note:** When using a large textured [BoxMesh] (e.g. as a floor), you may stumble upon UV
 * jittering issues depending on the camera angle. To solve this, increase [subdivideDepth],
 * [subdivideHeight] and [subdivideWidth] until you no longer notice UV jittering.
 */
@GodotBaseType
public open class BoxMesh : PrimitiveMesh() {
  /**
   * The box's width, height and depth.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector3
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * Number of extra edge loops inserted along the X axis.
   */
  public final inline var subdivideWidth: Int
    @JvmName("subdivideWidthProperty")
    get() = getSubdivideWidth()
    @JvmName("subdivideWidthProperty")
    set(`value`) {
      setSubdivideWidth(value)
    }

  /**
   * Number of extra edge loops inserted along the Y axis.
   */
  public final inline var subdivideHeight: Int
    @JvmName("subdivideHeightProperty")
    get() = getSubdivideHeight()
    @JvmName("subdivideHeightProperty")
    set(`value`) {
      setSubdivideHeight(value)
    }

  /**
   * Number of extra edge loops inserted along the Z axis.
   */
  public final inline var subdivideDepth: Int
    @JvmName("subdivideDepthProperty")
    get() = getSubdivideDepth()
    @JvmName("subdivideDepthProperty")
    set(`value`) {
      setSubdivideDepth(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(117, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = boxmesh.size
   * //Your changes
   * boxmesh.size = myCoreType
   * ``````
   *
   * The box's width, height and depth.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
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

  public final fun setSubdivideHeight(divisions: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to divisions.toLong())
    TransferContext.callMethod(MethodBindings.setSubdivideHeightPtr)
  }

  public final fun getSubdivideHeight(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubdivideHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSubdivideDepth(divisions: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to divisions.toLong())
    TransferContext.callMethod(MethodBindings.setSubdivideDepthPtr)
  }

  public final fun getSubdivideDepth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubdivideDepthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<BoxMesh, Unit, Vector3> =
        MethodStringName1<BoxMesh, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<BoxMesh, Vector3> =
        MethodStringName0<BoxMesh, Vector3>("get_size")

    @JvmField
    public val setSubdivideWidthName: MethodStringName1<BoxMesh, Unit, Int> =
        MethodStringName1<BoxMesh, Unit, Int>("set_subdivide_width")

    @JvmField
    public val getSubdivideWidthName: MethodStringName0<BoxMesh, Int> =
        MethodStringName0<BoxMesh, Int>("get_subdivide_width")

    @JvmField
    public val setSubdivideHeightName: MethodStringName1<BoxMesh, Unit, Int> =
        MethodStringName1<BoxMesh, Unit, Int>("set_subdivide_height")

    @JvmField
    public val getSubdivideHeightName: MethodStringName0<BoxMesh, Int> =
        MethodStringName0<BoxMesh, Int>("get_subdivide_height")

    @JvmField
    public val setSubdivideDepthName: MethodStringName1<BoxMesh, Unit, Int> =
        MethodStringName1<BoxMesh, Unit, Int>("set_subdivide_depth")

    @JvmField
    public val getSubdivideDepthName: MethodStringName0<BoxMesh, Int> =
        MethodStringName0<BoxMesh, Int>("get_subdivide_depth")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "get_size", 3360562783)

    internal val setSubdivideWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "set_subdivide_width", 1286410249)

    internal val getSubdivideWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "get_subdivide_width", 3905245786)

    internal val setSubdivideHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "set_subdivide_height", 1286410249)

    internal val getSubdivideHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "get_subdivide_height", 3905245786)

    internal val setSubdivideDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "set_subdivide_depth", 1286410249)

    internal val getSubdivideDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoxMesh", "get_subdivide_depth", 3905245786)
  }
}
