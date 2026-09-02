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
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedVector2Array
import godot.core.Rect2
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.Signal3
import godot.core.Signal4
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
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
 * [GraphEdit] provides tools for creation, manipulation, and display of various graphs. Its main
 * purpose in the engine is to power the visual programming systems, such as visual shaders, but it is
 * also available for use in user projects.
 *
 * [GraphEdit] by itself is only an empty container, representing an infinite grid where
 * [GraphNode]s can be placed. Each [GraphNode] represents a node in the graph, a single unit of data
 * in the connected scheme. [GraphEdit], in turn, helps to control various interactions with nodes and
 * between nodes. When the user attempts to connect, disconnect, or delete a [GraphNode], a signal is
 * emitted in the [GraphEdit], but no action is taken by default. It is the responsibility of the
 * programmer utilizing this control to implement the necessary logic to determine how each request
 * should be handled.
 *
 * **Performance:** It is greatly advised to enable low-processor usage mode (see
 * [OS.lowProcessorUsageMode]) when using GraphEdits.
 *
 * **Note:** Keep in mind that [Node.getChildren] will also return the connection layer node named
 * `_connection_layer` due to technical limitations. This behavior may change in future releases.
 */
@GodotBaseType
public open class GraphEdit : Control() {
  /**
   * Emitted to the GraphEdit when the connection between the [fromPort] of the [fromNode]
   * [GraphNode] and the [toPort] of the [toNode] [GraphNode] is attempted to be created.
   */
  public val connectionRequest: Signal4<StringName, Long, StringName, Long> by Signal4

  /**
   * Emitted to the GraphEdit when the connection between [fromPort] of [fromNode] [GraphNode] and
   * [toPort] of [toNode] [GraphNode] is attempted to be removed.
   */
  public val disconnectionRequest: Signal4<StringName, Long, StringName, Long> by Signal4

  /**
   * Emitted when user drags a connection from an output port into the empty space of the graph.
   */
  public val connectionToEmpty: Signal3<StringName, Long, Vector2> by Signal3

  /**
   * Emitted when user drags a connection from an input port into the empty space of the graph.
   */
  public val connectionFromEmpty: Signal3<StringName, Long, Vector2> by Signal3

  /**
   * Emitted at the beginning of a connection drag.
   */
  public val connectionDragStarted: Signal3<StringName, Long, Boolean> by Signal3

  /**
   * Emitted at the end of a connection drag.
   */
  public val connectionDragEnded: Signal0 by Signal0

  /**
   * Emitted when this [GraphEdit] captures a `ui_copy` action ([kbd]Ctrl + C[/kbd] by default). In
   * general, this signal indicates that the selected [GraphElement]s should be copied.
   */
  public val copyNodesRequest: Signal0 by Signal0

  /**
   * Emitted when this [GraphEdit] captures a `ui_cut` action ([kbd]Ctrl + X[/kbd] by default). In
   * general, this signal indicates that the selected [GraphElement]s should be cut.
   */
  public val cutNodesRequest: Signal0 by Signal0

  /**
   * Emitted when this [GraphEdit] captures a `ui_paste` action ([kbd]Ctrl + V[/kbd] by default). In
   * general, this signal indicates that previously copied [GraphElement]s should be pasted.
   */
  public val pasteNodesRequest: Signal0 by Signal0

  /**
   * Emitted when this [GraphEdit] captures a `ui_graph_duplicate` action ([kbd]Ctrl + D[/kbd] by
   * default). In general, this signal indicates that the selected [GraphElement]s should be
   * duplicated.
   */
  public val duplicateNodesRequest: Signal0 by Signal0

  /**
   * Emitted when this [GraphEdit] captures a `ui_graph_delete` action ([kbd]Delete[/kbd] by
   * default).
   *
   * [nodes] is an array of node names that should be removed. These usually include all selected
   * nodes.
   */
  public val deleteNodesRequest: Signal1<VariantArray<StringName>> by Signal1

  /**
   * Emitted when the given [GraphElement] node is selected.
   */
  public val nodeSelected: Signal1<Node> by Signal1

  /**
   * Emitted when the given [GraphElement] node is deselected.
   */
  public val nodeDeselected: Signal1<Node> by Signal1

  /**
   * Emitted when the [GraphFrame] [frame] is resized to [newRect].
   */
  public val frameRectChanged: Signal2<GraphFrame, Rect2> by Signal2

  /**
   * Emitted when a popup is requested. Happens on right-clicking in the GraphEdit. [atPosition] is
   * the position of the mouse pointer when the signal is sent.
   */
  public val popupRequest: Signal1<Vector2> by Signal1

  /**
   * Emitted at the beginning of a [GraphElement]'s movement.
   */
  public val beginNodeMove: Signal0 by Signal0

  /**
   * Emitted at the end of a [GraphElement]'s movement.
   */
  public val endNodeMove: Signal0 by Signal0

  /**
   * Emitted when one or more [GraphElement]s are dropped onto the [GraphFrame] named [frame], when
   * they were not previously attached to any other one.
   *
   * [elements] is an array of [GraphElement]s to be attached.
   */
  public val graphElementsLinkedToFrameRequest: Signal2<VariantArray<Any?>, StringName> by Signal2

  /**
   * Emitted when the scroll offset is changed by the user. It will not be emitted when changed in
   * code.
   */
  public val scrollOffsetChanged: Signal1<Vector2> by Signal1

  /**
   * The scroll offset.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollOffset: Vector2
    @JvmName("scrollOffsetProperty")
    get() = getScrollOffset()
    @JvmName("scrollOffsetProperty")
    set(`value`) {
      setScrollOffset(value)
    }

  /**
   * If `true`, the grid is visible.
   */
  public final inline var showGrid: Boolean
    @JvmName("showGridProperty")
    get() = isShowingGrid()
    @JvmName("showGridProperty")
    set(`value`) {
      setShowGrid(value)
    }

  /**
   * The pattern used for drawing the grid.
   */
  public final inline var gridPattern: GridPattern
    @JvmName("gridPatternProperty")
    get() = getGridPattern()
    @JvmName("gridPatternProperty")
    set(`value`) {
      setGridPattern(value)
    }

  /**
   * If `true`, enables snapping.
   */
  public final inline var snappingEnabled: Boolean
    @JvmName("snappingEnabledProperty")
    get() = isSnappingEnabled()
    @JvmName("snappingEnabledProperty")
    set(`value`) {
      setSnappingEnabled(value)
    }

  /**
   * The snapping distance in pixels, also determines the grid line distance.
   */
  public final inline var snappingDistance: Int
    @JvmName("snappingDistanceProperty")
    get() = getSnappingDistance()
    @JvmName("snappingDistanceProperty")
    set(`value`) {
      setSnappingDistance(value)
    }

