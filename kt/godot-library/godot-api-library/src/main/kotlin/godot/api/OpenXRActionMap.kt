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
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * OpenXR uses an action system similar to Godots Input map system to bind inputs and outputs on
 * various types of XR controllers to named actions. OpenXR specifies more detail on these inputs and
 * outputs than Godot supports.
 *
 * Another important distinction is that OpenXR offers no control over these bindings. The bindings
 * we register are suggestions, it is up to the XR runtime to offer users the ability to change these
 * bindings. This allows the XR runtime to fill in the gaps if new hardware becomes available.
 *
 * The action map therefore needs to be loaded at startup and can't be changed afterwards. This
 * resource is a container for the entire action map.
 */
@GodotBaseType
public open class OpenXRActionMap : Resource() {
  /**
   * Collection of [OpenXRActionSet]s that are part of this action map.
   */
  public final inline var actionSets: VariantArray<Any?>
    @JvmName("actionSetsProperty")
    get() = getActionSets()
    @JvmName("actionSetsProperty")
    set(`value`) {
      setActionSets(value)
    }

  /**
   * Collection of [OpenXRInteractionProfile]s that are part of this action map.
   */
  public final inline var interactionProfiles: VariantArray<Any?>
    @JvmName("interactionProfilesProperty")
    get() = getInteractionProfiles()
    @JvmName("interactionProfilesProperty")
    set(`value`) {
      setInteractionProfiles(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(439, scriptPtr)
  }

  public final fun setActionSets(actionSets: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to actionSets)
    TransferContext.callMethod(MethodBindings.setActionSetsPtr)
  }

