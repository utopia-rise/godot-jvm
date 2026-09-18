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
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_COLOR
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_COLOR
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_OBJECT
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * KHR_materials_pbrSpecularGlossiness is an archived glTF extension. This means that it is
 * deprecated and not recommended for new files. However, it is still supported for loading old files.
 */
@GodotBaseType
public open class GLTFSpecGloss : Resource() {
  /**
   * The diffuse texture.
   */
  public final inline var diffuseImg: Image?
    @JvmName("diffuseImgProperty")
    get() = getDiffuseImg()
    @JvmName("diffuseImgProperty")
    set(`value`) {
      setDiffuseImg(value)
    }

  /**
   * The reflected diffuse factor of the material.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var diffuseFactor: Color
    @JvmName("diffuseFactorProperty")
    get() = getDiffuseFactor()
    @JvmName("diffuseFactorProperty")
    set(`value`) {
      setDiffuseFactor(value)
    }

  /**
   * The glossiness or smoothness of the material.
   */
  public final inline var glossFactor: Float
    @JvmName("glossFactorProperty")
    get() = getGlossFactor()
    @JvmName("glossFactorProperty")
    set(`value`) {
      setGlossFactor(value)
    }

  /**
   * The specular RGB color of the material. The alpha channel is unused.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var specularFactor: Color
    @JvmName("specularFactorProperty")
    get() = getSpecularFactor()
    @JvmName("specularFactorProperty")
    set(`value`) {
      setSpecularFactor(value)
    }

  /**
   * The specular-glossiness texture.
   */
  public final inline var specGlossImg: Image?
    @JvmName("specGlossImgProperty")
    get() = getSpecGlossImg()
    @JvmName("specGlossImgProperty")
    set(`value`) {
      setSpecGlossImg(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(253, scriptPtr)
  }

  /**
   * This is a helper function for [diffuseFactor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfspecgloss.diffuseFactor
   * //Your changes
   * gltfspecgloss.diffuseFactor = myCoreType
   * ``````
   *
   * The reflected diffuse factor of the material.
   */
  @CoreTypeHelper
  public final fun diffuseFactorMutate(block: Color.() -> Unit): Color = diffuseFactor.apply {
     block(this)
     diffuseFactor = this
  }

  /**
   * This is a helper function for [specularFactor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfspecgloss.specularFactor
   * //Your changes
   * gltfspecgloss.specularFactor = myCoreType
   * ``````
   *
   * The specular RGB color of the material. The alpha channel is unused.
   */
  @CoreTypeHelper
  public final fun specularFactorMutate(block: Color.() -> Unit): Color = specularFactor.apply {
     block(this)
     specularFactor = this
  }

  public final fun getDiffuseImg(): Image? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDiffuseImgPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  public final fun setDiffuseImg(diffuseImg: Image?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, diffuseImg)
    TransferContext.callPtrMethod(MethodBindings.setDiffuseImgPtr, 0)
  }

  public final fun getDiffuseFactor(): Color {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDiffuseFactorPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  public final fun setDiffuseFactor(diffuseFactor: Color): Unit {
    TransferContext.writeMethodArguments_COLOR(ptr, objectID.id, diffuseFactor)
    TransferContext.callPtrMethod(MethodBindings.setDiffuseFactorPtr, 0)
  }

  public final fun getGlossFactor(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGlossFactorPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setGlossFactor(glossFactor: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, glossFactor.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setGlossFactorPtr, 0)
  }

  public final fun getSpecularFactor(): Color {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSpecularFactorPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  public final fun setSpecularFactor(specularFactor: Color): Unit {
    TransferContext.writeMethodArguments_COLOR(ptr, objectID.id, specularFactor)
    TransferContext.callPtrMethod(MethodBindings.setSpecularFactorPtr, 0)
  }

  public final fun getSpecGlossImg(): Image? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSpecGlossImgPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  public final fun setSpecGlossImg(specGlossImg: Image?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, specGlossImg)
    TransferContext.callPtrMethod(MethodBindings.setSpecGlossImgPtr, 0)
  }

  public companion object {
    @JvmField
    public val getDiffuseImgName: MethodStringName0<GLTFSpecGloss, Image?> =
        MethodStringName0<GLTFSpecGloss, Image?>("get_diffuse_img")

    @JvmField
    public val setDiffuseImgName: MethodStringName1<GLTFSpecGloss, Unit, Image?> =
        MethodStringName1<GLTFSpecGloss, Unit, Image?>("set_diffuse_img")

    @JvmField
    public val getDiffuseFactorName: MethodStringName0<GLTFSpecGloss, Color> =
        MethodStringName0<GLTFSpecGloss, Color>("get_diffuse_factor")

    @JvmField
    public val setDiffuseFactorName: MethodStringName1<GLTFSpecGloss, Unit, Color> =
        MethodStringName1<GLTFSpecGloss, Unit, Color>("set_diffuse_factor")

    @JvmField
    public val getGlossFactorName: MethodStringName0<GLTFSpecGloss, Float> =
        MethodStringName0<GLTFSpecGloss, Float>("get_gloss_factor")

    @JvmField
    public val setGlossFactorName: MethodStringName1<GLTFSpecGloss, Unit, Float> =
        MethodStringName1<GLTFSpecGloss, Unit, Float>("set_gloss_factor")

    @JvmField
    public val getSpecularFactorName: MethodStringName0<GLTFSpecGloss, Color> =
        MethodStringName0<GLTFSpecGloss, Color>("get_specular_factor")

    @JvmField
    public val setSpecularFactorName: MethodStringName1<GLTFSpecGloss, Unit, Color> =
        MethodStringName1<GLTFSpecGloss, Unit, Color>("set_specular_factor")

    @JvmField
    public val getSpecGlossImgName: MethodStringName0<GLTFSpecGloss, Image?> =
        MethodStringName0<GLTFSpecGloss, Image?>("get_spec_gloss_img")

    @JvmField
    public val setSpecGlossImgName: MethodStringName1<GLTFSpecGloss, Unit, Image?> =
        MethodStringName1<GLTFSpecGloss, Unit, Image?>("set_spec_gloss_img")
  }

  public object MethodBindings {
    internal val getDiffuseImgPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "get_diffuse_img", 564927088)

    internal val setDiffuseImgPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "set_diffuse_img", 532598488)

    internal val getDiffuseFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "get_diffuse_factor", 3200896285)

    internal val setDiffuseFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "set_diffuse_factor", 2920490490)

    internal val getGlossFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "get_gloss_factor", 191475506)

    internal val setGlossFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "set_gloss_factor", 373806689)

    internal val getSpecularFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "get_specular_factor", 3200896285)

    internal val setSpecularFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "set_specular_factor", 2920490490)

    internal val getSpecGlossImgPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "get_spec_gloss_img", 564927088)

    internal val setSpecGlossImgPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSpecGloss", "set_spec_gloss_img", 532598488)
  }
}