  /**
   * Defines the control scheme for panning with mouse wheel.
   */
  public final inline var panningScheme: PanningScheme
    @JvmName("panningSchemeProperty")
    get() = getPanningScheme()
    @JvmName("panningSchemeProperty")
    set(`value`) {
      setPanningScheme(value)
    }

  /**
   * If `true`, enables disconnection of existing connections in the GraphEdit by dragging the right
   * end.
   */
  public final inline var rightDisconnects: Boolean
    @JvmName("rightDisconnectsProperty")
    get() = isRightDisconnectsEnabled()
    @JvmName("rightDisconnectsProperty")
    set(`value`) {
      setRightDisconnects(value)
    }

  /**
   * [Dictionary] of human-readable port type names.
   */
  public final inline var typeNames: Dictionary<Any?, Any?>
    @JvmName("typeNamesProperty")
    get() = getTypeNames()
    @JvmName("typeNamesProperty")
    set(`value`) {
      setTypeNames(value)
    }

  /**
   * The curvature of the lines between the nodes. 0 results in straight lines.
   */
  public final inline var connectionLinesCurvature: Float
    @JvmName("connectionLinesCurvatureProperty")
    get() = getConnectionLinesCurvature()
    @JvmName("connectionLinesCurvatureProperty")
    set(`value`) {
      setConnectionLinesCurvature(value)
    }

  /**
   * The thickness of the lines between the nodes.
   */
  public final inline var connectionLinesThickness: Float
    @JvmName("connectionLinesThicknessProperty")
    get() = getConnectionLinesThickness()
    @JvmName("connectionLinesThicknessProperty")
    set(`value`) {
      setConnectionLinesThickness(value)
    }

  /**
   * If `true`, the lines between nodes will use antialiasing.
   */
  public final inline var connectionLinesAntialiased: Boolean
    @JvmName("connectionLinesAntialiasedProperty")
    get() = isConnectionLinesAntialiased()
    @JvmName("connectionLinesAntialiasedProperty")
    set(`value`) {
      setConnectionLinesAntialiased(value)
    }

  /**
   * The connections between [GraphNode]s.
   *
   * A connection is represented as a [Dictionary] in the form of:
   *
   * ```
   * {
   * 	from_node: StringName,
   * 	from_port: int,
   * 	to_node: StringName,
   * 	to_port: int,
   * 	keep_alive: bool
   * }
   * ```
   *
   * Connections with `keep_alive` set to `false` may be deleted automatically if invalid during a
   * redraw.
   */
  public final inline var connections: VariantArray<Dictionary<Any?, Any?>>
    @JvmName("connectionsProperty")
    get() = getConnectionList()
    @JvmName("connectionsProperty")
    set(`value`) {
      setConnections(value)
    }

  /**
   * The current zoom value.
   */
  public final inline var zoom: Float
    @JvmName("zoomProperty")
    get() = getZoom()
    @JvmName("zoomProperty")
    set(`value`) {
      setZoom(value)
    }

  /**
   * The lower zoom limit.
   */
  public final inline var zoomMin: Float
    @JvmName("zoomMinProperty")
    get() = getZoomMin()
    @JvmName("zoomMinProperty")
    set(`value`) {
      setZoomMin(value)
    }

  /**
   * The upper zoom limit.
   */
  public final inline var zoomMax: Float
    @JvmName("zoomMaxProperty")
    get() = getZoomMax()
    @JvmName("zoomMaxProperty")
    set(`value`) {
      setZoomMax(value)
    }

  /**
   * The step of each zoom level.
   */
  public final inline var zoomStep: Float
    @JvmName("zoomStepProperty")
    get() = getZoomStep()
    @JvmName("zoomStepProperty")
    set(`value`) {
      setZoomStep(value)
    }

  /**
   * If `true`, the minimap is visible.
   */
  public final inline var minimapEnabled: Boolean
    @JvmName("minimapEnabledProperty")
    get() = isMinimapEnabled()
    @JvmName("minimapEnabledProperty")
    set(`value`) {
      setMinimapEnabled(value)
    }

  /**
   * The size of the minimap rectangle. The map itself is based on the size of the grid area and is
   * scaled to fit this rectangle.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var minimapSize: Vector2
    @JvmName("minimapSizeProperty")
    get() = getMinimapSize()
    @JvmName("minimapSizeProperty")
    set(`value`) {
      setMinimapSize(value)
    }

  /**
   * The opacity of the minimap rectangle.
   */
  public final inline var minimapOpacity: Float
    @JvmName("minimapOpacityProperty")
    get() = getMinimapOpacity()
    @JvmName("minimapOpacityProperty")
    set(`value`) {
      setMinimapOpacity(value)
    }

  /**
   * If `true`, the menu toolbar is visible.
   */
  public final inline var showMenu: Boolean
    @JvmName("showMenuProperty")
    get() = isShowingMenu()
    @JvmName("showMenuProperty")
    set(`value`) {
      setShowMenu(value)
    }

  /**
   * If `true`, the label with the current zoom level is visible. The zoom level is displayed in
   * percents.
   */
  public final inline var showZoomLabel: Boolean
    @JvmName("showZoomLabelProperty")
    get() = isShowingZoomLabel()
    @JvmName("showZoomLabelProperty")
    set(`value`) {
      setShowZoomLabel(value)
    }

  /**
   * If `true`, buttons that allow to change and reset the zoom level are visible.
   */
  public final inline var showZoomButtons: Boolean
    @JvmName("showZoomButtonsProperty")
    get() = isShowingZoomButtons()
    @JvmName("showZoomButtonsProperty")
    set(`value`) {
      setShowZoomButtons(value)
    }

  /**
   * If `true`, buttons that allow to configure grid and snapping options are visible.
   */
  public final inline var showGridButtons: Boolean
    @JvmName("showGridButtonsProperty")
    get() = isShowingGridButtons()
    @JvmName("showGridButtonsProperty")
    set(`value`) {
      setShowGridButtons(value)
    }

  /**
   * If `true`, the button to toggle the minimap is visible.
   */
  public final inline var showMinimapButton: Boolean
    @JvmName("showMinimapButtonProperty")
    get() = isShowingMinimapButton()
    @JvmName("showMinimapButtonProperty")
    set(`value`) {
      setShowMinimapButton(value)
    }

