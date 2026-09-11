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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Turning on the option **Load As Placeholder** for an instantiated scene in the editor causes it
 * to be replaced by an [InstancePlaceholder] when running the game, this will not replace the node in
 * the editor. This makes it possible to delay actually loading the scene until calling
 * [createInstance]. This is useful to avoid loading large scenes all at once by loading parts of it
 * selectively.
 *
 * **Note:** Like [Node], [InstancePlaceholder] does not have a transform. This causes any child
 * nodes to be positioned relatively to the [Viewport] origin, rather than their parent as displayed in
 * the editor. Replacing the placeholder with a scene with a transform will transform children
 * relatively to their parent again.
 */
@GodotBaseType
public open class InstancePlaceholder internal constructor() : Node() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(328, scriptPtr)
  }

  /**
   * Returns the list of properties that will be applied to the node when [createInstance] is
   * called.
   *
   * If [withOrder] is `true`, a key named `.order` (note the leading period) is added to the
   * dictionary. This `.order` key is an [VariantArray] of [String] property names specifying the order
   * in which properties will be applied (with index 0 being the first).
   */
  @JvmOverloads
  public final fun getStoredValues(withOrder: Boolean = false): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to withOrder)
    TransferContext.callMethod(MethodBindings.getStoredValuesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Call this method to actually load in the node. The created node will be placed as a sibling
   * *above* the [InstancePlaceholder] in the scene tree. The [Node]'s reference is also returned for
   * convenience.
   *
   * **Note:** [createInstance] is not thread-safe. Use [Object.callDeferred] if calling from a
   * thread.
   */
  @JvmOverloads
  public final fun createInstance(replace: Boolean = false, customScene: PackedScene? = null):
      Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to replace, OBJECT to customScene)
    TransferContext.callMethod(MethodBindings.createInstancePtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Gets the path to the [PackedScene] resource file that is loaded by default when calling
   * [createInstance]. Not thread-safe. Use [Object.callDeferred] if calling from a thread.
   */
  public final fun getInstancePath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstancePathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public companion object {
    @JvmField
    public val getStoredValuesName:
        MethodStringName1<InstancePlaceholder, Dictionary<Any?, Any?>, Boolean> =
        MethodStringName1<InstancePlaceholder, Dictionary<Any?, Any?>, Boolean>("get_stored_values")

    @JvmField
    public val createInstanceName:
        MethodStringName2<InstancePlaceholder, Node?, Boolean, PackedScene?> =
        MethodStringName2<InstancePlaceholder, Node?, Boolean, PackedScene?>("create_instance")

    @JvmField
    public val getInstancePathName: MethodStringName0<InstancePlaceholder, String> =
        MethodStringName0<InstancePlaceholder, String>("get_instance_path")
  }

  public object MethodBindings {
    internal val getStoredValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InstancePlaceholder", "get_stored_values", 2230153369)

    internal val createInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InstancePlaceholder", "create_instance", 3794612210)

    internal val getInstancePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InstancePlaceholder", "get_instance_path", 201670096)
  }
}
