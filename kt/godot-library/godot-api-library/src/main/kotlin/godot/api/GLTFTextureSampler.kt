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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Represents a texture sampler as defined by the base glTF spec. Texture samplers in glTF specify
 * how to sample data from the texture's base image, when rendering the texture on an object.
 */
@GodotBaseType
public open class GLTFTextureSampler : Resource() {
  /**
   * Texture's magnification filter, used when texture appears larger on screen than the source
   * image.
   */
  public final inline var magFilter: Int
    @JvmName("magFilterProperty")
    get() = getMagFilter()
    @JvmName("magFilterProperty")
    set(`value`) {
      setMagFilter(value)
    }

  /**
   * Texture's minification filter, used when the texture appears smaller on screen than the source
   * image.
   */
  public final inline var minFilter: Int
    @JvmName("minFilterProperty")
    get() = getMinFilter()
    @JvmName("minFilterProperty")
    set(`value`) {
      setMinFilter(value)
    }

  /**
   * Wrapping mode to use for S-axis (horizontal) texture coordinates.
   */
  public final inline var wrapS: Int
    @JvmName("wrapSProperty")
    get() = getWrapS()
    @JvmName("wrapSProperty")
    set(`value`) {
      setWrapS(value)
    }

  /**
   * Wrapping mode to use for T-axis (vertical) texture coordinates.
   */
  public final inline var wrapT: Int
    @JvmName("wrapTProperty")
    get() = getWrapT()
    @JvmName("wrapTProperty")
    set(`value`) {
      setWrapT(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(256, scriptPtr)
  }

  public final fun getMagFilter(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMagFilterPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setMagFilter(filterMode: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, filterMode.toLong())
    TransferContext.callMethod(MethodBindings.setMagFilterPtr)
  }

  public final fun getMinFilter(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinFilterPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setMinFilter(filterMode: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, filterMode.toLong())
    TransferContext.callMethod(MethodBindings.setMinFilterPtr)
  }

  public final fun getWrapS(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWrapSPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setWrapS(wrapMode: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, wrapMode.toLong())
    TransferContext.callMethod(MethodBindings.setWrapSPtr)
  }

  public final fun getWrapT(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWrapTPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setWrapT(wrapMode: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, wrapMode.toLong())
    TransferContext.callMethod(MethodBindings.setWrapTPtr)
  }

  public companion object {
    @JvmField
    public val getMagFilterName: MethodStringName0<GLTFTextureSampler, Int> =
        MethodStringName0<GLTFTextureSampler, Int>("get_mag_filter")

    @JvmField
    public val setMagFilterName: MethodStringName1<GLTFTextureSampler, Unit, Int> =
        MethodStringName1<GLTFTextureSampler, Unit, Int>("set_mag_filter")

    @JvmField
    public val getMinFilterName: MethodStringName0<GLTFTextureSampler, Int> =
        MethodStringName0<GLTFTextureSampler, Int>("get_min_filter")

    @JvmField
    public val setMinFilterName: MethodStringName1<GLTFTextureSampler, Unit, Int> =
        MethodStringName1<GLTFTextureSampler, Unit, Int>("set_min_filter")

    @JvmField
    public val getWrapSName: MethodStringName0<GLTFTextureSampler, Int> =
        MethodStringName0<GLTFTextureSampler, Int>("get_wrap_s")

    @JvmField
    public val setWrapSName: MethodStringName1<GLTFTextureSampler, Unit, Int> =
        MethodStringName1<GLTFTextureSampler, Unit, Int>("set_wrap_s")

    @JvmField
    public val getWrapTName: MethodStringName0<GLTFTextureSampler, Int> =
        MethodStringName0<GLTFTextureSampler, Int>("get_wrap_t")

    @JvmField
    public val setWrapTName: MethodStringName1<GLTFTextureSampler, Unit, Int> =
        MethodStringName1<GLTFTextureSampler, Unit, Int>("set_wrap_t")
  }

  public object MethodBindings {
    internal val getMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "get_mag_filter", 3905245786)

    internal val setMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "set_mag_filter", 1286410249)

    internal val getMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "get_min_filter", 3905245786)

    internal val setMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "set_min_filter", 1286410249)

    internal val getWrapSPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "get_wrap_s", 3905245786)

    internal val setWrapSPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "set_wrap_s", 1286410249)

    internal val getWrapTPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "get_wrap_t", 3905245786)

    internal val setWrapTPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTextureSampler", "set_wrap_t", 1286410249)
  }
}
