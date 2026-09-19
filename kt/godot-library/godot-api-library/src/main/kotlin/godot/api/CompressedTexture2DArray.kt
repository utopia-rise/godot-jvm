// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * A texture array that is loaded from a `.ctexarray` file. This file format is internal to Godot;
 * it is created by importing other image formats with the import system. [CompressedTexture2DArray]
 * can use one of 4 compression methods:
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
 *
 * See [Texture2DArray] for a general description of texture arrays.
 */
@GodotBaseType
public open class CompressedTexture2DArray : CompressedTextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(176, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
