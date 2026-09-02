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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 2D texture that obtains colors from a [Gradient] to fill the texture data. This texture is able
 * to transform a color transition into different patterns such as a linear or a radial gradient. The
 * texture is filled by interpolating colors starting from [fillFrom] to [fillTo] offsets by default,
 * but the gradient fill can be repeated to cover the entire texture.
 *
 * The gradient is sampled individually for each pixel so it does not necessarily represent an exact
 * copy of the gradient (see [width] and [height]). See also [GradientTexture1D], [CurveTexture] and
 * [CurveXYZTexture].
 */
@GodotBaseType
public open class GradientTexture2D : Texture2D() {
  /**
   * The [Gradient] used to fill the texture.
   */
  public final inline var gradient: Gradient?
    @JvmName("gradientProperty")
    get() = getGradient()
    @JvmName("gradientProperty")
    set(`value`) {
      setGradient(value)
    }

  /**
   * The number of horizontal color samples that will be obtained from the [Gradient], which also
   * represents the texture's width.
   */
  public final inline var width: Int
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * The number of vertical color samples that will be obtained from the [Gradient], which also
   * represents the texture's height.
   */
  public final inline var height: Int
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * If `true`, the generated texture will support high dynamic range ([Image.FORMAT_RGBAF] format).
   * This allows for glow effects to work if [Environment.glowEnabled] is `true`. If `false`, the
   * generated texture will use low dynamic range; overbright colors will be clamped
   * ([Image.FORMAT_RGBA8] format).
   */
  public final inline var useHdr: Boolean
    @JvmName("useHdrProperty")
    get() = isUsingHdr()
    @JvmName("useHdrProperty")
    set(`value`) {
      setUseHdr(value)
    }

  /**
   * The gradient's fill type.
   */
  public final inline var fill: Fill
    @JvmName("fillProperty")
    get() = getFill()
    @JvmName("fillProperty")
    set(`value`) {
      setFill(value)
    }

  /**
   * The initial offset used to fill the texture specified in UV coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fillFrom: Vector2
    @JvmName("fillFromProperty")
    get() = getFillFrom()
    @JvmName("fillFromProperty")
    set(`value`) {
      setFillFrom(value)
    }

  /**
   * The final offset used to fill the texture specified in UV coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fillTo: Vector2
    @JvmName("fillToProperty")
    get() = getFillTo()
    @JvmName("fillToProperty")
    set(`value`) {
      setFillTo(value)
    }

  /**
   * The gradient's repeat type.
   */
  public final inline var repeat: Repeat
    @JvmName("repeatProperty")
    get() = getRepeat()
    @JvmName("repeatProperty")
    set(`value`) {
      setRepeat(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(278, scriptPtr)
  }

  /**
   * This is a helper function for [fillFrom] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gradienttexture2d.fillFrom
   * //Your changes
   * gradienttexture2d.fillFrom = myCoreType
   * ``````
   *
   * The initial offset used to fill the texture specified in UV coordinates.
   */
  @CoreTypeHelper
  public final fun fillFromMutate(block: Vector2.() -> Unit): Vector2 = fillFrom.apply {
     block(this)
     fillFrom = this
  }

  /**
   * This is a helper function for [fillTo] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gradienttexture2d.fillTo
   * //Your changes
   * gradienttexture2d.fillTo = myCoreType
   * ``````
   *
   * The final offset used to fill the texture specified in UV coordinates.
   */
  @CoreTypeHelper
  public final fun fillToMutate(block: Vector2.() -> Unit): Vector2 = fillTo.apply {
     block(this)
     fillTo = this
  }

  public final fun setGradient(gradient: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to gradient)
    TransferContext.callMethod(MethodBindings.setGradientPtr)
  }

  public final fun getGradient(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGradientPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  public final fun setWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun setHeight(height: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  public final fun setUseHdr(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseHdrPtr)
  }

  public final fun isUsingHdr(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingHdrPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFill(fill: Fill): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fill.value)
    TransferContext.callMethod(MethodBindings.setFillPtr)
  }

