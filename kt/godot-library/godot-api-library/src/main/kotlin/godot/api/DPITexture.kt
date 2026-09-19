// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callMethod_STRING_DOUBLE_DOUBLE_DICTIONARY_ret_OBJECT_REF
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DICTIONARY
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DICTIONARY
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_VECTOR2I
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName4
import godot.core.RID
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * An automatically scalable [Texture2D] based on an SVG image. [DPITexture]s are used to
 * automatically re-rasterize icons and other texture based UI theme elements to match viewport scale
 * and font oversampling. See also [ProjectSettings.display/window/stretch/mode] ("canvas_items" mode)
 * and [Viewport.oversamplingOverride].
 */
@GodotBaseType
public open class DPITexture : Texture2D() {
  /**
   * If `true`, puts pixels of the same surrounding color in transition from transparent to opaque
   * areas. For textures displayed with bilinear filtering, this helps to reduce the outline effect
   * when exporting images from an image editor.
   */
  public final inline var fixAlphaBorder: Boolean
    @JvmName("fixAlphaBorderProperty")
    get() = getFixAlphaBorder()
    @JvmName("fixAlphaBorderProperty")
    set(`value`) {
      setFixAlphaBorder(value)
    }

  /**
   * An alternative to fixing darkened borders with [fixAlphaBorder] is to use premultiplied alpha.
   * By enabling this option, the texture will be converted to this format. A premultiplied alpha
   * texture requires specific materials to be displayed correctly:
   *
   * - In 2D, a [CanvasItemMaterial] will need to be created and configured to use the
   * [CanvasItemMaterial.BLEND_MODE_PREMULT_ALPHA] blend mode on [CanvasItem]s that use this texture.
   * In custom `canvas_item` shaders, `render_mode blend_premul_alpha;` should be used.
   *
   * - In 3D, a [BaseMaterial3D] will need to be created and configured to use the
   * [BaseMaterial3D.BLEND_MODE_PREMULT_ALPHA] blend mode on materials that use this texture. In custom
   * `spatial` shaders, `render_mode blend_premul_alpha;` should be used.
   */
  public final inline var premultAlpha: Boolean
    @JvmName("premultAlphaProperty")
    get() = getPremultAlpha()
    @JvmName("premultAlphaProperty")
    set(`value`) {
      setPremultAlpha(value)
    }

  /**
   * Texture scale. `1.0` is the original SVG size. Higher values result in a larger image.
   */
  public final inline var baseScale: Float
    @JvmName("baseScaleProperty")
    get() = getBaseScale()
    @JvmName("baseScaleProperty")
    set(`value`) {
      setBaseScale(value)
    }

  /**
   * Overrides texture saturation.
   */
  public final inline var saturation: Float
    @JvmName("saturationProperty")
    get() = getSaturation()
    @JvmName("saturationProperty")
    set(`value`) {
      setSaturation(value)
    }

  /**
   * If set, remaps texture colors according to [Color]-[Color] map.
   */
  public final inline var colorMap: Dictionary<Any?, Any?>
    @JvmName("colorMapProperty")
    get() = getColorMap()
    @JvmName("colorMapProperty")
    set(`value`) {
      setColorMap(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(201, scriptPtr)
  }

  /**
   * Sets this SVG texture's source code.
   */
  public final fun setSource(source: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setSourcePtr, source)
  }

  /**
   * Returns this SVG texture's source code.
   */
  public final fun getSource(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getSourcePtr)

