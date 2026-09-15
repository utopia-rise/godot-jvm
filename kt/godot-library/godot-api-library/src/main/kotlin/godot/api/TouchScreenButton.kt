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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * TouchScreenButton allows you to create on-screen buttons for touch devices. It's intended for
 * gameplay use, such as a unit you have to touch to move. Unlike [Button], TouchScreenButton supports
 * multitouch out of the box. Several TouchScreenButtons can be pressed at the same time with touch
 * input.
 *
 * This node inherits from [Node2D]. Unlike with [Control] nodes, you cannot set anchors on it. If
 * you want to create menus or user interfaces, you may want to use [Button] nodes instead. To make
 * button nodes react to touch events, you can enable
 * [ProjectSettings.inputDevices/pointing/emulateMouseFromTouch] in the Project Settings.
 *
 * You can configure TouchScreenButton to be visible only on touch devices, helping you develop your
 * game both for desktop and mobile devices.
 */
@GodotBaseType
public open class TouchScreenButton : Node2D() {
  /**
   * Emitted when the button is pressed (down).
   */
  public val pressed: Signal0 by Signal0

  /**
   * Emitted when the button is released (up).
   */
  public val released: Signal0 by Signal0

  /**
   * The button's texture for the normal state.
   */
  public final inline var textureNormal: Texture2D?
    @JvmName("textureNormalProperty")
    get() = getTextureNormal()
    @JvmName("textureNormalProperty")
    set(`value`) {
      setTextureNormal(value)
    }

  /**
   * The button's texture for the pressed state.
   */
  public final inline var texturePressed: Texture2D?
    @JvmName("texturePressedProperty")
    get() = getTexturePressed()
    @JvmName("texturePressedProperty")
    set(`value`) {
      setTexturePressed(value)
    }

  /**
   * The button's bitmask.
   */
  public final inline var bitmask: BitMap?
    @JvmName("bitmaskProperty")
    get() = getBitmask()
    @JvmName("bitmaskProperty")
    set(`value`) {
      setBitmask(value)
    }

  /**
   * The button's shape.
   */
  public final inline var shape: Shape2D?
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * If `true`, the button's shape is centered in the provided texture. If no texture is used, this
   * property has no effect.
   */
  public final inline var shapeCentered: Boolean
    @JvmName("shapeCenteredProperty")
    get() = isShapeCentered()
    @JvmName("shapeCenteredProperty")
    set(`value`) {
      setShapeCentered(value)
    }

  /**
   * If `true`, the button's shape is visible in the editor.
   */
  public final inline var shapeVisible: Boolean
    @JvmName("shapeVisibleProperty")
    get() = isShapeVisible()
    @JvmName("shapeVisibleProperty")
    set(`value`) {
      setShapeVisible(value)
    }

  /**
   * If `true`, the [signal pressed] and [signal released] signals are emitted whenever a pressed
   * finger goes in and out of the button, even if the pressure started outside the active area of the
   * button.
   *
   * **Note:** This is a "pass-by" (not "bypass") press mode.
   */
  public final inline var passbyPress: Boolean
    @JvmName("passbyPressProperty")
    get() = isPassbyPressEnabled()
    @JvmName("passbyPressProperty")
    set(`value`) {
      setPassbyPress(value)
    }

  /**
   * The button's action. Actions can be handled with [InputEventAction].
   */
  public final inline var action: String
    @JvmName("actionProperty")
    get() = getAction()
    @JvmName("actionProperty")
    set(`value`) {
      setAction(value)
    }

  /**
   * The button's visibility mode.
   */
  public final inline var visibilityMode: VisibilityMode
    @JvmName("visibilityModeProperty")
    get() = getVisibilityMode()
    @JvmName("visibilityModeProperty")
    set(`value`) {
      setVisibilityMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(767, scriptPtr)
  }

