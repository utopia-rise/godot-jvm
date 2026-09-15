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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A control used for visual representation of a percentage. Shows the fill percentage in the
 * center. Can also be used to show indeterminate progress. For more fill modes, use
 * [TextureProgressBar] instead.
 */
@GodotBaseType
public open class ProgressBar : Range() {
  /**
   * The fill direction. See [FillMode] for possible values.
   */
  public final inline var fillMode: Int
    @JvmName("fillModeProperty")
    get() = getFillMode()
    @JvmName("fillModeProperty")
    set(`value`) {
      setFillMode(value)
    }

  /**
   * If `true`, the fill percentage is displayed on the bar.
   */
  public final inline var showPercentage: Boolean
    @JvmName("showPercentageProperty")
    get() = isPercentageShown()
    @JvmName("showPercentageProperty")
    set(`value`) {
      setShowPercentage(value)
    }

  /**
   * When set to `true`, the progress bar indicates that something is happening with an animation,
   * but does not show the fill percentage or value.
   */
  public final inline var indeterminate: Boolean
    @JvmName("indeterminateProperty")
    get() = isIndeterminate()
    @JvmName("indeterminateProperty")
    set(`value`) {
      setIndeterminate(value)
    }

  /**
   * If `false`, the [indeterminate] animation will be paused in the editor.
   */
  public final inline var editorPreviewIndeterminate: Boolean
    @JvmName("editorPreviewIndeterminateProperty")
    get() = isEditorPreviewIndeterminateEnabled()
    @JvmName("editorPreviewIndeterminateProperty")
    set(`value`) {
      setEditorPreviewIndeterminate(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(572, scriptPtr)
  }

  public final fun setFillMode(mode: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.toLong())
    TransferContext.callMethod(MethodBindings.setFillModePtr)
  }

  public final fun getFillMode(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillModePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setShowPercentage(visible: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, visible)
    TransferContext.callMethod(MethodBindings.setShowPercentagePtr)
  }

  public final fun isPercentageShown(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPercentageShownPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setIndeterminate(indeterminate: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, indeterminate)
    TransferContext.callMethod(MethodBindings.setIndeterminatePtr)
  }

  public final fun isIndeterminate(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIndeterminatePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEditorPreviewIndeterminate(previewIndeterminate: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, previewIndeterminate)
    TransferContext.callMethod(MethodBindings.setEditorPreviewIndeterminatePtr)
  }

  public final fun isEditorPreviewIndeterminateEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditorPreviewIndeterminateEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class FillMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The progress bar fills from begin to end horizontally, according to the language direction.
     * If [Control.isLayoutRtl] returns `false`, it fills from left to right, and if it returns `true`,
     * it fills from right to left.
     */
    BEGIN_TO_END(0),
    /**
     * The progress bar fills from end to begin horizontally, according to the language direction.
     * If [Control.isLayoutRtl] returns `false`, it fills from right to left, and if it returns `true`,
     * it fills from left to right.
     */
    END_TO_BEGIN(1),
    /**
     * The progress fills from top to bottom.
     */
    TOP_TO_BOTTOM(2),
    /**
     * The progress fills from bottom to top.
     */
    BOTTOM_TO_TOP(3),
    ;

    public companion object {
      public fun from(`value`: Long): FillMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFillModeName: MethodStringName1<ProgressBar, Unit, Int> =
        MethodStringName1<ProgressBar, Unit, Int>("set_fill_mode")

    @JvmField
    public val getFillModeName: MethodStringName0<ProgressBar, Int> =
        MethodStringName0<ProgressBar, Int>("get_fill_mode")

    @JvmField
    public val setShowPercentageName: MethodStringName1<ProgressBar, Unit, Boolean> =
        MethodStringName1<ProgressBar, Unit, Boolean>("set_show_percentage")

    @JvmField
    public val isPercentageShownName: MethodStringName0<ProgressBar, Boolean> =
        MethodStringName0<ProgressBar, Boolean>("is_percentage_shown")

    @JvmField
    public val setIndeterminateName: MethodStringName1<ProgressBar, Unit, Boolean> =
        MethodStringName1<ProgressBar, Unit, Boolean>("set_indeterminate")

    @JvmField
    public val isIndeterminateName: MethodStringName0<ProgressBar, Boolean> =
        MethodStringName0<ProgressBar, Boolean>("is_indeterminate")

    @JvmField
    public val setEditorPreviewIndeterminateName: MethodStringName1<ProgressBar, Unit, Boolean> =
        MethodStringName1<ProgressBar, Unit, Boolean>("set_editor_preview_indeterminate")

    @JvmField
    public val isEditorPreviewIndeterminateEnabledName: MethodStringName0<ProgressBar, Boolean> =
        MethodStringName0<ProgressBar, Boolean>("is_editor_preview_indeterminate_enabled")
  }

  public object MethodBindings {
    internal val setFillModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "set_fill_mode", 1286410249)

    internal val getFillModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "get_fill_mode", 2455072627)

    internal val setShowPercentagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "set_show_percentage", 2586408642)

    internal val isPercentageShownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "is_percentage_shown", 36873697)

    internal val setIndeterminatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "set_indeterminate", 2586408642)

    internal val isIndeterminatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "is_indeterminate", 36873697)

    internal val setEditorPreviewIndeterminatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "set_editor_preview_indeterminate", 2586408642)

    internal val isEditorPreviewIndeterminateEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProgressBar", "is_editor_preview_indeterminate_enabled", 36873697)
  }
}
