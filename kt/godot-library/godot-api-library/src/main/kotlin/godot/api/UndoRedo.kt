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
import godot.core.Callable
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.Signal0
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_CALLABLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_STRING_NAME_ANY
import godot.writeMethodArguments_STRING_LONG_BOOL
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * UndoRedo works by registering methods and property changes inside "actions". You can create an
 * action, then provide ways to do and undo this action using function calls and property changes, then
 * commit the action.
 *
 * When an action is committed, all of the `do_*` methods will run. If the [undo] method is used,
 * the `undo_*` methods will run. If the [redo] method is used, once again, all of the `do_*` methods
 * will run.
 *
 * Here's an example on how to add an action:
 *
 * ```gdscript
 * //gdscript
 * var undo_redo = UndoRedo.new()
 *
 * func do_something():
 * 	pass # Put your code here.
 *
 * func undo_something():
 * 	pass # Put here the code that reverts what's done by "do_something()".
 *
 * func _on_my_button_pressed():
 * 	var node = get_node("MyNode2D")
 * 	undo_redo.create_action("Move the node")
 * 	undo_redo.add_do_method(do_something)
 * 	undo_redo.add_undo_method(undo_something)
 * 	undo_redo.add_do_property(node, "position", Vector2(100, 100))
 * 	undo_redo.add_undo_property(node, "position", node.position)
 * 	undo_redo.commit_action()
 * ```
 *
 * ```csharp
 * //csharp
 * private UndoRedo _undoRedo;
 *
 * public override void _Ready()
 * {
 * 	_undoRedo = new UndoRedo();
 * }
 *
 * public void DoSomething()
 * {
 * 	// Put your code here.
 * }
 *
 * public void UndoSomething()
 * {
 * 	// Put here the code that reverts what's done by "DoSomething()".
 * }
 *
 * private void OnMyButtonPressed()
 * {
 * 	var node = GetNode<Node2D>("MyNode2D");
 * 	_undoRedo.CreateAction("Move the node");
 * 	_undoRedo.AddDoMethod(new Callable(this, MethodName.DoSomething));
 * 	_undoRedo.AddUndoMethod(new Callable(this, MethodName.UndoSomething));
 * 	_undoRedo.AddDoProperty(node, "position", new Vector2(100, 100));
 * 	_undoRedo.AddUndoProperty(node, "position", node.Position);
 * 	_undoRedo.CommitAction();
 * }
 * ```
 *
 * Before calling any of the `add_(un)do_*` methods, you need to first call [createAction].
 * Afterwards you need to call [commitAction].
 *
 * If you don't need to register a method, you can leave [addDoMethod] and [addUndoMethod] out; the
 * same goes for properties. You can also register more than one method/property.
 *
 * If you are making an [EditorPlugin] and want to integrate into the editor's undo history, use
 * [EditorUndoRedoManager] instead.
 *
 * If you are registering multiple properties/method which depend on one another, be aware that by
 * default undo operation are called in the same order they have been added. Therefore instead of
 * grouping do operation with their undo operations it is better to group do on one side and undo on
 * the other as shown below.
 *
 * ```gdscript
 * //gdscript
 * undo_redo.create_action("Add object")
 *
 * # DO
 * undo_redo.add_do_method(_create_object)
 * undo_redo.add_do_method(_add_object_to_singleton)
 *
 * # UNDO
 * undo_redo.add_undo_method(_remove_object_from_singleton)
 * undo_redo.add_undo_method(_destroy_that_object)
 *
 * undo_redo.commit_action()
 * ```
 *
 * ```csharp
 * //csharp
 * _undo_redo.CreateAction("Add object");
 *
 * // DO
 * _undo_redo.AddDoMethod(new Callable(this, MethodName.CreateObject));
 * _undo_redo.AddDoMethod(new Callable(this, MethodName.AddObjectToSingleton));
 *
 * // UNDO
 * _undo_redo.AddUndoMethod(new Callable(this, MethodName.RemoveObjectFromSingleton));
 * _undo_redo.AddUndoMethod(new Callable(this, MethodName.DestroyThatObject));
 *
 * _undo_redo.CommitAction();
 * ```
 */
@GodotBaseType
public open class UndoRedo : Object() {
  /**
   * Called when [undo] or [redo] was called.
   */
  public val versionChanged: Signal0 by Signal0

