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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.Rect2i
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.asCachedStringName
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
import kotlin.jvm.JvmStatic

/**
 * A node that creates a window. The window can either be a native system window or embedded inside
 * another [Window] (see [Viewport.guiEmbedSubwindows]).
 *
 * At runtime, [Window]s will not close automatically when requested. You need to handle it manually
 * using the [signal close_requested] signal (this applies both to pressing the close button and
 * clicking outside of a popup).
 */
@GodotBaseType
public open class Window : Viewport() {
  /**
   * Emitted when the [Window] is currently focused and receives any input, passing the received
   * event as an argument. The event's position, if present, is in the embedder's coordinate system.
   */
  public val windowInput: Signal1<InputEvent> by Signal1

  /**
   * Emitted when the mouse event is received by the custom decoration area defined by
   * [nonclientArea], and normal input to the window is blocked (such as when it has an exclusive child
   * opened). [event]'s position is in the embedder's coordinate system.
   */
  public val nonclientWindowInput: Signal1<InputEvent> by Signal1

  /**
   * Emitted when files are dragged from the OS file manager and dropped in the game window. The
   * argument is a list of file paths.
   *
   * ```
   * func _ready():
   * 	get_window().files_dropped.connect(on_files_dropped)
   *
   * func on_files_dropped(files):
   * 	print(files)
   * ```
   *
   * **Note:** This signal only works with native windows, i.e. the main window and [Window]-derived
   * nodes when [Viewport.guiEmbedSubwindows] is disabled in the main viewport.
   */
  public val filesDropped: Signal1<PackedStringArray> by Signal1

  /**
   * Emitted when the mouse cursor enters the [Window]'s visible area, that is not occluded behind
   * other [Control]s or windows, provided its [Viewport.guiDisableInput] is `false` and regardless if
   * it's currently focused or not.
   */
  public val mouseEntered: Signal0 by Signal0

  /**
   * Emitted when the mouse cursor leaves the [Window]'s visible area, that is not occluded behind
   * other [Control]s or windows, provided its [Viewport.guiDisableInput] is `false` and regardless if
   * it's currently focused or not.
   */
  public val mouseExited: Signal0 by Signal0

  /**
   * Emitted when the [Window] gains focus.
   */
  public val focusEntered: Signal0 by Signal0

  /**
   * Emitted when the [Window] loses its focus.
   */
  public val focusExited: Signal0 by Signal0

  /**
   * Emitted when the [Window]'s close button is pressed or when [popupWindow] is enabled and user
   * clicks outside the window.
   *
   * This signal can be used to handle window closing, e.g. by connecting it to [hide].
   */
  public val closeRequested: Signal0 by Signal0

  /**
   * Emitted when a go back request is sent (e.g. pressing the "Back" button on Android), right
   * after [Node.NOTIFICATION_WM_GO_BACK_REQUEST].
   */
  public val goBackRequested: Signal0 by Signal0

  /**
   * Emitted when [Window] is made visible or disappears.
   */
  public val visibilityChanged: Signal0 by Signal0

  /**
   * Emitted right after [popup] call, before the [Window] appears or does anything.
   */
  public val aboutToPopup: Signal0 by Signal0

  /**
   * Emitted when the [NOTIFICATION_THEME_CHANGED] notification is sent.
   */
  public val themeChanged: Signal0 by Signal0

  /**
   * Emitted when the [Window]'s DPI changes as a result of OS-level changes (e.g. moving the window
   * from a Retina display to a lower resolution one).
   *
   * **Note:** Only implemented on macOS and Linux (Wayland).
   */
  public val dpiChanged: Signal0 by Signal0

  /**
   * Emitted when window title bar decorations are changed, e.g. macOS window enter/exit full screen
   * mode, or extend-to-title flag is changed.
   */
  public val titlebarChanged: Signal0 by Signal0

  /**
   * Emitted when window title bar text is changed.
   */
  public val titleChanged: Signal0 by Signal0

  /**
   * Emitted when the output max linear value returned by [Window.getOutputMaxLinearValue] has
   * changed. This occurs when HDR output is enabled or disabled and when any HDR output luminance
   * values of the window have changed, such as when the player adjusts their screen brightness setting
   * or moves the window to a different screen. [outputMaxLinearValue] is the new value.
   */
  public val outputMaxLinearValueChanged: Signal1<Double> by Signal1

  /**
   * Set's the window's current mode.
   *
   * **Note:** Fullscreen mode is not exclusive full screen on Windows and Linux.
   *
   * **Note:** This method only works with native windows, i.e. the main window and [Window]-derived
   * nodes when [Viewport.guiEmbedSubwindows] is disabled in the main viewport.
   */
  public final inline var mode: Mode
    @JvmName("modeProperty")
    get() = getMode()
    @JvmName("modeProperty")
    set(`value`) {
      setMode(value)
    }

  /**
   * The window's title. If the [Window] is native, title styles set in [Theme] will have no effect.
   */
  public final inline var title: String
    @JvmName("titleProperty")
    get() = getTitle()
    @JvmName("titleProperty")
    set(`value`) {
      setTitle(value)
    }

  /**
   * Specifies the initial type of position for the [Window].
   */
  public final inline var initialPosition: WindowInitialPosition
    @JvmName("initialPositionProperty")
    get() = getInitialPosition()
    @JvmName("initialPositionProperty")
    set(`value`) {
      setInitialPosition(value)
    }

  /**
   * The window's position in pixels.
   *
   * If [ProjectSettings.display/window/subwindows/embedSubwindows] is `false`, the position is in
   * absolute screen coordinates. This typically applies to editor plugins. If the setting is `true`,
   * the window's position is in the coordinates of its parent [Viewport].
   *
   * **Note:** This property only works if [initialPosition] is set to
   * [WINDOW_INITIAL_POSITION_ABSOLUTE].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var position: Vector2i
    @JvmName("positionProperty")
    get() = getPosition()
    @JvmName("positionProperty")
    set(`value`) {
      setPosition(value)
    }

  /**
   * The window's size in pixels. See also [contentScaleSize], which doesn't set the window's
   * physical size but affects how scaling works relative to the current [contentScaleMode].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector2i
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * The screen the window is currently on.
   */
  public final inline var currentScreen: Int
    @JvmName("currentScreenProperty")
    get() = getCurrentScreen()
    @JvmName("currentScreenProperty")
    set(`value`) {
      setCurrentScreen(value)
    }

  /**
   * If set, defines the window's custom decoration area which will receive mouse input, even if
   * normal input to the window is blocked (such as when it has an exclusive child opened). See also
   * [signal nonclient_window_input].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var nonclientArea: Rect2i
    @JvmName("nonclientAreaProperty")
    get() = getNonclientArea()
    @JvmName("nonclientAreaProperty")
    set(`value`) {
      setNonclientArea(value)
    }

  /**
   * Sets a polygonal region of the window which accepts mouse events. Mouse events outside the
   * region will be passed through.
   *
   * Passing an empty array will disable passthrough support (all mouse events will be intercepted
   * by the window, which is the default behavior).
   *
   * ```gdscript
   * //gdscript
   * # Set region, using Path2D node.
   * $Window.mouse_passthrough_polygon = $Path2D.curve.get_baked_points()
   *
   * # Set region, using Polygon2D node.
   * $Window.mouse_passthrough_polygon = $Polygon2D.polygon
   *
   * # Reset region to default.
   * $Window.mouse_passthrough_polygon = []
   * ```
   *
   * ```csharp
   * //csharp
   * // Set region, using Path2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon =
   * GetNode<Path2D>("Path2D").Curve.GetBakedPoints();
   *
   * // Set region, using Polygon2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon = GetNode<Polygon2D>("Polygon2D").Polygon;
   *
   * // Reset region to default.
   * GetNode<Window>("Window").MousePassthroughPolygon = [];
   * ```
   *
   * **Note:** This property is ignored if [mousePassthrough] is set to `true`.
   *
   * **Note:** On Windows, the portion of a window that lies outside the region is not drawn, while
   * on Linux (X11) and macOS it is.
   *
   * **Note:** This property is implemented on Linux (X11), macOS and Windows.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var mousePassthroughPolygon: PackedVector2Array
    @JvmName("mousePassthroughPolygonProperty")
    get() = getMousePassthroughPolygon()
    @JvmName("mousePassthroughPolygonProperty")
    set(`value`) {
      setMousePassthroughPolygon(value)
    }

  /**
   * If `true`, the window is visible.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  /**
   * If `true`, the window's size will automatically update when a child node is added or removed,
   * ignoring [minSize] if the new size is bigger.
   *
   * If `false`, you need to call [childControlsChanged] manually.
   */
  public final inline var wrapControls: Boolean
    @JvmName("wrapControlsProperty")
    get() = isWrappingControls()
    @JvmName("wrapControlsProperty")
    set(`value`) {
      setWrapControls(value)
    }

  /**
   * If `true`, the [Window] is transient, i.e. it's considered a child of another [Window]. The
   * transient window will be destroyed with its transient parent and will return focus to their parent
   * when closed. The transient window is displayed on top of a non-exclusive full-screen parent
   * window. Transient windows can't enter full-screen mode.
   *
   * Note that behavior might be different depending on the platform.
   */
  public final inline var transient: Boolean
    @JvmName("transientProperty")
    get() = isTransient()
    @JvmName("transientProperty")
    set(`value`) {
      setTransient(value)
    }

  /**
   * If `true`, and the [Window] is [transient], this window will (at the time of becoming visible)
   * become transient to the currently focused window instead of the immediate parent window in the
   * hierarchy. Note that the transient parent is assigned at the time this window becomes visible, so
   * changing it afterwards has no effect until re-shown.
   */
  public final inline var transientToFocused: Boolean
    @JvmName("transientToFocusedProperty")
    get() = isTransientToFocused()
    @JvmName("transientToFocusedProperty")
    set(`value`) {
      setTransientToFocused(value)
    }

  /**
   * If `true`, the [Window] will be in exclusive mode. Exclusive windows are always on top of their
   * parent and will block all input going to the parent [Window].
   *
   * Needs [transient] enabled to work.
   */
  public final inline var exclusive: Boolean
    @JvmName("exclusiveProperty")
    get() = isExclusive()
    @JvmName("exclusiveProperty")
    set(`value`) {
      setExclusive(value)
    }

  /**
   * If `true`, the window can't be resized.
   */
  public final inline var unresizable: Boolean
    @JvmName("unresizableProperty")
    get() = getFlag(Window.Flags.RESIZE_DISABLED)
    @JvmName("unresizableProperty")
    set(`value`) {
      setFlag(Window.Flags.RESIZE_DISABLED, value)
    }

  /**
   * If `true`, the window will have no borders.
   */
  public final inline var borderless: Boolean
    @JvmName("borderlessProperty")
    get() = getFlag(Window.Flags.BORDERLESS)
    @JvmName("borderlessProperty")
    set(`value`) {
      setFlag(Window.Flags.BORDERLESS, value)
    }

  /**
   * If `true`, the window will be on top of all other windows. Does not work if [transient] is
   * enabled.
   */
  public final inline var alwaysOnTop: Boolean
    @JvmName("alwaysOnTopProperty")
    get() = getFlag(Window.Flags.ALWAYS_ON_TOP)
    @JvmName("alwaysOnTopProperty")
    set(`value`) {
      setFlag(Window.Flags.ALWAYS_ON_TOP, value)
    }

  /**
   * If `true`, the [Window]'s background can be transparent. This is best used with embedded
   * windows.
   *
   * **Note:** Transparency support is implemented on Linux, macOS and Windows, but availability
   * might vary depending on GPU driver, display manager, and compositor capabilities.
   *
   * **Note:** This property has no effect if
   * [ProjectSettings.display/window/perPixelTransparency/allowed] is set to `false`.
   */
  public final inline var transparent: Boolean
    @JvmName("transparentProperty")
    get() = getFlag(Window.Flags.TRANSPARENT)
    @JvmName("transparentProperty")
    set(`value`) {
      setFlag(Window.Flags.TRANSPARENT, value)
    }

