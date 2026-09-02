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
import godot.core.VariantParser.RECT2
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VisibleOnScreenNotifier2D] represents a rectangular region of 2D space. When any part of this
 * region becomes visible on screen or in a viewport, it will emit a [signal screen_entered] signal,
 * and likewise it will emit a [signal screen_exited] signal when no part of it remains visible.
 *
 * If you want a node to be enabled automatically when this region is visible on screen, use
 * [VisibleOnScreenEnabler2D].
 *
 * **Note:** [VisibleOnScreenNotifier2D] uses the render culling code to determine whether it's
 * visible on screen, so it won't function unless [CanvasItem.visible] is set to `true`.
 */
@GodotBaseType
public open class VisibleOnScreenNotifier2D : Node2D() {
  /**
   * Emitted when the VisibleOnScreenNotifier2D enters the screen.
   */
  public val screenEntered: Signal0 by Signal0

  /**
   * Emitted when the VisibleOnScreenNotifier2D exits the screen.
   */
  public val screenExited: Signal0 by Signal0

  /**
   * The VisibleOnScreenNotifier2D's bounding rectangle.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rect: Rect2
    @JvmName("rectProperty")
    get() = getRect()
    @JvmName("rectProperty")
    set(`value`) {
      setRect(value)
    }

  /**
   * If `true`, shows the rectangle area of [rect] in the editor with a translucent magenta fill.
   * Unlike changing the visibility of the VisibleOnScreenNotifier2D, this does not affect the screen
   * culling detection.
   */
  public final inline var showRect: Boolean
    @JvmName("showRectProperty")
    get() = isShowingRect()
    @JvmName("showRectProperty")
    set(`value`) {
      setShowRect(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(801, scriptPtr)
  }

  /**
   * This is a helper function for [rect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visibleonscreennotifier2d.rect
   * //Your changes
   * visibleonscreennotifier2d.rect = myCoreType
   * ``````
   *
   * The VisibleOnScreenNotifier2D's bounding rectangle.
   */
  @CoreTypeHelper
  public final fun rectMutate(block: Rect2.() -> Unit): Rect2 = rect.apply {
     block(this)
     rect = this
  }

  public final fun setRect(rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.setRectPtr)
  }

  public final fun getRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setShowRect(showRect: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to showRect)
    TransferContext.callMethod(MethodBindings.setShowRectPtr)
  }

  public final fun isShowingRect(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingRectPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the bounding rectangle is on the screen.
   *
   * **Note:** It takes one frame for the [VisibleOnScreenNotifier2D]'s visibility to be determined
   * once added to the scene tree, so this method will always return `false` right after it is
   * instantiated, before the draw pass.
   */
  public final fun isOnScreen(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnScreenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setRectName: MethodStringName1<VisibleOnScreenNotifier2D, Unit, Rect2> =
        MethodStringName1<VisibleOnScreenNotifier2D, Unit, Rect2>("set_rect")

    @JvmField
    public val getRectName: MethodStringName0<VisibleOnScreenNotifier2D, Rect2> =
        MethodStringName0<VisibleOnScreenNotifier2D, Rect2>("get_rect")

    @JvmField
    public val setShowRectName: MethodStringName1<VisibleOnScreenNotifier2D, Unit, Boolean> =
        MethodStringName1<VisibleOnScreenNotifier2D, Unit, Boolean>("set_show_rect")

    @JvmField
    public val isShowingRectName: MethodStringName0<VisibleOnScreenNotifier2D, Boolean> =
        MethodStringName0<VisibleOnScreenNotifier2D, Boolean>("is_showing_rect")

    @JvmField
    public val isOnScreenName: MethodStringName0<VisibleOnScreenNotifier2D, Boolean> =
        MethodStringName0<VisibleOnScreenNotifier2D, Boolean>("is_on_screen")
  }

  public object MethodBindings {
    internal val setRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier2D", "set_rect", 2046264180)

    internal val getRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier2D", "get_rect", 1639390495)

    internal val setShowRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier2D", "set_show_rect", 2586408642)

    internal val isShowingRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier2D", "is_showing_rect", 36873697)

    internal val isOnScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier2D", "is_on_screen", 36873697)
  }
}