  public final fun setFixAlphaBorder(fixAlphaBorder: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFixAlphaBorderPtr, fixAlphaBorder)
  }

  public final fun getFixAlphaBorder(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getFixAlphaBorderPtr)

  public final fun setPremultAlpha(premultAlpha: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPremultAlphaPtr, premultAlpha)
  }

  public final fun getPremultAlpha(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getPremultAlphaPtr)

  public final fun setBaseScale(baseScale: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBaseScalePtr, baseScale.toDouble())
  }

  public final fun getBaseScale(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBaseScalePtr).toFloat()

  public final fun setSaturation(saturation: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setSaturationPtr, saturation.toDouble())
  }

  public final fun getSaturation(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSaturationPtr).toFloat()

  public final fun setColorMap(colorMap: Dictionary<Any?, Any?>): Unit {
    TransferContext.callPtrMethod_DICTIONARY(ptr, objectID.id, MethodBindings.setColorMapPtr, colorMap)
  }

  public final fun getColorMap(): Dictionary<Any?, Any?> =
      (TransferContext.callPtrMethod0_ret_DICTIONARY(ptr, objectID.id, MethodBindings.getColorMapPtr) as Dictionary<Any?, Any?>)

  /**
   * Resizes the texture to the specified dimensions.
   */
  public final fun setSizeOverride(size: Vector2i): Unit {
    TransferContext.callPtrMethod_VECTOR2I(ptr, objectID.id, MethodBindings.setSizeOverridePtr, size)
  }

  /**
   * Returns the [RID] of the texture rasterized to match the oversampling of the currently drawn
   * canvas item.
   */
  public final fun getScaledRid(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getScaledRidPtr)

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("DPITexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("DPITexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val createFromStringName:
        MethodStringName4<DPITexture, DPITexture?, String, Float, Float, Dictionary<Any?, Any?>> =
        MethodStringName4<DPITexture, DPITexture?, String, Float, Float, Dictionary<Any?, Any?>>("create_from_string")

    @JvmField
    public val setSourceName: MethodStringName1<DPITexture, Unit, String> =
        MethodStringName1<DPITexture, Unit, String>("set_source")

    @JvmField
    public val getSourceName: MethodStringName0<DPITexture, String> =
        MethodStringName0<DPITexture, String>("get_source")

    @JvmField
    public val setFixAlphaBorderName: MethodStringName1<DPITexture, Unit, Boolean> =
        MethodStringName1<DPITexture, Unit, Boolean>("set_fix_alpha_border")

    @JvmField
    public val getFixAlphaBorderName: MethodStringName0<DPITexture, Boolean> =
        MethodStringName0<DPITexture, Boolean>("get_fix_alpha_border")

    @JvmField
    public val setPremultAlphaName: MethodStringName1<DPITexture, Unit, Boolean> =
        MethodStringName1<DPITexture, Unit, Boolean>("set_premult_alpha")

    @JvmField
    public val getPremultAlphaName: MethodStringName0<DPITexture, Boolean> =
        MethodStringName0<DPITexture, Boolean>("get_premult_alpha")

    @JvmField
    public val setBaseScaleName: MethodStringName1<DPITexture, Unit, Float> =
        MethodStringName1<DPITexture, Unit, Float>("set_base_scale")

    @JvmField
    public val getBaseScaleName: MethodStringName0<DPITexture, Float> =
        MethodStringName0<DPITexture, Float>("get_base_scale")

    @JvmField
    public val setSaturationName: MethodStringName1<DPITexture, Unit, Float> =
        MethodStringName1<DPITexture, Unit, Float>("set_saturation")

    @JvmField
    public val getSaturationName: MethodStringName0<DPITexture, Float> =
        MethodStringName0<DPITexture, Float>("get_saturation")

    @JvmField
    public val setColorMapName: MethodStringName1<DPITexture, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<DPITexture, Unit, Dictionary<Any?, Any?>>("set_color_map")

    @JvmField
    public val getColorMapName: MethodStringName0<DPITexture, Dictionary<Any?, Any?>> =
        MethodStringName0<DPITexture, Dictionary<Any?, Any?>>("get_color_map")

    @JvmField
    public val setSizeOverrideName: MethodStringName1<DPITexture, Unit, Vector2i> =
        MethodStringName1<DPITexture, Unit, Vector2i>("set_size_override")

    @JvmField
    public val getScaledRidName: MethodStringName0<DPITexture, RID> =
        MethodStringName0<DPITexture, RID>("get_scaled_rid")

    /**
     * Creates a new [DPITexture] and initializes it by allocating and setting the SVG data to
     * [source].
     */
    @JvmOverloads
    @JvmStatic
    public final fun createFromString(
      source: String,
      scale: Float = 1.0f,
      saturation: Float = 1.0f,
      colorMap: Dictionary<Any?, Any?> = Dictionary(),
    ): DPITexture? =
        (TransferContext.callMethod_STRING_DOUBLE_DOUBLE_DICTIONARY_ret_OBJECT_REF(0L, 0L, MethodBindings.createFromStringPtr, source, scale.toDouble(), saturation.toDouble(), colorMap) as DPITexture?)
  }

  public object MethodBindings {
    internal val createFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "create_from_string", 755140520)

    internal val setSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_source", 83702148)

    internal val getSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_source", 201670096)

    internal val setFixAlphaBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_fix_alpha_border", 2586408642)

    internal val getFixAlphaBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_fix_alpha_border", 36873697)

    internal val setPremultAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_premult_alpha", 2586408642)

    internal val getPremultAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_premult_alpha", 36873697)

    internal val setBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_base_scale", 373806689)

    internal val getBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_base_scale", 1740695150)

    internal val setSaturationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_saturation", 373806689)

    internal val getSaturationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_saturation", 1740695150)

    internal val setColorMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_color_map", 4155329257)

    internal val getColorMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_color_map", 3102165223)

    internal val setSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "set_size_override", 1130785943)

    internal val getScaledRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DPITexture", "get_scaled_rid", 2944877500)
  }
}