  /**
   * If `true`, the button to automatically arrange graph nodes is visible.
   */
  public final inline var showArrangeButton: Boolean
    @JvmName("showArrangeButtonProperty")
    get() = isShowingArrangeButton()
    @JvmName("showArrangeButtonProperty")
    set(`value`) {
      setShowArrangeButton(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(279, scriptPtr)
  }

  /**
   * This is a helper function for [scrollOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = graphedit.scrollOffset
   * //Your changes
   * graphedit.scrollOffset = myCoreType
   * ``````
   *
   * The scroll offset.
   */
  @CoreTypeHelper
  public final fun scrollOffsetMutate(block: Vector2.() -> Unit): Vector2 = scrollOffset.apply {
     block(this)
     scrollOffset = this
  }

  /**
   * This is a helper function for [minimapSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = graphedit.minimapSize
   * //Your changes
   * graphedit.minimapSize = myCoreType
   * ``````
   *
   * The size of the minimap rectangle. The map itself is based on the size of the grid area and is
   * scaled to fit this rectangle.
   */
  @CoreTypeHelper
  public final fun minimapSizeMutate(block: Vector2.() -> Unit): Vector2 = minimapSize.apply {
     block(this)
     minimapSize = this
  }

  /**
   * Returns whether the [mousePosition] is in the input hot zone.
   *
   * By default, a hot zone is a [Rect2] positioned such that its center is at
   * [inNode].[GraphNode.getInputPortPosition]([inPort]) (For output's case, call
   * [GraphNode.getOutputPortPosition] instead). The hot zone's width is twice the Theme Property
   * `port_grab_distance_horizontal`, and its height is twice the `port_grab_distance_vertical`.
   *
   * Below is a sample code to help get started:
   *
   * ```
   * func _is_in_input_hotzone(in_node, in_port, mouse_position):
   * 	var port_size = Vector2(get_theme_constant("port_grab_distance_horizontal"),
   * get_theme_constant("port_grab_distance_vertical"))
   * 	var port_pos = in_node.get_position() + in_node.get_input_port_position(in_port) - port_size /
   * 2
   * 	var rect = Rect2(port_pos, port_size)
   *
   * 	return rect.has_point(mouse_position)
   * ```
   */
  public open fun _isInInputHotzone(
    inNode: Object?,
    inPort: Int,
    mousePosition: Vector2,
  ): Boolean {
    throw NotImplementedError("GraphEdit::_isInInputHotzone is not implemented.")
  }

  /**
   * Returns whether the [mousePosition] is in the output hot zone. For more information on hot
   * zones, see [_isInInputHotzone].
   *
   * Below is a sample code to help get started:
   *
   * ```
   * func _is_in_output_hotzone(in_node, in_port, mouse_position):
   * 	var port_size = Vector2(get_theme_constant("port_grab_distance_horizontal"),
   * get_theme_constant("port_grab_distance_vertical"))
   * 	var port_pos = in_node.get_position() + in_node.get_output_port_position(in_port) - port_size
   * / 2
   * 	var rect = Rect2(port_pos, port_size)
   *
   * 	return rect.has_point(mouse_position)
   * ```
   */
  public open fun _isInOutputHotzone(
    inNode: Object?,
    inPort: Int,
    mousePosition: Vector2,
  ): Boolean {
    throw NotImplementedError("GraphEdit::_isInOutputHotzone is not implemented.")
  }

  /**
   * Virtual method which can be overridden to customize how connections are drawn.
   */
  public open fun _getConnectionLine(fromPosition: Vector2, toPosition: Vector2):
      PackedVector2Array {
    throw NotImplementedError("GraphEdit::_getConnectionLine is not implemented.")
  }

  /**
   * This virtual method can be used to insert additional error detection while the user is dragging
   * a connection over a valid port.
   *
   * Return `true` if the connection is indeed valid or return `false` if the connection is
   * impossible. If the connection is impossible, no snapping to the port and thus no connection
   * request to that port will happen.
   *
   * In this example a connection to same node is suppressed:
   *
   * ```gdscript
   * //gdscript
   * func _is_node_hover_valid(from, from_port, to, to_port):
   * 	return from != to
   * ```
   *
   * ```csharp
   * //csharp
   * public override bool _IsNodeHoverValid(StringName fromNode, int fromPort, StringName toNode,
   * int toPort)
   * {
   * 	return fromNode != toNode;
   * }
   * ```
   */
  public open fun _isNodeHoverValid(
    fromNode: StringName,
    fromPort: Int,
    toNode: StringName,
    toPort: Int,
  ): Boolean {
    throw NotImplementedError("GraphEdit::_isNodeHoverValid is not implemented.")
  }

  /**
   * Create a connection between the [fromPort] of the [fromNode] [GraphNode] and the [toPort] of
   * the [toNode] [GraphNode]. If the connection already exists, no connection is created.
   *
   * Connections with [keepAlive] set to `false` may be deleted automatically if invalid during a
   * redraw.
   */
  @JvmOverloads
  public final fun connectNode(
    fromNode: StringName,
    fromPort: Int,
    toNode: StringName,
    toPort: Int,
    keepAlive: Boolean = false,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to fromNode, LONG to fromPort.toLong(), STRING_NAME to toNode, LONG to toPort.toLong(), BOOL to keepAlive)
    TransferContext.callMethod(MethodBindings.connectNodePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the [fromPort] of the [fromNode] [GraphNode] is connected to the [toPort] of
   * the [toNode] [GraphNode].
   */
  public final fun isNodeConnected(
    fromNode: StringName,
    fromPort: Int,
    toNode: StringName,
    toPort: Int,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to fromNode, LONG to fromPort.toLong(), STRING_NAME to toNode, LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.isNodeConnectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes the connection between the [fromPort] of the [fromNode] [GraphNode] and the [toPort] of
   * the [toNode] [GraphNode]. If the connection does not exist, no connection is removed.
   */
  public final fun disconnectNode(
    fromNode: StringName,
    fromPort: Int,
    toNode: StringName,
    toPort: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to fromNode, LONG to fromPort.toLong(), STRING_NAME to toNode, LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.disconnectNodePtr)
  }

  /**
   * Sets the coloration of the connection between [fromNode]'s [fromPort] and [toNode]'s [toPort]
   * with the color provided in the [theme_item activity] theme property. The color is linearly
   * interpolated between the connection color and the activity color using [amount] as weight.
   */
  public final fun setConnectionActivity(
    fromNode: StringName,
    fromPort: Int,
    toNode: StringName,
    toPort: Int,
    amount: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to fromNode, LONG to fromPort.toLong(), STRING_NAME to toNode, LONG to toPort.toLong(), DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setConnectionActivityPtr)
  }

  public final fun setConnections(connections: VariantArray<Dictionary<Any?, Any?>>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to connections)
    TransferContext.callMethod(MethodBindings.setConnectionsPtr)
  }

