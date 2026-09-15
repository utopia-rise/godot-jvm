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
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A texture that is loaded from a `.ctex` file. This file format is internal to Godot; it is
 * created by importing other image formats with the import system. [CompressedTexture2D] can use one
 * of 4 compression methods (including a lack of any compression):
 *
 * - Lossless (WebP or PNG, uncompressed on the GPU)
 *
 * - Lossy (WebP, uncompressed on the GPU)
 *
 * - VRAM Compressed (compressed on the GPU)
 *
 * - VRAM Uncompressed (uncompressed on the GPU)
 *
 * - Basis Universal (compressed on the GPU. Lower file sizes than VRAM Compressed, but slower to
 * compress and lower quality than VRAM Compressed)
 *
 * Only **VRAM Compressed** actually reduces the memory usage on the GPU. The **Lossless** and
 * **Lossy** compression methods will reduce the required storage on disk, but they will not reduce
 * memory usage on the GPU as the texture is sent to the GPU uncompressed.
 *
 * Using **VRAM Compressed** also improves loading times, as VRAM-compressed textures are faster to
 * load compared to textures using lossless or lossy compression. VRAM compression can exhibit
 * noticeable artifacts and is intended to be used for 3D rendering, not 2D.
 */
@GodotBaseType
public open class CompressedTexture2D : Texture2D() {
  /**
   * The [CompressedTexture2D]'s file path to a `.ctex` file.
   */
  public final inline val loadPath: String
    @JvmName("loadPathProperty")
    get() = getLoadPath()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(175, scriptPtr)
  }

  /**
   * Loads the texture from the specified [path].
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
  public override fun _getWidth(): Int {
    throw NotImplementedError("CompressedTexture2D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("CompressedTexture2D::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val loadName: MethodStringName1<CompressedTexture2D, Error, String> =
        MethodStringName1<CompressedTexture2D, Error, String>("load")

    @JvmField
    public val getLoadPathName: MethodStringName0<CompressedTexture2D, String> =
        MethodStringName0<CompressedTexture2D, String>("get_load_path")
  }

  public object MethodBindings {
    internal val loadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompressedTexture2D", "load", 166001499)

    internal val getLoadPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompressedTexture2D", "get_load_path", 201670096)
  }
}
