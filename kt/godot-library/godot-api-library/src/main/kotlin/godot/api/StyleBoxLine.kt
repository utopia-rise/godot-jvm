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
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_COLOR
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Rect2
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A [StyleBox] that displays a single line of a given color and thickness. The line can be either
 * horizontal or vertical. Useful for separators.
 */
@GodotBaseType
public open class StyleBoxLine : StyleBox() {
  /**
   * The line's color.
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
   * The number of pixels the line will extend before the [StyleBoxLine]'s bounds. If set to a
   * negative value, the line will begin inside the [StyleBoxLine]'s bounds.
   */
  public final inline var growBegin: Float
    @JvmName("growBeginProperty")
    get() = getGrowBegin()
    @JvmName("growBeginProperty")
    set(`value`) {
      setGrowBegin(value)
    }

  /**
   * The number of pixels the line will extend past the [StyleBoxLine]'s bounds. If set to a
   * negative value, the line will end inside the [StyleBoxLine]'s bounds.
   */
  public final inline var growEnd: Float
    @JvmName("growEndProperty")
    get() = getGrowEnd()
    @JvmName("growEndProperty")
    set(`value`) {
      setGrowEnd(value)
    }

  /**
   * The line's thickness in pixels.
   */
  public final inline var thickness: Int
    @JvmName("thicknessProperty")
    get() = getThickness()
    @JvmName("thicknessProperty")
    set(`value`) {
      setThickness(value)
    }

  /**
   * If `true`, the line will be vertical. If `false`, the line will be horizontal.
   */
  public final inline var vertical: Boolean
    @JvmName("verticalProperty")
    get() = isVertical()
    @JvmName("verticalProperty")
    set(`value`) {
      setVertical(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(718, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxline.color
   * //Your changes
   * styleboxline.color = myCoreType
   * ``````
   *
   * The line's color.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setColorPtr, color)
  }

  public final fun getColor(): Color =
      TransferContext.callPtrMethod0_ret_COLOR(ptr, objectID.id, MethodBindings.getColorPtr)

  public final fun setThickness(thickness: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setThicknessPtr, thickness.toLong())
  }

  public final fun getThickness(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getThicknessPtr).toInt()

  public final fun setGrowBegin(offset: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setGrowBeginPtr, offset.toDouble())
  }

  public final fun getGrowBegin(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getGrowBeginPtr).toFloat()

  public final fun setGrowEnd(offset: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setGrowEndPtr, offset.toDouble())
  }

  public final fun getGrowEnd(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getGrowEndPtr).toFloat()

  public final fun setVertical(vertical: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setVerticalPtr, vertical)
  }

  public final fun isVertical(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isVerticalPtr)

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _draw(toCanvasItem: RID, rect: Rect2): Unit {
    throw NotImplementedError("StyleBoxLine::_draw can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setColorName: MethodStringName1<StyleBoxLine, Unit, Color> =
        MethodStringName1<StyleBoxLine, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<StyleBoxLine, Color> =
        MethodStringName0<StyleBoxLine, Color>("get_color")

    @JvmField
    public val setThicknessName: MethodStringName1<StyleBoxLine, Unit, Int> =
        MethodStringName1<StyleBoxLine, Unit, Int>("set_thickness")

    @JvmField
    public val getThicknessName: MethodStringName0<StyleBoxLine, Int> =
        MethodStringName0<StyleBoxLine, Int>("get_thickness")

    @JvmField
    public val setGrowBeginName: MethodStringName1<StyleBoxLine, Unit, Float> =
        MethodStringName1<StyleBoxLine, Unit, Float>("set_grow_begin")

    @JvmField
    public val getGrowBeginName: MethodStringName0<StyleBoxLine, Float> =
        MethodStringName0<StyleBoxLine, Float>("get_grow_begin")

    @JvmField
    public val setGrowEndName: MethodStringName1<StyleBoxLine, Unit, Float> =
        MethodStringName1<StyleBoxLine, Unit, Float>("set_grow_end")

    @JvmField
    public val getGrowEndName: MethodStringName0<StyleBoxLine, Float> =
        MethodStringName0<StyleBoxLine, Float>("get_grow_end")

    @JvmField
    public val setVerticalName: MethodStringName1<StyleBoxLine, Unit, Boolean> =
        MethodStringName1<StyleBoxLine, Unit, Boolean>("set_vertical")

    @JvmField
    public val isVerticalName: MethodStringName0<StyleBoxLine, Boolean> =
        MethodStringName0<StyleBoxLine, Boolean>("is_vertical")
  }

  public object MethodBindings {
    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "get_color", 3444240500)

    internal val setThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "set_thickness", 1286410249)

    internal val getThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "get_thickness", 3905245786)

    internal val setGrowBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "set_grow_begin", 373806689)

    internal val getGrowBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "get_grow_begin", 1740695150)

    internal val setGrowEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "set_grow_end", 373806689)

    internal val getGrowEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "get_grow_end", 1740695150)

    internal val setVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "set_vertical", 2586408642)

    internal val isVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxLine", "is_vertical", 36873697)
  }
}