  public final fun getConnectionList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectionListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns the number of connections from [fromPort] of [fromNode].
   */
  public final fun getConnectionCount(fromNode: StringName, fromPort: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to fromNode, LONG to fromPort.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the closest connection to the given point in screen space. If no connection is found
   * within [maxDistance] pixels, an empty [Dictionary] is returned.
   *
   * A connection is represented as a [Dictionary] in the form of:
   *
   * ```
   * {
   * 	from_node: StringName,
   * 	from_port: int,
   * 	to_node: StringName,
   * 	to_port: int,
   * 	keep_alive: bool
   * }
   * ```
   *
   * For example, getting a connection at a given mouse position can be achieved like this:
   *
   * ```gdscript
   * //gdscript
   * var connection = get_closest_connection_at_point(mouse_event.get_position())
   * ```
   */
  @JvmOverloads
  public final fun getClosestConnectionAtPoint(point: Vector2, maxDistance: Float = 4.0f):
      Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, DOUBLE to maxDistance.toDouble())
    TransferContext.callMethod(MethodBindings.getClosestConnectionAtPointPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns an [Array] containing a list of all connections for [node].
   *
   * A connection is represented as a [Dictionary] in the form of:
   *
   * ```
   * {
   * 	from_node: StringName,
   * 	from_port: int,
   * 	to_node: StringName,
   * 	to_port: int,
   * 	keep_alive: bool
   * }
   * ```
   *
   * **Example:** Get all connections on a specific port:
   *
   * ```
   * func get_connection_list_from_port(node, port):
   * 	var connections = get_connection_list_from_node(node)
   * 	var result = []
   * 	for connection in connections:
   * 		var dict = {}
   * 		if connection["from_node"] == node and connection["from_port"] == port:
   * 			dict["node"] = connection["to_node"]
   * 			dict["port"] = connection["to_port"]
   * 			dict["type"] = "left"
   * 			result.push_back(dict)
   * 		elif connection["to_node"] == node and connection["to_port"] == port:
   * 			dict["node"] = connection["from_node"]
   * 			dict["port"] = connection["from_port"]
   * 			dict["type"] = "right"
   * 			result.push_back(dict)
   * 	return result
   * ```
   */
  public final fun getConnectionListFromNode(node: StringName):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to node)
    TransferContext.callMethod(MethodBindings.getConnectionListFromNodePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns an [Array] containing the list of connections that intersect with the given [Rect2].
   *
   * A connection is represented as a [Dictionary] in the form of:
   *
   * ```
   * {
   * 	from_node: StringName,
   * 	from_port: int,
   * 	to_node: StringName,
   * 	to_port: int,
   * 	keep_alive: bool
   * }
   * ```
   */
  public final fun getConnectionsIntersectingWithRect(rect: Rect2):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.getConnectionsIntersectingWithRectPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Removes all connections between nodes.
   */
  public final fun clearConnections(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearConnectionsPtr)
  }

