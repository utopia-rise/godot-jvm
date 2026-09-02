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
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A node that displays a 2D texture in a 3D environment. The texture displayed can be a region from
 * a larger atlas texture, or a frame from a sprite sheet animation. See also [SpriteBase3D] where
 * properties such as the billboard mode are defined.
 */
@GodotBaseType
public open class Sprite3D : SpriteBase3D() {
  /**
   * Emitted when the [frame] changes.
   */
  public val frameChanged: Signal0 by Signal0

  /**
   * Emitted when the [texture] changes.
   */
  public val textureChanged: Signal0 by Signal0

  /**
   * [Texture2D] object to draw. If [GeometryInstance3D.materialOverride] is used, this will be
   * overridden. The size information is still used.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * The number of columns in the sprite sheet. When this property is changed, [frame] is adjusted
   * so that the same visual frame is maintained (same row and column). If that's impossible, [frame]
   * is reset to `0`.
   */
  public final inline var hframes: Int
    @JvmName("hframesProperty")
    get() = getHframes()
    @JvmName("hframesProperty")
    set(`value`) {
      setHframes(value)
    }

  /**
   * The number of rows in the sprite sheet. When this property is changed, [frame] is adjusted so
   * that the same visual frame is maintained (same row and column). If that's impossible, [frame] is
   * reset to `0`.
   */
  public final inline var vframes: Int
    @JvmName("vframesProperty")
    get() = getVframes()
    @JvmName("vframesProperty")
    set(`value`) {
      setVframes(value)
    }

  /**
   * Current frame to display from sprite sheet. [hframes] or [vframes] must be greater than 1. This
   * property is automatically adjusted when [hframes] or [vframes] are changed to keep pointing to the
   * same visual frame (same column and row). If that's impossible, this value is reset to `0`.
   */
  public final inline var frame: Int
    @JvmName("frameProperty")
    get() = getFrame()
    @JvmName("frameProperty")
    set(`value`) {
      setFrame(value)
    }

  /**
   * Coordinates of the frame to display from sprite sheet. This is as an alias for the [frame]
   * property. [hframes] or [vframes] must be greater than 1.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var frameCoords: Vector2i
    @JvmName("frameCoordsProperty")
    get() = getFrameCoords()
    @JvmName("frameCoordsProperty")
    set(`value`) {
      setFrameCoords(value)
    }

  /**
   * If `true`, the sprite will use [regionRect] and display only the specified part of its texture.
   */
  public final inline var regionEnabled: Boolean
    @JvmName("regionEnabledProperty")
    get() = isRegionEnabled()
    @JvmName("regionEnabledProperty")
    set(`value`) {
      setRegionEnabled(value)
    }

  /**
   * The region of the atlas texture to display. [regionEnabled] must be `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var regionRect: Rect2
    @JvmName("regionRectProperty")
    get() = getRegionRect()
    @JvmName("regionRectProperty")
    set(`value`) {
      setRegionRect(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(700, scriptPtr)
  }

  /**
   * This is a helper function for [frameCoords] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = sprite3d.frameCoords
   * //Your changes
   * sprite3d.frameCoords = myCoreType
   * ``````
   *
   * Coordinates of the frame to display from sprite sheet. This is as an alias for the [frame]
   * property. [hframes] or [vframes] must be greater than 1.
   */
  @CoreTypeHelper
  public final fun frameCoordsMutate(block: Vector2i.() -> Unit): Vector2i = frameCoords.apply {
     block(this)
     frameCoords = this
  }