  /**
   * If `true`, the [Window] can't be focused nor interacted with. It can still be visible.
   */
  public final inline var unfocusable: Boolean
    @JvmName("unfocusableProperty")
    get() = getFlag(Window.Flags.NO_FOCUS)
    @JvmName("unfocusableProperty")
    set(`value`) {
      setFlag(Window.Flags.NO_FOCUS, value)
    }

  /**
   * If `true`, the [Window] will be considered a popup. Popups are sub-windows that don't show as
   * separate windows in system's window manager's window list and will send close request when
   * anything is clicked outside of them (unless [exclusive] is enabled).
   */
  public final inline var popupWindow: Boolean
    @JvmName("popupWindowProperty")
    get() = getFlag(Window.Flags.POPUP)
    @JvmName("popupWindowProperty")
    set(`value`) {
      setFlag(Window.Flags.POPUP, value)
    }

  /**
   * If `true`, the [Window] contents is expanded to the full size of the window, window title bar
   * is transparent.
   *
   * **Note:** This property is implemented only on macOS.
   *
   * **Note:** This property only works with native windows.
   */
  public final inline var extendToTitle: Boolean
    @JvmName("extendToTitleProperty")
    get() = getFlag(Window.Flags.EXTEND_TO_TITLE)
    @JvmName("extendToTitleProperty")
    set(`value`) {
      setFlag(Window.Flags.EXTEND_TO_TITLE, value)
    }

  /**
   * If `true`, all mouse events will be passed to the underlying window of the same application.
   * See also [mousePassthroughPolygon].
   *
   * **Note:** This property is implemented on Linux (X11), macOS and Windows.
   *
   * **Note:** This property only works with native windows.
   */
  public final inline var mousePassthrough: Boolean
    @JvmName("mousePassthroughProperty")
    get() = getFlag(Window.Flags.MOUSE_PASSTHROUGH)
    @JvmName("mousePassthroughProperty")
    set(`value`) {
      setFlag(Window.Flags.MOUSE_PASSTHROUGH, value)
    }

  /**
   * If `true`, the [Window] will override the OS window style to display sharp corners.
   *
   * **Note:** This property is implemented only on Windows (11).
   *
   * **Note:** This property only works with native windows.
   */
  public final inline var sharpCorners: Boolean
    @JvmName("sharpCornersProperty")
    get() = getFlag(Window.Flags.SHARP_CORNERS)
    @JvmName("sharpCornersProperty")
    set(`value`) {
      setFlag(Window.Flags.SHARP_CORNERS, value)
    }

  /**
   * If `true`, the [Window] is excluded from screenshots taken by [DisplayServer.screenGetImage],
   * [DisplayServer.screenGetImageRect], and [DisplayServer.screenGetPixel].
   *
   * **Note:** This property is implemented on macOS and Windows.
   *
   * **Note:** Enabling this setting will prevent standard screenshot methods from capturing a
   * window image, but does **NOT** guarantee that other apps won't be able to capture an image. It
   * should not be used as a DRM or security measure.
   */
  public final inline var excludeFromCapture: Boolean
    @JvmName("excludeFromCaptureProperty")
    get() = getFlag(Window.Flags.EXCLUDE_FROM_CAPTURE)
    @JvmName("excludeFromCaptureProperty")
    set(`value`) {
      setFlag(Window.Flags.EXCLUDE_FROM_CAPTURE, value)
    }

  /**
   * If `true`, the [Window] will signal to the window manager that it is supposed to be an
   * implementation-defined "popup" (usually a floating, borderless, untileable and immovable child
   * window).
   */
  public final inline var popupWmHint: Boolean
    @JvmName("popupWmHintProperty")
    get() = getFlag(Window.Flags.POPUP_WM_HINT)
    @JvmName("popupWmHintProperty")
    set(`value`) {
      setFlag(Window.Flags.POPUP_WM_HINT, value)
    }

  /**
   * If `true`, the [Window]'s minimize button is disabled.
   *
   * **Note:** If both minimize and maximize buttons are disabled, buttons are fully hidden, and
   * only close button is visible.
   *
   * **Note:** This property is implemented only on macOS and Windows.
   */
  public final inline var minimizeDisabled: Boolean
    @JvmName("minimizeDisabledProperty")
    get() = getFlag(Window.Flags.MINIMIZE_DISABLED)
    @JvmName("minimizeDisabledProperty")
    set(`value`) {
      setFlag(Window.Flags.MINIMIZE_DISABLED, value)
    }

  /**
   * If `true`, the [Window]'s maximize button is disabled.
   *
   * **Note:** If both minimize and maximize buttons are disabled, buttons are fully hidden, and
   * only close button is visible.
   *
   * **Note:** This property is implemented only on macOS and Windows.
   */
  public final inline var maximizeDisabled: Boolean
    @JvmName("maximizeDisabledProperty")
    get() = getFlag(Window.Flags.MAXIMIZE_DISABLED)
    @JvmName("maximizeDisabledProperty")
    set(`value`) {
      setFlag(Window.Flags.MAXIMIZE_DISABLED, value)
    }

  /**
   * If `true`, native window will be used regardless of parent viewport and project settings.
   */
  public final inline var forceNative: Boolean
    @JvmName("forceNativeProperty")
    get() = getForceNative()
    @JvmName("forceNativeProperty")
    set(`value`) {
      setForceNative(value)
    }

  /**
   * If non-zero, the [Window] can't be resized to be smaller than this size.
   *
   * **Note:** This property will be ignored in favor of [getContentsMinimumSize] if [wrapControls]
   * is enabled and if its size is bigger.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var minSize: Vector2i
    @JvmName("minSizeProperty")
    get() = getMinSize()
    @JvmName("minSizeProperty")
    set(`value`) {
      setMinSize(value)
    }

  /**
   * If non-zero, the [Window] can't be resized to be bigger than this size.
   *
   * **Note:** This property will be ignored if the value is lower than [minSize].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var maxSize: Vector2i
    @JvmName("maxSizeProperty")
    get() = getMaxSize()
    @JvmName("maxSizeProperty")
    set(`value`) {
      setMaxSize(value)
    }

  /**
   * If `true`, the [Window] width is expanded to keep the title bar text fully visible.
   */
  public final inline var keepTitleVisible: Boolean
    @JvmName("keepTitleVisibleProperty")
    get() = getKeepTitleVisible()
    @JvmName("keepTitleVisibleProperty")
    set(`value`) {
      setKeepTitleVisible(value)
    }

  /**
   * The content's base size in "virtual" pixels. Not to be confused with [size], which sets the
   * actual window's physical size in pixels. If set to a value greater than `0` and [contentScaleMode]
   * is set to a value other than [CONTENT_SCALE_MODE_DISABLED], the [Window]'s content will be scaled
   * when the window is resized to a different size. Higher values will make the content appear
   * *smaller*, as it will be able to fit more of the project in view. On the root [Window], this is
   * set to match [ProjectSettings.display/window/size/viewportWidth] and
   * [ProjectSettings.display/window/size/viewportHeight] by default.
   *
   * For example, when using [CONTENT_SCALE_MODE_CANVAS_ITEMS] and [contentScaleSize] set to
   * `Vector2i(1280, 720)`, using a window size of `2560×1440` will make 2D elements appear at double
   * their original size, as the content is scaled by a factor of `2.0` (`2560.0 / 1280.0 = 2.0`,
   * `1440.0 / 720.0 = 2.0`).
   *
   * See [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html#base-size]the Base size
   * section of the Multiple resolutions documentation[/url] for details.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var contentScaleSize: Vector2i
    @JvmName("contentScaleSizeProperty")
    get() = getContentScaleSize()
    @JvmName("contentScaleSizeProperty")
    set(`value`) {
      setContentScaleSize(value)
    }

  /**
   * Specifies how the content is scaled when the [Window] is resized.
   */
  public final inline var contentScaleMode: ContentScaleMode
    @JvmName("contentScaleModeProperty")
    get() = getContentScaleMode()
    @JvmName("contentScaleModeProperty")
    set(`value`) {
      setContentScaleMode(value)
    }

  /**
   * Specifies how the content's aspect behaves when the [Window] is resized. The base aspect is
   * determined by [contentScaleSize].
   */
  public final inline var contentScaleAspect: ContentScaleAspect
    @JvmName("contentScaleAspectProperty")
    get() = getContentScaleAspect()
    @JvmName("contentScaleAspectProperty")
    set(`value`) {
      setContentScaleAspect(value)
    }

  /**
   * The policy to use to determine the final scale factor for 2D elements. This affects how
   * [contentScaleFactor] is applied, in addition to the automatic scale factor determined by
   * [contentScaleSize].
   */
  public final inline var contentScaleStretch: ContentScaleStretch
    @JvmName("contentScaleStretchProperty")
    get() = getContentScaleStretch()
    @JvmName("contentScaleStretchProperty")
    set(`value`) {
      setContentScaleStretch(value)
    }

  /**
   * Specifies the base scale of [Window]'s content when its [size] is equal to [contentScaleSize].
   * See also [Viewport.getStretchTransform].
   */
  public final inline var contentScaleFactor: Float
    @JvmName("contentScaleFactorProperty")
    get() = getContentScaleFactor()
    @JvmName("contentScaleFactorProperty")
    set(`value`) {
      setContentScaleFactor(value)
    }

  /**
   * If `true`, requests HDR output for the [Window], falling back to SDR if not supported, and
   * automatically switching between HDR and SDR as the window moves between screens, screen
   * capabilities change, or system settings are modified. This will internally force
   * [Viewport.useHdr2d] to be enabled on the main [Viewport]. All other [SubViewport] of this [Window]
   * must have their [Viewport.useHdr2d] property enabled to produce HDR output.
   */
  public final inline var hdrOutputRequested: Boolean
    @JvmName("hdrOutputRequestedProperty")
    get() = isHdrOutputRequested()
    @JvmName("hdrOutputRequestedProperty")
    set(`value`) {
      setHdrOutputRequested(value)
    }

  /**
   * Toggles if any text should automatically change to its translated version depending on the
   * current locale.
   */
  public final inline var autoTranslate: Boolean
    @JvmName("autoTranslateProperty")
    get() = isAutoTranslating()
    @JvmName("autoTranslateProperty")
    set(`value`) {
      setAutoTranslate(value)
    }

  /**
   * The human-readable node name that is reported to assistive apps.
   */
  public final inline var accessibilityName: String
    @JvmName("accessibilityNameProperty")
    get() = getAccessibilityName()
    @JvmName("accessibilityNameProperty")
    set(`value`) {
      setAccessibilityName(value)
    }

  /**
   * The human-readable node description that is reported to assistive apps.
   */
  public final inline var accessibilityDescription: String
    @JvmName("accessibilityDescriptionProperty")
    get() = getAccessibilityDescription()
    @JvmName("accessibilityDescriptionProperty")
    set(`value`) {
      setAccessibilityDescription(value)
    }

  /**
   * The [Theme] resource this node and all its [Control] and [Window] children use. If a child node
   * has its own [Theme] resource set, theme items are merged with child's definitions having higher
   * priority.
   *
   * **Note:** [Window] styles will have no effect unless the window is embedded.
   */
  public final inline var theme: Theme?
    @JvmName("themeProperty")
    get() = getTheme()
    @JvmName("themeProperty")
    set(`value`) {
      setTheme(value)
    }

