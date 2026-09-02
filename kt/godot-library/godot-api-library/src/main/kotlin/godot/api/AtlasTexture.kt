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
import godot.core.Rect2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [Texture2D] resource that draws only part of its [atlas] texture, as defined by the [region]. An
 * additional [margin] can also be set, which is useful for small adjustments.
 *
 * Multiple [AtlasTexture] resources can be cropped from the same [atlas]. Packing many smaller
 * textures into a singular large texture helps to optimize video memory costs and render calls.
 *
 * **Note:** [AtlasTexture] cannot be used in an [AnimatedTexture], and will not tile properly in
 * nodes such as [TextureRect] or [Sprite2D]. To tile an [AtlasTexture], modify its [region] instead.
 */
@GodotBaseType
public open class AtlasTexture : Texture2D() {
  /**
   * The texture that contains the atlas. Can be any type inheriting from [Texture2D], including
   * another [AtlasTexture].
   */
  public final inline var atlas: Texture2D?
    @JvmName("atlasProperty")
    get() = getAtlas()
    @JvmName("atlasProperty")
    set(`value`) {
      setAtlas(value)
    }

  /**
   * The region used to draw the [atlas]. If either dimension of the region's size is `0`, the value
   * from [atlas] size will be used for that axis instead.
   *
   * **Note:** The image size is always an integer, so the actual region size is rounded down.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var region: Rect2
    @JvmName("regionProperty")
    get() = getRegion()
    @JvmName("regionProperty")
    set(`value`) {
      setRegion(value)
    }

  /**
   * The margin around the [region]. Useful for small adjustments. If the [Rect2.size] of this
   * property ("w" and "h" in the editor) is set, the drawn texture is resized to fit within the
   * margin.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var margin: Rect2
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
    }

  /**
   * If `true`, the area outside of the [region] is clipped to avoid bleeding of the surrounding
   * texture pixels.
   */
  public final inline var filterClip: Boolean
    @JvmName("filterClipProperty")
    get() = hasFilterClip()
    @JvmName("filterClipProperty")
    set(`value`) {
      setFilterClip(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(46, scriptPtr)
  }

  /**
   * This is a helper function for [region] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = atlastexture.region
   * //Your changes
   * atlastexture.region = myCoreType
   * ``````
   *
   * The region used to draw the [atlas]. If either dimension of the region's size is `0`, the value
   * from [atlas] size will be used for that axis instead.
   *
   * **Note:** The image size is always an integer, so the actual region size is rounded down.
   */
  @CoreTypeHelper
  public final fun regionMutate(block: Rect2.() -> Unit): Rect2 = region.apply {
     block(this)
     region = this
  }

  /**
   * This is a helper function for [margin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = atlastexture.margin
   * //Your changes
   * atlastexture.margin = myCoreType
   * ``````
   *
   * The margin around the [region]. Useful for small adjustments. If the [Rect2.size] of this
   * property ("w" and "h" in the editor) is set, the drawn texture is resized to fit within the
   * margin.
   */
  @CoreTypeHelper
  public final fun marginMutate(block: Rect2.() -> Unit): Rect2 = margin.apply {
     block(this)
     margin = this
  }

  public final fun setAtlas(atlas: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to atlas)
    TransferContext.callMethod(MethodBindings.setAtlasPtr)
  }

  public final fun getAtlas(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAtlasPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setRegion(region: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to region)
    TransferContext.callMethod(MethodBindings.setRegionPtr)
  }

  public final fun getRegion(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRegionPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setMargin(margin: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to margin)
    TransferContext.callMethod(MethodBindings.setMarginPtr)
  }

  public final fun getMargin(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarginPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setFilterClip(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFilterClipPtr)
  }

  public final fun hasFilterClip(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasFilterClipPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("AtlasTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("AtlasTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setAtlasName: MethodStringName1<AtlasTexture, Unit, Texture2D?> =
        MethodStringName1<AtlasTexture, Unit, Texture2D?>("set_atlas")

    @JvmField
    public val getAtlasName: MethodStringName0<AtlasTexture, Texture2D?> =
        MethodStringName0<AtlasTexture, Texture2D?>("get_atlas")

    @JvmField
    public val setRegionName: MethodStringName1<AtlasTexture, Unit, Rect2> =
        MethodStringName1<AtlasTexture, Unit, Rect2>("set_region")

    @JvmField
    public val getRegionName: MethodStringName0<AtlasTexture, Rect2> =
        MethodStringName0<AtlasTexture, Rect2>("get_region")

    @JvmField
    public val setMarginName: MethodStringName1<AtlasTexture, Unit, Rect2> =
        MethodStringName1<AtlasTexture, Unit, Rect2>("set_margin")

    @JvmField
    public val getMarginName: MethodStringName0<AtlasTexture, Rect2> =
        MethodStringName0<AtlasTexture, Rect2>("get_margin")

    @JvmField
    public val setFilterClipName: MethodStringName1<AtlasTexture, Unit, Boolean> =
        MethodStringName1<AtlasTexture, Unit, Boolean>("set_filter_clip")

    @JvmField
    public val hasFilterClipName: MethodStringName0<AtlasTexture, Boolean> =
        MethodStringName0<AtlasTexture, Boolean>("has_filter_clip")
  }

  public object MethodBindings {
    internal val setAtlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "set_atlas", 4051416890)

    internal val getAtlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "get_atlas", 3635182373)

    internal val setRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "set_region", 2046264180)

    internal val getRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "get_region", 1639390495)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "set_margin", 2046264180)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "get_margin", 1639390495)

    internal val setFilterClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "set_filter_clip", 2586408642)

    internal val hasFilterClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AtlasTexture", "has_filter_clip", 36873697)
  }
}