  /**
   * This is a helper function for [regionRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = sprite3d.regionRect
   * //Your changes
   * sprite3d.regionRect = myCoreType
   * ``````
   *
   * The region of the atlas texture to display. [regionEnabled] must be `true`.
   */
  @CoreTypeHelper
  public final fun regionRectMutate(block: Rect2.() -> Unit): Rect2 = regionRect.apply {
     block(this)
     regionRect = this
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

  public final fun setRegionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRegionEnabledPtr)
  }

  public final fun isRegionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRegionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRegionRect(rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.setRegionRectPtr)
  }

  public final fun getRegionRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRegionRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setFrame(frame: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frame.toLong())
    TransferContext.callMethod(MethodBindings.setFramePtr)
  }

  public final fun getFrame(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFrameCoords(coords: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.setFrameCoordsPtr)
  }

  public final fun getFrameCoords(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameCoordsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setVframes(vframes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to vframes.toLong())
    TransferContext.callMethod(MethodBindings.setVframesPtr)
  }

  public final fun getVframes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVframesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHframes(hframes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to hframes.toLong())
    TransferContext.callMethod(MethodBindings.setHframesPtr)
  }

  public final fun getHframes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHframesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<Sprite3D, Unit, Texture2D?> =
        MethodStringName1<Sprite3D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<Sprite3D, Texture2D?> =
        MethodStringName0<Sprite3D, Texture2D?>("get_texture")

    @JvmField
    public val setRegionEnabledName: MethodStringName1<Sprite3D, Unit, Boolean> =
        MethodStringName1<Sprite3D, Unit, Boolean>("set_region_enabled")

    @JvmField
    public val isRegionEnabledName: MethodStringName0<Sprite3D, Boolean> =
        MethodStringName0<Sprite3D, Boolean>("is_region_enabled")

    @JvmField
    public val setRegionRectName: MethodStringName1<Sprite3D, Unit, Rect2> =
        MethodStringName1<Sprite3D, Unit, Rect2>("set_region_rect")

    @JvmField
    public val getRegionRectName: MethodStringName0<Sprite3D, Rect2> =
        MethodStringName0<Sprite3D, Rect2>("get_region_rect")

    @JvmField
    public val setFrameName: MethodStringName1<Sprite3D, Unit, Int> =
        MethodStringName1<Sprite3D, Unit, Int>("set_frame")

    @JvmField
    public val getFrameName: MethodStringName0<Sprite3D, Int> =
        MethodStringName0<Sprite3D, Int>("get_frame")

    @JvmField
    public val setFrameCoordsName: MethodStringName1<Sprite3D, Unit, Vector2i> =
        MethodStringName1<Sprite3D, Unit, Vector2i>("set_frame_coords")

    @JvmField
    public val getFrameCoordsName: MethodStringName0<Sprite3D, Vector2i> =
        MethodStringName0<Sprite3D, Vector2i>("get_frame_coords")

    @JvmField
    public val setVframesName: MethodStringName1<Sprite3D, Unit, Int> =
        MethodStringName1<Sprite3D, Unit, Int>("set_vframes")

    @JvmField
    public val getVframesName: MethodStringName0<Sprite3D, Int> =
        MethodStringName0<Sprite3D, Int>("get_vframes")

    @JvmField
    public val setHframesName: MethodStringName1<Sprite3D, Unit, Int> =
        MethodStringName1<Sprite3D, Unit, Int>("set_hframes")

    @JvmField
    public val getHframesName: MethodStringName0<Sprite3D, Int> =
        MethodStringName0<Sprite3D, Int>("get_hframes")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_texture", 3635182373)

    internal val setRegionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_region_enabled", 2586408642)

    internal val isRegionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "is_region_enabled", 36873697)

    internal val setRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_region_rect", 2046264180)

    internal val getRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_region_rect", 1639390495)

    internal val setFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_frame", 1286410249)

    internal val getFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_frame", 3905245786)

    internal val setFrameCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_frame_coords", 1130785943)

    internal val getFrameCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_frame_coords", 3690982128)

    internal val setVframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_vframes", 1286410249)

    internal val getVframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_vframes", 3905245786)

    internal val setHframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "set_hframes", 1286410249)

    internal val getHframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite3D", "get_hframes", 3905245786)
  }
}
