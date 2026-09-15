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
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base class for [CompressedTexture2DArray] and [CompressedTexture3D]. Cannot be used directly, but
 * contains all the functions necessary for accessing the derived resource types. See also
 * [TextureLayered].
 */
@GodotBaseType
public open class CompressedTextureLayered internal constructor() : TextureLayered() {
  /**
   * The path the texture should be loaded from.
   */
  public final inline val loadPath: String
    @JvmName("loadPathProperty")
    get() = getLoadPath()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(178, scriptPtr)
  }

  /**
   * Loads the texture at [path].
   */
  public final fun load(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.loadPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public final fun getLoadPath(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoadPathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("CompressedTextureLayered::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayeredType(): Long {
    throw NotImplementedError("CompressedTextureLayered::_getLayeredType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("CompressedTextureLayered::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("CompressedTextureLayered::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayers(): Int {
    throw NotImplementedError("CompressedTextureLayered::_getLayers can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("CompressedTextureLayered::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayerData(layerIndex: Int): Image? {
    throw NotImplementedError("CompressedTextureLayered::_getLayerData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val loadName: MethodStringName1<CompressedTextureLayered, Error, String> =
        MethodStringName1<CompressedTextureLayered, Error, String>("load")

    @JvmField
    public val getLoadPathName: MethodStringName0<CompressedTextureLayered, String> =
        MethodStringName0<CompressedTextureLayered, String>("get_load_path")
  }

  public object MethodBindings {
    internal val loadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompressedTextureLayered", "load", 166001499)

    internal val getLoadPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompressedTextureLayered", "get_load_path", 201670096)
  }
}