  /**
   * The maximum number of steps that can be stored in the undo/redo history. If the number of
   * stored steps exceeds this limit, older steps are removed from history and can no longer be reached
   * by calling [undo]. A value of `0` or lower means no limit.
   */
  public final inline var maxSteps: Int
    @JvmName("maxStepsProperty")
    get() = getMaxSteps()
    @JvmName("maxStepsProperty")
    set(`value`) {
      setMaxSteps(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(782, scriptPtr)
  }

  /**
   * Create a new action. After this is called, do all your calls to [addDoMethod], [addUndoMethod],
   * [addDoProperty], and [addUndoProperty], then commit the action with [commitAction].
   *
   * The way actions are merged is dictated by [mergeMode].
   *
   * The way undo operation are ordered in actions is dictated by [backwardUndoOps]. When
   * [backwardUndoOps] is `false` undo option are ordered in the same order they were added. Which
   * means the first operation to be added will be the first to be undone.
   */
  @JvmOverloads
  public final fun createAction(
    name: String,
    mergeMode: MergeMode = UndoRedo.MergeMode.DISABLE,
    backwardUndoOps: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_LONG_BOOL(ptr, objectID.id, name, mergeMode.value, backwardUndoOps)
    TransferContext.callMethod(MethodBindings.createActionPtr)
  }

  /**
   * Commit the action. If [execute] is `true` (which it is by default), all "do" methods/properties
   * are called/set when this function is called.
   */
  @JvmOverloads
  public final fun commitAction(execute: Boolean = true): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, execute)
    TransferContext.callPtrMethod(MethodBindings.commitActionPtr, 0)
  }

  /**
   * Returns `true` if the [UndoRedo] is currently committing the action, i.e. running its "do"
   * method or property change (see [commitAction]).
   */
  public final fun isCommittingAction(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCommittingActionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Register a [Callable] that will be called when the action is committed.
   */
  public final fun addDoMethod(callable: Callable): Unit {
    TransferContext.writeMethodArguments_CALLABLE(ptr, objectID.id, callable)
    TransferContext.callMethod(MethodBindings.addDoMethodPtr)
  }

  /**
   * Register a [Callable] that will be called when the action is undone.
   */
  public final fun addUndoMethod(callable: Callable): Unit {
    TransferContext.writeMethodArguments_CALLABLE(ptr, objectID.id, callable)
    TransferContext.callMethod(MethodBindings.addUndoMethodPtr)
  }

  /**
   * Register a [property] that would change its value to [value] when the action is committed.
   */
  public final fun addDoProperty(
    `object`: Object?,
    `property`: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME_ANY(ptr, objectID.id, `object`, property, value)
    TransferContext.callMethod(MethodBindings.addDoPropertyPtr)
  }

  /**
   * Register a [property] that would change its value to [value] when the action is undone.
   */
  public final fun addUndoProperty(
    `object`: Object?,
    `property`: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME_ANY(ptr, objectID.id, `object`, property, value)
    TransferContext.callMethod(MethodBindings.addUndoPropertyPtr)
  }

  /**
   * Register a reference to an object that will be erased if the "do" history is deleted. This is
   * useful for objects added by the "do" action and removed by the "undo" action.
   *
   * When the "do" history is deleted, if the object is a [RefCounted], it will be unreferenced.
   * Otherwise, it will be freed. Do not use for resources.
   *
   * ```
   * var node = Node2D.new()
   * undo_redo.create_action("Add node")
   * undo_redo.add_do_method(add_child.bind(node))
   * undo_redo.add_do_reference(node)
   * undo_redo.add_undo_method(remove_child.bind(node))
   * undo_redo.commit_action()
   * ```
   */
  public final fun addDoReference(`object`: Object?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, `object`)
    TransferContext.callPtrMethod(MethodBindings.addDoReferencePtr, 0)
  }

  /**
   * Register a reference to an object that will be erased if the "undo" history is deleted. This is
   * useful for objects added by the "undo" action and removed by the "do" action.
   *
   * When the "undo" history is deleted, if the object is a [RefCounted], it will be unreferenced.
   * Otherwise, it will be freed. Do not use for resources.
   *
   * ```
   * var node = $Node2D
   * undo_redo.create_action("Remove node")
   * undo_redo.add_do_method(remove_child.bind(node))
   * undo_redo.add_undo_method(add_child.bind(node))
   * undo_redo.add_undo_reference(node)
   * undo_redo.commit_action()
   * ```
   */
  public final fun addUndoReference(`object`: Object?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, `object`)
    TransferContext.callPtrMethod(MethodBindings.addUndoReferencePtr, 0)
  }

  /**
   * Marks the next "do" and "undo" operations to be processed even if the action gets merged with
   * another in the [MERGE_ENDS] mode. Return to normal operation using [endForceKeepInMergeEnds].
   */
  public final fun startForceKeepInMergeEnds(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.startForceKeepInMergeEndsPtr, 0)
  }

  /**
   * Stops marking operations as to be processed even if the action gets merged with another in the
   * [MERGE_ENDS] mode. See [startForceKeepInMergeEnds].
   */
  public final fun endForceKeepInMergeEnds(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.endForceKeepInMergeEndsPtr, 0)
  }

  /**
   * Returns how many elements are in the history.
   */
  public final fun getHistoryCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHistoryCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Gets the index of the current action.
   */
  public final fun getCurrentAction(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCurrentActionPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Gets the action name from its index.
   */
  public final fun getActionName(id: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callMethod(MethodBindings.getActionNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Clear the undo/redo history and associated references.
   *
   * Passing `false` to [increaseVersion] will prevent the version number from increasing when the
   * history is cleared.
   */
  @JvmOverloads
  public final fun clearHistory(increaseVersion: Boolean = true): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, increaseVersion)
    TransferContext.callPtrMethod(MethodBindings.clearHistoryPtr, 0)
  }

  /**
   * Gets the name of the current action, equivalent to `get_action_name(get_current_action())`.
   */
  public final fun getCurrentActionName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentActionNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if an "undo" action is available.
   */
  public final fun hasUndo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasUndoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a "redo" action is available.
   */
  public final fun hasRedo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasRedoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Gets the version. Every time a new action is committed, the [UndoRedo]'s version number is
   * increased automatically.
   *
   * This is useful mostly to check if something changed from a saved version.
   */
  public final fun getVersion(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVersionPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setMaxSteps(maxSteps: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxSteps.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxStepsPtr, 0)
  }

  public final fun getMaxSteps(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxStepsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Redo the last action. Returns `false` if there was no action to redo.
   */
  public final fun redo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.redoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Undo the last action. Returns `false` if there was no action to undo.
   */
  public final fun undo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.undoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Register a [property] that would change its value to [value] when the action is committed.
   */
  public final fun addDoProperty(
    `object`: Object?,
    `property`: String,
    `value`: Any?,
  ) = addDoProperty(`object`, property.asCachedStringName(), value)

  /**
   * Register a [property] that would change its value to [value] when the action is undone.
   */
  public final fun addUndoProperty(
    `object`: Object?,
    `property`: String,
    `value`: Any?,
  ) = addUndoProperty(`object`, property.asCachedStringName(), value)

  public enum class MergeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Makes "do"/"undo" operations stay in separate actions.
     */
    DISABLE(0),
    /**
     * Merges this action with the previous one if they have the same name. Keeps only the first
     * action's "undo" operations and the last action's "do" operations. Useful for sequential changes
     * to a single value.
     */
    ENDS(1),
    /**
     * Merges this action with the previous one if they have the same name.
     */
    ALL(2),
    ;

    public companion object {
      public fun from(`value`: Long): MergeMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val createActionName: MethodStringName3<UndoRedo, Unit, String, MergeMode, Boolean> =
        MethodStringName3<UndoRedo, Unit, String, MergeMode, Boolean>("create_action")

    @JvmField
    public val commitActionName: MethodStringName1<UndoRedo, Unit, Boolean> =
        MethodStringName1<UndoRedo, Unit, Boolean>("commit_action")

    @JvmField
    public val isCommittingActionName: MethodStringName0<UndoRedo, Boolean> =
        MethodStringName0<UndoRedo, Boolean>("is_committing_action")

    @JvmField
    public val addDoMethodName: MethodStringName1<UndoRedo, Unit, Callable> =
        MethodStringName1<UndoRedo, Unit, Callable>("add_do_method")

    @JvmField
    public val addUndoMethodName: MethodStringName1<UndoRedo, Unit, Callable> =
        MethodStringName1<UndoRedo, Unit, Callable>("add_undo_method")

    @JvmField
    public val addDoPropertyName: MethodStringName3<UndoRedo, Unit, Object?, StringName, Any?> =
        MethodStringName3<UndoRedo, Unit, Object?, StringName, Any?>("add_do_property")

    @JvmField
    public val addUndoPropertyName: MethodStringName3<UndoRedo, Unit, Object?, StringName, Any?> =
        MethodStringName3<UndoRedo, Unit, Object?, StringName, Any?>("add_undo_property")

    @JvmField
    public val addDoReferenceName: MethodStringName1<UndoRedo, Unit, Object?> =
        MethodStringName1<UndoRedo, Unit, Object?>("add_do_reference")

    @JvmField
    public val addUndoReferenceName: MethodStringName1<UndoRedo, Unit, Object?> =
        MethodStringName1<UndoRedo, Unit, Object?>("add_undo_reference")

    @JvmField
    public val startForceKeepInMergeEndsName: MethodStringName0<UndoRedo, Unit> =
        MethodStringName0<UndoRedo, Unit>("start_force_keep_in_merge_ends")

    @JvmField
    public val endForceKeepInMergeEndsName: MethodStringName0<UndoRedo, Unit> =
        MethodStringName0<UndoRedo, Unit>("end_force_keep_in_merge_ends")

    @JvmField
    public val getHistoryCountName: MethodStringName0<UndoRedo, Int> =
        MethodStringName0<UndoRedo, Int>("get_history_count")

    @JvmField
    public val getCurrentActionName: MethodStringName0<UndoRedo, Int> =
        MethodStringName0<UndoRedo, Int>("get_current_action")

    @JvmField
    public val getActionNameName: MethodStringName1<UndoRedo, String, Int> =
        MethodStringName1<UndoRedo, String, Int>("get_action_name")

    @JvmField
    public val clearHistoryName: MethodStringName1<UndoRedo, Unit, Boolean> =
        MethodStringName1<UndoRedo, Unit, Boolean>("clear_history")

    @JvmField
    public val getCurrentActionNameName: MethodStringName0<UndoRedo, String> =
        MethodStringName0<UndoRedo, String>("get_current_action_name")

    @JvmField
    public val hasUndoName: MethodStringName0<UndoRedo, Boolean> =
        MethodStringName0<UndoRedo, Boolean>("has_undo")

    @JvmField
    public val hasRedoName: MethodStringName0<UndoRedo, Boolean> =
        MethodStringName0<UndoRedo, Boolean>("has_redo")

    @JvmField
    public val getVersionName: MethodStringName0<UndoRedo, Long> =
        MethodStringName0<UndoRedo, Long>("get_version")

    @JvmField
    public val setMaxStepsName: MethodStringName1<UndoRedo, Unit, Int> =
        MethodStringName1<UndoRedo, Unit, Int>("set_max_steps")

    @JvmField
    public val getMaxStepsName: MethodStringName0<UndoRedo, Int> =
        MethodStringName0<UndoRedo, Int>("get_max_steps")

    @JvmField
    public val redoName: MethodStringName0<UndoRedo, Boolean> =
        MethodStringName0<UndoRedo, Boolean>("redo")

    @JvmField
    public val undoName: MethodStringName0<UndoRedo, Boolean> =
        MethodStringName0<UndoRedo, Boolean>("undo")
  }

  public object MethodBindings {
    internal val createActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "create_action", 3171901514)

    internal val commitActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "commit_action", 3216645846)

    internal val isCommittingActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "is_committing_action", 36873697)

    internal val addDoMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_do_method", 1611583062)

    internal val addUndoMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_undo_method", 1611583062)

    internal val addDoPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_do_property", 1017172818)

    internal val addUndoPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_undo_property", 1017172818)

    internal val addDoReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_do_reference", 3975164845)

    internal val addUndoReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "add_undo_reference", 3975164845)

    internal val startForceKeepInMergeEndsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "start_force_keep_in_merge_ends", 3218959716)

    internal val endForceKeepInMergeEndsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "end_force_keep_in_merge_ends", 3218959716)

    internal val getHistoryCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_history_count", 2455072627)

    internal val getCurrentActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_current_action", 2455072627)

    internal val getActionNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_action_name", 990163283)

    internal val clearHistoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "clear_history", 3216645846)

    internal val getCurrentActionNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_current_action_name", 201670096)

    internal val hasUndoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "has_undo", 36873697)

    internal val hasRedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "has_redo", 36873697)

    internal val getVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_version", 3905245786)

    internal val setMaxStepsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "set_max_steps", 1286410249)

    internal val getMaxStepsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UndoRedo", "get_max_steps", 3905245786)

    internal val redoPtr: VoidPtr = TypeManager.getMethodBindPtr("UndoRedo", "redo", 2240911060)

    internal val undoPtr: VoidPtr = TypeManager.getMethodBindPtr("UndoRedo", "undo", 2240911060)
  }
}
