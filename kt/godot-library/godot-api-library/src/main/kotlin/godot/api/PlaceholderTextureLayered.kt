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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class is used when loading a project that uses a [TextureLayered] subclass in 2 conditions:
 *
 * - When running the project exported in dedicated server mode, only the texture's dimensions are
 * kept (as they may be relied upon for gameplay purposes or positioning of other elements). This
 * allows reducing the exported PCK's size significantly.
 *
 * - When this subclass is missing due to using a different engine version or build (e.g. modules
 * disabled).
 *
 * **Note:** This is not intended to be used as an actual texture for rendering. It is not
 * guaranteed to work like one in shaders or materials (for example when calculating UV).
 */
@GodotBaseType
public open class PlaceholderTextureLayered internal constructor() : TextureLayered() {
  /**
   * The size of each texture layer (in pixels).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector2i
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * The number of layers in the texture array.
   */
  public final inline var layers: Int
    @JvmName("layersProperty")
    get() = getLayers()
    @JvmName("layersProperty")
    set(`value`) {
      setLayers(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(559, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = placeholdertexturelayered.size
   * //Your changes
   * placeholdertexturelayered.size = myCoreType
   * ``````
   *
   * The size of each texture layer (in pixels).
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector2i.() -> Unit): Vector2i = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setLayers(layers: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layers.toLong())
    TransferContext.callMethod(MethodBindings.setLayersPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("PlaceholderTextureLayered::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayeredType(): Long {
    throw NotImplementedError("PlaceholderTextureLayered::_getLayeredType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("PlaceholderTextureLayered::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("PlaceholderTextureLayered::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayers(): Int {
    throw NotImplementedError("PlaceholderTextureLayered::_getLayers can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("PlaceholderTextureLayered::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayerData(layerIndex: Int): Image? {
    throw NotImplementedError("PlaceholderTextureLayered::_getLayerData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<PlaceholderTextureLayered, Unit, Vector2i> =
        MethodStringName1<PlaceholderTextureLayered, Unit, Vector2i>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<PlaceholderTextureLayered, Vector2i> =
        MethodStringName0<PlaceholderTextureLayered, Vector2i>("get_size")

    @JvmField
    public val setLayersName: MethodStringName1<PlaceholderTextureLayered, Unit, Int> =
        MethodStringName1<PlaceholderTextureLayered, Unit, Int>("set_layers")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaceholderTextureLayered", "set_size", 1130785943)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaceholderTextureLayered", "get_size", 3690982128)

    internal val setLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaceholderTextureLayered", "set_layers", 1286410249)
  }
}
