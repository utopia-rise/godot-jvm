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
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Double
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Casts light in a 2D environment. This light's shape is defined by a (usually grayscale) texture.
 */
@GodotBaseType
public open class PointLight2D : Light2D() {
  /**
   * [Texture2D] used for the light's appearance.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * The offset of the light's [texture].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector2
    @JvmName("offsetProperty")
    get() = getTextureOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setTextureOffset(value)
    }

  /**
   * The [texture]'s scale factor.
   */
  public final inline var textureScale: Float
    @JvmName("textureScaleProperty")
    get() = getTextureScale()
    @JvmName("textureScaleProperty")
    set(`value`) {
      setTextureScale(value)
    }

  /**
   * The height of the light. Used with 2D normal mapping. The units are in pixels, e.g. if the
   * height is 100, then it will illuminate an object 100 pixels away at a 45° angle to the plane.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(561, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = pointlight2d.offset
   * //Your changes
   * pointlight2d.offset = myCoreType
   * ``````
   *
   * The offset of the light's [texture].
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setTextureOffset(textureOffset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to textureOffset)
    TransferContext.callMethod(MethodBindings.setTextureOffsetPtr)
  }

  public final fun getTextureOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setTextureScale(textureScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to textureScale.toDouble())
    TransferContext.callMethod(MethodBindings.setTextureScalePtr)
  }

  public final fun getTextureScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<PointLight2D, Unit, Texture2D?> =
        MethodStringName1<PointLight2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<PointLight2D, Texture2D?> =
        MethodStringName0<PointLight2D, Texture2D?>("get_texture")

    @JvmField
    public val setTextureOffsetName: MethodStringName1<PointLight2D, Unit, Vector2> =
        MethodStringName1<PointLight2D, Unit, Vector2>("set_texture_offset")

    @JvmField
    public val getTextureOffsetName: MethodStringName0<PointLight2D, Vector2> =
        MethodStringName0<PointLight2D, Vector2>("get_texture_offset")

    @JvmField
    public val setTextureScaleName: MethodStringName1<PointLight2D, Unit, Float> =
        MethodStringName1<PointLight2D, Unit, Float>("set_texture_scale")

    @JvmField
    public val getTextureScaleName: MethodStringName0<PointLight2D, Float> =
        MethodStringName0<PointLight2D, Float>("get_texture_scale")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "get_texture", 3635182373)

    internal val setTextureOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "set_texture_offset", 743155724)

    internal val getTextureOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "get_texture_offset", 3341600327)

    internal val setTextureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "set_texture_scale", 373806689)

    internal val getTextureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PointLight2D", "get_texture_scale", 1740695150)
  }
}
