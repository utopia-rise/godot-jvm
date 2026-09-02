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
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [GraphElement] allows to create custom elements for a [GraphEdit] graph. By default such elements
 * can be selected, resized, and repositioned, but they cannot be connected. For a graph element that
 * allows for connections see [GraphNode].
 */
@GodotBaseType
public open class GraphElement : Container() {
  /**
   * Emitted when the GraphElement is selected.
   */
  public val nodeSelected: Signal0 by Signal0

  /**
   * Emitted when the GraphElement is deselected.
   */
  public val nodeDeselected: Signal0 by Signal0

  /**
   * Emitted when displaying the GraphElement over other ones is requested. Happens on focusing
   * (clicking into) the GraphElement.
   */
  public val raiseRequest: Signal0 by Signal0

  /**
   * Emitted when removing the GraphElement is requested.
   */
  public val deleteRequest: Signal0 by Signal0

  /**
   * Emitted when resizing the GraphElement is requested. Happens on dragging the resizer handle
   * (see [resizable]).
   */
  public val resizeRequest: Signal1<Vector2> by Signal1

  /**
   * Emitted when releasing the mouse button after dragging the resizer handle (see [resizable]).
   */
  public val resizeEnd: Signal1<Vector2> by Signal1

  /**
   * Emitted when the GraphElement is dragged.
   */
  public val dragged: Signal2<Vector2, Vector2> by Signal2

  /**
   * Emitted when the GraphElement is moved.
   */
  public val positionOffsetChanged: Signal0 by Signal0

  /**
   * The offset of the GraphElement, relative to the scroll offset of the [GraphEdit].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var positionOffset: Vector2
    @JvmName("positionOffsetProperty")
    get() = getPositionOffset()
    @JvmName("positionOffsetProperty")
    set(`value`) {
      setPositionOffset(value)
    }

  /**
   * If `true`, the user can resize the GraphElement.
   *
   * **Note:** Dragging the handle will only emit the [signal resize_request] and [signal
   * resize_end] signals, the GraphElement needs to be resized manually.
   */
  public final inline var resizable: Boolean
    @JvmName("resizableProperty")
    get() = isResizable()
    @JvmName("resizableProperty")
    set(`value`) {
      setResizable(value)
    }

  /**
   * If `true`, the user can drag the GraphElement.
   */
  public final inline var draggable: Boolean
    @JvmName("draggableProperty")
    get() = isDraggable()
    @JvmName("draggableProperty")
    set(`value`) {
      setDraggable(value)
    }

  /**
   * If `true`, the user can select the GraphElement.
   */
  public final inline var selectable: Boolean
    @JvmName("selectableProperty")
    get() = isSelectable()
    @JvmName("selectableProperty")
    set(`value`) {
      setSelectable(value)
    }

  /**
   * If `true`, the GraphElement is selected.
   */
  public final inline var selected: Boolean
    @JvmName("selectedProperty")
    get() = isSelected()
    @JvmName("selectedProperty")
    set(`value`) {
      setSelected(value)
    }

  /**
   * If `true`, [PopupMenu]s that are descendants of the GraphElement are scaled with the
   * [GraphEdit] zoom.
   */
  public final inline var scalingMenus: Boolean
    @JvmName("scalingMenusProperty")
    get() = isScalingMenus()
    @JvmName("scalingMenusProperty")
    set(`value`) {
      setScalingMenus(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(280, scriptPtr)
  }

  /**
   * This is a helper function for [positionOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = graphelement.positionOffset
   * //Your changes
   * graphelement.positionOffset = myCoreType
   * ``````
   *
   * The offset of the GraphElement, relative to the scroll offset of the [GraphEdit].
   */
  @CoreTypeHelper
  public final fun positionOffsetMutate(block: Vector2.() -> Unit): Vector2 = positionOffset.apply {
     block(this)
     positionOffset = this
  }

  public final fun setResizable(resizable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to resizable)
    TransferContext.callMethod(MethodBindings.setResizablePtr)
  }

  public final fun isResizable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isResizablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDraggable(draggable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to draggable)
    TransferContext.callMethod(MethodBindings.setDraggablePtr)
  }

  public final fun isDraggable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDraggablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSelectable(selectable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to selectable)
    TransferContext.callMethod(MethodBindings.setSelectablePtr)
  }

  public final fun isSelectable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSelectablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSelected(selected: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to selected)
    TransferContext.callMethod(MethodBindings.setSelectedPtr)
  }

  public final fun isSelected(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSelectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setScalingMenus(scalingMenus: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to scalingMenus)
    TransferContext.callMethod(MethodBindings.setScalingMenusPtr)
  }

  public final fun isScalingMenus(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isScalingMenusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPositionOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setPositionOffsetPtr)
  }

  public final fun getPositionOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setResizableName: MethodStringName1<GraphElement, Unit, Boolean> =
        MethodStringName1<GraphElement, Unit, Boolean>("set_resizable")

    @JvmField
    public val isResizableName: MethodStringName0<GraphElement, Boolean> =
        MethodStringName0<GraphElement, Boolean>("is_resizable")

    @JvmField
    public val setDraggableName: MethodStringName1<GraphElement, Unit, Boolean> =
        MethodStringName1<GraphElement, Unit, Boolean>("set_draggable")

    @JvmField
    public val isDraggableName: MethodStringName0<GraphElement, Boolean> =
        MethodStringName0<GraphElement, Boolean>("is_draggable")

    @JvmField
    public val setSelectableName: MethodStringName1<GraphElement, Unit, Boolean> =
        MethodStringName1<GraphElement, Unit, Boolean>("set_selectable")

    @JvmField
    public val isSelectableName: MethodStringName0<GraphElement, Boolean> =
        MethodStringName0<GraphElement, Boolean>("is_selectable")

    @JvmField
    public val setSelectedName: MethodStringName1<GraphElement, Unit, Boolean> =
        MethodStringName1<GraphElement, Unit, Boolean>("set_selected")

    @JvmField
    public val isSelectedName: MethodStringName0<GraphElement, Boolean> =
        MethodStringName0<GraphElement, Boolean>("is_selected")

    @JvmField
    public val setScalingMenusName: MethodStringName1<GraphElement, Unit, Boolean> =
        MethodStringName1<GraphElement, Unit, Boolean>("set_scaling_menus")

    @JvmField
    public val isScalingMenusName: MethodStringName0<GraphElement, Boolean> =
        MethodStringName0<GraphElement, Boolean>("is_scaling_menus")

    @JvmField
    public val setPositionOffsetName: MethodStringName1<GraphElement, Unit, Vector2> =
        MethodStringName1<GraphElement, Unit, Vector2>("set_position_offset")

    @JvmField
    public val getPositionOffsetName: MethodStringName0<GraphElement, Vector2> =
        MethodStringName0<GraphElement, Vector2>("get_position_offset")
  }

  public object MethodBindings {
    internal val setResizablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_resizable", 2586408642)

    internal val isResizablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "is_resizable", 36873697)

    internal val setDraggablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_draggable", 2586408642)

    internal val isDraggablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "is_draggable", 2240911060)

    internal val setSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_selectable", 2586408642)

    internal val isSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "is_selectable", 2240911060)

    internal val setSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_selected", 2586408642)

    internal val isSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "is_selected", 2240911060)

    internal val setScalingMenusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_scaling_menus", 2586408642)

    internal val isScalingMenusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "is_scaling_menus", 36873697)

    internal val setPositionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "set_position_offset", 743155724)

    internal val getPositionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphElement", "get_position_offset", 3341600327)
  }
}
