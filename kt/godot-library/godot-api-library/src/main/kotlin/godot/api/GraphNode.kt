// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_LONG_ANY
import godot.callMethod_LONG_ret_ANY
import godot.callMethod_STRING
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_BOOL_LONG_COLOR_BOOL_LONG_COLOR_OBJECT_OBJECT_BOOL
import godot.callPtrMethod_LONG_COLOR
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_COLOR
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_ret_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName2
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [GraphNode] allows to create nodes for a [GraphEdit] graph with customizable content based on its
 * child controls. [GraphNode] is derived from [Container] and it is responsible for placing its
 * children on screen. This works similar to [VBoxContainer]. Children, in turn, provide [GraphNode]
 * with so-called slots, each of which can have a connection port on either side.
 *
 * Each [GraphNode] slot is defined by its index and can provide the node with up to two ports: one
 * on the left, and one on the right. By convention the left port is also referred to as the **input
 * port** and the right port is referred to as the **output port**. Each port can be enabled and
 * configured individually, using different type and color. The type is an arbitrary value that you can
 * define using your own considerations. The parent [GraphEdit] will receive this information on each
 * connect and disconnect request.
 *
 * Slots can be configured in the Inspector dock once you add at least one child [Control]. The
 * properties are grouped by each slot's index in the "Slot" section.
 *
 * **Note:** While GraphNode is set up using slots and slot indices, connections are made between
 * the ports which are enabled. Because of that [GraphEdit] uses the port's index and not the slot's
 * index. You can use [getInputPortSlot] and [getOutputPortSlot] to get the slot index from the port
 * index.
 */
@GodotBaseType
public open class GraphNode : GraphElement() {
  /**
   * Emitted when any GraphNode's slot is updated.
   */
  public val slotUpdated: Signal1<Long> by Signal1

  /**
   * Emitted when any slot's size might have changed.
   */
  public val slotSizesChanged: Signal0 by Signal0

  /**
   * The text displayed in the GraphNode's title bar.
   */
  public final inline var title: String
    @JvmName("titleProperty")
    get() = getTitle()
    @JvmName("titleProperty")
    set(`value`) {
      setTitle(value)
    }

  /**
   * If `true`, you can connect ports with different types, even if the connection was not
   * explicitly allowed in the parent [GraphEdit].
   */
  public final inline var ignoreInvalidConnectionType: Boolean
    @JvmName("ignoreInvalidConnectionTypeProperty")
    get() = isIgnoringValidConnectionType()
    @JvmName("ignoreInvalidConnectionTypeProperty")
    set(`value`) {
      setIgnoreInvalidConnectionType(value)
    }

  /**
   * Determines how connection slots can be focused.
   *
   * - If set to [Control.FOCUS_CLICK], connections can only be made with the mouse.
   *
   * - If set to [Control.FOCUS_ALL], slots can also be focused using the
   * [ProjectSettings.input/uiUp] and [ProjectSettings.input/uiDown] and connected using
   * [ProjectSettings.input/uiLeft] and [ProjectSettings.input/uiRight] input actions.
   *
   * - If set to [Control.FOCUS_ACCESSIBILITY], slot input actions are only enabled when the screen
   * reader is active.
   */
  public final inline var slotsFocusMode: Control.FocusMode
    @JvmName("slotsFocusModeProperty")
    get() = getSlotsFocusMode()
    @JvmName("slotsFocusModeProperty")
    set(`value`) {
      setSlotsFocusMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(280, scriptPtr)
  }

  public open fun _drawPort(
    slotIndex: Int,
    position: Vector2i,
    left: Boolean,
    color: Color,
  ): Unit {
    throw NotImplementedError("GraphNode::_drawPort is not implemented.")
  }

