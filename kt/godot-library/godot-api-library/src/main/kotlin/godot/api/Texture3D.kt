// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class for [ImageTexture3D] and [CompressedTexture3D]. Cannot be used directly, but contains
 * all the functions necessary for accessing the derived resource types. [Texture3D] is the base class
 * for all 3-dimensional texture types. See also [TextureLayered].
 *
 * All images need to have the same width, height and number of mipmap levels.
 *
 * To create such a texture file yourself, reimport your image files using the Godot Editor import
 * presets.
 */
@GodotBaseType
public abstract class Texture3D : Texture() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(744, scriptPtr)
  }

  /**
   * Called when the [Texture3D]'s format is queried.
   */
  public abstract fun _getFormat(): Image.Format

  /**
   * Called when the [Texture3D]'s width is queried.
   */
  public abstract fun _getWidth(): Int

  /**
   * Called when the [Texture3D]'s height is queried.
   */
  public abstract fun _getHeight(): Int

  /**
   * Called when the [Texture3D]'s depth is queried.
   */
  public abstract fun _getDepth(): Int

  /**
   * Called when the presence of mipmaps in the [Texture3D] is queried.
   */
  public abstract fun _hasMipmaps(): Boolean

  /**
   * Called when the [Texture3D]'s data is queried.
   */
  public abstract fun _getData(): VariantArray<Image>

  /**
   * Returns the current format being used by this texture.
   */
  public final fun getFormat(): Image.Format =
      Image.Format.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFormatPtr))

  /**
   * Returns the [Texture3D]'s width in pixels. Width is typically represented by the X axis.
   */
  public final fun getWidth(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getWidthPtr).toInt()

  /**
   * Returns the [Texture3D]'s height in pixels. Width is typically represented by the Y axis.
   */
  public final fun getHeight(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHeightPtr).toInt()

  /**
   * Returns the [Texture3D]'s depth in pixels. Depth is typically represented by the Z axis (a
   * dimension not present in [Texture2D]).
   */
  public final fun getDepth(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDepthPtr).toInt()

  /**
   * Returns `true` if the [Texture3D] has generated mipmaps.
   */
  public final fun hasMipmaps(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasMipmapsPtr)

  /**
   * Returns the [Texture3D]'s data as an array of [Image]s. Each [Image] represents a *slice* of
   * the [Texture3D], with different slices mapping to different depth (Z axis) levels.
   */
  public final fun getData(): VariantArray<Image> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getDataPtr) as VariantArray<Image>)

  /**
   * Creates a placeholder version of this resource ([PlaceholderTexture3D]).
   */
  public final fun createPlaceholder(): Resource? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.createPlaceholderPtr) as Resource?)

  public companion object {
    @JvmField
    public val getFormatName: MethodStringName0<Texture3D, Image.Format> =
        MethodStringName0<Texture3D, Image.Format>("get_format")

    @JvmField
    public val getWidthName: MethodStringName0<Texture3D, Int> =
        MethodStringName0<Texture3D, Int>("get_width")

    @JvmField
    public val getHeightName: MethodStringName0<Texture3D, Int> =
        MethodStringName0<Texture3D, Int>("get_height")

    @JvmField
    public val getDepthName: MethodStringName0<Texture3D, Int> =
        MethodStringName0<Texture3D, Int>("get_depth")

    @JvmField
    public val hasMipmapsName: MethodStringName0<Texture3D, Boolean> =
        MethodStringName0<Texture3D, Boolean>("has_mipmaps")

    @JvmField
    public val getDataName: MethodStringName0<Texture3D, VariantArray<Image>> =
        MethodStringName0<Texture3D, VariantArray<Image>>("get_data")

    @JvmField
    public val createPlaceholderName: MethodStringName0<Texture3D, Resource?> =
        MethodStringName0<Texture3D, Resource?>("create_placeholder")
  }

  public object MethodBindings {
    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "get_format", 3847873762)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "get_width", 3905245786)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "get_height", 3905245786)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "get_depth", 3905245786)

    internal val hasMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "has_mipmaps", 36873697)

    internal val getDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "get_data", 3995934104)

    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture3D", "create_placeholder", 121922552)
  }
}

internal class Texture3DDummy : Texture3D() {
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("Texture3D::_getFormat is only implemented by non-JVM code.")
  }

  public override fun _getWidth(): Int {
    throw NotImplementedError("Texture3D::_getWidth is only implemented by non-JVM code.")
  }

  public override fun _getHeight(): Int {
    throw NotImplementedError("Texture3D::_getHeight is only implemented by non-JVM code.")
  }

  public override fun _getDepth(): Int {
    throw NotImplementedError("Texture3D::_getDepth is only implemented by non-JVM code.")
  }

  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("Texture3D::_hasMipmaps is only implemented by non-JVM code.")
  }

  public override fun _getData(): VariantArray<Image> {
    throw NotImplementedError("Texture3D::_getData is only implemented by non-JVM code.")
  }
}
