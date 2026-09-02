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
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import kotlin.Double
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
    createNativeObject(255, scriptPtr)
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
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiffuseImgPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  public final fun setDiffuseImg(diffuseImg: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to diffuseImg)
    TransferContext.callMethod(MethodBindings.setDiffuseImgPtr)
  }

  public final fun getDiffuseFactor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiffuseFactorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setDiffuseFactor(diffuseFactor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to diffuseFactor)
    TransferContext.callMethod(MethodBindings.setDiffuseFactorPtr)
  }

  public final fun getGlossFactor(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlossFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlossFactor(glossFactor: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to glossFactor.toDouble())
    TransferContext.callMethod(MethodBindings.setGlossFactorPtr)
  }

  public final fun getSpecularFactor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpecularFactorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSpecularFactor(specularFactor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to specularFactor)
    TransferContext.callMethod(MethodBindings.setSpecularFactorPtr)
  }

  public final fun getSpecGlossImg(): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpecGlossImgPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  public final fun setSpecGlossImg(specGlossImg: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to specGlossImg)
    TransferContext.callMethod(MethodBindings.setSpecGlossImgPtr)
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
