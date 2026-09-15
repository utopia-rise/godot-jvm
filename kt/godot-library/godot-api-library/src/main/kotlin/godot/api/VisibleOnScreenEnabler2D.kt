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
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VisibleOnScreenEnabler2D] contains a rectangular region of 2D space and a target node. The
 * target node will be automatically enabled (via its [Node.processMode] property) when any part of
 * this region becomes visible on the screen, and automatically disabled otherwise. This can for
 * example be used to activate enemies only when the player approaches them.
 *
 * See [VisibleOnScreenNotifier2D] if you only want to be notified when the region is visible on
 * screen.
 *
 * **Note:** [VisibleOnScreenEnabler2D] uses the render culling code to determine whether it's
 * visible on screen, so it won't function unless [CanvasItem.visible] is set to `true`.
 */
@GodotBaseType
public open class VisibleOnScreenEnabler2D : VisibleOnScreenNotifier2D() {
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
   * The path to the target node, relative to the [VisibleOnScreenEnabler2D]. The target node is
   * cached; it's only assigned when setting this property (if the [VisibleOnScreenEnabler2D] is inside
   * the scene tree) and every time the [VisibleOnScreenEnabler2D] enters the scene tree. If the path
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
    createNativeObject(799, scriptPtr)
  }

  public final fun setEnableMode(mode: EnableMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setEnableModePtr)
  }

  public final fun getEnableMode(): EnableMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableModePtr)
    return EnableMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setEnableNodePath(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.setEnableNodePathPtr)
  }

  public final fun getEnableNodePath(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableNodePathPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

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
    public val setEnableModeName: MethodStringName1<VisibleOnScreenEnabler2D, Unit, EnableMode> =
        MethodStringName1<VisibleOnScreenEnabler2D, Unit, EnableMode>("set_enable_mode")

    @JvmField
    public val getEnableModeName: MethodStringName0<VisibleOnScreenEnabler2D, EnableMode> =
        MethodStringName0<VisibleOnScreenEnabler2D, EnableMode>("get_enable_mode")

    @JvmField
    public val setEnableNodePathName: MethodStringName1<VisibleOnScreenEnabler2D, Unit, NodePath> =
        MethodStringName1<VisibleOnScreenEnabler2D, Unit, NodePath>("set_enable_node_path")

    @JvmField
    public val getEnableNodePathName: MethodStringName0<VisibleOnScreenEnabler2D, NodePath> =
        MethodStringName0<VisibleOnScreenEnabler2D, NodePath>("get_enable_node_path")
  }

  public object MethodBindings {
    internal val setEnableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler2D", "set_enable_mode", 2961788752)

    internal val getEnableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler2D", "get_enable_mode", 2650445576)

    internal val setEnableNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler2D", "set_enable_node_path", 1348162250)

    internal val getEnableNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisibleOnScreenEnabler2D", "get_enable_node_path", 277076166)
  }
}