  /**
   * The name of a theme type variation used by this [Window] to look up its own theme items. See
   * [Control.themeTypeVariation] for more details.
   */
  public final inline var themeTypeVariation: StringName
    @JvmName("themeTypeVariationProperty")
    get() = getThemeTypeVariation()
    @JvmName("themeTypeVariationProperty")
    set(`value`) {
      setThemeTypeVariation(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(927, scriptPtr)
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.position
   * //Your changes
   * window.position = myCoreType
   * ``````
   *
   * The window's position in pixels.
   *
   * If [ProjectSettings.display/window/subwindows/embedSubwindows] is `false`, the position is in
   * absolute screen coordinates. This typically applies to editor plugins. If the setting is `true`,
   * the window's position is in the coordinates of its parent [Viewport].
   *
   * **Note:** This property only works if [initialPosition] is set to
   * [WINDOW_INITIAL_POSITION_ABSOLUTE].
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2i.() -> Unit): Vector2i = position.apply {
     block(this)
     position = this
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.size
   * //Your changes
   * window.size = myCoreType
   * ``````
   *
   * The window's size in pixels. See also [contentScaleSize], which doesn't set the window's
   * physical size but affects how scaling works relative to the current [contentScaleMode].
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector2i.() -> Unit): Vector2i = size.apply {
     block(this)
     size = this
  }

  /**
   * This is a helper function for [nonclientArea] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.nonclientArea
   * //Your changes
   * window.nonclientArea = myCoreType
   * ``````
   *
   * If set, defines the window's custom decoration area which will receive mouse input, even if
   * normal input to the window is blocked (such as when it has an exclusive child opened). See also
   * [signal nonclient_window_input].
   */
  @CoreTypeHelper
  public final fun nonclientAreaMutate(block: Rect2i.() -> Unit): Rect2i = nonclientArea.apply {
     block(this)
     nonclientArea = this
  }

  /**
   * This is a helper function for [mousePassthroughPolygon] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.mousePassthroughPolygon
   * //Your changes
   * window.mousePassthroughPolygon = myCoreType
   * ``````
   *
   * Sets a polygonal region of the window which accepts mouse events. Mouse events outside the
   * region will be passed through.
   *
   * Passing an empty array will disable passthrough support (all mouse events will be intercepted
   * by the window, which is the default behavior).
   *
   * ```gdscript
   * //gdscript
   * # Set region, using Path2D node.
   * $Window.mouse_passthrough_polygon = $Path2D.curve.get_baked_points()
   *
   * # Set region, using Polygon2D node.
   * $Window.mouse_passthrough_polygon = $Polygon2D.polygon
   *
   * # Reset region to default.
   * $Window.mouse_passthrough_polygon = []
   * ```
   *
   * ```csharp
   * //csharp
   * // Set region, using Path2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon =
   * GetNode<Path2D>("Path2D").Curve.GetBakedPoints();
   *
   * // Set region, using Polygon2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon = GetNode<Polygon2D>("Polygon2D").Polygon;
   *
   * // Reset region to default.
   * GetNode<Window>("Window").MousePassthroughPolygon = [];
   * ```
   *
   * **Note:** This property is ignored if [mousePassthrough] is set to `true`.
   *
   * **Note:** On Windows, the portion of a window that lies outside the region is not drawn, while
   * on Linux (X11) and macOS it is.
   *
   * **Note:** This property is implemented on Linux (X11), macOS and Windows.
   */
  @CoreTypeHelper
  public final fun mousePassthroughPolygonMutate(block: PackedVector2Array.() -> Unit):
      PackedVector2Array = mousePassthroughPolygon.apply {
     block(this)
     mousePassthroughPolygon = this
  }

  /**
   * This is a helper function for [mousePassthroughPolygon] to make dealing with local copies
   * easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Sets a polygonal region of the window which accepts mouse events. Mouse events outside the
   * region will be passed through.
   *
   * Passing an empty array will disable passthrough support (all mouse events will be intercepted
   * by the window, which is the default behavior).
   *
   * ```gdscript
   * //gdscript
   * # Set region, using Path2D node.
   * $Window.mouse_passthrough_polygon = $Path2D.curve.get_baked_points()
   *
   * # Set region, using Polygon2D node.
   * $Window.mouse_passthrough_polygon = $Polygon2D.polygon
   *
   * # Reset region to default.
   * $Window.mouse_passthrough_polygon = []
   * ```
   *
   * ```csharp
   * //csharp
   * // Set region, using Path2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon =
   * GetNode<Path2D>("Path2D").Curve.GetBakedPoints();
   *
   * // Set region, using Polygon2D node.
   * GetNode<Window>("Window").MousePassthroughPolygon = GetNode<Polygon2D>("Polygon2D").Polygon;
   *
   * // Reset region to default.
   * GetNode<Window>("Window").MousePassthroughPolygon = [];
   * ```
   *
   * **Note:** This property is ignored if [mousePassthrough] is set to `true`.
   *
   * **Note:** On Windows, the portion of a window that lies outside the region is not drawn, while
   * on Linux (X11) and macOS it is.
   *
   * **Note:** This property is implemented on Linux (X11), macOS and Windows.
   */
  @CoreTypeHelper
  public final fun mousePassthroughPolygonMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = mousePassthroughPolygon.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     mousePassthroughPolygon = this
  }

  /**
   * This is a helper function for [minSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.minSize
   * //Your changes
   * window.minSize = myCoreType
   * ``````
   *
   * If non-zero, the [Window] can't be resized to be smaller than this size.
   *
   * **Note:** This property will be ignored in favor of [getContentsMinimumSize] if [wrapControls]
   * is enabled and if its size is bigger.
   */
  @CoreTypeHelper
  public final fun minSizeMutate(block: Vector2i.() -> Unit): Vector2i = minSize.apply {
     block(this)
     minSize = this
  }

  /**
   * This is a helper function for [maxSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.maxSize
   * //Your changes
   * window.maxSize = myCoreType
   * ``````
   *
   * If non-zero, the [Window] can't be resized to be bigger than this size.
   *
   * **Note:** This property will be ignored if the value is lower than [minSize].
   */
  @CoreTypeHelper
  public final fun maxSizeMutate(block: Vector2i.() -> Unit): Vector2i = maxSize.apply {
     block(this)
     maxSize = this
  }

  /**
   * This is a helper function for [contentScaleSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = window.contentScaleSize
   * //Your changes
   * window.contentScaleSize = myCoreType
   * ``````
   *
   * The content's base size in "virtual" pixels. Not to be confused with [size], which sets the
   * actual window's physical size in pixels. If set to a value greater than `0` and [contentScaleMode]
   * is set to a value other than [CONTENT_SCALE_MODE_DISABLED], the [Window]'s content will be scaled
   * when the window is resized to a different size. Higher values will make the content appear
   * *smaller*, as it will be able to fit more of the project in view. On the root [Window], this is
   * set to match [ProjectSettings.display/window/size/viewportWidth] and
   * [ProjectSettings.display/window/size/viewportHeight] by default.
   *
   * For example, when using [CONTENT_SCALE_MODE_CANVAS_ITEMS] and [contentScaleSize] set to
   * `Vector2i(1280, 720)`, using a window size of `2560×1440` will make 2D elements appear at double
   * their original size, as the content is scaled by a factor of `2.0` (`2560.0 / 1280.0 = 2.0`,
   * `1440.0 / 720.0 = 2.0`).
   *
   * See [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html#base-size]the Base size
   * section of the Multiple resolutions documentation[/url] for details.
   */
  @CoreTypeHelper
  public final fun contentScaleSizeMutate(block: Vector2i.() -> Unit): Vector2i =
      contentScaleSize.apply {
     block(this)
     contentScaleSize = this
  }

  /**
   * Virtual method to be implemented by the user. Overrides the value returned by
   * [getContentsMinimumSize].
   */
  public open fun _getContentsMinimumSize(): Vector2 {
    throw NotImplementedError("Window::_getContentsMinimumSize is not implemented.")
  }

