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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class for [ImageTextureLayered] and [CompressedTextureLayered]. Cannot be used directly, but
 * contains all the functions necessary for accessing the derived resource types. See also [Texture3D].
 *
 * Data is set on a per-layer basis. For [Texture2DArray]s, the layer specifies the array layer.
 *
 * All images need to have the same width, height and number of mipmap levels.
 *
 * A [TextureLayered] can be loaded with [ResourceLoader.load].
 *
 * Internally, Godot maps these files to their respective counterparts in the target rendering
 * driver (Vulkan, OpenGL3).
 */
@GodotBaseType
public abstract class TextureLayered : Texture() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(749, scriptPtr)
  }

  /**
   * Called when the [TextureLayered]'s format is queried.
   */
  public abstract fun _getFormat(): Image.Format

  /**
   * Called when the layers' type in the [TextureLayered] is queried.
   */
  public abstract fun _getLayeredType(): Long

  /**
   * Called when the [TextureLayered]'s width queried.
   */
  public abstract fun _getWidth(): Int

  /**
   * Called when the [TextureLayered]'s height is queried.
   */
  public abstract fun _getHeight(): Int

  /**
   * Called when the number of layers in the [TextureLayered] is queried.
   */
  public abstract fun _getLayers(): Int

  /**
   * Called when the presence of mipmaps in the [TextureLayered] is queried.
   */
  public abstract fun _hasMipmaps(): Boolean

  /**
   * Called when the data for a layer in the [TextureLayered] is queried.
   */
  public abstract fun _getLayerData(layerIndex: Int): Image?

  /**
   * Returns the current format being used by this texture.
   */
  public final fun getFormat(): Image.Format {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return Image.Format.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the [TextureLayered]'s type. The type determines how the data is accessed, with
   * cubemaps having special types.
   */
  public final fun getLayeredType(): LayeredType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayeredTypePtr)
    return LayeredType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the width of the texture in pixels. Width is typically represented by the X axis.
   */
  public final fun getWidth(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWidthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the height of the texture in pixels. Height is typically represented by the Y axis.
   */
  public final fun getHeight(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of referenced [Image]s.
   */
  public final fun getLayers(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayersPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the layers have generated mipmaps.
   */
  public final fun hasMipmaps(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasMipmapsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an [Image] resource with the data from specified [layer].
   */
  public final fun getLayerData(layer: Int): Image? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layer.toLong())
    TransferContext.callMethod(MethodBindings.getLayerDataPtr)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  public enum class LayeredType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Texture is a generic [Texture2DArray].
     */
    LAYERED_TYPE_2D_ARRAY(0),
    /**
     * Texture is a [Cubemap], with each side in its own layer (6 in total).
     */
    CUBEMAP(1),
    /**
     * Texture is a [CubemapArray], with each cubemap being made of 6 layers.
     */
    CUBEMAP_ARRAY(2),
    ;

    public companion object {
      public fun from(`value`: Long): LayeredType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getFormatName: MethodStringName0<TextureLayered, Image.Format> =
        MethodStringName0<TextureLayered, Image.Format>("get_format")

    @JvmField
    public val getLayeredTypeName: MethodStringName0<TextureLayered, LayeredType> =
        MethodStringName0<TextureLayered, LayeredType>("get_layered_type")

    @JvmField
    public val getWidthName: MethodStringName0<TextureLayered, Int> =
        MethodStringName0<TextureLayered, Int>("get_width")

    @JvmField
    public val getHeightName: MethodStringName0<TextureLayered, Int> =
        MethodStringName0<TextureLayered, Int>("get_height")

    @JvmField
    public val getLayersName: MethodStringName0<TextureLayered, Int> =
        MethodStringName0<TextureLayered, Int>("get_layers")

    @JvmField
    public val hasMipmapsName: MethodStringName0<TextureLayered, Boolean> =
        MethodStringName0<TextureLayered, Boolean>("has_mipmaps")

    @JvmField
    public val getLayerDataName: MethodStringName1<TextureLayered, Image?, Int> =
        MethodStringName1<TextureLayered, Image?, Int>("get_layer_data")
  }

  public object MethodBindings {
    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_format", 3847873762)

    internal val getLayeredTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_layered_type", 518123893)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_width", 3905245786)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_height", 3905245786)

    internal val getLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_layers", 3905245786)

    internal val hasMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "has_mipmaps", 36873697)

    internal val getLayerDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayered", "get_layer_data", 3655284255)
  }
}

internal class TextureLayeredDummy : TextureLayered() {
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("TextureLayered::_getFormat is only implemented by non-JVM code.")
  }

  public override fun _getLayeredType(): Long {
    throw NotImplementedError("TextureLayered::_getLayeredType is only implemented by non-JVM code.")
  }

  public override fun _getWidth(): Int {
    throw NotImplementedError("TextureLayered::_getWidth is only implemented by non-JVM code.")
  }

  public override fun _getHeight(): Int {
    throw NotImplementedError("TextureLayered::_getHeight is only implemented by non-JVM code.")
  }

  public override fun _getLayers(): Int {
    throw NotImplementedError("TextureLayered::_getLayers is only implemented by non-JVM code.")
  }

  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("TextureLayered::_hasMipmaps is only implemented by non-JVM code.")
  }

  public override fun _getLayerData(layerIndex: Int): Image? {
    throw NotImplementedError("TextureLayered::_getLayerData is only implemented by non-JVM code.")
  }
}
