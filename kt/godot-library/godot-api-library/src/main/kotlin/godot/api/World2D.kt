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
import godot.core.MethodStringName0
import godot.core.RID
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Class that has everything pertaining to a 2D world: A physics space, a canvas, and a sound space.
 * 2D nodes register their resources into the current 2D world.
 */
@GodotBaseType
public open class World2D : Resource() {
  /**
   * The [RID] of this world's canvas resource. Used by the [RenderingServer] for 2D drawing.
   */
  public final inline val canvas: RID
    @JvmName("canvasProperty")
    get() = getCanvas()

  /**
   * The [RID] of this world's navigation map. Used by the [NavigationServer2D].
   */
  public final inline val navigationMap: RID
    @JvmName("navigationMapProperty")
    get() = getNavigationMap()

  /**
   * The [RID] of this world's physics space resource. Used by the [PhysicsServer2D] for 2D physics,
   * treating it as both a space and an area.
   */
  public final inline val space: RID
    @JvmName("spaceProperty")
    get() = getSpace()

  /**
   * Direct access to the world's physics 2D space state. Used for querying current and potential
   * collisions. When using multi-threaded physics, access is limited to [Node.PhysicsProcess] in the
   * main thread.
   */
  public final inline val directSpaceState: PhysicsDirectSpaceState2D?
    @JvmName("directSpaceStateProperty")
    get() = getDirectSpaceState()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(929, scriptPtr)
  }

  public final fun getCanvas(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCanvasPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun getNavigationMap(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNavigationMapPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun getSpace(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSpacePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun getDirectSpaceState(): PhysicsDirectSpaceState2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDirectSpaceStatePtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as PhysicsDirectSpaceState2D?)
  }

  public companion object {
    @JvmField
    public val getCanvasName: MethodStringName0<World2D, RID> =
        MethodStringName0<World2D, RID>("get_canvas")

    @JvmField
    public val getNavigationMapName: MethodStringName0<World2D, RID> =
        MethodStringName0<World2D, RID>("get_navigation_map")

    @JvmField
    public val getSpaceName: MethodStringName0<World2D, RID> =
        MethodStringName0<World2D, RID>("get_space")

    @JvmField
    public val getDirectSpaceStateName: MethodStringName0<World2D, PhysicsDirectSpaceState2D?> =
        MethodStringName0<World2D, PhysicsDirectSpaceState2D?>("get_direct_space_state")
  }

  public object MethodBindings {
    internal val getCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("World2D", "get_canvas", 2944877500)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("World2D", "get_navigation_map", 2944877500)

    internal val getSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("World2D", "get_space", 2944877500)

    internal val getDirectSpaceStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("World2D", "get_direct_space_state", 2506717822)
  }
}
