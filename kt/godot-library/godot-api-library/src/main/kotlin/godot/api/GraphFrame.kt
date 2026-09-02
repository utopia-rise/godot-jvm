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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * GraphFrame is a special [GraphElement] to which other [GraphElement]s can be attached. It can be
 * configured to automatically resize to enclose all attached [GraphElement]s. If the frame is moved,
 * all the attached [GraphElement]s inside it will be moved as well.
 *
 * A GraphFrame is always kept behind the connection layer and other [GraphElement]s inside a
 * [GraphEdit].
 */
@GodotBaseType
public open class GraphFrame : GraphElement() {
  /**
   * Emitted when [autoshrinkEnabled] or [autoshrinkMargin] changes.
   */
  public val autoshrinkChanged: Signal0 by Signal0

  /**
   * Title of the frame.
   */
  public final inline var title: String
    @JvmName("titleProperty")
    get() = getTitle()
    @JvmName("titleProperty")
    set(`value`) {
      setTitle(value)
    }

  /**
   * If `true`, the frame's rect will be adjusted automatically to enclose all attached
   * [GraphElement]s.
   */
  public final inline var autoshrinkEnabled: Boolean
    @JvmName("autoshrinkEnabledProperty")
    get() = isAutoshrinkEnabled()
    @JvmName("autoshrinkEnabledProperty")
    set(`value`) {
      setAutoshrinkEnabled(value)
    }

  /**
   * The margin around the attached nodes that is used to calculate the size of the frame when
   * [autoshrinkEnabled] is `true`.
   */
  public final inline var autoshrinkMargin: Int
    @JvmName("autoshrinkMarginProperty")
    get() = getAutoshrinkMargin()
    @JvmName("autoshrinkMarginProperty")
    set(`value`) {
      setAutoshrinkMargin(value)
    }

  /**
   * The margin inside the frame that can be used to drag the frame.
   */
  public final inline var dragMargin: Int
    @JvmName("dragMarginProperty")
    get() = getDragMargin()
    @JvmName("dragMarginProperty")
    set(`value`) {
      setDragMargin(value)
    }

  /**
   * If `true`, the tint color will be used to tint the frame.
   */
  public final inline var tintColorEnabled: Boolean
    @JvmName("tintColorEnabledProperty")
    get() = isTintColorEnabled()
    @JvmName("tintColorEnabledProperty")
    set(`value`) {
      setTintColorEnabled(value)
    }

  /**
   * The color of the frame when [tintColorEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tintColor: Color
    @JvmName("tintColorProperty")
    get() = getTintColor()
    @JvmName("tintColorProperty")
    set(`value`) {
      setTintColor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(281, scriptPtr)
  }

  /**
   * This is a helper function for [tintColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = graphframe.tintColor
   * //Your changes
   * graphframe.tintColor = myCoreType
   * ``````
   *
   * The color of the frame when [tintColorEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun tintColorMutate(block: Color.() -> Unit): Color = tintColor.apply {
     block(this)
     tintColor = this
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

  /**
   * Returns the [HBoxContainer] used for the title bar, only containing a [Label] for displaying
   * the title by default.
   *
   * This can be used to add custom controls to the title bar such as option or close buttons.
   */
  public final fun getTitlebarHbox(): HBoxContainer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitlebarHboxPtr)
    return (TransferContext.readReturnValue(OBJECT) as HBoxContainer?)
  }

  public final fun setAutoshrinkEnabled(shrink: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to shrink)
    TransferContext.callMethod(MethodBindings.setAutoshrinkEnabledPtr)
  }

  public final fun isAutoshrinkEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoshrinkEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoshrinkMargin(autoshrinkMargin: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to autoshrinkMargin.toLong())
    TransferContext.callMethod(MethodBindings.setAutoshrinkMarginPtr)
  }

  public final fun getAutoshrinkMargin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoshrinkMarginPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setDragMargin(dragMargin: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to dragMargin.toLong())
    TransferContext.callMethod(MethodBindings.setDragMarginPtr)
  }

  public final fun getDragMargin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragMarginPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setTintColorEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setTintColorEnabledPtr)
  }

  public final fun isTintColorEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTintColorEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTintColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setTintColorPtr)
  }

  public final fun getTintColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTintColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public companion object {
    @JvmField
    public val setTitleName: MethodStringName1<GraphFrame, Unit, String> =
        MethodStringName1<GraphFrame, Unit, String>("set_title")

    @JvmField
    public val getTitleName: MethodStringName0<GraphFrame, String> =
        MethodStringName0<GraphFrame, String>("get_title")

    @JvmField
    public val getTitlebarHboxName: MethodStringName0<GraphFrame, HBoxContainer?> =
        MethodStringName0<GraphFrame, HBoxContainer?>("get_titlebar_hbox")

    @JvmField
    public val setAutoshrinkEnabledName: MethodStringName1<GraphFrame, Unit, Boolean> =
        MethodStringName1<GraphFrame, Unit, Boolean>("set_autoshrink_enabled")

    @JvmField
    public val isAutoshrinkEnabledName: MethodStringName0<GraphFrame, Boolean> =
        MethodStringName0<GraphFrame, Boolean>("is_autoshrink_enabled")

    @JvmField
    public val setAutoshrinkMarginName: MethodStringName1<GraphFrame, Unit, Int> =
        MethodStringName1<GraphFrame, Unit, Int>("set_autoshrink_margin")

    @JvmField
    public val getAutoshrinkMarginName: MethodStringName0<GraphFrame, Int> =
        MethodStringName0<GraphFrame, Int>("get_autoshrink_margin")

    @JvmField
    public val setDragMarginName: MethodStringName1<GraphFrame, Unit, Int> =
        MethodStringName1<GraphFrame, Unit, Int>("set_drag_margin")

    @JvmField
    public val getDragMarginName: MethodStringName0<GraphFrame, Int> =
        MethodStringName0<GraphFrame, Int>("get_drag_margin")

    @JvmField
    public val setTintColorEnabledName: MethodStringName1<GraphFrame, Unit, Boolean> =
        MethodStringName1<GraphFrame, Unit, Boolean>("set_tint_color_enabled")

    @JvmField
    public val isTintColorEnabledName: MethodStringName0<GraphFrame, Boolean> =
        MethodStringName0<GraphFrame, Boolean>("is_tint_color_enabled")

    @JvmField
    public val setTintColorName: MethodStringName1<GraphFrame, Unit, Color> =
        MethodStringName1<GraphFrame, Unit, Color>("set_tint_color")

    @JvmField
    public val getTintColorName: MethodStringName0<GraphFrame, Color> =
        MethodStringName0<GraphFrame, Color>("get_tint_color")
  }

  public object MethodBindings {
    internal val setTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_title", 83702148)

    internal val getTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "get_title", 201670096)

    internal val getTitlebarHboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "get_titlebar_hbox", 3590609951)

    internal val setAutoshrinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_autoshrink_enabled", 2586408642)

    internal val isAutoshrinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "is_autoshrink_enabled", 36873697)

    internal val setAutoshrinkMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_autoshrink_margin", 1286410249)

    internal val getAutoshrinkMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "get_autoshrink_margin", 3905245786)

    internal val setDragMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_drag_margin", 1286410249)

    internal val getDragMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "get_drag_margin", 3905245786)

    internal val setTintColorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_tint_color_enabled", 2586408642)

    internal val isTintColorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "is_tint_color_enabled", 36873697)

    internal val setTintColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "set_tint_color", 2920490490)

    internal val getTintColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GraphFrame", "get_tint_color", 3444240500)
  }
}
