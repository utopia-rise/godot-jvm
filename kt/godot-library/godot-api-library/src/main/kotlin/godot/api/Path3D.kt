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
import godot.core.Signal0
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Can have [PathFollow3D] child nodes moving along the [Curve3D]. See [PathFollow3D] for more
 * information on the usage.
 *
 * Note that the path is considered as relative to the moved nodes (children of [PathFollow3D]). As
 * such, the curve should usually start with a zero vector `(0, 0, 0)`.
 */
@GodotBaseType
public open class Path3D : Node3D() {
  /**
   * Emitted when the [curve] changes.
   */
  public val curveChanged: Signal0 by Signal0

  /**
   * Emitted when the [debugCustomColor] changes.
   */
  public val debugColorChanged: Signal0 by Signal0

  /**
   * A [Curve3D] describing the path.
   */
  public final inline var curve: Curve3D?
    @JvmName("curveProperty")
    get() = getCurve()
    @JvmName("curveProperty")
    set(`value`) {
      setCurve(value)
    }

  /**
   * The custom color used to draw the path in the editor. If set to [Color.BLACK] (as by default),
   * the color set in [ProjectSettings.debug/shapes/paths/geometryColor] is used.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var debugCustomColor: Color
    @JvmName("debugCustomColorProperty")
    get() = getDebugCustomColor()
    @JvmName("debugCustomColorProperty")
    set(`value`) {
      setDebugCustomColor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(516, scriptPtr)
  }

  /**
   * This is a helper function for [debugCustomColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = path3d.debugCustomColor
   * //Your changes
   * path3d.debugCustomColor = myCoreType
   * ``````
   *
   * The custom color used to draw the path in the editor. If set to [Color.BLACK] (as by default),
   * the color set in [ProjectSettings.debug/shapes/paths/geometryColor] is used.
   */
  @CoreTypeHelper
  public final fun debugCustomColorMutate(block: Color.() -> Unit): Color = debugCustomColor.apply {
     block(this)
     debugCustomColor = this
  }

  public final fun setCurve(curve: Curve3D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setCurvePtr)
  }

  public final fun getCurve(): Curve3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve3D?)
  }

  public final fun setDebugCustomColor(debugCustomColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to debugCustomColor)
    TransferContext.callMethod(MethodBindings.setDebugCustomColorPtr)
  }

  public final fun getDebugCustomColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDebugCustomColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public companion object {
    @JvmField
    public val setCurveName: MethodStringName1<Path3D, Unit, Curve3D?> =
        MethodStringName1<Path3D, Unit, Curve3D?>("set_curve")

    @JvmField
    public val getCurveName: MethodStringName0<Path3D, Curve3D?> =
        MethodStringName0<Path3D, Curve3D?>("get_curve")

    @JvmField
    public val setDebugCustomColorName: MethodStringName1<Path3D, Unit, Color> =
        MethodStringName1<Path3D, Unit, Color>("set_debug_custom_color")

    @JvmField
    public val getDebugCustomColorName: MethodStringName0<Path3D, Color> =
        MethodStringName0<Path3D, Color>("get_debug_custom_color")
  }

  public object MethodBindings {
    internal val setCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path3D", "set_curve", 408955118)

    internal val getCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path3D", "get_curve", 4244715212)

    internal val setDebugCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path3D", "set_debug_custom_color", 2920490490)

    internal val getDebugCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path3D", "get_debug_custom_color", 3444240500)
  }
}
