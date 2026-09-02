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
import godot.core.VariantArray
import godot.core.VariantParser.VECTOR3I
import godot.core.Vector3i
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class is used when loading a project that uses a [Texture3D] subclass in 2 conditions:
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
public open class PlaceholderTexture3D : Texture3D() {
  /**
   * The texture's size (in pixels).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector3i
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(558, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = placeholdertexture3d.size
   * //Your changes
   * placeholdertexture3d.size = myCoreType
   * ``````
   *
   * The texture's size (in pixels).
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3i.() -> Unit): Vector3i = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector3i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3I to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector3i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3I) as Vector3i)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("PlaceholderTexture3D::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("PlaceholderTexture3D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("PlaceholderTexture3D::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getDepth(): Int {
    throw NotImplementedError("PlaceholderTexture3D::_getDepth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("PlaceholderTexture3D::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getData(): VariantArray<Image> {
    throw NotImplementedError("PlaceholderTexture3D::_getData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<PlaceholderTexture3D, Unit, Vector3i> =
        MethodStringName1<PlaceholderTexture3D, Unit, Vector3i>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<PlaceholderTexture3D, Vector3i> =
        MethodStringName0<PlaceholderTexture3D, Vector3i>("get_size")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaceholderTexture3D", "set_size", 560364750)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PlaceholderTexture3D", "get_size", 2785653706)
  }
}