  public final fun getActionSets(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionSetsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Retrieve the number of actions sets in our action map.
   */
  public final fun getActionSetCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionSetCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Retrieve an action set by name.
   */
  public final fun findActionSet(name: String): OpenXRActionSet? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.findActionSetPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRActionSet?)
  }

  /**
   * Retrieve the action set at this index.
   */
  public final fun getActionSet(idx: Int): OpenXRActionSet? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getActionSetPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRActionSet?)
  }

  /**
   * Add an action set.
   */
  public final fun addActionSet(actionSet: OpenXRActionSet?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to actionSet)
    TransferContext.callMethod(MethodBindings.addActionSetPtr)
  }

  /**
   * Remove an action set.
   */
  public final fun removeActionSet(actionSet: OpenXRActionSet?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to actionSet)
    TransferContext.callMethod(MethodBindings.removeActionSetPtr)
  }

  public final fun setInteractionProfiles(interactionProfiles: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to interactionProfiles)
    TransferContext.callMethod(MethodBindings.setInteractionProfilesPtr)
  }

  public final fun getInteractionProfiles(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInteractionProfilesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Retrieve the number of interaction profiles in our action map.
   */
  public final fun getInteractionProfileCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInteractionProfileCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Find an interaction profile by its name (path).
   */
  public final fun findInteractionProfile(name: String): OpenXRInteractionProfile? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.findInteractionProfilePtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRInteractionProfile?)
  }

  /**
   * Get the interaction profile at this index.
   */
  public final fun getInteractionProfile(idx: Int): OpenXRInteractionProfile? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getInteractionProfilePtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRInteractionProfile?)
  }

  /**
   * Add an interaction profile.
   */
  public final fun addInteractionProfile(interactionProfile: OpenXRInteractionProfile?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to interactionProfile)
    TransferContext.callMethod(MethodBindings.addInteractionProfilePtr)
  }

  /**
   * Remove an interaction profile.
   */
  public final fun removeInteractionProfile(interactionProfile: OpenXRInteractionProfile?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to interactionProfile)
    TransferContext.callMethod(MethodBindings.removeInteractionProfilePtr)
  }

  /**
   * Setup this action set with our default actions.
   */
  public final fun createDefaultActionSets(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createDefaultActionSetsPtr)
  }

  public companion object {
    @JvmField
    public val setActionSetsName: MethodStringName1<OpenXRActionMap, Unit, VariantArray<Any?>> =
        MethodStringName1<OpenXRActionMap, Unit, VariantArray<Any?>>("set_action_sets")

    @JvmField
    public val getActionSetsName: MethodStringName0<OpenXRActionMap, VariantArray<Any?>> =
        MethodStringName0<OpenXRActionMap, VariantArray<Any?>>("get_action_sets")

    @JvmField
    public val getActionSetCountName: MethodStringName0<OpenXRActionMap, Int> =
        MethodStringName0<OpenXRActionMap, Int>("get_action_set_count")

    @JvmField
    public val findActionSetName: MethodStringName1<OpenXRActionMap, OpenXRActionSet?, String> =
        MethodStringName1<OpenXRActionMap, OpenXRActionSet?, String>("find_action_set")

    @JvmField
    public val getActionSetName: MethodStringName1<OpenXRActionMap, OpenXRActionSet?, Int> =
        MethodStringName1<OpenXRActionMap, OpenXRActionSet?, Int>("get_action_set")

    @JvmField
    public val addActionSetName: MethodStringName1<OpenXRActionMap, Unit, OpenXRActionSet?> =
        MethodStringName1<OpenXRActionMap, Unit, OpenXRActionSet?>("add_action_set")

    @JvmField
    public val removeActionSetName: MethodStringName1<OpenXRActionMap, Unit, OpenXRActionSet?> =
        MethodStringName1<OpenXRActionMap, Unit, OpenXRActionSet?>("remove_action_set")

    @JvmField
    public val setInteractionProfilesName:
        MethodStringName1<OpenXRActionMap, Unit, VariantArray<Any?>> =
        MethodStringName1<OpenXRActionMap, Unit, VariantArray<Any?>>("set_interaction_profiles")

    @JvmField
    public val getInteractionProfilesName: MethodStringName0<OpenXRActionMap, VariantArray<Any?>> =
        MethodStringName0<OpenXRActionMap, VariantArray<Any?>>("get_interaction_profiles")

    @JvmField
    public val getInteractionProfileCountName: MethodStringName0<OpenXRActionMap, Int> =
        MethodStringName0<OpenXRActionMap, Int>("get_interaction_profile_count")

    @JvmField
    public val findInteractionProfileName:
        MethodStringName1<OpenXRActionMap, OpenXRInteractionProfile?, String> =
        MethodStringName1<OpenXRActionMap, OpenXRInteractionProfile?, String>("find_interaction_profile")

    @JvmField
    public val getInteractionProfileName:
        MethodStringName1<OpenXRActionMap, OpenXRInteractionProfile?, Int> =
        MethodStringName1<OpenXRActionMap, OpenXRInteractionProfile?, Int>("get_interaction_profile")

    @JvmField
    public val addInteractionProfileName:
        MethodStringName1<OpenXRActionMap, Unit, OpenXRInteractionProfile?> =
        MethodStringName1<OpenXRActionMap, Unit, OpenXRInteractionProfile?>("add_interaction_profile")

    @JvmField
    public val removeInteractionProfileName:
        MethodStringName1<OpenXRActionMap, Unit, OpenXRInteractionProfile?> =
        MethodStringName1<OpenXRActionMap, Unit, OpenXRInteractionProfile?>("remove_interaction_profile")

    @JvmField
    public val createDefaultActionSetsName: MethodStringName0<OpenXRActionMap, Unit> =
        MethodStringName0<OpenXRActionMap, Unit>("create_default_action_sets")
  }

  public object MethodBindings {
    internal val setActionSetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "set_action_sets", 381264803)

    internal val getActionSetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_action_sets", 3995934104)

    internal val getActionSetCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_action_set_count", 3905245786)

    internal val findActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "find_action_set", 1888809267)

    internal val getActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_action_set", 1789580336)

    internal val addActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "add_action_set", 2093310581)

    internal val removeActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "remove_action_set", 2093310581)

    internal val setInteractionProfilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "set_interaction_profiles", 381264803)

    internal val getInteractionProfilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_interaction_profiles", 3995934104)

    internal val getInteractionProfileCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_interaction_profile_count", 3905245786)

    internal val findInteractionProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "find_interaction_profile", 3095875538)

    internal val getInteractionProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "get_interaction_profile", 2546151210)

    internal val addInteractionProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "add_interaction_profile", 2697953512)

    internal val removeInteractionProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "remove_interaction_profile", 2697953512)

    internal val createDefaultActionSetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionMap", "create_default_action_sets", 3218959716)
  }
}
