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
 * A 2D polyline shape, intended for use in physics. Used internally in [CollisionPolygon2D] when
 * it's in [CollisionPolygon2D.BUILD_SEGMENTS] mode.
 *
 * Being just a collection of interconnected line segments, [ConcavePolygonShape2D] is the most
 * freely configurable single 2D shape. It can be used to form polygons of any nature, or even shapes
 * that don't enclose an area. However, [ConcavePolygonShape2D] is *hollow* even if the interconnected
 * line segments do enclose an area, which often makes it unsuitable for physics or detection.
 *
 * **Note:** When used for collision, [ConcavePolygonShape2D] is intended to work with static
 * [CollisionShape2D] nodes like [StaticBody2D] and will likely not behave well for [CharacterBody2D]s
 * or [RigidBody2D]s in a mode other than Static.
 *
 * **Warning:** Physics bodies that are small have a chance to clip through this shape when moving
 * fast. This happens because on one frame, the physics body may be on the "outside" of the shape, and
 * on the next frame it may be "inside" it. [ConcavePolygonShape2D] is hollow, so it won't detect a
 * collision.
 *
 * **Performance:** Due to its complexity, [ConcavePolygonShape2D] is the slowest 2D collision shape
 * to check collisions against. Its use should generally be limited to level geometry. If the polyline
 * is closed, [CollisionPolygon2D]'s [CollisionPolygon2D.BUILD_SOLIDS] mode can be used, which
 * decomposes the polygon into convex ones; see [ConvexPolygonShape2D]'s documentation for
 * instructions.
 */
@GodotBaseType
public open class ConcavePolygonShape2D : Shape2D() {
  /**
   * The array of points that make up the [ConcavePolygonShape2D]'s line segments. The array (of
   * length divisible by two) is naturally divided into pairs (one pair for each segment); each pair
   * consists of the starting point of a segment and the endpoint of a segment.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var segments: PackedVector2Array
    @JvmName("segmentsProperty")
    get() = getSegments()
    @JvmName("segmentsProperty")
    set(`value`) {
      setSegments(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(181, scriptPtr)
  }

  /**
   * This is a helper function for [segments] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = concavepolygonshape2d.segments
   * //Your changes
   * concavepolygonshape2d.segments = myCoreType
   * ``````
   *
   * The array of points that make up the [ConcavePolygonShape2D]'s line segments. The array (of
   * length divisible by two) is naturally divided into pairs (one pair for each segment); each pair
   * consists of the starting point of a segment and the endpoint of a segment.
   */
  @CoreTypeHelper
  public final fun segmentsMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      segments.apply {
     block(this)
     segments = this
  }

  /**
   * This is a helper function for [segments] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The array of points that make up the [ConcavePolygonShape2D]'s line segments. The array (of
   * length divisible by two) is naturally divided into pairs (one pair for each segment); each pair
   * consists of the starting point of a segment and the endpoint of a segment.
   */
  @CoreTypeHelper
  public final fun segmentsMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = segments.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     segments = this
  }

  public final fun setSegments(segments: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to segments)
    TransferContext.callMethod(MethodBindings.setSegmentsPtr)
  }

  public final fun getSegments(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSegmentsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public companion object {
    @JvmField
    public val setSegmentsName: MethodStringName1<ConcavePolygonShape2D, Unit, PackedVector2Array> =
        MethodStringName1<ConcavePolygonShape2D, Unit, PackedVector2Array>("set_segments")

    @JvmField
    public val getSegmentsName: MethodStringName0<ConcavePolygonShape2D, PackedVector2Array> =
        MethodStringName0<ConcavePolygonShape2D, PackedVector2Array>("get_segments")
  }

  public object MethodBindings {
    internal val setSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape2D", "set_segments", 1509147220)

    internal val getSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape2D", "get_segments", 2961356807)
  }
}
