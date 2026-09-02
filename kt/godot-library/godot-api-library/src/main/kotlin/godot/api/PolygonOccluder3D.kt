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
import godot.core.PackedVector2Array
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.Vector2
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [PolygonOccluder3D] stores a polygon shape that can be used by the engine's occlusion culling
 * system. When an [OccluderInstance3D] with a [PolygonOccluder3D] is selected in the editor, an editor
 * will appear at the top of the 3D viewport so you can add/remove points. All points must be placed on
 * the same 2D plane, which means it is not possible to create arbitrary 3D shapes with a single
 * [PolygonOccluder3D]. To use arbitrary 3D shapes as occluders, use [ArrayOccluder3D] or
 * [OccluderInstance3D]'s baking feature instead.
 *
 * See [OccluderInstance3D]'s documentation for instructions on setting up occlusion culling.
 */
@GodotBaseType
public open class PolygonOccluder3D : Occluder3D() {
  /**
   * The polygon to use for occlusion culling. The polygon can be convex or concave, but it should
   * have as few points as possible to maximize performance.
   *
   * The polygon must *not* have intersecting lines. Otherwise, triangulation will fail (with an
   * error message printed).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var polygon: PackedVector2Array
    @JvmName("polygonProperty")
    get() = getPolygon()
    @JvmName("polygonProperty")
    set(`value`) {
      setPolygon(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(564, scriptPtr)
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygonoccluder3d.polygon
   * //Your changes
   * polygonoccluder3d.polygon = myCoreType
   * ``````
   *
   * The polygon to use for occlusion culling. The polygon can be convex or concave, but it should
   * have as few points as possible to maximize performance.
   *
   * The polygon must *not* have intersecting lines. Otherwise, triangulation will fail (with an
   * error message printed).
   */
  @CoreTypeHelper
  public final fun polygonMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      polygon.apply {
     block(this)
     polygon = this
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The polygon to use for occlusion culling. The polygon can be convex or concave, but it should
   * have as few points as possible to maximize performance.
   *
   * The polygon must *not* have intersecting lines. Otherwise, triangulation will fail (with an
   * error message printed).
   */
  @CoreTypeHelper
  public final fun polygonMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = polygon.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     polygon = this
  }

  public final fun setPolygon(polygon: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.setPolygonPtr)
  }

  public final fun getPolygon(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPolygonPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public companion object {
    @JvmField
    public val setPolygonName: MethodStringName1<PolygonOccluder3D, Unit, PackedVector2Array> =
        MethodStringName1<PolygonOccluder3D, Unit, PackedVector2Array>("set_polygon")

    @JvmField
    public val getPolygonName: MethodStringName0<PolygonOccluder3D, PackedVector2Array> =
        MethodStringName0<PolygonOccluder3D, PackedVector2Array>("get_polygon")
  }

  public object MethodBindings {
    internal val setPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonOccluder3D", "set_polygon", 1509147220)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonOccluder3D", "get_polygon", 2961356807)
  }
}
