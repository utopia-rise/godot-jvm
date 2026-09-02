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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A rectangular box that displays only a colored border around its rectangle (see
 * [Control.getRect]). It can be used to visualize the extents of a [Control] node, for testing
 * purposes.
 */
@GodotBaseType
public open class ReferenceRect : Control() {
  /**
   * Sets the border color of the [ReferenceRect].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var borderColor: Color
    @JvmName("borderColorProperty")
    get() = getBorderColor()
    @JvmName("borderColorProperty")
    set(`value`) {
      setBorderColor(value)
    }

  /**
   * Sets the border width of the [ReferenceRect]. The border grows both inwards and outwards with
   * respect to the rectangle box.
   */
  public final inline var borderWidth: Float
    @JvmName("borderWidthProperty")
    get() = getBorderWidth()
    @JvmName("borderWidthProperty")
    set(`value`) {
      setBorderWidth(value)
    }

  /**
   * If `true`, the [ReferenceRect] will only be visible while in editor. Otherwise, [ReferenceRect]
   * will be visible in the running project.
   */
  public final inline var editorOnly: Boolean
    @JvmName("editorOnlyProperty")
    get() = getEditorOnly()
    @JvmName("editorOnlyProperty")
    set(`value`) {
      setEditorOnly(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(603, scriptPtr)
  }

  /**
   * This is a helper function for [borderColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = referencerect.borderColor
   * //Your changes
   * referencerect.borderColor = myCoreType
   * ``````
   *
   * Sets the border color of the [ReferenceRect].
   */
  @CoreTypeHelper
  public final fun borderColorMutate(block: Color.() -> Unit): Color = borderColor.apply {
     block(this)
     borderColor = this
  }

  public final fun getBorderColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setBorderColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setBorderColorPtr)
  }

  public final fun getBorderWidth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBorderWidth(width: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to width.toDouble())
    TransferContext.callMethod(MethodBindings.setBorderWidthPtr)
  }

  public final fun getEditorOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEditorOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEditorOnly(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEditorOnlyPtr)
  }

  public companion object {
    @JvmField
    public val getBorderColorName: MethodStringName0<ReferenceRect, Color> =
        MethodStringName0<ReferenceRect, Color>("get_border_color")

    @JvmField
    public val setBorderColorName: MethodStringName1<ReferenceRect, Unit, Color> =
        MethodStringName1<ReferenceRect, Unit, Color>("set_border_color")

    @JvmField
    public val getBorderWidthName: MethodStringName0<ReferenceRect, Float> =
        MethodStringName0<ReferenceRect, Float>("get_border_width")

    @JvmField
    public val setBorderWidthName: MethodStringName1<ReferenceRect, Unit, Float> =
        MethodStringName1<ReferenceRect, Unit, Float>("set_border_width")

    @JvmField
    public val getEditorOnlyName: MethodStringName0<ReferenceRect, Boolean> =
        MethodStringName0<ReferenceRect, Boolean>("get_editor_only")

    @JvmField
    public val setEditorOnlyName: MethodStringName1<ReferenceRect, Unit, Boolean> =
        MethodStringName1<ReferenceRect, Unit, Boolean>("set_editor_only")
  }

  public object MethodBindings {
    internal val getBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "get_border_color", 3444240500)

    internal val setBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "set_border_color", 2920490490)

    internal val getBorderWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "get_border_width", 1740695150)

    internal val setBorderWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "set_border_width", 373806689)

    internal val getEditorOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "get_editor_only", 36873697)

    internal val setEditorOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReferenceRect", "set_editor_only", 2586408642)
  }
}
