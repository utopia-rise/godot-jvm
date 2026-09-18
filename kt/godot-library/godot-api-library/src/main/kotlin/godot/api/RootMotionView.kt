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
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_COLOR
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_COLOR
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * *Root motion* refers to an animation technique where a mesh's skeleton is used to give impulse to
 * a character. When working with 3D animations, a popular technique is for animators to use the root
 * skeleton bone to give motion to the rest of the skeleton. This allows animating characters in a way
 * where steps actually match the floor below. It also allows precise interaction with objects during
 * cinematics. See also [AnimationMixer].
 *
 * **Note:** [RootMotionView] is only visible in the editor. It will be hidden automatically in the
 * running project.
 */
@GodotBaseType
public open class RootMotionView : VisualInstance3D() {
  /**
   * Path to an [AnimationMixer] node to use as a basis for root motion.
   */
  public final inline var animationPath: NodePath
    @JvmName("animationPathProperty")
    get() = getAnimationPath()
    @JvmName("animationPathProperty")
    set(`value`) {
      setAnimationPath(value)
    }

  /**
   * The grid's color.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getColor()
    @JvmName("colorProperty")
    set(`value`) {
      setColor(value)
    }

  /**
   * The grid's cell size in 3D units.
   */
  public final inline var cellSize: Float
    @JvmName("cellSizeProperty")
    get() = getCellSize()
    @JvmName("cellSizeProperty")
    set(`value`) {
      setCellSize(value)
    }

  /**
   * The grid's radius in 3D units. The grid's opacity will fade gradually as the distance from the
   * origin increases until this [radius] is reached.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * If `true`, the grid's points will all be on the same Y coordinate (*local* Y = 0). If `false`,
   * the points' original Y coordinate is preserved.
   */
  public final inline var zeroY: Boolean
    @JvmName("zeroYProperty")
    get() = getZeroY()
    @JvmName("zeroYProperty")
    set(`value`) {
      setZeroY(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(635, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rootmotionview.color
   * //Your changes
   * rootmotionview.color = myCoreType
   * ``````
   *
   * The grid's color.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  public final fun setAnimationPath(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callPtrMethod(MethodBindings.setAnimationPathPtr, 0)
  }

  public final fun getAnimationPath(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAnimationPathPtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.writeMethodArguments_COLOR(ptr, objectID.id, color)
    TransferContext.callPtrMethod(MethodBindings.setColorPtr, 0)
  }

  public final fun getColor(): Color {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColorPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  public final fun setCellSize(size: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, size.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCellSizePtr, 0)
  }

  public final fun getCellSize(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCellSizePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRadius(size: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, size.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRadiusPtr, 0)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setZeroY(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setZeroYPtr, 0)
  }

  public final fun getZeroY(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getZeroYPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAnimationPath(path: String) = setAnimationPath(path.asCachedNodePath())

  public companion object {
    @JvmField
    public val setAnimationPathName: MethodStringName1<RootMotionView, Unit, NodePath> =
        MethodStringName1<RootMotionView, Unit, NodePath>("set_animation_path")

    @JvmField
    public val getAnimationPathName: MethodStringName0<RootMotionView, NodePath> =
        MethodStringName0<RootMotionView, NodePath>("get_animation_path")

    @JvmField
    public val setColorName: MethodStringName1<RootMotionView, Unit, Color> =
        MethodStringName1<RootMotionView, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<RootMotionView, Color> =
        MethodStringName0<RootMotionView, Color>("get_color")

    @JvmField
    public val setCellSizeName: MethodStringName1<RootMotionView, Unit, Float> =
        MethodStringName1<RootMotionView, Unit, Float>("set_cell_size")

    @JvmField
    public val getCellSizeName: MethodStringName0<RootMotionView, Float> =
        MethodStringName0<RootMotionView, Float>("get_cell_size")

    @JvmField
    public val setRadiusName: MethodStringName1<RootMotionView, Unit, Float> =
        MethodStringName1<RootMotionView, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<RootMotionView, Float> =
        MethodStringName0<RootMotionView, Float>("get_radius")

    @JvmField
    public val setZeroYName: MethodStringName1<RootMotionView, Unit, Boolean> =
        MethodStringName1<RootMotionView, Unit, Boolean>("set_zero_y")

    @JvmField
    public val getZeroYName: MethodStringName0<RootMotionView, Boolean> =
        MethodStringName0<RootMotionView, Boolean>("get_zero_y")
  }

  public object MethodBindings {
    internal val setAnimationPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "set_animation_path", 1348162250)

    internal val getAnimationPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "get_animation_path", 4075236667)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "get_color", 3444240500)

    internal val setCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "set_cell_size", 373806689)

    internal val getCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "get_cell_size", 1740695150)

    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "get_radius", 1740695150)

    internal val setZeroYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "set_zero_y", 2586408642)

    internal val getZeroYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RootMotionView", "get_zero_y", 36873697)
  }
}
