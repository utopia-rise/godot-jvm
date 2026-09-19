// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod_LONG
import godot.callPtrMethod_NODE_PATH
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.asCachedNodePath
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VisibleOnScreenEnabler3D] contains a box-shaped region of 3D space and a target node. The target
 * node will be automatically enabled (via its [Node.processMode] property) when any part of this
 * region becomes visible on the screen, and automatically disabled otherwise. This can for example be
 * used to activate enemies only when the player approaches them.
 *
 * See [VisibleOnScreenNotifier3D] if you only want to be notified when the region is visible on
 * screen.
 *
 * **Note:** [VisibleOnScreenEnabler3D] uses an approximate heuristic that doesn't take walls and
 * other occlusion into account, unless occlusion culling is used. It also won't function unless
 * [Node3D.visible] is set to `true`.
 */
@GodotBaseType
public open class VisibleOnScreenEnabler3D : VisibleOnScreenNotifier3D() {
  /**
   * Determines how the target node is enabled. Corresponds to [Node.ProcessMode]. When the node is
   * disabled, it always uses [Node.PROCESS_MODE_DISABLED].
   */
  public final inline var enableMode: EnableMode
    @JvmName("enableModeProperty")
    get() = getEnableMode()
    @JvmName("enableModeProperty")
    set(`value`) {
      setEnableMode(value)
    }

  /**
   * The path to the target node, relative to the [VisibleOnScreenEnabler3D]. The target node is
   * cached; it's only assigned when setting this property (if the [VisibleOnScreenEnabler3D] is inside
   * the scene tree) and every time the [VisibleOnScreenEnabler3D] enters the scene tree. If the path
   * is empty, no node will be affected. If the path is invalid, an error is also generated.
   */
  public final inline var enableNodePath: NodePath
    @JvmName("enableNodePathProperty")
    get() = getEnableNodePath()
    @JvmName("enableNodePathProperty")
    set(`value`) {
      setEnableNodePath(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(800, scriptPtr)
  }

  public final fun setEnableMode(mode: EnableMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setEnableModePtr, mode.value)
  }

  public final fun getEnableMode(): EnableMode =
      EnableMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getEnableModePtr))

  public final fun setEnableNodePath(path: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setEnableNodePathPtr, path)
  }

  public final fun getEnableNodePath(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getEnableNodePathPtr)

  public final fun setEnableNodePath(path: String) = setEnableNodePath(path.asCachedNodePath())

  public enum class EnableMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Corresponds to [Node.PROCESS_MODE_INHERIT].
     */
    INHERIT(0),
    /**
     * Corresponds to [Node.PROCESS_MODE_ALWAYS].
     */
    ALWAYS(1),
    /**
     * Corresponds to [Node.PROCESS_MODE_WHEN_PAUSED].
     */
    WHEN_PAUSED(2),
    ;

    public companion object {
      public fun from(`value`: Long): EnableMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setEnableModeName: MethodStringName1<VisibleOnScreenEnabler3D, Unit, EnableMode> =
        MethodStringName1<VisibleOnScreenEnabler3D, Unit, EnableMode>("set_enable_mode")

    @JvmField
    public val getEnableModeName: MethodStringName0<VisibleOnScreenEnabler3D, EnableMode> =
        MethodStringName0<VisibleOnScreenEnabler3D, EnableMode>("get_enable_mode")

    @JvmField
    public val setEnableNodePathName: MethodStringName1<VisibleOnScreenEnabler3D, Unit, NodePath> =
        MethodStringName1<VisibleOnScreenEnabler3D, Unit, NodePath>("set_enable_node_path")

    @JvmField
    public val getEnableNodePathName: MethodStringName0<VisibleOnScreenEnabler3D, NodePath> =
        MethodStringName0<VisibleOnScreenEnabler3D, NodePath>("get_enable_node_path")
  }

  public object MethodBindings {
    internal val setEnableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler3D", "set_enable_mode", 320303646)

    internal val getEnableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler3D", "get_enable_mode", 3352990031)

    internal val setEnableNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler3D", "set_enable_node_path", 1348162250)

    internal val getEnableNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler3D", "get_enable_node_path", 277076166)
  }
}
