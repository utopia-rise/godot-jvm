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
import godot.core.MethodStringName1
import godot.core.MethodStringName6
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [ImageTexture3D] is a 3-dimensional [ImageTexture] that has a width, height, and depth. See also
 * [ImageTextureLayered].
 *
 * 3D textures are typically used to store density maps for [FogMaterial], color correction LUTs for
 * [Environment], vector fields for [GPUParticlesAttractorVectorField3D] and collision maps for
 * [GPUParticlesCollisionSDF3D]. 3D textures can also be used in custom shaders.
 */
@GodotBaseType
public open class ImageTexture3D : Texture3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(302, scriptPtr)
  }

  /**
   * Creates the [ImageTexture3D] with specified [format], [width], [height], and [depth]. If
   * [useMipmaps] is `true`, generates mipmaps for the [ImageTexture3D].
   */
  public final fun create(
    format: Image.Format,
    width: Int,
    height: Int,
    depth: Int,
    useMipmaps: Boolean,
    `data`: VariantArray<Image>,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value, LONG to width.toLong(), LONG to height.toLong(), LONG to depth.toLong(), BOOL to useMipmaps, ARRAY to data)
    TransferContext.callMethod(MethodBindings.createPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Replaces the texture's existing data with the layers specified in [data]. The size of [data]
   * must match the parameters that were used for [create]. In other words, the texture cannot be
   * resized or have its format changed by calling [update].
   */
  public final fun update(`data`: VariantArray<Image>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to data)
    TransferContext.callMethod(MethodBindings.updatePtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("ImageTexture3D::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("ImageTexture3D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("ImageTexture3D::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getDepth(): Int {
    throw NotImplementedError("ImageTexture3D::_getDepth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("ImageTexture3D::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getData(): VariantArray<Image> {
    throw NotImplementedError("ImageTexture3D::_getData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val createName:
        MethodStringName6<ImageTexture3D, Error, Image.Format, Int, Int, Int, Boolean, VariantArray<Image>>
        =
        MethodStringName6<ImageTexture3D, Error, Image.Format, Int, Int, Int, Boolean, VariantArray<Image>>("create")

    @JvmField
    public val updateName: MethodStringName1<ImageTexture3D, Unit, VariantArray<Image>> =
        MethodStringName1<ImageTexture3D, Unit, VariantArray<Image>>("update")
  }

  public object MethodBindings {
    internal val createPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture3D", "create", 1130379827)

    internal val updatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture3D", "update", 381264803)
  }
}
