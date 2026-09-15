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
import godot.core.PackedColorArray
import godot.readReturnValue_PACKED_COLOR_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_PACKED_COLOR_ARRAY
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The [ColorPalette] resource is designed to store and manage a collection of colors. This resource
 * is useful in scenarios where a predefined set of colors is required, such as for creating themes,
 * designing user interfaces, or managing game assets. The built-in [ColorPicker] control can also make
 * use of [ColorPalette] without additional code.
 */
@GodotBaseType
public open class ColorPalette : Resource() {
  /**
   * A [PackedColorArray] containing the colors in the palette.
   */
  public final inline var colors: PackedColorArray
    @JvmName("colorsProperty")
    get() = getColors()
    @JvmName("colorsProperty")
    set(`value`) {
      setColors(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(167, scriptPtr)
  }

  public final fun setColors(colors: PackedColorArray): Unit {
    TransferContext.writeMethodArguments_PACKED_COLOR_ARRAY(ptr, objectID.id, colors)
    TransferContext.callPtrMethod(MethodBindings.setColorsPtr, 0)
  }

  public final fun getColors(): PackedColorArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorsPtr)
    return TransferContext.readReturnValue_PACKED_COLOR_ARRAY()
  }

  public companion object {
    @JvmField
    public val setColorsName: MethodStringName1<ColorPalette, Unit, PackedColorArray> =
        MethodStringName1<ColorPalette, Unit, PackedColorArray>("set_colors")

    @JvmField
    public val getColorsName: MethodStringName0<ColorPalette, PackedColorArray> =
        MethodStringName0<ColorPalette, PackedColorArray>("get_colors")
  }

  public object MethodBindings {
    internal val setColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPalette", "set_colors", 3546319833)

    internal val getColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPalette", "get_colors", 1392750486)
  }
}