  public final fun setTitle(title: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title)
    TransferContext.callMethod(MethodBindings.setTitlePtr)
  }

  public final fun getTitle(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitlePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setInitialPosition(initialPosition: WindowInitialPosition): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to initialPosition.value)
    TransferContext.callMethod(MethodBindings.setInitialPositionPtr)
  }

  public final fun getInitialPosition(): WindowInitialPosition {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInitialPositionPtr)
    return WindowInitialPosition.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCurrentScreen(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.setCurrentScreenPtr)
  }

  public final fun getCurrentScreen(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentScreenPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPosition(position: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getPosition(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Centers the window in the current screen. If the window is embedded, it is centered in the
   * embedder [Viewport] instead.
   */
  public final fun moveToCenter(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveToCenterPtr)
  }

  public final fun setSize(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Resets the size to the minimum size, which is the max of [minSize] and (if [wrapControls] is
   * enabled) [getContentsMinimumSize]. This is equivalent to calling `set_size(Vector2i())` (or any
   * size below the minimum).
   */
  public final fun resetSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetSizePtr)
  }

  /**
   * Returns the window's position including its border.
   *
   * **Note:** If [visible] is `false`, this method returns the same value as [position].
   */
  public final fun getPositionWithDecorations(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionWithDecorationsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the window's size including its border.
   *
   * **Note:** If [visible] is `false`, this method returns the same value as [size].
   */
  public final fun getSizeWithDecorations(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizeWithDecorationsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setMaxSize(maxSize: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to maxSize)
    TransferContext.callMethod(MethodBindings.setMaxSizePtr)
  }

  public final fun getMaxSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setMinSize(minSize: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to minSize)
    TransferContext.callMethod(MethodBindings.setMinSizePtr)
  }

  public final fun getMinSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setMode(mode: Mode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setModePtr)
  }

  public final fun getMode(): Mode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModePtr)
    return Mode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets a specified window flag.
   */
  public final fun setFlag(flag: Flags, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFlagPtr)
  }

  /**
   * Returns `true` if the [flag] is set.
   */
  public final fun getFlag(flag: Flags): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.getFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHdrOutputRequested(requested: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to requested)
    TransferContext.callMethod(MethodBindings.setHdrOutputRequestedPtr)
  }

  public final fun isHdrOutputRequested(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHdrOutputRequestedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the maximum value for linear color components that can be displayed in this window,
   * regardless of SDR or HDR output. Returns `1.0` if HDR is not enabled or not supported. The [signal
   * output_max_linear_value_changed] signal will be emitted whenever this value changes.
   *
   * This value is used by tonemapping and other [Environment] effects to ensure that bright colors
   * are presented in the range that can be displayed by this window. When using this maximum linear
   * value in your project, it should only be used to present colors directly to the screen without
   * tonemapping and without influencing lighting, post-processing effects, or surrounding color. The
   * following is an example that produces the brightest purple color that the screen can produce:
   *
   * ```gdscript
   * //gdscript
   * func _process(_delta):
   * 	# output_max_linear_value may change often, so do this every frame.
   * 	var max_linear_value = get_window().get_output_max_linear_value()
   * 	# Replace this with your color:
   * 	var original_color = Color.PURPLE
   * 	# Normalize to max_linear_value to produce the brightest color possible,
   * 	# regardless of SDR or HDR output:
   * 	var bright_color = normalize_color(original_color, max_linear_value)
   *
   *
   * func normalize_color(srgb_color, max_linear_value = 1.0):
   * 	# Color must be linear-encoded to use math operations.
   * 	var linear_color = srgb_color.srgb_to_linear()
   * 	var max_rgb_value = maxf(linear_color.r, maxf(linear_color.g, linear_color.b))
   * 	var brightness_scale = max_linear_value / max_rgb_value
   * 	linear_color *= brightness_scale
   * 	# Undo changes to the alpha channel, which should not be modified.
   * 	linear_color.a = srgb_color.a
   * 	# Convert back to nonlinear sRGB encoding, which is required for Color in
   * 	# Godot unless stated otherwise.
   * 	return linear_color.linear_to_srgb()
   * ```
   *
   * **Note:** You will need to convert sRGB colors to linear before multiplying by this value to
   * get correct results.
   */
  public final fun getOutputMaxLinearValue(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutputMaxLinearValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns `true` if the window can be maximized (the maximize button is enabled).
   */
  public final fun isMaximizeAllowed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMaximizeAllowedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Tells the OS that the [Window] needs an attention. This makes the window stand out in some way
   * depending on the system, e.g. it might blink on the task bar.
   */
  public final fun requestAttention(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.requestAttentionPtr)
  }

  /**
   * Creates a progress bar on the taskbar/dock icon of the [Window] if it does not exist, sets the
   * progress of the icon.
   *
   * [value] acts as a relative percentage value, ranges from `0.0` (lowest) to `1.0` (highest).
   *
   * **Note:** This method is implemented only on Windows and macOS.
   */
  public final fun setTaskbarProgressValue(`value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.setTaskbarProgressValuePtr)
  }

  /**
   * Sets the type and state of the progress bar on the taskbar/dock icon of the [Window]. See
   * [DisplayServer.ProgressState] for possible values and how each mode behaves.
   *
   * **Note:** This method is implemented only on Windows and macOS.
   */
  public final fun setTaskbarProgressState(state: DisplayServer.ProgressState): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to state.value)
    TransferContext.callMethod(MethodBindings.setTaskbarProgressStatePtr)
  }

  /**
   * Causes the window to grab focus, allowing it to receive user input.
   */
  public final fun moveToForeground(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveToForegroundPtr)
  }

  public final fun setVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setVisiblePtr)
  }

  public final fun isVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Hides the window. This is not the same as minimized state. Hidden window can't be interacted
   * with and needs to be made visible with [show].
   */
  public final fun hide(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hidePtr)
  }

  /**
   * Makes the [Window] appear. This enables interactions with the [Window] and doesn't change any
   * of its property other than visibility (unlike e.g. [popup]).
   */
  public final fun show(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showPtr)
  }

  public final fun setTransient(transient: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to transient)
    TransferContext.callMethod(MethodBindings.setTransientPtr)
  }

  public final fun isTransient(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTransientPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTransientToFocused(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setTransientToFocusedPtr)
  }

  public final fun isTransientToFocused(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTransientToFocusedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setExclusive(exclusive: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to exclusive)
    TransferContext.callMethod(MethodBindings.setExclusivePtr)
  }

  public final fun isExclusive(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isExclusivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If [unparent] is `true`, the window is automatically unparented when going invisible.
   *
   * **Note:** Make sure to keep a reference to the node, otherwise it will be orphaned. You also
   * need to manually call [Node.queueFree] to free the window if it's not parented.
   */
  public final fun setUnparentWhenInvisible(unparent: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to unparent)
    TransferContext.callMethod(MethodBindings.setUnparentWhenInvisiblePtr)
  }

  /**
   * Returns whether the window is being drawn to the screen.
   */
  public final fun canDraw(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canDrawPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the window is focused.
   */
  public final fun hasFocus(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasFocusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Causes the window to grab focus, allowing it to receive user input.
   */
  public final fun grabFocus(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.grabFocusPtr)
  }

  /**
   * Starts an interactive drag operation on the window, using the current mouse position. Call this
   * method when handling a mouse button being pressed to simulate a pressed event on the window's
   * title bar. Using this method allows the window to participate in space switching, tiling, and
   * other system features.
   */
  public final fun startDrag(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.startDragPtr)
  }

  /**
   * Starts an interactive resize operation on the window, using the current mouse position. Call
   * this method when handling a mouse button being pressed to simulate a pressed event on the window's
   * edge.
   */
  public final fun startResize(edge: DisplayServer.WindowResizeEdge): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to edge.value)
    TransferContext.callMethod(MethodBindings.startResizePtr)
  }

  /**
   * If [active] is `true`, enables system's native IME (Input Method Editor).
   */
  public final fun setImeActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.setImeActivePtr)
  }

  /**
   * Moves IME to the given position.
   */
  public final fun setImePosition(position: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.setImePositionPtr)
  }

  /**
   * Returns `true` if the window is currently embedded in another window.
   */
  public final fun isEmbedded(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmbeddedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the combined minimum size from the child [Control] nodes of the window. Use
   * [childControlsChanged] to update it when child nodes have changed.
   *
   * The value returned by this method can be overridden with [_getContentsMinimumSize].
   */
  public final fun getContentsMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentsMinimumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setForceNative(forceNative: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to forceNative)
    TransferContext.callMethod(MethodBindings.setForceNativePtr)
  }

  public final fun getForceNative(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getForceNativePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setContentScaleSize(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setContentScaleSizePtr)
  }

  public final fun getContentScaleSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentScaleSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setContentScaleMode(mode: ContentScaleMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setContentScaleModePtr)
  }

  public final fun getContentScaleMode(): ContentScaleMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentScaleModePtr)
    return ContentScaleMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setContentScaleAspect(aspect: ContentScaleAspect): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to aspect.value)
    TransferContext.callMethod(MethodBindings.setContentScaleAspectPtr)
  }

  public final fun getContentScaleAspect(): ContentScaleAspect {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentScaleAspectPtr)
    return ContentScaleAspect.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setContentScaleStretch(stretch: ContentScaleStretch): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stretch.value)
    TransferContext.callMethod(MethodBindings.setContentScaleStretchPtr)
  }

  public final fun getContentScaleStretch(): ContentScaleStretch {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentScaleStretchPtr)
    return ContentScaleStretch.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setNonclientArea(area: Rect2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to area)
    TransferContext.callMethod(MethodBindings.setNonclientAreaPtr)
  }

  public final fun getNonclientArea(): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNonclientAreaPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  public final fun setKeepTitleVisible(titleVisible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to titleVisible)
    TransferContext.callMethod(MethodBindings.setKeepTitleVisiblePtr)
  }

  public final fun getKeepTitleVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeepTitleVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setContentScaleFactor(factor: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to factor.toDouble())
    TransferContext.callMethod(MethodBindings.setContentScaleFactorPtr)
  }

  public final fun getContentScaleFactor(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContentScaleFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMousePassthroughPolygon(polygon: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.setMousePassthroughPolygonPtr)
  }

  public final fun getMousePassthroughPolygon(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMousePassthroughPolygonPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun setWrapControls(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setWrapControlsPtr)
  }

  public final fun isWrappingControls(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isWrappingControlsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Requests an update of the [Window] size to fit underlying [Control] nodes.
   */
  public final fun childControlsChanged(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.childControlsChangedPtr)
  }

  public final fun setTheme(theme: Theme?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to theme)
    TransferContext.callMethod(MethodBindings.setThemePtr)
  }

  public final fun getTheme(): Theme? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemePtr)
    return (TransferContext.readReturnValue(OBJECT) as Theme?)
  }

  public final fun setThemeTypeVariation(themeType: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.setThemeTypeVariationPtr)
  }

  public final fun getThemeTypeVariation(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeTypeVariationPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Prevents `*_theme_*_override` methods from emitting [NOTIFICATION_THEME_CHANGED] until
   * [endBulkThemeOverride] is called.
   */
  public final fun beginBulkThemeOverride(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beginBulkThemeOverridePtr)
  }

  /**
   * Ends a bulk theme override update. See [beginBulkThemeOverride].
   */
  public final fun endBulkThemeOverride(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endBulkThemeOverridePtr)
  }

  /**
   * Creates a local override for a theme icon with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeIconOverride].
   *
   * See also [getThemeIcon].
   */
  public final fun addThemeIconOverride(name: StringName, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.addThemeIconOverridePtr)
  }

  /**
   * Creates a local override for a theme [StyleBox] with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeStyleboxOverride].
   *
   * See also [getThemeStylebox] and [Control.addThemeStyleboxOverride] for more details.
   */
  public final fun addThemeStyleboxOverride(name: StringName, stylebox: StyleBox?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to stylebox)
    TransferContext.callMethod(MethodBindings.addThemeStyleboxOverridePtr)
  }

  /**
   * Creates a local override for a theme [Font] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontOverride].
   *
   * See also [getThemeFont].
   */
  public final fun addThemeFontOverride(name: StringName, font: Font?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to font)
    TransferContext.callMethod(MethodBindings.addThemeFontOverridePtr)
  }

  /**
   * Creates a local override for a theme font size with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontSizeOverride].
   *
   * See also [getThemeFontSize].
   */
  public final fun addThemeFontSizeOverride(name: StringName, fontSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, LONG to fontSize.toLong())
    TransferContext.callMethod(MethodBindings.addThemeFontSizeOverridePtr)
  }

  /**
   * Creates a local override for a theme [Color] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeColorOverride].
   *
   * See also [getThemeColor] and [Control.addThemeColorOverride] for more details.
   */
  public final fun addThemeColorOverride(name: StringName, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, COLOR to color)
    TransferContext.callMethod(MethodBindings.addThemeColorOverridePtr)
  }

  /**
   * Creates a local override for a theme constant with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeConstantOverride].
   *
   * See also [getThemeConstant].
   */
  public final fun addThemeConstantOverride(name: StringName, constant: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, LONG to constant.toLong())
    TransferContext.callMethod(MethodBindings.addThemeConstantOverridePtr)
  }

  /**
   * Removes a local override for a theme icon with the specified [name] previously added by
   * [addThemeIconOverride] or via the Inspector dock.
   */
  public final fun removeThemeIconOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeIconOverridePtr)
  }

  /**
   * Removes a local override for a theme [StyleBox] with the specified [name] previously added by
   * [addThemeStyleboxOverride] or via the Inspector dock.
   */
  public final fun removeThemeStyleboxOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeStyleboxOverridePtr)
  }

  /**
   * Removes a local override for a theme [Font] with the specified [name] previously added by
   * [addThemeFontOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeFontOverridePtr)
  }

  /**
   * Removes a local override for a theme font size with the specified [name] previously added by
   * [addThemeFontSizeOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontSizeOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeFontSizeOverridePtr)
  }

  /**
   * Removes a local override for a theme [Color] with the specified [name] previously added by
   * [addThemeColorOverride] or via the Inspector dock.
   */
  public final fun removeThemeColorOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeColorOverridePtr)
  }

  /**
   * Removes a local override for a theme constant with the specified [name] previously added by
   * [addThemeConstantOverride] or via the Inspector dock.
   */
  public final fun removeThemeConstantOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeConstantOverridePtr)
  }

  /**
   * Returns an icon from the first matching [Theme] in the tree if that [Theme] has an icon item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeIcon(name: StringName, themeType: StringName = StringName("")):
      Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns a [StyleBox] from the first matching [Theme] in the tree if that [Theme] has a stylebox
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeStylebox(name: StringName, themeType: StringName = StringName("")):
      StyleBox? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeStyleboxPtr)
    return (TransferContext.readReturnValue(OBJECT) as StyleBox?)
  }

  /**
   * Returns a [Font] from the first matching [Theme] in the tree if that [Theme] has a font item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeFont(name: StringName, themeType: StringName = StringName("")): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  /**
   * Returns a font size from the first matching [Theme] in the tree if that [Theme] has a font size
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeFontSize(name: StringName, themeType: StringName = StringName("")): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [Color] from the first matching [Theme] in the tree if that [Theme] has a color item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for more details.
   */
  public final fun getThemeColor(name: StringName, themeType: StringName = StringName("")): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns a constant from the first matching [Theme] in the tree if that [Theme] has a constant
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for more details.
   */
  public final fun getThemeConstant(name: StringName, themeType: StringName = StringName("")): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeConstantPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if there is a local override for a theme icon with the specified [name] in this
   * [Control] node.
   *
   * See [addThemeIconOverride].
   */
  public final fun hasThemeIconOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeIconOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [StyleBox] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeStyleboxOverride].
   */
  public final fun hasThemeStyleboxOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeStyleboxOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [Font] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontOverride].
   */
  public final fun hasThemeFontOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeFontOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme font size with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontSizeOverride].
   */
  public final fun hasThemeFontSizeOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeFontSizeOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [Color] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeColorOverride].
   */
  public final fun hasThemeColorOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeColorOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme constant with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeConstantOverride].
   */
  public final fun hasThemeConstantOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeConstantOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has an icon item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeIcon(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeIconPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a stylebox item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeStylebox(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeStyleboxPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeFont(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeFontPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font size item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeFontSize(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeFontSizePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a color item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeColor(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeColorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a constant item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeConstant(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeConstantPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the default base scale value from the first matching [Theme] in the tree if that
   * [Theme] has a valid [Theme.defaultBaseScale] value.
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeDefaultBaseScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultBaseScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the default font from the first matching [Theme] in the tree if that [Theme] has a
   * valid [Theme.defaultFont] value.
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeDefaultFont(): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  /**
   * Returns the default font size value from the first matching [Theme] in the tree if that [Theme]
   * has a valid [Theme.defaultFontSize] value.
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeDefaultFontSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the ID of the window.
   */
  public final fun getWindowId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindowIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setAccessibilityName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setAccessibilityNamePtr)
  }

  public final fun getAccessibilityName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setAccessibilityDescription(description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to description)
    TransferContext.callMethod(MethodBindings.setAccessibilityDescriptionPtr)
  }

  public final fun getAccessibilityDescription(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityDescriptionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets layout direction and text writing direction. Right-to-left layouts are necessary for
   * certain languages (e.g. Arabic and Hebrew).
   */
  public final fun setLayoutDirection(direction: LayoutDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setLayoutDirectionPtr)
  }

  /**
   * Returns layout direction and text writing direction.
   */
  public final fun getLayoutDirection(): LayoutDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayoutDirectionPtr)
    return LayoutDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the layout is right-to-left.
   */
  public final fun isLayoutRtl(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLayoutRtlPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoTranslate(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoTranslatePtr)
  }

  public final fun isAutoTranslating(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoTranslatingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Enables font oversampling. This makes fonts look better when they are scaled up.
   */
  public final fun setUseFontOversampling(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseFontOversamplingPtr)
  }

  /**
   * Returns `true` if font oversampling is enabled. See [setUseFontOversampling].
   */
  public final fun isUsingFontOversampling(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingFontOversamplingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Shows the [Window] and makes it transient (see [transient]). If [rect] is provided, it will be
   * set as the [Window]'s size. Fails if called on the main window.
   *
   * If [ProjectSettings.display/window/subwindows/embedSubwindows] is `true` (single-window mode),
   * [rect]'s coordinates are global and relative to the main window's top-left corner (excluding
   * window decorations). If [rect]'s position coordinates are negative, the window will be located
   * outside the main window and may not be visible as a result.
   *
   * If [ProjectSettings.display/window/subwindows/embedSubwindows] is `false` (multi-window mode),
   * [rect]'s coordinates are global and relative to the top-left corner of the leftmost screen. If
   * [rect]'s position coordinates are negative, the window will be placed at the top-left corner of
   * the screen.
   *
   * **Note:** [rect] must be in global coordinates if specified.
   */
  @JvmOverloads
  public final fun popup(rect: Rect2i = Rect2i(0, 0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to rect)
    TransferContext.callMethod(MethodBindings.popupPtr)
  }

  /**
   * Popups the [Window] with a position shifted by parent [Window]'s position. If the [Window] is
   * embedded, has the same effect as [popup].
   */
  public final fun popupOnParent(parentRect: Rect2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to parentRect)
    TransferContext.callMethod(MethodBindings.popupOnParentPtr)
  }

  /**
   * Popups the [Window] at the center of the current screen, with optionally given minimum size. If
   * the [Window] is embedded, it will be centered in the parent [Viewport] instead.
   *
   * **Note:** Calling it with the default value of [minsize] is equivalent to calling it with
   * [size].
   */
  @JvmOverloads
  public final fun popupCentered(minsize: Vector2i = Vector2i(0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to minsize)
    TransferContext.callMethod(MethodBindings.popupCenteredPtr)
  }

  /**
   * If [Window] is embedded, popups the [Window] centered inside its embedder and sets its size as
   * a [ratio] of embedder's size.
   *
   * If [Window] is a native window, popups the [Window] centered inside the screen of its parent
   * [Window] and sets its size as a [ratio] of the screen size.
   */
  @JvmOverloads
  public final fun popupCenteredRatio(ratio: Float = 0.8f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.popupCenteredRatioPtr)
  }

  /**
   * Popups the [Window] centered inside its parent [Window]. [fallbackRatio] determines the maximum
   * size of the [Window], in relation to its parent.
   *
   * **Note:** Calling it with the default value of [minsize] is equivalent to calling it with
   * [size].
   */
  @JvmOverloads
  public final fun popupCenteredClamped(minsize: Vector2i = Vector2i(0, 0), fallbackRatio: Float =
      0.75f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to minsize, DOUBLE to fallbackRatio.toDouble())
    TransferContext.callMethod(MethodBindings.popupCenteredClampedPtr)
  }

  /**
   * Attempts to parent this dialog to the last exclusive window relative to [fromNode], and then
   * calls [Window.popup] on it. The dialog must have no current parent, otherwise the method fails.
   *
   * See also [setUnparentWhenInvisible] and [Node.getLastExclusiveWindow].
   */
  @JvmOverloads
  public final fun popupExclusive(fromNode: Node?, rect: Rect2i = Rect2i(0, 0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, RECT2I to rect)
    TransferContext.callMethod(MethodBindings.popupExclusivePtr)
  }

  /**
   * Attempts to parent this dialog to the last exclusive window relative to [fromNode], and then
   * calls [Window.popupOnParent] on it. The dialog must have no current parent, otherwise the method
   * fails.
   *
   * See also [setUnparentWhenInvisible] and [Node.getLastExclusiveWindow].
   */
  public final fun popupExclusiveOnParent(fromNode: Node?, parentRect: Rect2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, RECT2I to parentRect)
    TransferContext.callMethod(MethodBindings.popupExclusiveOnParentPtr)
  }

  /**
   * Attempts to parent this dialog to the last exclusive window relative to [fromNode], and then
   * calls [Window.popupCentered] on it. The dialog must have no current parent, otherwise the method
   * fails.
   *
   * See also [setUnparentWhenInvisible] and [Node.getLastExclusiveWindow].
   */
  @JvmOverloads
  public final fun popupExclusiveCentered(fromNode: Node?, minsize: Vector2i = Vector2i(0, 0)):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, VECTOR2I to minsize)
    TransferContext.callMethod(MethodBindings.popupExclusiveCenteredPtr)
  }

  /**
   * Attempts to parent this dialog to the last exclusive window relative to [fromNode], and then
   * calls [Window.popupCenteredRatio] on it. The dialog must have no current parent, otherwise the
   * method fails.
   *
   * See also [setUnparentWhenInvisible] and [Node.getLastExclusiveWindow].
   */
  @JvmOverloads
  public final fun popupExclusiveCenteredRatio(fromNode: Node?, ratio: Float = 0.8f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.popupExclusiveCenteredRatioPtr)
  }

  /**
   * Attempts to parent this dialog to the last exclusive window relative to [fromNode], and then
   * calls [Window.popupCenteredClamped] on it. The dialog must have no current parent, otherwise the
   * method fails.
   *
   * See also [setUnparentWhenInvisible] and [Node.getLastExclusiveWindow].
   */
  @JvmOverloads
  public final fun popupExclusiveCenteredClamped(
    fromNode: Node?,
    minsize: Vector2i = Vector2i(0, 0),
    fallbackRatio: Float = 0.75f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, VECTOR2I to minsize, DOUBLE to fallbackRatio.toDouble())
    TransferContext.callMethod(MethodBindings.popupExclusiveCenteredClampedPtr)
  }

  public final fun setThemeTypeVariation(themeType: String) =
      setThemeTypeVariation(themeType.asCachedStringName())

  /**
   * Creates a local override for a theme icon with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeIconOverride].
   *
   * See also [getThemeIcon].
   */
  public final fun addThemeIconOverride(name: String, texture: Texture2D?) =
      addThemeIconOverride(name.asCachedStringName(), texture)

  /**
   * Creates a local override for a theme [StyleBox] with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeStyleboxOverride].
   *
   * See also [getThemeStylebox] and [Control.addThemeStyleboxOverride] for more details.
   */
  public final fun addThemeStyleboxOverride(name: String, stylebox: StyleBox?) =
      addThemeStyleboxOverride(name.asCachedStringName(), stylebox)

  /**
   * Creates a local override for a theme [Font] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontOverride].
   *
   * See also [getThemeFont].
   */
  public final fun addThemeFontOverride(name: String, font: Font?) =
      addThemeFontOverride(name.asCachedStringName(), font)

  /**
   * Creates a local override for a theme font size with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontSizeOverride].
   *
   * See also [getThemeFontSize].
   */
  public final fun addThemeFontSizeOverride(name: String, fontSize: Int) =
      addThemeFontSizeOverride(name.asCachedStringName(), fontSize)

  /**
   * Creates a local override for a theme [Color] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeColorOverride].
   *
   * See also [getThemeColor] and [Control.addThemeColorOverride] for more details.
   */
  public final fun addThemeColorOverride(name: String, color: Color) =
      addThemeColorOverride(name.asCachedStringName(), color)

  /**
   * Creates a local override for a theme constant with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeConstantOverride].
   *
   * See also [getThemeConstant].
   */
  public final fun addThemeConstantOverride(name: String, constant: Int) =
      addThemeConstantOverride(name.asCachedStringName(), constant)

  /**
   * Removes a local override for a theme icon with the specified [name] previously added by
   * [addThemeIconOverride] or via the Inspector dock.
   */
  public final fun removeThemeIconOverride(name: String) =
      removeThemeIconOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [StyleBox] with the specified [name] previously added by
   * [addThemeStyleboxOverride] or via the Inspector dock.
   */
  public final fun removeThemeStyleboxOverride(name: String) =
      removeThemeStyleboxOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [Font] with the specified [name] previously added by
   * [addThemeFontOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontOverride(name: String) =
      removeThemeFontOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme font size with the specified [name] previously added by
   * [addThemeFontSizeOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontSizeOverride(name: String) =
      removeThemeFontSizeOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [Color] with the specified [name] previously added by
   * [addThemeColorOverride] or via the Inspector dock.
   */
  public final fun removeThemeColorOverride(name: String) =
      removeThemeColorOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme constant with the specified [name] previously added by
   * [addThemeConstantOverride] or via the Inspector dock.
   */
  public final fun removeThemeConstantOverride(name: String) =
      removeThemeConstantOverride(name.asCachedStringName())

  /**
   * Returns an icon from the first matching [Theme] in the tree if that [Theme] has an icon item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeIcon(name: String, themeType: String): Texture2D? =
      getThemeIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [StyleBox] from the first matching [Theme] in the tree if that [Theme] has a stylebox
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeStylebox(name: String, themeType: String): StyleBox? =
      getThemeStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [Font] from the first matching [Theme] in the tree if that [Theme] has a font item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeFont(name: String, themeType: String): Font? =
      getThemeFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a font size from the first matching [Theme] in the tree if that [Theme] has a font size
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun getThemeFontSize(name: String, themeType: String): Int =
      getThemeFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [Color] from the first matching [Theme] in the tree if that [Theme] has a color item
   * with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for more details.
   */
  public final fun getThemeColor(name: String, themeType: String): Color =
      getThemeColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a constant from the first matching [Theme] in the tree if that [Theme] has a constant
   * item with the specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for more details.
   */
  public final fun getThemeConstant(name: String, themeType: String): Int =
      getThemeConstant(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme icon with the specified [name] in this
   * [Control] node.
   *
   * See [addThemeIconOverride].
   */
  public final fun hasThemeIconOverride(name: String): Boolean =
      hasThemeIconOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [StyleBox] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeStyleboxOverride].
   */
  public final fun hasThemeStyleboxOverride(name: String): Boolean =
      hasThemeStyleboxOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [Font] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontOverride].
   */
  public final fun hasThemeFontOverride(name: String): Boolean =
      hasThemeFontOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme font size with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontSizeOverride].
   */
  public final fun hasThemeFontSizeOverride(name: String): Boolean =
      hasThemeFontSizeOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [Color] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeColorOverride].
   */
  public final fun hasThemeColorOverride(name: String): Boolean =
      hasThemeColorOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme constant with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeConstantOverride].
   */
  public final fun hasThemeConstantOverride(name: String): Boolean =
      hasThemeConstantOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has an icon item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeIcon(name: String, themeType: String): Boolean =
      hasThemeIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a stylebox item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeStylebox(name: String, themeType: String): Boolean =
      hasThemeStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeFont(name: String, themeType: String): Boolean =
      hasThemeFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font size item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeFontSize(name: String, themeType: String): Boolean =
      hasThemeFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a color item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeColor(name: String, themeType: String): Boolean =
      hasThemeColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a constant item with the
   * specified [name] and [themeType].
   *
   * See [Control.getThemeColor] for details.
   */
  public final fun hasThemeConstant(name: String, themeType: String): Boolean =
      hasThemeConstant(name.asCachedStringName(), themeType.asCachedStringName())

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Windowed mode, i.e. [Window] doesn't occupy the whole screen (unless set to the size of the
     * screen).
     */
    WINDOWED(0),
    /**
     * Minimized window mode, i.e. [Window] is not visible and available on window manager's window
     * list. Normally happens when the minimize button is pressed.
     */
    MINIMIZED(1),
    /**
     * Maximized window mode, i.e. [Window] will occupy whole screen area except task bar and still
     * display its borders. Normally happens when the maximize button is pressed.
     */
    MAXIMIZED(2),
    /**
     * Full screen mode with full multi-window support.
     *
     * Full screen window covers the entire display area of a screen and has no decorations. The
     * display's video mode is not changed.
     *
     * **On Android:** This enables immersive mode.
     *
     * **On macOS:** A new desktop is used to display the running project.
     *
     * **Note:** Regardless of the platform, enabling full screen will change the window size to
     * match the monitor's size. Therefore, make sure your project supports
     * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]multiple resolutions[/url] when
     * enabling full screen mode.
     */
    FULLSCREEN(3),
    /**
     * A single window full screen mode. This mode has less overhead, but only one window can be
     * open on a given screen at a time (opening a child window or application switching will trigger a
     * full screen transition).
     *
     * Full screen window covers the entire display area of a screen and has no border or
     * decorations. The display's video mode is not changed.
     *
     * **Note:** This mode might not work with screen recording software.
     *
     * **On Android:** This enables immersive mode.
     *
     * **On Windows:** Depending on video driver, full screen transition might cause screens to go
     * black for a moment.
     *
     * **On macOS:** A new desktop is used to display the running project. Exclusive full screen
     * mode prevents Dock and Menu from showing up when the mouse pointer is hovering the edge of the
     * screen.
     *
     * **On Linux (X11):** Exclusive full screen mode bypasses compositor.
     *
     * **On Linux (Wayland):** Equivalent to [MODE_FULLSCREEN].
     *
     * **Note:** Regardless of the platform, enabling full screen will change the window size to
     * match the monitor's size. Therefore, make sure your project supports
     * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]multiple resolutions[/url] when
     * enabling full screen mode.
     */
    EXCLUSIVE_FULLSCREEN(4),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Flags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The window can't be resized by dragging its resize grip. It's still possible to resize the
     * window using [size]. This flag is ignored for full screen windows. Set with [unresizable].
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, Windows, and embedded windows.
     */
    RESIZE_DISABLED(0),
    /**
     * The window do not have native title bar and other decorations. This flag is ignored for
     * full-screen windows. Set with [borderless].
     *
     * **Note:** This flag is implemented on Linux (X11/Wayland), macOS, Windows, and embedded
     * windows.
     */
    BORDERLESS(1),
    /**
     * The window is floating on top of all other windows. This flag is ignored for full-screen
     * windows. Set with [alwaysOnTop].
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, Windows, and embedded windows.
     */
    ALWAYS_ON_TOP(2),
    /**
     * The window background can be transparent. Set with [transparent].
     *
     * **Note:** This flag has no effect if either
     * [ProjectSettings.display/window/perPixelTransparency/allowed], or the window's
     * [Viewport.transparentBg] is set to `false`.
     *
     * **Note:** Transparency support is implemented on Linux (X11/Wayland), macOS, Windows, and
     * embedded windows.
     */
    TRANSPARENT(3),
    /**
     * The window can't be focused. No-focus window will ignore all input, except mouse clicks. Set
     * with [unfocusable].
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, Windows, and embedded windows.
     */
    NO_FOCUS(4),
    /**
     * Window is part of menu or [OptionButton] dropdown. This flag can't be changed when the window
     * is visible. An active popup window will exclusively receive all input, without stealing focus
     * from its parent. Popup windows are automatically closed when uses click outside it, or when an
     * application is switched. Popup window must have transient parent set (see [transient]).
     *
     * **Note:** This flag is implemented on Linux (X11/Wayland), macOS, Windows, and embedded
     * [Popup] windows.
     */
    POPUP(5),
    /**
     * Window content is expanded to the full size of the window. Unlike borderless window, the
     * frame is left intact and can be used to resize the window, title bar is transparent, but have
     * minimize/maximize/close buttons. Set with [extendToTitle].
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented only on macOS.
     */
    EXTEND_TO_TITLE(6),
    /**
     * All mouse events are passed to the underlying window of the same application.
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, Windows.
     */
    MOUSE_PASSTHROUGH(7),
    /**
     * Window style is overridden, forcing sharp corners.
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented only on Windows (11).
     */
    SHARP_CORNERS(8),
    /**
     * Windows is excluded from screenshots taken by [DisplayServer.screenGetImage],
     * [DisplayServer.screenGetImageRect], and [DisplayServer.screenGetPixel].
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented on macOS and Windows (10, 20H1).
     *
     * **Note:** Setting this flag will prevent standard screenshot methods from capturing a window
     * image, but does **NOT** guarantee that other apps won't be able to capture an image. It should
     * not be used as a DRM or security measure.
     */
    EXCLUDE_FROM_CAPTURE(9),
    /**
     * Signals the window manager that this window is supposed to be an implementation-defined
     * "popup" (usually a floating, borderless, untileable and immovable child window).
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented on Linux (Wayland).
     */
    POPUP_WM_HINT(10),
    /**
     * Window minimize button is disabled.
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    MINIMIZE_DISABLED(11),
    /**
     * Window maximize button is disabled.
     *
     * **Note:** This flag has no effect in embedded windows.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    MAXIMIZE_DISABLED(12),
    /**
     * Max value of the [Flags].
     */
    MAX(13),
    ;

    public companion object {
      public fun from(`value`: Long): Flags = entries.single { it.`value` == `value` }
    }
  }

  public enum class ContentScaleMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The content will not be scaled to match the [Window]'s size ([contentScaleSize] is ignored).
     */
    DISABLED(0),
    /**
     * The content will be rendered at the target size. This is more performance-expensive than
     * [CONTENT_SCALE_MODE_VIEWPORT], but provides better results.
     */
    CANVAS_ITEMS(1),
    /**
     * The content will be rendered at the base size and then scaled to the target size. More
     * performant than [CONTENT_SCALE_MODE_CANVAS_ITEMS], but results in pixelated image.
     */
    VIEWPORT(2),
    ;

    public companion object {
      public fun from(`value`: Long): ContentScaleMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ContentScaleAspect(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The aspect will be ignored. Scaling will simply stretch the content to fit the target size.
     */
    IGNORE(0),
    /**
     * The content's aspect will be preserved. If the target size has different aspect from the base
     * one, the image will be centered and black bars will appear on left and right sides.
     */
    KEEP(1),
    /**
     * The content can be expanded vertically. Scaling horizontally will result in keeping the width
     * ratio and then black bars on left and right sides.
     */
    KEEP_WIDTH(2),
    /**
     * The content can be expanded horizontally. Scaling vertically will result in keeping the
     * height ratio and then black bars on top and bottom sides.
     */
    KEEP_HEIGHT(3),
    /**
     * The content's aspect will be preserved. If the target size has different aspect from the base
     * one, the content will stay in the top-left corner and add an extra visible area in the stretched
     * space.
     */
    EXPAND(4),
    ;

    public companion object {
      public fun from(`value`: Long): ContentScaleAspect = entries.single { it.`value` == `value` }
    }
  }

  public enum class ContentScaleStretch(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The content will be stretched according to a fractional factor. This fills all the space
     * available in the window, but allows "pixel wobble" to occur due to uneven pixel scaling.
     */
    FRACTIONAL(0),
    /**
     * The content will be stretched only according to an integer factor, preserving sharp pixels.
     * This may leave a black background visible on the window's edges depending on the window size.
     */
    INTEGER(1),
    ;

    public companion object {
      public fun from(`value`: Long): ContentScaleStretch = entries.single { it.`value` == `value` }
    }
  }

  public enum class LayoutDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Automatic layout direction, determined from the parent window layout direction.
     */
    INHERITED(0),
    /**
     * Automatic layout direction, determined from the current locale.
     */
    APPLICATION_LOCALE(1),
    /**
     * Left-to-right layout direction.
     */
    LTR(2),
    /**
     * Right-to-left layout direction.
     */
    RTL(3),
    /**
     * Automatic layout direction, determined from the system locale.
     */
    SYSTEM_LOCALE(4),
    /**
     * Represents the size of the [LayoutDirection] enum.
     */
    MAX(5),
    LOCALE(1),
    ;

    public companion object {
      public fun from(`value`: Long): LayoutDirection = entries.single { it.`value` == `value` }
    }
  }

  public enum class WindowInitialPosition(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Initial window position is determined by [position].
     */
    ABSOLUTE(0),
    /**
     * Initial window position is the center of the primary screen.
     */
    CENTER_PRIMARY_SCREEN(1),
    /**
     * Initial window position is the center of the main window screen.
     */
    CENTER_MAIN_WINDOW_SCREEN(2),
    /**
     * Initial window position is the center of [currentScreen] screen.
     */
    CENTER_OTHER_SCREEN(3),
    /**
     * Initial window position is the center of the screen containing the mouse pointer.
     */
    CENTER_SCREEN_WITH_MOUSE_FOCUS(4),
    /**
     * Initial window position is the center of the screen containing the window with the keyboard
     * focus.
     */
    CENTER_SCREEN_WITH_KEYBOARD_FOCUS(5),
    ;

    public companion object {
      public fun from(`value`: Long): WindowInitialPosition =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTitleName: MethodStringName1<Window, Unit, String> =
        MethodStringName1<Window, Unit, String>("set_title")

    @JvmField
    public val getTitleName: MethodStringName0<Window, String> =
        MethodStringName0<Window, String>("get_title")

    @JvmField
    public val setInitialPositionName: MethodStringName1<Window, Unit, WindowInitialPosition> =
        MethodStringName1<Window, Unit, WindowInitialPosition>("set_initial_position")

    @JvmField
    public val getInitialPositionName: MethodStringName0<Window, WindowInitialPosition> =
        MethodStringName0<Window, WindowInitialPosition>("get_initial_position")

    @JvmField
    public val setCurrentScreenName: MethodStringName1<Window, Unit, Int> =
        MethodStringName1<Window, Unit, Int>("set_current_screen")

    @JvmField
    public val getCurrentScreenName: MethodStringName0<Window, Int> =
        MethodStringName0<Window, Int>("get_current_screen")

    @JvmField
    public val setPositionName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_position")

    @JvmField
    public val moveToCenterName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("move_to_center")

    @JvmField
    public val setSizeName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_size")

    @JvmField
    public val resetSizeName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("reset_size")

    @JvmField
    public val getPositionWithDecorationsName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_position_with_decorations")

    @JvmField
    public val getSizeWithDecorationsName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_size_with_decorations")

    @JvmField
    public val setMaxSizeName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_max_size")

    @JvmField
    public val getMaxSizeName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_max_size")

    @JvmField
    public val setMinSizeName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_min_size")

    @JvmField
    public val getMinSizeName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_min_size")

    @JvmField
    public val setModeName: MethodStringName1<Window, Unit, Mode> =
        MethodStringName1<Window, Unit, Mode>("set_mode")

    @JvmField
    public val getModeName: MethodStringName0<Window, Mode> =
        MethodStringName0<Window, Mode>("get_mode")

    @JvmField
    public val setFlagName: MethodStringName2<Window, Unit, Flags, Boolean> =
        MethodStringName2<Window, Unit, Flags, Boolean>("set_flag")

    @JvmField
    public val getFlagName: MethodStringName1<Window, Boolean, Flags> =
        MethodStringName1<Window, Boolean, Flags>("get_flag")

    @JvmField
    public val setHdrOutputRequestedName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_hdr_output_requested")

    @JvmField
    public val isHdrOutputRequestedName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_hdr_output_requested")

    @JvmField
    public val getOutputMaxLinearValueName: MethodStringName0<Window, Float> =
        MethodStringName0<Window, Float>("get_output_max_linear_value")

    @JvmField
    public val isMaximizeAllowedName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_maximize_allowed")

    @JvmField
    public val requestAttentionName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("request_attention")

    @JvmField
    public val setTaskbarProgressValueName: MethodStringName1<Window, Unit, Float> =
        MethodStringName1<Window, Unit, Float>("set_taskbar_progress_value")

    @JvmField
    public val setTaskbarProgressStateName:
        MethodStringName1<Window, Unit, DisplayServer.ProgressState> =
        MethodStringName1<Window, Unit, DisplayServer.ProgressState>("set_taskbar_progress_state")

    @JvmField
    public val moveToForegroundName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("move_to_foreground")

    @JvmField
    public val setVisibleName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_visible")

    @JvmField
    public val isVisibleName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_visible")

    @JvmField
    public val hideName: MethodStringName0<Window, Unit> = MethodStringName0<Window, Unit>("hide")

    @JvmField
    public val showName: MethodStringName0<Window, Unit> = MethodStringName0<Window, Unit>("show")

    @JvmField
    public val setTransientName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_transient")

    @JvmField
    public val isTransientName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_transient")

    @JvmField
    public val setTransientToFocusedName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_transient_to_focused")

    @JvmField
    public val isTransientToFocusedName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_transient_to_focused")

    @JvmField
    public val setExclusiveName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_exclusive")

    @JvmField
    public val isExclusiveName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_exclusive")

    @JvmField
    public val setUnparentWhenInvisibleName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_unparent_when_invisible")

    @JvmField
    public val canDrawName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("can_draw")

    @JvmField
    public val hasFocusName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("has_focus")

    @JvmField
    public val grabFocusName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("grab_focus")

    @JvmField
    public val startDragName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("start_drag")

    @JvmField
    public val startResizeName: MethodStringName1<Window, Unit, DisplayServer.WindowResizeEdge> =
        MethodStringName1<Window, Unit, DisplayServer.WindowResizeEdge>("start_resize")

    @JvmField
    public val setImeActiveName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_ime_active")

    @JvmField
    public val setImePositionName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_ime_position")

    @JvmField
    public val isEmbeddedName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_embedded")

    @JvmField
    public val getContentsMinimumSizeName: MethodStringName0<Window, Vector2> =
        MethodStringName0<Window, Vector2>("get_contents_minimum_size")

    @JvmField
    public val setForceNativeName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_force_native")

    @JvmField
    public val getForceNativeName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("get_force_native")

    @JvmField
    public val setContentScaleSizeName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("set_content_scale_size")

    @JvmField
    public val getContentScaleSizeName: MethodStringName0<Window, Vector2i> =
        MethodStringName0<Window, Vector2i>("get_content_scale_size")

    @JvmField
    public val setContentScaleModeName: MethodStringName1<Window, Unit, ContentScaleMode> =
        MethodStringName1<Window, Unit, ContentScaleMode>("set_content_scale_mode")

    @JvmField
    public val getContentScaleModeName: MethodStringName0<Window, ContentScaleMode> =
        MethodStringName0<Window, ContentScaleMode>("get_content_scale_mode")

    @JvmField
    public val setContentScaleAspectName: MethodStringName1<Window, Unit, ContentScaleAspect> =
        MethodStringName1<Window, Unit, ContentScaleAspect>("set_content_scale_aspect")

    @JvmField
    public val getContentScaleAspectName: MethodStringName0<Window, ContentScaleAspect> =
        MethodStringName0<Window, ContentScaleAspect>("get_content_scale_aspect")

    @JvmField
    public val setContentScaleStretchName: MethodStringName1<Window, Unit, ContentScaleStretch> =
        MethodStringName1<Window, Unit, ContentScaleStretch>("set_content_scale_stretch")

    @JvmField
    public val getContentScaleStretchName: MethodStringName0<Window, ContentScaleStretch> =
        MethodStringName0<Window, ContentScaleStretch>("get_content_scale_stretch")

    @JvmField
    public val setNonclientAreaName: MethodStringName1<Window, Unit, Rect2i> =
        MethodStringName1<Window, Unit, Rect2i>("set_nonclient_area")

    @JvmField
    public val getNonclientAreaName: MethodStringName0<Window, Rect2i> =
        MethodStringName0<Window, Rect2i>("get_nonclient_area")

    @JvmField
    public val setKeepTitleVisibleName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_keep_title_visible")

    @JvmField
    public val getKeepTitleVisibleName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("get_keep_title_visible")

    @JvmField
    public val setContentScaleFactorName: MethodStringName1<Window, Unit, Float> =
        MethodStringName1<Window, Unit, Float>("set_content_scale_factor")

    @JvmField
    public val getContentScaleFactorName: MethodStringName0<Window, Float> =
        MethodStringName0<Window, Float>("get_content_scale_factor")

    @JvmField
    public val setMousePassthroughPolygonName: MethodStringName1<Window, Unit, PackedVector2Array> =
        MethodStringName1<Window, Unit, PackedVector2Array>("set_mouse_passthrough_polygon")

    @JvmField
    public val getMousePassthroughPolygonName: MethodStringName0<Window, PackedVector2Array> =
        MethodStringName0<Window, PackedVector2Array>("get_mouse_passthrough_polygon")

    @JvmField
    public val setWrapControlsName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_wrap_controls")

    @JvmField
    public val isWrappingControlsName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_wrapping_controls")

    @JvmField
    public val childControlsChangedName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("child_controls_changed")

    @JvmField
    public val setThemeName: MethodStringName1<Window, Unit, Theme?> =
        MethodStringName1<Window, Unit, Theme?>("set_theme")

    @JvmField
    public val getThemeName: MethodStringName0<Window, Theme?> =
        MethodStringName0<Window, Theme?>("get_theme")

    @JvmField
    public val setThemeTypeVariationName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("set_theme_type_variation")

    @JvmField
    public val getThemeTypeVariationName: MethodStringName0<Window, StringName> =
        MethodStringName0<Window, StringName>("get_theme_type_variation")

    @JvmField
    public val beginBulkThemeOverrideName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("begin_bulk_theme_override")

    @JvmField
    public val endBulkThemeOverrideName: MethodStringName0<Window, Unit> =
        MethodStringName0<Window, Unit>("end_bulk_theme_override")

    @JvmField
    public val addThemeIconOverrideName: MethodStringName2<Window, Unit, StringName, Texture2D?> =
        MethodStringName2<Window, Unit, StringName, Texture2D?>("add_theme_icon_override")

    @JvmField
    public val addThemeStyleboxOverrideName: MethodStringName2<Window, Unit, StringName, StyleBox?>
        = MethodStringName2<Window, Unit, StringName, StyleBox?>("add_theme_stylebox_override")

    @JvmField
    public val addThemeFontOverrideName: MethodStringName2<Window, Unit, StringName, Font?> =
        MethodStringName2<Window, Unit, StringName, Font?>("add_theme_font_override")

    @JvmField
    public val addThemeFontSizeOverrideName: MethodStringName2<Window, Unit, StringName, Int> =
        MethodStringName2<Window, Unit, StringName, Int>("add_theme_font_size_override")

    @JvmField
    public val addThemeColorOverrideName: MethodStringName2<Window, Unit, StringName, Color> =
        MethodStringName2<Window, Unit, StringName, Color>("add_theme_color_override")

    @JvmField
    public val addThemeConstantOverrideName: MethodStringName2<Window, Unit, StringName, Int> =
        MethodStringName2<Window, Unit, StringName, Int>("add_theme_constant_override")

    @JvmField
    public val removeThemeIconOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_icon_override")

    @JvmField
    public val removeThemeStyleboxOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_stylebox_override")

    @JvmField
    public val removeThemeFontOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_font_override")

    @JvmField
    public val removeThemeFontSizeOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_font_size_override")

    @JvmField
    public val removeThemeColorOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_color_override")

    @JvmField
    public val removeThemeConstantOverrideName: MethodStringName1<Window, Unit, StringName> =
        MethodStringName1<Window, Unit, StringName>("remove_theme_constant_override")

    @JvmField
    public val getThemeIconName: MethodStringName2<Window, Texture2D?, StringName, StringName> =
        MethodStringName2<Window, Texture2D?, StringName, StringName>("get_theme_icon")

    @JvmField
    public val getThemeStyleboxName: MethodStringName2<Window, StyleBox?, StringName, StringName> =
        MethodStringName2<Window, StyleBox?, StringName, StringName>("get_theme_stylebox")

    @JvmField
    public val getThemeFontName: MethodStringName2<Window, Font?, StringName, StringName> =
        MethodStringName2<Window, Font?, StringName, StringName>("get_theme_font")

    @JvmField
    public val getThemeFontSizeName: MethodStringName2<Window, Int, StringName, StringName> =
        MethodStringName2<Window, Int, StringName, StringName>("get_theme_font_size")

    @JvmField
    public val getThemeColorName: MethodStringName2<Window, Color, StringName, StringName> =
        MethodStringName2<Window, Color, StringName, StringName>("get_theme_color")

    @JvmField
    public val getThemeConstantName: MethodStringName2<Window, Int, StringName, StringName> =
        MethodStringName2<Window, Int, StringName, StringName>("get_theme_constant")

    @JvmField
    public val hasThemeIconOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_icon_override")

    @JvmField
    public val hasThemeStyleboxOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_stylebox_override")

    @JvmField
    public val hasThemeFontOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_font_override")

    @JvmField
    public val hasThemeFontSizeOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_font_size_override")

    @JvmField
    public val hasThemeColorOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_color_override")

    @JvmField
    public val hasThemeConstantOverrideName: MethodStringName1<Window, Boolean, StringName> =
        MethodStringName1<Window, Boolean, StringName>("has_theme_constant_override")

    @JvmField
    public val hasThemeIconName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_icon")

    @JvmField
    public val hasThemeStyleboxName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_stylebox")

    @JvmField
    public val hasThemeFontName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_font")

    @JvmField
    public val hasThemeFontSizeName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_font_size")

    @JvmField
    public val hasThemeColorName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_color")

    @JvmField
    public val hasThemeConstantName: MethodStringName2<Window, Boolean, StringName, StringName> =
        MethodStringName2<Window, Boolean, StringName, StringName>("has_theme_constant")

    @JvmField
    public val getThemeDefaultBaseScaleName: MethodStringName0<Window, Float> =
        MethodStringName0<Window, Float>("get_theme_default_base_scale")

    @JvmField
    public val getThemeDefaultFontName: MethodStringName0<Window, Font?> =
        MethodStringName0<Window, Font?>("get_theme_default_font")

    @JvmField
    public val getThemeDefaultFontSizeName: MethodStringName0<Window, Int> =
        MethodStringName0<Window, Int>("get_theme_default_font_size")

    @JvmField
    public val getWindowIdName: MethodStringName0<Window, Int> =
        MethodStringName0<Window, Int>("get_window_id")

    @JvmField
    public val setAccessibilityNameName: MethodStringName1<Window, Unit, String> =
        MethodStringName1<Window, Unit, String>("set_accessibility_name")

    @JvmField
    public val getAccessibilityNameName: MethodStringName0<Window, String> =
        MethodStringName0<Window, String>("get_accessibility_name")

    @JvmField
    public val setAccessibilityDescriptionName: MethodStringName1<Window, Unit, String> =
        MethodStringName1<Window, Unit, String>("set_accessibility_description")

    @JvmField
    public val getAccessibilityDescriptionName: MethodStringName0<Window, String> =
        MethodStringName0<Window, String>("get_accessibility_description")

    @JvmField
    public val getFocusedWindowName: MethodStringName0<Window, Window?> =
        MethodStringName0<Window, Window?>("get_focused_window")

    @JvmField
    public val setLayoutDirectionName: MethodStringName1<Window, Unit, LayoutDirection> =
        MethodStringName1<Window, Unit, LayoutDirection>("set_layout_direction")

    @JvmField
    public val getLayoutDirectionName: MethodStringName0<Window, LayoutDirection> =
        MethodStringName0<Window, LayoutDirection>("get_layout_direction")

    @JvmField
    public val isLayoutRtlName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_layout_rtl")

    @JvmField
    public val setAutoTranslateName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_auto_translate")

    @JvmField
    public val isAutoTranslatingName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_auto_translating")

    @JvmField
    public val setUseFontOversamplingName: MethodStringName1<Window, Unit, Boolean> =
        MethodStringName1<Window, Unit, Boolean>("set_use_font_oversampling")

    @JvmField
    public val isUsingFontOversamplingName: MethodStringName0<Window, Boolean> =
        MethodStringName0<Window, Boolean>("is_using_font_oversampling")

    @JvmField
    public val popupName: MethodStringName1<Window, Unit, Rect2i> =
        MethodStringName1<Window, Unit, Rect2i>("popup")

    @JvmField
    public val popupOnParentName: MethodStringName1<Window, Unit, Rect2i> =
        MethodStringName1<Window, Unit, Rect2i>("popup_on_parent")

    @JvmField
    public val popupCenteredName: MethodStringName1<Window, Unit, Vector2i> =
        MethodStringName1<Window, Unit, Vector2i>("popup_centered")

    @JvmField
    public val popupCenteredRatioName: MethodStringName1<Window, Unit, Float> =
        MethodStringName1<Window, Unit, Float>("popup_centered_ratio")

    @JvmField
    public val popupCenteredClampedName: MethodStringName2<Window, Unit, Vector2i, Float> =
        MethodStringName2<Window, Unit, Vector2i, Float>("popup_centered_clamped")

    @JvmField
    public val popupExclusiveName: MethodStringName2<Window, Unit, Node?, Rect2i> =
        MethodStringName2<Window, Unit, Node?, Rect2i>("popup_exclusive")

    @JvmField
    public val popupExclusiveOnParentName: MethodStringName2<Window, Unit, Node?, Rect2i> =
        MethodStringName2<Window, Unit, Node?, Rect2i>("popup_exclusive_on_parent")

    @JvmField
    public val popupExclusiveCenteredName: MethodStringName2<Window, Unit, Node?, Vector2i> =
        MethodStringName2<Window, Unit, Node?, Vector2i>("popup_exclusive_centered")

    @JvmField
    public val popupExclusiveCenteredRatioName: MethodStringName2<Window, Unit, Node?, Float> =
        MethodStringName2<Window, Unit, Node?, Float>("popup_exclusive_centered_ratio")

    @JvmField
    public val popupExclusiveCenteredClampedName:
        MethodStringName3<Window, Unit, Node?, Vector2i, Float> =
        MethodStringName3<Window, Unit, Node?, Vector2i, Float>("popup_exclusive_centered_clamped")

    /**
     * Emitted when [Window]'s visibility changes, right before [signal visibility_changed].
     */
    public final const val NOTIFICATION_VISIBILITY_CHANGED: Long = 30

    /**
     * Sent when the node needs to refresh its theme items. This happens in one of the following
     * cases:
     *
     * - The [theme] property is changed on this node or any of its ancestors.
     *
     * - The [themeTypeVariation] property is changed on this node.
     *
     * - The node enters the scene tree.
     *
     * **Note:** As an optimization, this notification won't be sent from changes that occur while
     * this node is outside of the scene tree. Instead, all of the theme item updates can be applied at
     * once when the node enters the scene tree.
     */
    public final const val NOTIFICATION_THEME_CHANGED: Long = 32

    /**
     * Returns the focused window.
     */
    @JvmStatic
    public final fun getFocusedWindow(): Window? {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getFocusedWindowPtr)
      return (TransferContext.readReturnValue(OBJECT) as Window?)
    }
  }

  public object MethodBindings {
    internal val setTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_title", 83702148)

    internal val getTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_title", 201670096)

    internal val setInitialPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_initial_position", 4084468099)

    internal val getInitialPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_initial_position", 4294066647)

    internal val setCurrentScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_current_screen", 1286410249)

    internal val getCurrentScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_current_screen", 3905245786)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_position", 1130785943)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_position", 3690982128)

    internal val moveToCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "move_to_center", 3218959716)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_size", 1130785943)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_size", 3690982128)

    internal val resetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "reset_size", 3218959716)

    internal val getPositionWithDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_position_with_decorations", 3690982128)

    internal val getSizeWithDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_size_with_decorations", 3690982128)

    internal val setMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_max_size", 1130785943)

    internal val getMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_max_size", 3690982128)

    internal val setMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_min_size", 1130785943)

    internal val getMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_min_size", 3690982128)

    internal val setModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_mode", 3095236531)

    internal val getModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_mode", 2566346114)

    internal val setFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_flag", 3426449779)

    internal val getFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_flag", 3062752289)

    internal val setHdrOutputRequestedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_hdr_output_requested", 2586408642)

    internal val isHdrOutputRequestedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_hdr_output_requested", 36873697)

    internal val getOutputMaxLinearValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_output_max_linear_value", 1740695150)

    internal val isMaximizeAllowedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_maximize_allowed", 36873697)

    internal val requestAttentionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "request_attention", 3218959716)

    internal val setTaskbarProgressValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_taskbar_progress_value", 373806689)

    internal val setTaskbarProgressStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_taskbar_progress_state", 824071031)

    internal val moveToForegroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "move_to_foreground", 3218959716)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_visible", 2586408642)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_visible", 36873697)

    internal val hidePtr: VoidPtr = TypeManager.getMethodBindPtr("Window", "hide", 3218959716)

    internal val showPtr: VoidPtr = TypeManager.getMethodBindPtr("Window", "show", 3218959716)

    internal val setTransientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_transient", 2586408642)

    internal val isTransientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_transient", 36873697)

    internal val setTransientToFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_transient_to_focused", 2586408642)

    internal val isTransientToFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_transient_to_focused", 36873697)

    internal val setExclusivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_exclusive", 2586408642)

    internal val isExclusivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_exclusive", 36873697)

    internal val setUnparentWhenInvisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_unparent_when_invisible", 2586408642)

    internal val canDrawPtr: VoidPtr = TypeManager.getMethodBindPtr("Window", "can_draw", 36873697)

    internal val hasFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_focus", 36873697)

    internal val grabFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "grab_focus", 3218959716)

    internal val startDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "start_drag", 3218959716)

    internal val startResizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "start_resize", 122288853)

    internal val setImeActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_ime_active", 2586408642)

    internal val setImePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_ime_position", 1130785943)

    internal val isEmbeddedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_embedded", 36873697)

    internal val getContentsMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_contents_minimum_size", 3341600327)

    internal val setForceNativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_force_native", 2586408642)

    internal val getForceNativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_force_native", 36873697)

    internal val setContentScaleSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_content_scale_size", 1130785943)

    internal val getContentScaleSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_content_scale_size", 3690982128)

    internal val setContentScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_content_scale_mode", 2937716473)

    internal val getContentScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_content_scale_mode", 161585230)

    internal val setContentScaleAspectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_content_scale_aspect", 2370399418)

    internal val getContentScaleAspectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_content_scale_aspect", 4158790715)

    internal val setContentScaleStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_content_scale_stretch", 349355940)

    internal val getContentScaleStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_content_scale_stretch", 536857316)

    internal val setNonclientAreaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_nonclient_area", 1763793166)

    internal val getNonclientAreaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_nonclient_area", 410525958)

    internal val setKeepTitleVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_keep_title_visible", 2586408642)

    internal val getKeepTitleVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_keep_title_visible", 36873697)

    internal val setContentScaleFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_content_scale_factor", 373806689)

    internal val getContentScaleFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_content_scale_factor", 1740695150)

    internal val setMousePassthroughPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_mouse_passthrough_polygon", 1509147220)

    internal val getMousePassthroughPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_mouse_passthrough_polygon", 2961356807)

    internal val setWrapControlsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_wrap_controls", 2586408642)

    internal val isWrappingControlsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_wrapping_controls", 36873697)

    internal val childControlsChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "child_controls_changed", 3218959716)

    internal val setThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_theme", 2326690814)

    internal val getThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme", 3846893731)

    internal val setThemeTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_theme_type_variation", 3304788590)

    internal val getThemeTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_type_variation", 2002593661)

    internal val beginBulkThemeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "begin_bulk_theme_override", 3218959716)

    internal val endBulkThemeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "end_bulk_theme_override", 3218959716)

    internal val addThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_icon_override", 1373065600)

    internal val addThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_stylebox_override", 4188838905)

    internal val addThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_font_override", 3518018674)

    internal val addThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_font_size_override", 2415702435)

    internal val addThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_color_override", 4260178595)

    internal val addThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "add_theme_constant_override", 2415702435)

    internal val removeThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_icon_override", 3304788590)

    internal val removeThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_stylebox_override", 3304788590)

    internal val removeThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_font_override", 3304788590)

    internal val removeThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_font_size_override", 3304788590)

    internal val removeThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_color_override", 3304788590)

    internal val removeThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "remove_theme_constant_override", 3304788590)

    internal val getThemeIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_icon", 3163973443)

    internal val getThemeStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_stylebox", 604739069)

    internal val getThemeFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_font", 2826986490)

    internal val getThemeFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_font_size", 1327056374)

    internal val getThemeColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_color", 2798751242)

    internal val getThemeConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_constant", 1327056374)

    internal val hasThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_icon_override", 2619796661)

    internal val hasThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_stylebox_override", 2619796661)

    internal val hasThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_font_override", 2619796661)

    internal val hasThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_font_size_override", 2619796661)

    internal val hasThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_color_override", 2619796661)

    internal val hasThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_constant_override", 2619796661)

    internal val hasThemeIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_icon", 866386512)

    internal val hasThemeStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_stylebox", 866386512)

    internal val hasThemeFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_font", 866386512)

    internal val hasThemeFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_font_size", 866386512)

    internal val hasThemeColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_color", 866386512)

    internal val hasThemeConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "has_theme_constant", 866386512)

    internal val getThemeDefaultBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_default_base_scale", 1740695150)

    internal val getThemeDefaultFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_default_font", 3229501585)

    internal val getThemeDefaultFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_theme_default_font_size", 3905245786)

    internal val getWindowIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_window_id", 3905245786)

    internal val setAccessibilityNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_accessibility_name", 83702148)

    internal val getAccessibilityNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_accessibility_name", 201670096)

    internal val setAccessibilityDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_accessibility_description", 83702148)

    internal val getAccessibilityDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_accessibility_description", 201670096)

    internal val getFocusedWindowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_focused_window", 1835468782)

    internal val setLayoutDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_layout_direction", 3094704184)

    internal val getLayoutDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "get_layout_direction", 3909617982)

    internal val isLayoutRtlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_layout_rtl", 36873697)

    internal val setAutoTranslatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_auto_translate", 2586408642)

    internal val isAutoTranslatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_auto_translating", 36873697)

    internal val setUseFontOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "set_use_font_oversampling", 2586408642)

    internal val isUsingFontOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "is_using_font_oversampling", 36873697)

    internal val popupPtr: VoidPtr = TypeManager.getMethodBindPtr("Window", "popup", 1680304321)

    internal val popupOnParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_on_parent", 1763793166)

    internal val popupCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_centered", 3447975422)

    internal val popupCenteredRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_centered_ratio", 1014814997)

    internal val popupCenteredClampedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_centered_clamped", 2613752477)

    internal val popupExclusivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_exclusive", 2134721627)

    internal val popupExclusiveOnParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_exclusive_on_parent", 2344671043)

    internal val popupExclusiveCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_exclusive_centered", 3357594017)

    internal val popupExclusiveCenteredRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_exclusive_centered_ratio", 2284776287)

    internal val popupExclusiveCenteredClampedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Window", "popup_exclusive_centered_clamped", 2612708785)
  }
}
