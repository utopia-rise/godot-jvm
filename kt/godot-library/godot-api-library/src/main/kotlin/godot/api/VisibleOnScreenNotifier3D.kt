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
import godot.core.AABB
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VisibleOnScreenNotifier3D] represents a box-shaped region of 3D space. When any part of this
 * region becomes visible on screen or in a [Camera3D]'s view, it will emit a [signal screen_entered]
 * signal, and likewise it will emit a [signal screen_exited] signal when no part of it remains
 * visible.
 *
 * If you want a node to be enabled automatically when this region is visible on screen, use
 * [VisibleOnScreenEnabler3D].
 *
 * **Note:** [VisibleOnScreenNotifier3D] uses an approximate heuristic that doesn't take walls and
 * other occlusion into account, unless occlusion culling is used. It also won't function unless
 * [Node3D.visible] is set to `true`.
 */
@GodotBaseType
public open class VisibleOnScreenNotifier3D : VisualInstance3D() {
  /**
   * Emitted when the [VisibleOnScreenNotifier3D] enters the screen.
   */
  public val screenEntered: Signal0 by Signal0

  /**
   * Emitted when the [VisibleOnScreenNotifier3D] exits the screen.
   */
  public val screenExited: Signal0 by Signal0

  /**
   * The [VisibleOnScreenNotifier3D]'s bounding box.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var aabb: AABB
    @JvmName("aabbProperty")
    get() = getAabb()
    @JvmName("aabbProperty")
    set(`value`) {
      setAabb(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(802, scriptPtr)
  }

  /**
   * This is a helper function for [aabb] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visibleonscreennotifier3d.aabb
   * //Your changes
   * visibleonscreennotifier3d.aabb = myCoreType
   * ``````
   *
   * The [VisibleOnScreenNotifier3D]'s bounding box.
   */
  @CoreTypeHelper
  public final fun aabbMutate(block: AABB.() -> Unit): AABB = aabb.apply {
     block(this)
     aabb = this
  }

  public final fun setAabb(rect: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, godot.core.VariantParser.AABB to rect)
    TransferContext.callMethod(MethodBindings.setAabbPtr)
  }

  /**
   * Returns `true` if the bounding box is on the screen.
   *
   * **Note:** It takes one frame for the [VisibleOnScreenNotifier3D]'s visibility to be assessed
   * once added to the scene tree, so this method will always return `false` right after it is
   * instantiated.
   */
  public final fun isOnScreen(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnScreenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setAabbName: MethodStringName1<VisibleOnScreenNotifier3D, Unit, AABB> =
        MethodStringName1<VisibleOnScreenNotifier3D, Unit, AABB>("set_aabb")

    @JvmField
    public val isOnScreenName: MethodStringName0<VisibleOnScreenNotifier3D, Boolean> =
        MethodStringName0<VisibleOnScreenNotifier3D, Boolean>("is_on_screen")
  }

  public object MethodBindings {
    internal val setAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier3D", "set_aabb", 259215842)

    internal val isOnScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenNotifier3D", "is_on_screen", 36873697)
  }
}
