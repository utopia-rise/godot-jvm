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
import godot.core.PackedStringArray
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This binding resource binds an [OpenXRAction] to an input or output. As most controllers have
 * left hand and right versions that are handled by the same interaction profile we can specify
 * multiple bindings. For instance an action "Fire" could be bound to both
 * "/user/hand/left/input/trigger" and "/user/hand/right/input/trigger". This would require two binding
 * entries.
 */
@GodotBaseType
public open class OpenXRIPBinding : Resource() {
  /**
   * [OpenXRAction] that is bound to [bindingPath].
   */
  public final inline var action: OpenXRAction?
    @JvmName("actionProperty")
    get() = getAction()
    @JvmName("actionProperty")
    set(`value`) {
      setAction(value)
    }

  /**
   * Binding path that defines the input or output bound to [action].
   *
   * **Note:** Binding paths are suggestions, an XR runtime may choose to bind the action to a
   * different input or output emulating this input or output.
   */
  public final inline var bindingPath: String
    @JvmName("bindingPathProperty")
    get() = getBindingPath()
    @JvmName("bindingPathProperty")
    set(`value`) {
      setBindingPath(value)
    }

  /**
   * Binding modifiers for this binding.
   */
  public final inline var bindingModifiers: VariantArray<Any?>
    @JvmName("bindingModifiersProperty")
    get() = getBindingModifiers()
    @JvmName("bindingModifiersProperty")
    set(`value`) {
      setBindingModifiers(value)
    }

  /**
   * Paths that define the inputs or outputs bound on the device.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var paths: PackedStringArray
    @JvmName("pathsProperty")
    get() = getPaths()
    @JvmName("pathsProperty")
    set(`value`) {
      setPaths(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(459, scriptPtr)
  }

  /**
   * This is a helper function for [paths] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxripbinding.paths
   * //Your changes
   * openxripbinding.paths = myCoreType
   * ``````
   *
   * Paths that define the inputs or outputs bound on the device.
   */
  @CoreTypeHelper
  public final fun pathsMutate(block: PackedStringArray.() -> Unit): PackedStringArray =
      paths.apply {
     block(this)
     paths = this
  }

  /**
   * This is a helper function for [paths] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Paths that define the inputs or outputs bound on the device.
   */
  @CoreTypeHelper
  public final fun pathsMutateEach(block: (index: Int, `value`: String) -> Unit): PackedStringArray
      = paths.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     paths = this
  }

  public final fun setAction(action: OpenXRAction?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to action)
    TransferContext.callMethod(MethodBindings.setActionPtr)
  }

  public final fun getAction(): OpenXRAction? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRAction?)
  }

  public final fun setBindingPath(bindingPath: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to bindingPath)
    TransferContext.callMethod(MethodBindings.setBindingPathPtr)
  }

  public final fun getBindingPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Get the number of binding modifiers for this binding.
   */
  public final fun getBindingModifierCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingModifierCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Get the [OpenXRBindingModifier] at this index.
   */
  public final fun getBindingModifier(index: Int): OpenXRActionBindingModifier? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getBindingModifierPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRActionBindingModifier?)
  }

  public final fun setBindingModifiers(bindingModifiers: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to bindingModifiers)
    TransferContext.callMethod(MethodBindings.setBindingModifiersPtr)
  }

  public final fun getBindingModifiers(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingModifiersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  public final fun setPaths(paths: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to paths)
    TransferContext.callMethod(MethodBindings.setPathsPtr)
  }

  public final fun getPaths(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Get the number of input/output paths in this binding.
   */
  public final fun getPathCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if this input/output path is part of this binding.
   */
  public final fun hasPath(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.hasPathPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Add an input/output path to this binding.
   */
  public final fun addPath(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.addPathPtr)
  }

  /**
   * Removes this input/output path from this binding.
   */
  public final fun removePath(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.removePathPtr)
  }

  public companion object {
    @JvmField
    public val setActionName: MethodStringName1<OpenXRIPBinding, Unit, OpenXRAction?> =
        MethodStringName1<OpenXRIPBinding, Unit, OpenXRAction?>("set_action")

    @JvmField
    public val getActionName: MethodStringName0<OpenXRIPBinding, OpenXRAction?> =
        MethodStringName0<OpenXRIPBinding, OpenXRAction?>("get_action")

    @JvmField
    public val setBindingPathName: MethodStringName1<OpenXRIPBinding, Unit, String> =
        MethodStringName1<OpenXRIPBinding, Unit, String>("set_binding_path")

    @JvmField
    public val getBindingPathName: MethodStringName0<OpenXRIPBinding, String> =
        MethodStringName0<OpenXRIPBinding, String>("get_binding_path")

    @JvmField
    public val getBindingModifierCountName: MethodStringName0<OpenXRIPBinding, Int> =
        MethodStringName0<OpenXRIPBinding, Int>("get_binding_modifier_count")

    @JvmField
    public val getBindingModifierName:
        MethodStringName1<OpenXRIPBinding, OpenXRActionBindingModifier?, Int> =
        MethodStringName1<OpenXRIPBinding, OpenXRActionBindingModifier?, Int>("get_binding_modifier")

    @JvmField
    public val setBindingModifiersName: MethodStringName1<OpenXRIPBinding, Unit, VariantArray<Any?>>
        = MethodStringName1<OpenXRIPBinding, Unit, VariantArray<Any?>>("set_binding_modifiers")

    @JvmField
    public val getBindingModifiersName: MethodStringName0<OpenXRIPBinding, VariantArray<Any?>> =
        MethodStringName0<OpenXRIPBinding, VariantArray<Any?>>("get_binding_modifiers")

    @JvmField
    public val setPathsName: MethodStringName1<OpenXRIPBinding, Unit, PackedStringArray> =
        MethodStringName1<OpenXRIPBinding, Unit, PackedStringArray>("set_paths")

    @JvmField
    public val getPathsName: MethodStringName0<OpenXRIPBinding, PackedStringArray> =
        MethodStringName0<OpenXRIPBinding, PackedStringArray>("get_paths")

    @JvmField
    public val getPathCountName: MethodStringName0<OpenXRIPBinding, Int> =
        MethodStringName0<OpenXRIPBinding, Int>("get_path_count")

    @JvmField
    public val hasPathName: MethodStringName1<OpenXRIPBinding, Boolean, String> =
        MethodStringName1<OpenXRIPBinding, Boolean, String>("has_path")

    @JvmField
    public val addPathName: MethodStringName1<OpenXRIPBinding, Unit, String> =
        MethodStringName1<OpenXRIPBinding, Unit, String>("add_path")

    @JvmField
    public val removePathName: MethodStringName1<OpenXRIPBinding, Unit, String> =
        MethodStringName1<OpenXRIPBinding, Unit, String>("remove_path")
  }

  public object MethodBindings {
    internal val setActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "set_action", 349361333)

    internal val getActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_action", 4072409085)

    internal val setBindingPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "set_binding_path", 83702148)

    internal val getBindingPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_binding_path", 201670096)

    internal val getBindingModifierCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_binding_modifier_count", 3905245786)

    internal val getBindingModifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_binding_modifier", 3538296211)

    internal val setBindingModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "set_binding_modifiers", 381264803)

    internal val getBindingModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_binding_modifiers", 3995934104)

    internal val setPathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "set_paths", 4015028928)

    internal val getPathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_paths", 1139954409)

    internal val getPathCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "get_path_count", 3905245786)

    internal val hasPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "has_path", 3927539163)

    internal val addPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "add_path", 83702148)

    internal val removePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRIPBinding", "remove_path", 83702148)
  }
}