  /**
   * Ends the creation of the current connection. In other words, if you are dragging a connection
   * you can use this method to abort the process and remove the line that followed your cursor.
   *
   * This is best used together with [signal connection_drag_started] and [signal
   * connection_drag_ended] to add custom behavior like node addition through shortcuts.
   *
   * **Note:** This method suppresses any other connection request signals apart from [signal
   * connection_drag_ended].
   */
  public final fun forceConnectionDragEnd(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceConnectionDragEndPtr)
  }

  public final fun getScrollOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setScrollOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setScrollOffsetPtr)
  }

  /**
   * Allows to disconnect nodes when dragging from the right port of the [GraphNode]'s slot if it
   * has the specified type. See also [removeValidRightDisconnectType].
   */
  public final fun addValidRightDisconnectType(type: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.toLong())
    TransferContext.callMethod(MethodBindings.addValidRightDisconnectTypePtr)
  }

  /**
   * Disallows to disconnect nodes when dragging from the right port of the [GraphNode]'s slot if it
   * has the specified type. Use this to disable a disconnection previously allowed with
   * [addValidRightDisconnectType].
   */
  public final fun removeValidRightDisconnectType(type: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.toLong())
    TransferContext.callMethod(MethodBindings.removeValidRightDisconnectTypePtr)
  }

  /**
   * Allows to disconnect nodes when dragging from the left port of the [GraphNode]'s slot if it has
   * the specified type. See also [removeValidLeftDisconnectType].
   */
  public final fun addValidLeftDisconnectType(type: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.toLong())
    TransferContext.callMethod(MethodBindings.addValidLeftDisconnectTypePtr)
  }

  /**
   * Disallows to disconnect nodes when dragging from the left port of the [GraphNode]'s slot if it
   * has the specified type. Use this to disable a disconnection previously allowed with
   * [addValidLeftDisconnectType].
   */
  public final fun removeValidLeftDisconnectType(type: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.toLong())
    TransferContext.callMethod(MethodBindings.removeValidLeftDisconnectTypePtr)
  }

  /**
   * Allows the connection between two different port types. The port type is defined individually
   * for the left and the right port of each slot with the [GraphNode.setSlot] method.
   *
   * See also [isValidConnectionType] and [removeValidConnectionType].
   */
  public final fun addValidConnectionType(fromType: Int, toType: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromType.toLong(), LONG to toType.toLong())
    TransferContext.callMethod(MethodBindings.addValidConnectionTypePtr)
  }

  /**
   * Disallows the connection between two different port types previously allowed by
   * [addValidConnectionType]. The port type is defined individually for the left and the right port of
   * each slot with the [GraphNode.setSlot] method.
   *
   * See also [isValidConnectionType].
   */
  public final fun removeValidConnectionType(fromType: Int, toType: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromType.toLong(), LONG to toType.toLong())
    TransferContext.callMethod(MethodBindings.removeValidConnectionTypePtr)
  }

  /**
   * Returns whether it's possible to make a connection between two different port types. The port
   * type is defined individually for the left and the right port of each slot with the
   * [GraphNode.setSlot] method.
   *
   * See also [addValidConnectionType] and [removeValidConnectionType].
   */
  public final fun isValidConnectionType(fromType: Int, toType: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromType.toLong(), LONG to toType.toLong())
    TransferContext.callMethod(MethodBindings.isValidConnectionTypePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the points which would make up a connection between [fromNode] and [toNode].
   */
  public final fun getConnectionLine(fromNode: Vector2, toNode: Vector2): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to fromNode, VECTOR2 to toNode)
    TransferContext.callMethod(MethodBindings.getConnectionLinePtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Attaches the [element] [GraphElement] to the [frame] [GraphFrame].
   */
  public final fun attachGraphElementToFrame(element: StringName, frame: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to element, STRING_NAME to frame)
    TransferContext.callMethod(MethodBindings.attachGraphElementToFramePtr)
  }

  /**
   * Detaches the [element] [GraphElement] from the [GraphFrame] it is currently attached to.
   */
  public final fun detachGraphElementFromFrame(element: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to element)
    TransferContext.callMethod(MethodBindings.detachGraphElementFromFramePtr)
  }

  /**
   * Returns the [GraphFrame] that contains the [GraphElement] with the given name.
   */
  public final fun getElementFrame(element: StringName): GraphFrame? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to element)
    TransferContext.callMethod(MethodBindings.getElementFramePtr)
    return (TransferContext.readReturnValue(OBJECT) as GraphFrame?)
  }

  /**
   * Returns an array of node names that are attached to the [GraphFrame] with the given name.
   */
  public final fun getAttachedNodesOfFrame(frame: StringName): VariantArray<StringName> {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to frame)
    TransferContext.callMethod(MethodBindings.getAttachedNodesOfFramePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<StringName>)
  }

  public final fun setPanningScheme(scheme: PanningScheme): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scheme.value)
    TransferContext.callMethod(MethodBindings.setPanningSchemePtr)
  }

  public final fun getPanningScheme(): PanningScheme {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPanningSchemePtr)
    return PanningScheme.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setZoom(zoom: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to zoom.toDouble())
    TransferContext.callMethod(MethodBindings.setZoomPtr)
  }

  public final fun getZoom(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZoomPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZoomMin(zoomMin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to zoomMin.toDouble())
    TransferContext.callMethod(MethodBindings.setZoomMinPtr)
  }

  public final fun getZoomMin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZoomMinPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZoomMax(zoomMax: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to zoomMax.toDouble())
    TransferContext.callMethod(MethodBindings.setZoomMaxPtr)
  }

  public final fun getZoomMax(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZoomMaxPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZoomStep(zoomStep: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to zoomStep.toDouble())
    TransferContext.callMethod(MethodBindings.setZoomStepPtr)
  }

  public final fun getZoomStep(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZoomStepPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setShowGrid(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setShowGridPtr)
  }

  public final fun isShowingGrid(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingGridPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGridPattern(pattern: GridPattern): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pattern.value)
    TransferContext.callMethod(MethodBindings.setGridPatternPtr)
  }

  public final fun getGridPattern(): GridPattern {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGridPatternPtr)
    return GridPattern.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSnappingEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSnappingEnabledPtr)
  }

  public final fun isSnappingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSnappingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSnappingDistance(pixels: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pixels.toLong())
    TransferContext.callMethod(MethodBindings.setSnappingDistancePtr)
  }

  public final fun getSnappingDistance(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSnappingDistancePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setConnectionLinesCurvature(curvature: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curvature.toDouble())
    TransferContext.callMethod(MethodBindings.setConnectionLinesCurvaturePtr)
  }

  public final fun getConnectionLinesCurvature(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectionLinesCurvaturePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setConnectionLinesThickness(pixels: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pixels.toDouble())
    TransferContext.callMethod(MethodBindings.setConnectionLinesThicknessPtr)
  }

  public final fun getConnectionLinesThickness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectionLinesThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setConnectionLinesAntialiased(pixels: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pixels)
    TransferContext.callMethod(MethodBindings.setConnectionLinesAntialiasedPtr)
  }

  public final fun isConnectionLinesAntialiased(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isConnectionLinesAntialiasedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMinimapSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setMinimapSizePtr)
  }

  public final fun getMinimapSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimapSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMinimapOpacity(opacity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to opacity.toDouble())
    TransferContext.callMethod(MethodBindings.setMinimapOpacityPtr)
  }

  public final fun getMinimapOpacity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimapOpacityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMinimapEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setMinimapEnabledPtr)
  }

  public final fun isMinimapEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMinimapEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowMenu(hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setShowMenuPtr)
  }

  public final fun isShowingMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowZoomLabel(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setShowZoomLabelPtr)
  }

  public final fun isShowingZoomLabel(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingZoomLabelPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowGridButtons(hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setShowGridButtonsPtr)
  }

  public final fun isShowingGridButtons(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingGridButtonsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowZoomButtons(hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setShowZoomButtonsPtr)
  }

  public final fun isShowingZoomButtons(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingZoomButtonsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowMinimapButton(hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setShowMinimapButtonPtr)
  }

  public final fun isShowingMinimapButton(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingMinimapButtonPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShowArrangeButton(hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setShowArrangeButtonPtr)
  }

  public final fun isShowingArrangeButton(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingArrangeButtonPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRightDisconnects(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setRightDisconnectsPtr)
  }

  public final fun isRightDisconnectsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRightDisconnectsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTypeNames(typeNames: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to typeNames)
    TransferContext.callMethod(MethodBindings.setTypeNamesPtr)
  }

  public final fun getTypeNames(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTypeNamesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Gets the [HBoxContainer] that contains the zooming and grid snap controls in the top left of
   * the graph. You can use this method to reposition the toolbar or to add your own custom controls to
   * it.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getMenuHbox(): HBoxContainer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMenuHboxPtr)
    return (TransferContext.readReturnValue(OBJECT) as HBoxContainer?)
  }

  /**
   * Rearranges selected nodes in a layout with minimum crossings between connections and uniform
   * horizontal and vertical gap between nodes.
   */
  public final fun arrangeNodes(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.arrangeNodesPtr)
  }

  /**
   * Sets the specified [node] as the one selected.
   */
  public final fun setSelected(node: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node)
    TransferContext.callMethod(MethodBindings.setSelectedPtr)
  }

  /**
   * Create a connection between the [fromPort] of the [fromNode] [GraphNode] and the [toPort] of
   * the [toNode] [GraphNode]. If the connection already exists, no connection is created.
   *
   * Connections with [keepAlive] set to `false` may be deleted automatically if invalid during a
   * redraw.
   */
  @JvmOverloads
  public final fun connectNode(
    fromNode: String,
    fromPort: Int,
    toNode: String,
    toPort: Int,
    keepAlive: Boolean = false,
  ): Error =
      connectNode(fromNode.asCachedStringName(), fromPort, toNode.asCachedStringName(), toPort, keepAlive)

  /**
   * Returns `true` if the [fromPort] of the [fromNode] [GraphNode] is connected to the [toPort] of
   * the [toNode] [GraphNode].
   */
  public final fun isNodeConnected(
    fromNode: String,
    fromPort: Int,
    toNode: String,
    toPort: Int,
  ): Boolean =
      isNodeConnected(fromNode.asCachedStringName(), fromPort, toNode.asCachedStringName(), toPort)

  /**
   * Removes the connection between the [fromPort] of the [fromNode] [GraphNode] and the [toPort] of
   * the [toNode] [GraphNode]. If the connection does not exist, no connection is removed.
   */
  public final fun disconnectNode(
    fromNode: String,
    fromPort: Int,
    toNode: String,
    toPort: Int,
  ) = disconnectNode(fromNode.asCachedStringName(), fromPort, toNode.asCachedStringName(), toPort)

  /**
   * Sets the coloration of the connection between [fromNode]'s [fromPort] and [toNode]'s [toPort]
   * with the color provided in the [theme_item activity] theme property. The color is linearly
   * interpolated between the connection color and the activity color using [amount] as weight.
   */
  public final fun setConnectionActivity(
    fromNode: String,
    fromPort: Int,
    toNode: String,
    toPort: Int,
    amount: Float,
  ) =
      setConnectionActivity(fromNode.asCachedStringName(), fromPort, toNode.asCachedStringName(), toPort, amount)

  /**
   * Returns the number of connections from [fromPort] of [fromNode].
   */
  public final fun getConnectionCount(fromNode: String, fromPort: Int): Int =
      getConnectionCount(fromNode.asCachedStringName(), fromPort)

  /**
   * Returns an [Array] containing a list of all connections for [node].
   *
   * A connection is represented as a [Dictionary] in the form of:
   *
   * ```
   * {
   * 	from_node: StringName,
   * 	from_port: int,
   * 	to_node: StringName,
   * 	to_port: int,
   * 	keep_alive: bool
   * }
   * ```
   *
   * **Example:** Get all connections on a specific port:
   *
   * ```
   * func get_connection_list_from_port(node, port):
   * 	var connections = get_connection_list_from_node(node)
   * 	var result = []
   * 	for connection in connections:
   * 		var dict = {}
   * 		if connection["from_node"] == node and connection["from_port"] == port:
   * 			dict["node"] = connection["to_node"]
   * 			dict["port"] = connection["to_port"]
   * 			dict["type"] = "left"
   * 			result.push_back(dict)
   * 		elif connection["to_node"] == node and connection["to_port"] == port:
   * 			dict["node"] = connection["from_node"]
   * 			dict["port"] = connection["from_port"]
   * 			dict["type"] = "right"
   * 			result.push_back(dict)
   * 	return result
   * ```
   */
  public final fun getConnectionListFromNode(node: String): VariantArray<Dictionary<Any?, Any?>> =
      getConnectionListFromNode(node.asCachedStringName())

  /**
   * Attaches the [element] [GraphElement] to the [frame] [GraphFrame].
   */
  public final fun attachGraphElementToFrame(element: String, frame: String) =
      attachGraphElementToFrame(element.asCachedStringName(), frame.asCachedStringName())

  /**
   * Detaches the [element] [GraphElement] from the [GraphFrame] it is currently attached to.
   */
  public final fun detachGraphElementFromFrame(element: String) =
      detachGraphElementFromFrame(element.asCachedStringName())

  /**
   * Returns the [GraphFrame] that contains the [GraphElement] with the given name.
   */
  public final fun getElementFrame(element: String): GraphFrame? =
      getElementFrame(element.asCachedStringName())

  /**
   * Returns an array of node names that are attached to the [GraphFrame] with the given name.
   */
  public final fun getAttachedNodesOfFrame(frame: String): VariantArray<StringName> =
      getAttachedNodesOfFrame(frame.asCachedStringName())

  public enum class PanningScheme(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * [kbd]Mouse Wheel[/kbd] will zoom, [kbd]Ctrl + Mouse Wheel[/kbd] will move the view.
     */
    SCROLL_ZOOMS(0),
    /**
     * [kbd]Mouse Wheel[/kbd] will move the view, [kbd]Ctrl + Mouse Wheel[/kbd] will zoom.
     */
    SCROLL_PANS(1),
    ;

    public companion object {
      public fun from(`value`: Long): PanningScheme = entries.single { it.`value` == `value` }
    }
  }

  public enum class GridPattern(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Draw the grid using solid lines.
     */
    LINES(0),
    /**
     * Draw the grid using dots.
     */
    DOTS(1),
    ;

    public companion object {
      public fun from(`value`: Long): GridPattern = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val connectNodeName:
        MethodStringName5<GraphEdit, Error, StringName, Int, StringName, Int, Boolean> =
        MethodStringName5<GraphEdit, Error, StringName, Int, StringName, Int, Boolean>("connect_node")

    @JvmField
    public val isNodeConnectedName:
        MethodStringName4<GraphEdit, Boolean, StringName, Int, StringName, Int> =
        MethodStringName4<GraphEdit, Boolean, StringName, Int, StringName, Int>("is_node_connected")

    @JvmField
    public val disconnectNodeName:
        MethodStringName4<GraphEdit, Unit, StringName, Int, StringName, Int> =
        MethodStringName4<GraphEdit, Unit, StringName, Int, StringName, Int>("disconnect_node")

    @JvmField
    public val setConnectionActivityName:
        MethodStringName5<GraphEdit, Unit, StringName, Int, StringName, Int, Float> =
        MethodStringName5<GraphEdit, Unit, StringName, Int, StringName, Int, Float>("set_connection_activity")

    @JvmField
    public val setConnectionsName:
        MethodStringName1<GraphEdit, Unit, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName1<GraphEdit, Unit, VariantArray<Dictionary<Any?, Any?>>>("set_connections")

    @JvmField
    public val getConnectionListName:
        MethodStringName0<GraphEdit, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<GraphEdit, VariantArray<Dictionary<Any?, Any?>>>("get_connection_list")

    @JvmField
    public val getConnectionCountName: MethodStringName2<GraphEdit, Int, StringName, Int> =
        MethodStringName2<GraphEdit, Int, StringName, Int>("get_connection_count")

    @JvmField
    public val getClosestConnectionAtPointName:
        MethodStringName2<GraphEdit, Dictionary<Any?, Any?>, Vector2, Float> =
        MethodStringName2<GraphEdit, Dictionary<Any?, Any?>, Vector2, Float>("get_closest_connection_at_point")

    @JvmField
    public val getConnectionListFromNodeName:
        MethodStringName1<GraphEdit, VariantArray<Dictionary<Any?, Any?>>, StringName> =
        MethodStringName1<GraphEdit, VariantArray<Dictionary<Any?, Any?>>, StringName>("get_connection_list_from_node")

    @JvmField
    public val getConnectionsIntersectingWithRectName:
        MethodStringName1<GraphEdit, VariantArray<Dictionary<Any?, Any?>>, Rect2> =
        MethodStringName1<GraphEdit, VariantArray<Dictionary<Any?, Any?>>, Rect2>("get_connections_intersecting_with_rect")

    @JvmField
    public val clearConnectionsName: MethodStringName0<GraphEdit, Unit> =
        MethodStringName0<GraphEdit, Unit>("clear_connections")

    @JvmField
    public val forceConnectionDragEndName: MethodStringName0<GraphEdit, Unit> =
        MethodStringName0<GraphEdit, Unit>("force_connection_drag_end")

    @JvmField
    public val getScrollOffsetName: MethodStringName0<GraphEdit, Vector2> =
        MethodStringName0<GraphEdit, Vector2>("get_scroll_offset")

    @JvmField
    public val setScrollOffsetName: MethodStringName1<GraphEdit, Unit, Vector2> =
        MethodStringName1<GraphEdit, Unit, Vector2>("set_scroll_offset")

    @JvmField
    public val addValidRightDisconnectTypeName: MethodStringName1<GraphEdit, Unit, Int> =
        MethodStringName1<GraphEdit, Unit, Int>("add_valid_right_disconnect_type")

    @JvmField
    public val removeValidRightDisconnectTypeName: MethodStringName1<GraphEdit, Unit, Int> =
        MethodStringName1<GraphEdit, Unit, Int>("remove_valid_right_disconnect_type")

    @JvmField
    public val addValidLeftDisconnectTypeName: MethodStringName1<GraphEdit, Unit, Int> =
        MethodStringName1<GraphEdit, Unit, Int>("add_valid_left_disconnect_type")

    @JvmField
    public val removeValidLeftDisconnectTypeName: MethodStringName1<GraphEdit, Unit, Int> =
        MethodStringName1<GraphEdit, Unit, Int>("remove_valid_left_disconnect_type")

    @JvmField
    public val addValidConnectionTypeName: MethodStringName2<GraphEdit, Unit, Int, Int> =
        MethodStringName2<GraphEdit, Unit, Int, Int>("add_valid_connection_type")

    @JvmField
    public val removeValidConnectionTypeName: MethodStringName2<GraphEdit, Unit, Int, Int> =
        MethodStringName2<GraphEdit, Unit, Int, Int>("remove_valid_connection_type")

    @JvmField
    public val isValidConnectionTypeName: MethodStringName2<GraphEdit, Boolean, Int, Int> =
        MethodStringName2<GraphEdit, Boolean, Int, Int>("is_valid_connection_type")

    @JvmField
    public val getConnectionLineName:
        MethodStringName2<GraphEdit, PackedVector2Array, Vector2, Vector2> =
        MethodStringName2<GraphEdit, PackedVector2Array, Vector2, Vector2>("get_connection_line")

    @JvmField
    public val attachGraphElementToFrameName:
        MethodStringName2<GraphEdit, Unit, StringName, StringName> =
        MethodStringName2<GraphEdit, Unit, StringName, StringName>("attach_graph_element_to_frame")

    @JvmField
    public val detachGraphElementFromFrameName: MethodStringName1<GraphEdit, Unit, StringName> =
        MethodStringName1<GraphEdit, Unit, StringName>("detach_graph_element_from_frame")

    @JvmField
    public val getElementFrameName: MethodStringName1<GraphEdit, GraphFrame?, StringName> =
        MethodStringName1<GraphEdit, GraphFrame?, StringName>("get_element_frame")

    @JvmField
    public val getAttachedNodesOfFrameName:
        MethodStringName1<GraphEdit, VariantArray<StringName>, StringName> =
        MethodStringName1<GraphEdit, VariantArray<StringName>, StringName>("get_attached_nodes_of_frame")

    @JvmField
    public val setPanningSchemeName: MethodStringName1<GraphEdit, Unit, PanningScheme> =
        MethodStringName1<GraphEdit, Unit, PanningScheme>("set_panning_scheme")

    @JvmField
    public val getPanningSchemeName: MethodStringName0<GraphEdit, PanningScheme> =
        MethodStringName0<GraphEdit, PanningScheme>("get_panning_scheme")

    @JvmField
    public val setZoomName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_zoom")

    @JvmField
    public val getZoomName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_zoom")

    @JvmField
    public val setZoomMinName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_zoom_min")

    @JvmField
    public val getZoomMinName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_zoom_min")

    @JvmField
    public val setZoomMaxName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_zoom_max")

    @JvmField
    public val getZoomMaxName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_zoom_max")

    @JvmField
    public val setZoomStepName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_zoom_step")

    @JvmField
    public val getZoomStepName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_zoom_step")

    @JvmField
    public val setShowGridName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_grid")

    @JvmField
    public val isShowingGridName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_grid")

    @JvmField
    public val setGridPatternName: MethodStringName1<GraphEdit, Unit, GridPattern> =
        MethodStringName1<GraphEdit, Unit, GridPattern>("set_grid_pattern")

    @JvmField
    public val getGridPatternName: MethodStringName0<GraphEdit, GridPattern> =
        MethodStringName0<GraphEdit, GridPattern>("get_grid_pattern")

    @JvmField
    public val setSnappingEnabledName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_snapping_enabled")

    @JvmField
    public val isSnappingEnabledName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_snapping_enabled")

    @JvmField
    public val setSnappingDistanceName: MethodStringName1<GraphEdit, Unit, Int> =
        MethodStringName1<GraphEdit, Unit, Int>("set_snapping_distance")

    @JvmField
    public val getSnappingDistanceName: MethodStringName0<GraphEdit, Int> =
        MethodStringName0<GraphEdit, Int>("get_snapping_distance")

    @JvmField
    public val setConnectionLinesCurvatureName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_connection_lines_curvature")

    @JvmField
    public val getConnectionLinesCurvatureName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_connection_lines_curvature")

    @JvmField
    public val setConnectionLinesThicknessName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_connection_lines_thickness")

    @JvmField
    public val getConnectionLinesThicknessName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_connection_lines_thickness")

    @JvmField
    public val setConnectionLinesAntialiasedName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_connection_lines_antialiased")

    @JvmField
    public val isConnectionLinesAntialiasedName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_connection_lines_antialiased")

    @JvmField
    public val setMinimapSizeName: MethodStringName1<GraphEdit, Unit, Vector2> =
        MethodStringName1<GraphEdit, Unit, Vector2>("set_minimap_size")

    @JvmField
    public val getMinimapSizeName: MethodStringName0<GraphEdit, Vector2> =
        MethodStringName0<GraphEdit, Vector2>("get_minimap_size")

    @JvmField
    public val setMinimapOpacityName: MethodStringName1<GraphEdit, Unit, Float> =
        MethodStringName1<GraphEdit, Unit, Float>("set_minimap_opacity")

    @JvmField
    public val getMinimapOpacityName: MethodStringName0<GraphEdit, Float> =
        MethodStringName0<GraphEdit, Float>("get_minimap_opacity")

    @JvmField
    public val setMinimapEnabledName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_minimap_enabled")

    @JvmField
    public val isMinimapEnabledName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_minimap_enabled")

    @JvmField
    public val setShowMenuName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_menu")

    @JvmField
    public val isShowingMenuName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_menu")

    @JvmField
    public val setShowZoomLabelName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_zoom_label")

    @JvmField
    public val isShowingZoomLabelName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_zoom_label")

    @JvmField
    public val setShowGridButtonsName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_grid_buttons")

    @JvmField
    public val isShowingGridButtonsName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_grid_buttons")

    @JvmField
    public val setShowZoomButtonsName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_zoom_buttons")

    @JvmField
    public val isShowingZoomButtonsName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_zoom_buttons")

    @JvmField
    public val setShowMinimapButtonName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_minimap_button")

    @JvmField
    public val isShowingMinimapButtonName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_minimap_button")

    @JvmField
    public val setShowArrangeButtonName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_show_arrange_button")

    @JvmField
    public val isShowingArrangeButtonName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_showing_arrange_button")

    @JvmField
    public val setRightDisconnectsName: MethodStringName1<GraphEdit, Unit, Boolean> =
        MethodStringName1<GraphEdit, Unit, Boolean>("set_right_disconnects")

    @JvmField
    public val isRightDisconnectsEnabledName: MethodStringName0<GraphEdit, Boolean> =
        MethodStringName0<GraphEdit, Boolean>("is_right_disconnects_enabled")

    @JvmField
    public val setTypeNamesName: MethodStringName1<GraphEdit, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<GraphEdit, Unit, Dictionary<Any?, Any?>>("set_type_names")

    @JvmField
    public val getTypeNamesName: MethodStringName0<GraphEdit, Dictionary<Any?, Any?>> =
        MethodStringName0<GraphEdit, Dictionary<Any?, Any?>>("get_type_names")

    @JvmField
    public val getMenuHboxName: MethodStringName0<GraphEdit, HBoxContainer?> =
        MethodStringName0<GraphEdit, HBoxContainer?>("get_menu_hbox")

    @JvmField
    public val arrangeNodesName: MethodStringName0<GraphEdit, Unit> =
        MethodStringName0<GraphEdit, Unit>("arrange_nodes")

    @JvmField
    public val setSelectedName: MethodStringName1<GraphEdit, Unit, Node?> =
        MethodStringName1<GraphEdit, Unit, Node?>("set_selected")
  }

  public object MethodBindings {
    internal val connectNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "connect_node", 1376144231)

    internal val isNodeConnectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_node_connected", 4216241294)

    internal val disconnectNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "disconnect_node", 1933654315)

    internal val setConnectionActivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_connection_activity", 1141899943)

    internal val setConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_connections", 381264803)

    internal val getConnectionListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_list", 3995934104)

    internal val getConnectionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_count", 861718734)

    internal val getClosestConnectionAtPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_closest_connection_at_point", 453879819)

    internal val getConnectionListFromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_list_from_node", 3147814860)

    internal val getConnectionsIntersectingWithRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connections_intersecting_with_rect", 2709748719)

    internal val clearConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "clear_connections", 3218959716)

    internal val forceConnectionDragEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "force_connection_drag_end", 3218959716)

    internal val getScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_scroll_offset", 3341600327)

    internal val setScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_scroll_offset", 743155724)

    internal val addValidRightDisconnectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "add_valid_right_disconnect_type", 1286410249)

    internal val removeValidRightDisconnectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "remove_valid_right_disconnect_type", 1286410249)

    internal val addValidLeftDisconnectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "add_valid_left_disconnect_type", 1286410249)

    internal val removeValidLeftDisconnectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "remove_valid_left_disconnect_type", 1286410249)

    internal val addValidConnectionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "add_valid_connection_type", 3937882851)

    internal val removeValidConnectionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "remove_valid_connection_type", 3937882851)

    internal val isValidConnectionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_valid_connection_type", 2522259332)

    internal val getConnectionLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_line", 3932192302)

    internal val attachGraphElementToFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "attach_graph_element_to_frame", 3740211285)

    internal val detachGraphElementFromFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "detach_graph_element_from_frame", 3304788590)

    internal val getElementFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_element_frame", 988084372)

    internal val getAttachedNodesOfFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_attached_nodes_of_frame", 689397652)

    internal val setPanningSchemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_panning_scheme", 18893313)

    internal val getPanningSchemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_panning_scheme", 549924446)

    internal val setZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_zoom", 373806689)

    internal val getZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_zoom", 1740695150)

    internal val setZoomMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_zoom_min", 373806689)

    internal val getZoomMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_zoom_min", 1740695150)

    internal val setZoomMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_zoom_max", 373806689)

    internal val getZoomMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_zoom_max", 1740695150)

    internal val setZoomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_zoom_step", 373806689)

    internal val getZoomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_zoom_step", 1740695150)

    internal val setShowGridPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_grid", 2586408642)

    internal val isShowingGridPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_grid", 36873697)

    internal val setGridPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_grid_pattern", 1074098205)

    internal val getGridPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_grid_pattern", 1286127528)

    internal val setSnappingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_snapping_enabled", 2586408642)

    internal val isSnappingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_snapping_enabled", 36873697)

    internal val setSnappingDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_snapping_distance", 1286410249)

    internal val getSnappingDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_snapping_distance", 3905245786)

    internal val setConnectionLinesCurvaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_connection_lines_curvature", 373806689)

    internal val getConnectionLinesCurvaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_lines_curvature", 1740695150)

    internal val setConnectionLinesThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_connection_lines_thickness", 373806689)

    internal val getConnectionLinesThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_connection_lines_thickness", 1740695150)

    internal val setConnectionLinesAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_connection_lines_antialiased", 2586408642)

    internal val isConnectionLinesAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_connection_lines_antialiased", 36873697)

    internal val setMinimapSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_minimap_size", 743155724)

    internal val getMinimapSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_minimap_size", 3341600327)

    internal val setMinimapOpacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_minimap_opacity", 373806689)

    internal val getMinimapOpacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_minimap_opacity", 1740695150)

    internal val setMinimapEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_minimap_enabled", 2586408642)

    internal val isMinimapEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_minimap_enabled", 36873697)

    internal val setShowMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_menu", 2586408642)

    internal val isShowingMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_menu", 36873697)

    internal val setShowZoomLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_zoom_label", 2586408642)

    internal val isShowingZoomLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_zoom_label", 36873697)

    internal val setShowGridButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_grid_buttons", 2586408642)

    internal val isShowingGridButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_grid_buttons", 36873697)

    internal val setShowZoomButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_zoom_buttons", 2586408642)

    internal val isShowingZoomButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_zoom_buttons", 36873697)

    internal val setShowMinimapButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_minimap_button", 2586408642)

    internal val isShowingMinimapButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_minimap_button", 36873697)

    internal val setShowArrangeButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_show_arrange_button", 2586408642)

    internal val isShowingArrangeButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_showing_arrange_button", 36873697)

    internal val setRightDisconnectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_right_disconnects", 2586408642)

    internal val isRightDisconnectsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "is_right_disconnects_enabled", 36873697)

    internal val setTypeNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_type_names", 4155329257)

    internal val getTypeNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_type_names", 3102165223)

    internal val getMenuHboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "get_menu_hbox", 3590609951)

    internal val arrangeNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "arrange_nodes", 3218959716)

    internal val setSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphEdit", "set_selected", 1078189570)
  }
}
