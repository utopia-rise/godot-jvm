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
import godot.core.MethodStringName1
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object stores suggested bindings for an interaction profile. Interaction profiles define the
 * metadata for a tracked XR device such as an XR controller.
 *
 * For more information see the
 * [url=https://www.khronos.org/registry/OpenXR/specs/1.0/html/xrspec.html#semantic-path-interaction-profiles]interaction
 * profiles info in the OpenXR specification[/url].
 */
@GodotBaseType
public open class OpenXRInteractionProfile : Resource() {
  /**
   * The interaction profile path identifying the XR device.
   */
  public final inline var interactionProfilePath: String
    @JvmName("interactionProfilePathProperty")
    get() = getInteractionProfilePath()
    @JvmName("interactionProfilePathProperty")
    set(`value`) {
      setInteractionProfilePath(value)
    }

  /**
   * Action bindings for this interaction profile.
   */
  public final inline var bindings: VariantArray<Any?>
    @JvmName("bindingsProperty")
    get() = getBindings()
    @JvmName("bindingsProperty")
    set(`value`) {
      setBindings(value)
    }

  /**
   * Binding modifiers for this interaction profile.
   */
  public final inline var bindingModifiers: VariantArray<Any?>
    @JvmName("bindingModifiersProperty")
    get() = getBindingModifiers()
    @JvmName("bindingModifiersProperty")
    set(`value`) {
      setBindingModifiers(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(460, scriptPtr)
  }

  public final fun setInteractionProfilePath(interactionProfilePath: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, interactionProfilePath)
    TransferContext.callMethod(MethodBindings.setInteractionProfilePathPtr)
  }

  public final fun getInteractionProfilePath(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInteractionProfilePathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Get the number of bindings in this interaction profile.
   */
  public final fun getBindingCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Retrieve the binding at this index.
   */
  public final fun getBinding(index: Int): OpenXRIPBinding? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getBindingPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRIPBinding?)
  }

  public final fun setBindings(bindings: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, bindings)
    TransferContext.callMethod(MethodBindings.setBindingsPtr)
  }

  public final fun getBindings(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Get the number of binding modifiers in this interaction profile.
   */
  public final fun getBindingModifierCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingModifierCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Get the [OpenXRBindingModifier] at this index.
   */
  public final fun getBindingModifier(index: Int): OpenXRIPBindingModifier? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getBindingModifierPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRIPBindingModifier?)
  }

  public final fun setBindingModifiers(bindingModifiers: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, bindingModifiers)
    TransferContext.callMethod(MethodBindings.setBindingModifiersPtr)
  }

  public final fun getBindingModifiers(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingModifiersPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  public companion object {
    @JvmField
    public val setInteractionProfilePathName:
        MethodStringName1<OpenXRInteractionProfile, Unit, String> =
        MethodStringName1<OpenXRInteractionProfile, Unit, String>("set_interaction_profile_path")

    @JvmField
    public val getInteractionProfilePathName: MethodStringName0<OpenXRInteractionProfile, String> =
        MethodStringName0<OpenXRInteractionProfile, String>("get_interaction_profile_path")

    @JvmField
    public val getBindingCountName: MethodStringName0<OpenXRInteractionProfile, Int> =
        MethodStringName0<OpenXRInteractionProfile, Int>("get_binding_count")

    @JvmField
    public val getBindingName: MethodStringName1<OpenXRInteractionProfile, OpenXRIPBinding?, Int> =
        MethodStringName1<OpenXRInteractionProfile, OpenXRIPBinding?, Int>("get_binding")

    @JvmField
    public val setBindingsName:
        MethodStringName1<OpenXRInteractionProfile, Unit, VariantArray<Any?>> =
        MethodStringName1<OpenXRInteractionProfile, Unit, VariantArray<Any?>>("set_bindings")

    @JvmField
    public val getBindingsName: MethodStringName0<OpenXRInteractionProfile, VariantArray<Any?>> =
        MethodStringName0<OpenXRInteractionProfile, VariantArray<Any?>>("get_bindings")

    @JvmField
    public val getBindingModifierCountName: MethodStringName0<OpenXRInteractionProfile, Int> =
        MethodStringName0<OpenXRInteractionProfile, Int>("get_binding_modifier_count")

    @JvmField
    public val getBindingModifierName:
        MethodStringName1<OpenXRInteractionProfile, OpenXRIPBindingModifier?, Int> =
        MethodStringName1<OpenXRInteractionProfile, OpenXRIPBindingModifier?, Int>("get_binding_modifier")

    @JvmField
    public val setBindingModifiersName:
        MethodStringName1<OpenXRInteractionProfile, Unit, VariantArray<Any?>> =
        MethodStringName1<OpenXRInteractionProfile, Unit, VariantArray<Any?>>("set_binding_modifiers")

    @JvmField
    public val getBindingModifiersName:
        MethodStringName0<OpenXRInteractionProfile, VariantArray<Any?>> =
        MethodStringName0<OpenXRInteractionProfile, VariantArray<Any?>>("get_binding_modifiers")
  }

  public object MethodBindings {
    internal val setInteractionProfilePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "set_interaction_profile_path", 83702148)

    internal val getInteractionProfilePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_interaction_profile_path", 201670096)

    internal val getBindingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_binding_count", 3905245786)

    internal val getBindingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_binding", 3934429652)

    internal val setBindingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "set_bindings", 381264803)

    internal val getBindingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_bindings", 3995934104)

    internal val getBindingModifierCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_binding_modifier_count", 3905245786)

    internal val getBindingModifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_binding_modifier", 2419896583)

    internal val setBindingModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "set_binding_modifiers", 381264803)

    internal val getBindingModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfile", "get_binding_modifiers", 3995934104)
  }
}