  public final fun setTextureNormal(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTextureNormalPtr)
  }

  public final fun getTextureNormal(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureNormalPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun setTexturePressed(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTexturePressedPtr)
  }

  public final fun getTexturePressed(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePressedPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun setBitmask(bitmask: BitMap?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, bitmask)
    TransferContext.callMethod(MethodBindings.setBitmaskPtr)
  }

  public final fun getBitmask(): BitMap? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBitmaskPtr)
    return (TransferContext.readReturnValue_OBJECT() as BitMap?)
  }

  public final fun setShape(shape: Shape2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, shape)
    TransferContext.callMethod(MethodBindings.setShapePtr)
  }

  public final fun getShape(): Shape2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapePtr)
    return (TransferContext.readReturnValue_OBJECT() as Shape2D?)
  }

  public final fun setShapeCentered(bool: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, bool)
    TransferContext.callMethod(MethodBindings.setShapeCenteredPtr)
  }

  public final fun isShapeCentered(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShapeCenteredPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setShapeVisible(bool: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, bool)
    TransferContext.callMethod(MethodBindings.setShapeVisiblePtr)
  }

  public final fun isShapeVisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShapeVisiblePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAction(action: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.setActionPtr)
  }

  public final fun getAction(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setVisibilityMode(mode: VisibilityMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setVisibilityModePtr)
  }

  public final fun getVisibilityMode(): VisibilityMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityModePtr)
    return VisibilityMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPassbyPress(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setPassbyPressPtr)
  }

  public final fun isPassbyPressEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPassbyPressEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if this button is currently pressed.
   */
  public final fun isPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPressedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class VisibilityMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Always visible.
     */
    ALWAYS(0),
    /**
     * Visible on touch screens only.
     */
    TOUCHSCREEN_ONLY(1),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureNormalName: MethodStringName1<TouchScreenButton, Unit, Texture2D?> =
        MethodStringName1<TouchScreenButton, Unit, Texture2D?>("set_texture_normal")

    @JvmField
    public val getTextureNormalName: MethodStringName0<TouchScreenButton, Texture2D?> =
        MethodStringName0<TouchScreenButton, Texture2D?>("get_texture_normal")

    @JvmField
    public val setTexturePressedName: MethodStringName1<TouchScreenButton, Unit, Texture2D?> =
        MethodStringName1<TouchScreenButton, Unit, Texture2D?>("set_texture_pressed")

    @JvmField
    public val getTexturePressedName: MethodStringName0<TouchScreenButton, Texture2D?> =
        MethodStringName0<TouchScreenButton, Texture2D?>("get_texture_pressed")

    @JvmField
    public val setBitmaskName: MethodStringName1<TouchScreenButton, Unit, BitMap?> =
        MethodStringName1<TouchScreenButton, Unit, BitMap?>("set_bitmask")

    @JvmField
    public val getBitmaskName: MethodStringName0<TouchScreenButton, BitMap?> =
        MethodStringName0<TouchScreenButton, BitMap?>("get_bitmask")

    @JvmField
    public val setShapeName: MethodStringName1<TouchScreenButton, Unit, Shape2D?> =
        MethodStringName1<TouchScreenButton, Unit, Shape2D?>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<TouchScreenButton, Shape2D?> =
        MethodStringName0<TouchScreenButton, Shape2D?>("get_shape")

    @JvmField
    public val setShapeCenteredName: MethodStringName1<TouchScreenButton, Unit, Boolean> =
        MethodStringName1<TouchScreenButton, Unit, Boolean>("set_shape_centered")

    @JvmField
    public val isShapeCenteredName: MethodStringName0<TouchScreenButton, Boolean> =
        MethodStringName0<TouchScreenButton, Boolean>("is_shape_centered")

    @JvmField
    public val setShapeVisibleName: MethodStringName1<TouchScreenButton, Unit, Boolean> =
        MethodStringName1<TouchScreenButton, Unit, Boolean>("set_shape_visible")

    @JvmField
    public val isShapeVisibleName: MethodStringName0<TouchScreenButton, Boolean> =
        MethodStringName0<TouchScreenButton, Boolean>("is_shape_visible")

    @JvmField
    public val setActionName: MethodStringName1<TouchScreenButton, Unit, String> =
        MethodStringName1<TouchScreenButton, Unit, String>("set_action")

    @JvmField
    public val getActionName: MethodStringName0<TouchScreenButton, String> =
        MethodStringName0<TouchScreenButton, String>("get_action")

    @JvmField
    public val setVisibilityModeName: MethodStringName1<TouchScreenButton, Unit, VisibilityMode> =
        MethodStringName1<TouchScreenButton, Unit, VisibilityMode>("set_visibility_mode")

    @JvmField
    public val getVisibilityModeName: MethodStringName0<TouchScreenButton, VisibilityMode> =
        MethodStringName0<TouchScreenButton, VisibilityMode>("get_visibility_mode")

    @JvmField
    public val setPassbyPressName: MethodStringName1<TouchScreenButton, Unit, Boolean> =
        MethodStringName1<TouchScreenButton, Unit, Boolean>("set_passby_press")

    @JvmField
    public val isPassbyPressEnabledName: MethodStringName0<TouchScreenButton, Boolean> =
        MethodStringName0<TouchScreenButton, Boolean>("is_passby_press_enabled")

    @JvmField
    public val isPressedName: MethodStringName0<TouchScreenButton, Boolean> =
        MethodStringName0<TouchScreenButton, Boolean>("is_pressed")
  }

  public object MethodBindings {
    internal val setTextureNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_texture_normal", 4051416890)

    internal val getTextureNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_texture_normal", 3635182373)

    internal val setTexturePressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_texture_pressed", 4051416890)

    internal val getTexturePressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_texture_pressed", 3635182373)

    internal val setBitmaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_bitmask", 698588216)

    internal val getBitmaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_bitmask", 2459671998)

    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_shape", 771364740)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_shape", 522005891)

    internal val setShapeCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_shape_centered", 2586408642)

    internal val isShapeCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "is_shape_centered", 36873697)

    internal val setShapeVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_shape_visible", 2586408642)

    internal val isShapeVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "is_shape_visible", 36873697)

    internal val setActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_action", 83702148)

    internal val getActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_action", 201670096)

    internal val setVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_visibility_mode", 3031128463)

    internal val getVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "get_visibility_mode", 2558996468)

    internal val setPassbyPressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "set_passby_press", 2586408642)

    internal val isPassbyPressEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "is_passby_press_enabled", 36873697)

    internal val isPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TouchScreenButton", "is_pressed", 36873697)
  }
}