  public final fun setTitle(title: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTitlePtr, title)
  }

  public final fun getTitle(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTitlePtr)

  /**
   * Returns the [HBoxContainer] used for the title bar, only containing a [Label] for displaying
   * the title by default. This can be used to add custom controls to the title bar such as option or
   * close buttons.
   */
  public final fun getTitlebarHbox(): HBoxContainer? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getTitlebarHboxPtr) as HBoxContainer?)

  /**
   * Sets properties of the slot with the given [slotIndex].
   *
   * If [enableLeftPort]/[enableRightPort] is `true`, a port will appear and the slot will be able
   * to be connected from this side.
   *
   * With [typeLeft]/[typeRight] an arbitrary type can be assigned to each port. Two ports can be
   * connected if they share the same type, or if the connection between their types is allowed in the
   * parent [GraphEdit] (see [GraphEdit.addValidConnectionType]). Keep in mind that the [GraphEdit] has
   * the final say in accepting the connection. Type compatibility simply allows the [signal
   * GraphEdit.connection_request] signal to be emitted.
   *
   * Ports can be further customized using [colorLeft]/[colorRight] and
   * [customIconLeft]/[customIconRight]. The color parameter adds a tint to the icon. The custom icon
   * can be used to override the default port dot.
   *
   * Additionally, [drawStylebox] can be used to enable or disable drawing of the background
   * stylebox for each slot. See [theme_item slot].
   *
   * Individual properties can also be set using one of the `set_slot_*` methods.
   *
   * **Note:** This method only sets properties of the slot. To create the slot itself, add a
   * [Control]-derived child to the GraphNode.
   */
  @JvmOverloads
  public final fun setSlot(
    slotIndex: Int,
    enableLeftPort: Boolean,
    typeLeft: Int,
    colorLeft: Color,
    enableRightPort: Boolean,
    typeRight: Int,
    colorRight: Color,
    customIconLeft: Texture2D? = null,
    customIconRight: Texture2D? = null,
    drawStylebox: Boolean = true,
  ): Unit {
    TransferContext.callPtrMethod_LONG_BOOL_LONG_COLOR_BOOL_LONG_COLOR_OBJECT_OBJECT_BOOL(ptr, objectID.id, MethodBindings.setSlotPtr, slotIndex.toLong(), enableLeftPort, typeLeft.toLong(), colorLeft, enableRightPort, typeRight.toLong(), colorRight, customIconLeft, customIconRight, drawStylebox)
  }

  /**
   * Disables the slot with the given [slotIndex]. This will remove the corresponding input and
   * output port from the GraphNode.
   */
  public final fun clearSlot(slotIndex: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.clearSlotPtr, slotIndex.toLong())
  }

  /**
   * Disables all slots of the GraphNode. This will remove all input/output ports from the
   * GraphNode.
   */
  public final fun clearAllSlots(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearAllSlotsPtr)
  }

  /**
   * Returns `true` if left (input) side of the slot with the given [slotIndex] is enabled.
   */
  public final fun isSlotEnabledLeft(slotIndex: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isSlotEnabledLeftPtr, slotIndex.toLong())

  /**
   * Toggles the left (input) side of the slot with the given [slotIndex]. If [enable] is `true`, a
   * port will appear on the left side and the slot will be able to be connected from this side.
   */
  public final fun setSlotEnabledLeft(slotIndex: Int, enable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setSlotEnabledLeftPtr, slotIndex.toLong(), enable)
  }

  /**
   * Sets the left (input) type of the slot with the given [slotIndex] to [type]. If the value is
   * negative, all connections will be disallowed to be created via user inputs.
   */
  public final fun setSlotTypeLeft(slotIndex: Int, type: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setSlotTypeLeftPtr, slotIndex.toLong(), type.toLong())
  }

  /**
   * Returns the left (input) type of the slot with the given [slotIndex].
   */
  public final fun getSlotTypeLeft(slotIndex: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getSlotTypeLeftPtr, slotIndex.toLong()).toInt()

  /**
   * Sets the [Color] of the left (input) side of the slot with the given [slotIndex] to [color].
   */
  public final fun setSlotColorLeft(slotIndex: Int, color: Color): Unit {
    TransferContext.callPtrMethod_LONG_COLOR(ptr, objectID.id, MethodBindings.setSlotColorLeftPtr, slotIndex.toLong(), color)
  }

  /**
   * Returns the left (input) [Color] of the slot with the given [slotIndex].
   */
  public final fun getSlotColorLeft(slotIndex: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getSlotColorLeftPtr, slotIndex.toLong())

  /**
   * Sets the custom [Texture2D] of the left (input) side of the slot with the given [slotIndex] to
   * [customIcon].
   */
  public final fun setSlotCustomIconLeft(slotIndex: Int, customIcon: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setSlotCustomIconLeftPtr, slotIndex.toLong(), customIcon)
  }

  /**
   * Returns the left (input) custom [Texture2D] of the slot with the given [slotIndex].
   */
  public final fun getSlotCustomIconLeft(slotIndex: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getSlotCustomIconLeftPtr, slotIndex.toLong()) as Texture2D?)

  /**
   * Sets the custom metadata for the left (input) side of the slot with the given [slotIndex] to
   * [value].
   */
  public final fun setSlotMetadataLeft(slotIndex: Int, `value`: Any?): Unit {
    TransferContext.callMethod_LONG_ANY(ptr, objectID.id, MethodBindings.setSlotMetadataLeftPtr, slotIndex.toLong(), value)
  }

  /**
   * Returns the left (input) metadata of the slot with the given [slotIndex].
   */
  public final fun getSlotMetadataLeft(slotIndex: Int): Any? =
      TransferContext.callMethod_LONG_ret_ANY(ptr, objectID.id, MethodBindings.getSlotMetadataLeftPtr, slotIndex.toLong())

  /**
   * Returns `true` if right (output) side of the slot with the given [slotIndex] is enabled.
   */
  public final fun isSlotEnabledRight(slotIndex: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isSlotEnabledRightPtr, slotIndex.toLong())

  /**
   * Toggles the right (output) side of the slot with the given [slotIndex]. If [enable] is `true`,
   * a port will appear on the right side and the slot will be able to be connected from this side.
   */
  public final fun setSlotEnabledRight(slotIndex: Int, enable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setSlotEnabledRightPtr, slotIndex.toLong(), enable)
  }

  /**
   * Sets the right (output) type of the slot with the given [slotIndex] to [type]. If the value is
   * negative, all connections will be disallowed to be created via user inputs.
   */
  public final fun setSlotTypeRight(slotIndex: Int, type: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setSlotTypeRightPtr, slotIndex.toLong(), type.toLong())
  }

  /**
   * Returns the right (output) type of the slot with the given [slotIndex].
   */
  public final fun getSlotTypeRight(slotIndex: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getSlotTypeRightPtr, slotIndex.toLong()).toInt()

  /**
   * Sets the [Color] of the right (output) side of the slot with the given [slotIndex] to [color].
   */
  public final fun setSlotColorRight(slotIndex: Int, color: Color): Unit {
    TransferContext.callPtrMethod_LONG_COLOR(ptr, objectID.id, MethodBindings.setSlotColorRightPtr, slotIndex.toLong(), color)
  }

  /**
   * Returns the right (output) [Color] of the slot with the given [slotIndex].
   */
  public final fun getSlotColorRight(slotIndex: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getSlotColorRightPtr, slotIndex.toLong())

  /**
   * Sets the custom [Texture2D] of the right (output) side of the slot with the given [slotIndex]
   * to [customIcon].
   */
  public final fun setSlotCustomIconRight(slotIndex: Int, customIcon: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setSlotCustomIconRightPtr, slotIndex.toLong(), customIcon)
  }

  /**
   * Returns the right (output) custom [Texture2D] of the slot with the given [slotIndex].
   */
  public final fun getSlotCustomIconRight(slotIndex: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getSlotCustomIconRightPtr, slotIndex.toLong()) as Texture2D?)

  /**
   * Sets the custom metadata for the right (output) side of the slot with the given [slotIndex] to
   * [value].
   */
  public final fun setSlotMetadataRight(slotIndex: Int, `value`: Any?): Unit {
    TransferContext.callMethod_LONG_ANY(ptr, objectID.id, MethodBindings.setSlotMetadataRightPtr, slotIndex.toLong(), value)
  }

  /**
   * Returns the right (output) metadata of the slot with the given [slotIndex].
   */
  public final fun getSlotMetadataRight(slotIndex: Int): Any? =
      TransferContext.callMethod_LONG_ret_ANY(ptr, objectID.id, MethodBindings.getSlotMetadataRightPtr, slotIndex.toLong())

  /**
   * Returns `true` if the background [StyleBox] of the slot with the given [slotIndex] is drawn.
   */
  public final fun isSlotDrawStylebox(slotIndex: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isSlotDrawStyleboxPtr, slotIndex.toLong())

  /**
   * Toggles the background [StyleBox] of the slot with the given [slotIndex].
   */
  public final fun setSlotDrawStylebox(slotIndex: Int, enable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setSlotDrawStyleboxPtr, slotIndex.toLong(), enable)
  }

  public final fun setIgnoreInvalidConnectionType(ignore: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setIgnoreInvalidConnectionTypePtr, ignore)
  }

  public final fun isIgnoringValidConnectionType(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isIgnoringValidConnectionTypePtr)

  public final fun setSlotsFocusMode(focusMode: Control.FocusMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSlotsFocusModePtr, focusMode.value)
  }

  public final fun getSlotsFocusMode(): Control.FocusMode =
      Control.FocusMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSlotsFocusModePtr))

  /**
   * Returns the number of slots with an enabled input port.
   */
  public final fun getInputPortCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInputPortCountPtr).toInt()

  /**
   * Returns the position of the input port with the given [portIdx].
   */
  public final fun getInputPortPosition(portIdx: Int): Vector2 =
      TransferContext.callPtrMethod_LONG_ret_VECTOR2(ptr, objectID.id, MethodBindings.getInputPortPositionPtr, portIdx.toLong())

  /**
   * Returns the type of the input port with the given [portIdx].
   */
  public final fun getInputPortType(portIdx: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getInputPortTypePtr, portIdx.toLong()).toInt()

  /**
   * Returns the [Color] of the input port with the given [portIdx].
   */
  public final fun getInputPortColor(portIdx: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getInputPortColorPtr, portIdx.toLong())

  /**
   * Returns the corresponding slot index of the input port with the given [portIdx].
   */
  public final fun getInputPortSlot(portIdx: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getInputPortSlotPtr, portIdx.toLong()).toInt()

  /**
   * Returns the number of slots with an enabled output port.
   */
  public final fun getOutputPortCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOutputPortCountPtr).toInt()

  /**
   * Returns the position of the output port with the given [portIdx].
   */
  public final fun getOutputPortPosition(portIdx: Int): Vector2 =
      TransferContext.callPtrMethod_LONG_ret_VECTOR2(ptr, objectID.id, MethodBindings.getOutputPortPositionPtr, portIdx.toLong())

  /**
   * Returns the type of the output port with the given [portIdx].
   */
  public final fun getOutputPortType(portIdx: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getOutputPortTypePtr, portIdx.toLong()).toInt()

  /**
   * Returns the [Color] of the output port with the given [portIdx].
   */
  public final fun getOutputPortColor(portIdx: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getOutputPortColorPtr, portIdx.toLong())

  /**
   * Returns the corresponding slot index of the output port with the given [portIdx].
   */
  public final fun getOutputPortSlot(portIdx: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getOutputPortSlotPtr, portIdx.toLong()).toInt()

  public companion object {
    @JvmField
    public val setTitleName: MethodStringName1<GraphNode, Unit, String> =
        MethodStringName1<GraphNode, Unit, String>("set_title")

    @JvmField
    public val getTitleName: MethodStringName0<GraphNode, String> =
        MethodStringName0<GraphNode, String>("get_title")

    @JvmField
    public val getTitlebarHboxName: MethodStringName0<GraphNode, HBoxContainer?> =
        MethodStringName0<GraphNode, HBoxContainer?>("get_titlebar_hbox")

    @JvmField
    public val setSlotName:
        MethodStringName10<GraphNode, Unit, Int, Boolean, Int, Color, Boolean, Int, Color, Texture2D?, Texture2D?, Boolean>
        =
        MethodStringName10<GraphNode, Unit, Int, Boolean, Int, Color, Boolean, Int, Color, Texture2D?, Texture2D?, Boolean>("set_slot")

    @JvmField
    public val clearSlotName: MethodStringName1<GraphNode, Unit, Int> =
        MethodStringName1<GraphNode, Unit, Int>("clear_slot")

    @JvmField
    public val clearAllSlotsName: MethodStringName0<GraphNode, Unit> =
        MethodStringName0<GraphNode, Unit>("clear_all_slots")

    @JvmField
    public val isSlotEnabledLeftName: MethodStringName1<GraphNode, Boolean, Int> =
        MethodStringName1<GraphNode, Boolean, Int>("is_slot_enabled_left")

    @JvmField
    public val setSlotEnabledLeftName: MethodStringName2<GraphNode, Unit, Int, Boolean> =
        MethodStringName2<GraphNode, Unit, Int, Boolean>("set_slot_enabled_left")

    @JvmField
    public val setSlotTypeLeftName: MethodStringName2<GraphNode, Unit, Int, Int> =
        MethodStringName2<GraphNode, Unit, Int, Int>("set_slot_type_left")

    @JvmField
    public val getSlotTypeLeftName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_slot_type_left")

    @JvmField
    public val setSlotColorLeftName: MethodStringName2<GraphNode, Unit, Int, Color> =
        MethodStringName2<GraphNode, Unit, Int, Color>("set_slot_color_left")

    @JvmField
    public val getSlotColorLeftName: MethodStringName1<GraphNode, Color, Int> =
        MethodStringName1<GraphNode, Color, Int>("get_slot_color_left")

    @JvmField
    public val setSlotCustomIconLeftName: MethodStringName2<GraphNode, Unit, Int, Texture2D?> =
        MethodStringName2<GraphNode, Unit, Int, Texture2D?>("set_slot_custom_icon_left")

    @JvmField
    public val getSlotCustomIconLeftName: MethodStringName1<GraphNode, Texture2D?, Int> =
        MethodStringName1<GraphNode, Texture2D?, Int>("get_slot_custom_icon_left")

    @JvmField
    public val setSlotMetadataLeftName: MethodStringName2<GraphNode, Unit, Int, Any?> =
        MethodStringName2<GraphNode, Unit, Int, Any?>("set_slot_metadata_left")

    @JvmField
    public val getSlotMetadataLeftName: MethodStringName1<GraphNode, Any?, Int> =
        MethodStringName1<GraphNode, Any?, Int>("get_slot_metadata_left")

    @JvmField
    public val isSlotEnabledRightName: MethodStringName1<GraphNode, Boolean, Int> =
        MethodStringName1<GraphNode, Boolean, Int>("is_slot_enabled_right")

    @JvmField
    public val setSlotEnabledRightName: MethodStringName2<GraphNode, Unit, Int, Boolean> =
        MethodStringName2<GraphNode, Unit, Int, Boolean>("set_slot_enabled_right")

    @JvmField
    public val setSlotTypeRightName: MethodStringName2<GraphNode, Unit, Int, Int> =
        MethodStringName2<GraphNode, Unit, Int, Int>("set_slot_type_right")

    @JvmField
    public val getSlotTypeRightName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_slot_type_right")

    @JvmField
    public val setSlotColorRightName: MethodStringName2<GraphNode, Unit, Int, Color> =
        MethodStringName2<GraphNode, Unit, Int, Color>("set_slot_color_right")

    @JvmField
    public val getSlotColorRightName: MethodStringName1<GraphNode, Color, Int> =
        MethodStringName1<GraphNode, Color, Int>("get_slot_color_right")

    @JvmField
    public val setSlotCustomIconRightName: MethodStringName2<GraphNode, Unit, Int, Texture2D?> =
        MethodStringName2<GraphNode, Unit, Int, Texture2D?>("set_slot_custom_icon_right")

    @JvmField
    public val getSlotCustomIconRightName: MethodStringName1<GraphNode, Texture2D?, Int> =
        MethodStringName1<GraphNode, Texture2D?, Int>("get_slot_custom_icon_right")

    @JvmField
    public val setSlotMetadataRightName: MethodStringName2<GraphNode, Unit, Int, Any?> =
        MethodStringName2<GraphNode, Unit, Int, Any?>("set_slot_metadata_right")

    @JvmField
    public val getSlotMetadataRightName: MethodStringName1<GraphNode, Any?, Int> =
        MethodStringName1<GraphNode, Any?, Int>("get_slot_metadata_right")

    @JvmField
    public val isSlotDrawStyleboxName: MethodStringName1<GraphNode, Boolean, Int> =
        MethodStringName1<GraphNode, Boolean, Int>("is_slot_draw_stylebox")

    @JvmField
    public val setSlotDrawStyleboxName: MethodStringName2<GraphNode, Unit, Int, Boolean> =
        MethodStringName2<GraphNode, Unit, Int, Boolean>("set_slot_draw_stylebox")

    @JvmField
    public val setIgnoreInvalidConnectionTypeName: MethodStringName1<GraphNode, Unit, Boolean> =
        MethodStringName1<GraphNode, Unit, Boolean>("set_ignore_invalid_connection_type")

    @JvmField
    public val isIgnoringValidConnectionTypeName: MethodStringName0<GraphNode, Boolean> =
        MethodStringName0<GraphNode, Boolean>("is_ignoring_valid_connection_type")

    @JvmField
    public val setSlotsFocusModeName: MethodStringName1<GraphNode, Unit, Control.FocusMode> =
        MethodStringName1<GraphNode, Unit, Control.FocusMode>("set_slots_focus_mode")

    @JvmField
    public val getSlotsFocusModeName: MethodStringName0<GraphNode, Control.FocusMode> =
        MethodStringName0<GraphNode, Control.FocusMode>("get_slots_focus_mode")

    @JvmField
    public val getInputPortCountName: MethodStringName0<GraphNode, Int> =
        MethodStringName0<GraphNode, Int>("get_input_port_count")

    @JvmField
    public val getInputPortPositionName: MethodStringName1<GraphNode, Vector2, Int> =
        MethodStringName1<GraphNode, Vector2, Int>("get_input_port_position")

    @JvmField
    public val getInputPortTypeName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_input_port_type")

    @JvmField
    public val getInputPortColorName: MethodStringName1<GraphNode, Color, Int> =
        MethodStringName1<GraphNode, Color, Int>("get_input_port_color")

    @JvmField
    public val getInputPortSlotName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_input_port_slot")

    @JvmField
    public val getOutputPortCountName: MethodStringName0<GraphNode, Int> =
        MethodStringName0<GraphNode, Int>("get_output_port_count")

    @JvmField
    public val getOutputPortPositionName: MethodStringName1<GraphNode, Vector2, Int> =
        MethodStringName1<GraphNode, Vector2, Int>("get_output_port_position")

    @JvmField
    public val getOutputPortTypeName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_output_port_type")

    @JvmField
    public val getOutputPortColorName: MethodStringName1<GraphNode, Color, Int> =
        MethodStringName1<GraphNode, Color, Int>("get_output_port_color")

    @JvmField
    public val getOutputPortSlotName: MethodStringName1<GraphNode, Int, Int> =
        MethodStringName1<GraphNode, Int, Int>("get_output_port_slot")
  }

  public object MethodBindings {
    internal val setTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_title", 83702148)

    internal val getTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_title", 201670096)

    internal val getTitlebarHboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_titlebar_hbox", 3590609951)

    internal val setSlotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot", 2873310869)

    internal val clearSlotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "clear_slot", 1286410249)

    internal val clearAllSlotsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "clear_all_slots", 3218959716)

    internal val isSlotEnabledLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "is_slot_enabled_left", 1116898809)

    internal val setSlotEnabledLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_enabled_left", 300928843)

    internal val setSlotTypeLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_type_left", 3937882851)

    internal val getSlotTypeLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_type_left", 923996154)

    internal val setSlotColorLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_color_left", 2878471219)

    internal val getSlotColorLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_color_left", 3457211756)

    internal val setSlotCustomIconLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_custom_icon_left", 666127730)

    internal val getSlotCustomIconLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_custom_icon_left", 3536238170)

    internal val setSlotMetadataLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_metadata_left", 2152698145)

    internal val getSlotMetadataLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_metadata_left", 4227898402)

    internal val isSlotEnabledRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "is_slot_enabled_right", 1116898809)

    internal val setSlotEnabledRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_enabled_right", 300928843)

    internal val setSlotTypeRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_type_right", 3937882851)

    internal val getSlotTypeRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_type_right", 923996154)

    internal val setSlotColorRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_color_right", 2878471219)

    internal val getSlotColorRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_color_right", 3457211756)

    internal val setSlotCustomIconRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_custom_icon_right", 666127730)

    internal val getSlotCustomIconRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_custom_icon_right", 3536238170)

    internal val setSlotMetadataRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_metadata_right", 2152698145)

    internal val getSlotMetadataRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slot_metadata_right", 4227898402)

    internal val isSlotDrawStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "is_slot_draw_stylebox", 1116898809)

    internal val setSlotDrawStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slot_draw_stylebox", 300928843)

    internal val setIgnoreInvalidConnectionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_ignore_invalid_connection_type", 2586408642)

    internal val isIgnoringValidConnectionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "is_ignoring_valid_connection_type", 36873697)

    internal val setSlotsFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "set_slots_focus_mode", 3232914922)

    internal val getSlotsFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_slots_focus_mode", 2132829277)

    internal val getInputPortCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_input_port_count", 2455072627)

    internal val getInputPortPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_input_port_position", 3114997196)

    internal val getInputPortTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_input_port_type", 3744713108)

    internal val getInputPortColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_input_port_color", 2624840992)

    internal val getInputPortSlotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_input_port_slot", 3744713108)

    internal val getOutputPortCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_output_port_count", 2455072627)

    internal val getOutputPortPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_output_port_position", 3114997196)

    internal val getOutputPortTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_output_port_type", 3744713108)

    internal val getOutputPortColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_output_port_color", 2624840992)

    internal val getOutputPortSlotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphNode", "get_output_port_slot", 3744713108)
  }
}
