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
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A ParallaxLayer must be the child of a [ParallaxBackground] node. Each ParallaxLayer can be set
 * to move at different speeds relative to the camera movement or the [ParallaxBackground.scrollOffset]
 * value.
 *
 * This node's children will be affected by its scroll offset.
 *
 * **Note:** Any changes to this node's position and scale made after it enters the scene will be
 * ignored.
 */
@GodotBaseType
public open class ParallaxLayer : Node2D() {
  /**
   * Multiplies the ParallaxLayer's motion. If an axis is set to `0`, it will not scroll.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var motionScale: Vector2
    @JvmName("motionScaleProperty")
    get() = getMotionScale()
    @JvmName("motionScaleProperty")
    set(`value`) {
      setMotionScale(value)
    }

  /**
   * The ParallaxLayer's offset relative to the parent ParallaxBackground's
   * [ParallaxBackground.scrollOffset].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var motionOffset: Vector2
    @JvmName("motionOffsetProperty")
    get() = getMotionOffset()
    @JvmName("motionOffsetProperty")
    set(`value`) {
      setMotionOffset(value)
    }

  /**
   * The interval, in pixels, at which the [ParallaxLayer] is drawn repeatedly. Useful for creating
   * an infinitely scrolling background. If an axis is set to `0`, the [ParallaxLayer] will be drawn
   * only once along that direction.
   *
   * **Note:** If you want the repetition to pixel-perfect match a [Texture2D] displayed by a child
   * node, you should account for any scale applied to the texture when defining this interval. For
   * example, if you use a child [Sprite2D] scaled to `0.5` to display a 600x600 texture, and want this
   * sprite to be repeated continuously horizontally, you should set the mirroring to `Vector2(300,
   * 0)`.
   *
   * **Note:** If the length of the viewport axis is bigger than twice the repeated axis size, it
   * will not repeat infinitely, as the parallax layer only draws 2 instances of the layer at any given
   * time. The visibility window is calculated from the parent [ParallaxBackground]'s position, not the
   * layer's own position. So, if you use mirroring, **do not** change the [ParallaxLayer] position
   * relative to its parent. Instead, if you need to adjust the background's position, set the
   * [CanvasLayer.offset] property in the parent [ParallaxBackground].
   *
   * **Note:** Despite the name, the layer will not be mirrored, it will only be repeated.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var motionMirroring: Vector2
    @JvmName("motionMirroringProperty")
    get() = getMirroring()
    @JvmName("motionMirroringProperty")
    set(`value`) {
      setMirroring(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(513, scriptPtr)
  }

  /**
   * This is a helper function for [motionScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionScale
   * //Your changes
   * parallaxlayer.motionScale = myCoreType
   * ``````
   *
   * Multiplies the ParallaxLayer's motion. If an axis is set to `0`, it will not scroll.
   */
  @CoreTypeHelper
  public final fun motionScaleMutate(block: Vector2.() -> Unit): Vector2 = motionScale.apply {
     block(this)
     motionScale = this
  }

  /**
   * This is a helper function for [motionOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionOffset
   * //Your changes
   * parallaxlayer.motionOffset = myCoreType
   * ``````
   *
   * The ParallaxLayer's offset relative to the parent ParallaxBackground's
   * [ParallaxBackground.scrollOffset].
   */
  @CoreTypeHelper
  public final fun motionOffsetMutate(block: Vector2.() -> Unit): Vector2 = motionOffset.apply {
     block(this)
     motionOffset = this
  }

  /**
   * This is a helper function for [motionMirroring] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxlayer.motionMirroring
   * //Your changes
   * parallaxlayer.motionMirroring = myCoreType
   * ``````
   *
   * The interval, in pixels, at which the [ParallaxLayer] is drawn repeatedly. Useful for creating
   * an infinitely scrolling background. If an axis is set to `0`, the [ParallaxLayer] will be drawn
   * only once along that direction.
   *
   * **Note:** If you want the repetition to pixel-perfect match a [Texture2D] displayed by a child
   * node, you should account for any scale applied to the texture when defining this interval. For
   * example, if you use a child [Sprite2D] scaled to `0.5` to display a 600x600 texture, and want this
   * sprite to be repeated continuously horizontally, you should set the mirroring to `Vector2(300,
   * 0)`.
   *
   * **Note:** If the length of the viewport axis is bigger than twice the repeated axis size, it
   * will not repeat infinitely, as the parallax layer only draws 2 instances of the layer at any given
   * time. The visibility window is calculated from the parent [ParallaxBackground]'s position, not the
   * layer's own position. So, if you use mirroring, **do not** change the [ParallaxLayer] position
   * relative to its parent. Instead, if you need to adjust the background's position, set the
   * [CanvasLayer.offset] property in the parent [ParallaxBackground].
   *
   * **Note:** Despite the name, the layer will not be mirrored, it will only be repeated.
   */
  @CoreTypeHelper
  public final fun motionMirroringMutate(block: Vector2.() -> Unit): Vector2 =
      motionMirroring.apply {
     block(this)
     motionMirroring = this
  }

  public final fun setMotionScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setMotionScalePtr)
  }

  public final fun getMotionScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionScalePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMotionOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setMotionOffsetPtr)
  }

  public final fun getMotionOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMirroring(mirror: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to mirror)
    TransferContext.callMethod(MethodBindings.setMirroringPtr)
  }

  public final fun getMirroring(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMirroringPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setMotionScaleName: MethodStringName1<ParallaxLayer, Unit, Vector2> =
        MethodStringName1<ParallaxLayer, Unit, Vector2>("set_motion_scale")

    @JvmField
    public val getMotionScaleName: MethodStringName0<ParallaxLayer, Vector2> =
        MethodStringName0<ParallaxLayer, Vector2>("get_motion_scale")

    @JvmField
    public val setMotionOffsetName: MethodStringName1<ParallaxLayer, Unit, Vector2> =
        MethodStringName1<ParallaxLayer, Unit, Vector2>("set_motion_offset")

    @JvmField
    public val getMotionOffsetName: MethodStringName0<ParallaxLayer, Vector2> =
        MethodStringName0<ParallaxLayer, Vector2>("get_motion_offset")

    @JvmField
    public val setMirroringName: MethodStringName1<ParallaxLayer, Unit, Vector2> =
        MethodStringName1<ParallaxLayer, Unit, Vector2>("set_mirroring")

    @JvmField
    public val getMirroringName: MethodStringName0<ParallaxLayer, Vector2> =
        MethodStringName0<ParallaxLayer, Vector2>("get_mirroring")
  }

  public object MethodBindings {
    internal val setMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_motion_scale", 743155724)

    internal val getMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_motion_scale", 3341600327)

    internal val setMotionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_motion_offset", 743155724)

    internal val getMotionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_motion_offset", 3341600327)

    internal val setMirroringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "set_mirroring", 743155724)

    internal val getMirroringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxLayer", "get_mirroring", 3341600327)
  }
}