  public final fun getFill(): Fill {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillPtr)
    return Fill.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFillFrom(fillFrom: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to fillFrom)
    TransferContext.callMethod(MethodBindings.setFillFromPtr)
  }

  public final fun getFillFrom(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillFromPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setFillTo(fillTo: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to fillTo)
    TransferContext.callMethod(MethodBindings.setFillToPtr)
  }

  public final fun getFillTo(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillToPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setRepeat(repeat: Repeat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to repeat.value)
    TransferContext.callMethod(MethodBindings.setRepeatPtr)
  }

  public final fun getRepeat(): Repeat {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatPtr)
    return Repeat.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("GradientTexture2D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("GradientTexture2D::_getHeight can't be called from the JVM.")
  }

  public enum class Fill(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The colors are linearly interpolated in a straight line.
     */
    LINEAR(0),
    /**
     * The colors are linearly interpolated in a circular pattern.
     */
    RADIAL(1),
    /**
     * The colors are linearly interpolated in a square pattern.
     */
    SQUARE(2),
    /**
     * The colors are linearly interpolated in a cone pattern.
     */
    CONIC(3),
    ;

    public companion object {
      public fun from(`value`: Long): Fill = entries.single { it.`value` == `value` }
    }
  }

  public enum class Repeat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The gradient fill is restricted to the range defined by [fillFrom] to [fillTo] offsets.
     */
    NONE(0),
    /**
     * The texture is filled starting from [fillFrom] to [fillTo] offsets, repeating the same
     * pattern in both directions.
     */
    REPEAT(1),
    /**
     * The texture is filled starting from [fillFrom] to [fillTo] offsets, mirroring the pattern in
     * both directions.
     */
    MIRROR(2),
    ;

    public companion object {
      public fun from(`value`: Long): Repeat = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setGradientName: MethodStringName1<GradientTexture2D, Unit, Gradient?> =
        MethodStringName1<GradientTexture2D, Unit, Gradient?>("set_gradient")

    @JvmField
    public val getGradientName: MethodStringName0<GradientTexture2D, Gradient?> =
        MethodStringName0<GradientTexture2D, Gradient?>("get_gradient")

    @JvmField
    public val setWidthName: MethodStringName1<GradientTexture2D, Unit, Int> =
        MethodStringName1<GradientTexture2D, Unit, Int>("set_width")

    @JvmField
    public val setHeightName: MethodStringName1<GradientTexture2D, Unit, Int> =
        MethodStringName1<GradientTexture2D, Unit, Int>("set_height")

    @JvmField
    public val setUseHdrName: MethodStringName1<GradientTexture2D, Unit, Boolean> =
        MethodStringName1<GradientTexture2D, Unit, Boolean>("set_use_hdr")

    @JvmField
    public val isUsingHdrName: MethodStringName0<GradientTexture2D, Boolean> =
        MethodStringName0<GradientTexture2D, Boolean>("is_using_hdr")

    @JvmField
    public val setFillName: MethodStringName1<GradientTexture2D, Unit, Fill> =
        MethodStringName1<GradientTexture2D, Unit, Fill>("set_fill")

    @JvmField
    public val getFillName: MethodStringName0<GradientTexture2D, Fill> =
        MethodStringName0<GradientTexture2D, Fill>("get_fill")

    @JvmField
    public val setFillFromName: MethodStringName1<GradientTexture2D, Unit, Vector2> =
        MethodStringName1<GradientTexture2D, Unit, Vector2>("set_fill_from")

    @JvmField
    public val getFillFromName: MethodStringName0<GradientTexture2D, Vector2> =
        MethodStringName0<GradientTexture2D, Vector2>("get_fill_from")

    @JvmField
    public val setFillToName: MethodStringName1<GradientTexture2D, Unit, Vector2> =
        MethodStringName1<GradientTexture2D, Unit, Vector2>("set_fill_to")

    @JvmField
    public val getFillToName: MethodStringName0<GradientTexture2D, Vector2> =
        MethodStringName0<GradientTexture2D, Vector2>("get_fill_to")

    @JvmField
    public val setRepeatName: MethodStringName1<GradientTexture2D, Unit, Repeat> =
        MethodStringName1<GradientTexture2D, Unit, Repeat>("set_repeat")

    @JvmField
    public val getRepeatName: MethodStringName0<GradientTexture2D, Repeat> =
        MethodStringName0<GradientTexture2D, Repeat>("get_repeat")
  }

  public object MethodBindings {
    internal val setGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_gradient", 2756054477)

    internal val getGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "get_gradient", 132272999)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_width", 1286410249)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_height", 1286410249)

    internal val setUseHdrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_use_hdr", 2586408642)

    internal val isUsingHdrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "is_using_hdr", 36873697)

    internal val setFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_fill", 3623927636)

    internal val getFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "get_fill", 1876227217)

    internal val setFillFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_fill_from", 743155724)

    internal val getFillFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "get_fill_from", 3341600327)

    internal val setFillToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_fill_to", 743155724)

    internal val getFillToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "get_fill_to", 3341600327)

    internal val setRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "set_repeat", 1357597002)

    internal val getRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture2D", "get_repeat", 3351758665)
  }
}
