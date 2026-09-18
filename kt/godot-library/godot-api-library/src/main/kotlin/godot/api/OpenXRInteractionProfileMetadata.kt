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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName6
import godot.writeMethodArguments_STRING_STRING
import godot.writeMethodArguments_STRING_STRING_STRING
import godot.writeMethodArguments_STRING_STRING_STRING_STRING_STRING_LONG
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This class allows OpenXR core and extensions to register metadata relating to supported
 * interaction devices such as controllers, trackers, haptic devices, etc. It is primarily used by the
 * action map editor and to sanitize any action map by removing extension-dependent entries when
 * applicable.
 */
@GodotBaseType
public open class OpenXRInteractionProfileMetadata : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(461, scriptPtr)
  }

  /**
   * Allows for renaming old interaction profile paths to new paths in order to load and process
   * older action maps.
   */
  public final fun registerProfileRename(oldName: String, newName: String): Unit {
    TransferContext.writeMethodArguments_STRING_STRING(ptr, objectID.id, oldName, newName)
    TransferContext.callMethod(MethodBindings.registerProfileRenamePtr)
  }

  /**
   * Allows for renaming old input/output paths to new paths in order to load and process older
   * action maps.
   */
  public final fun registerPathRename(oldName: String, newName: String): Unit {
    TransferContext.writeMethodArguments_STRING_STRING(ptr, objectID.id, oldName, newName)
    TransferContext.callMethod(MethodBindings.registerPathRenamePtr)
  }

  /**
   * Registers a top level path to which profiles can be bound. For instance `/user/hand/left`
   * refers to the bind point for the player's left hand. Extensions can register additional top level
   * paths, for instance a haptic vest extension might register `/user/body/vest`.
   *
   * [displayName] is the name shown to the user. [openxrPath] is the top level path being
   * registered. [openxrExtensionNames] is optional and ensures the top level path is only used if the
   * specified extension is available/enabled.
   *
   * When a top level path ends up being bound by OpenXR, an [XRPositionalTracker] is instantiated
   * to manage the state of the device.
   */
  public final fun registerTopLevelPath(
    displayName: String,
    openxrPath: String,
    openxrExtensionNames: String,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_STRING_STRING(ptr, objectID.id, displayName, openxrPath, openxrExtensionNames)
    TransferContext.callMethod(MethodBindings.registerTopLevelPathPtr)
  }

  /**
   * Registers an interaction profile using its OpenXR designation (e.g.
   * `/interaction_profiles/khr/simple_controller` is the profile for OpenXR's simple controller
   * profile).
   *
   * [displayName] is the description shown to the user. [openxrPath] is the interaction profile
   * path being registered. [openxrExtensionNames] optionally restricts this profile to the given
   * extension being enabled/available. If the extension is not available, the profile and all related
   * entries used in an action map are filtered out.
   */
  public final fun registerInteractionProfile(
    displayName: String,
    openxrPath: String,
    openxrExtensionNames: String,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_STRING_STRING(ptr, objectID.id, displayName, openxrPath, openxrExtensionNames)
    TransferContext.callMethod(MethodBindings.registerInteractionProfilePtr)
  }

  /**
   * Registers an input/output path for the given [interactionProfile]. The profile should
   * previously have been registered using [registerInteractionProfile]. [displayName] is the
   * description shown to the user. [toplevelPath] specifies the bind path this input/output can be
   * bound to (e.g. `/user/hand/left` or `/user/hand/right`). [openxrPath] is the action input/output
   * being registered (e.g. `/user/hand/left/input/aim/pose`). [openxrExtensionNames] restricts this
   * input/output to an enabled/available extension, this doesn't need to repeat the extension on the
   * profile but relates to overlapping extension (e.g. `XR_EXT_palm_pose` that introduces
   * `…/input/palm_ext/pose` input paths). [actionType] defines the type of input or output provided by
   * OpenXR.
   */
  public final fun registerIoPath(
    interactionProfile: String,
    displayName: String,
    toplevelPath: String,
    openxrPath: String,
    openxrExtensionNames: String,
    actionType: OpenXRAction.ActionType,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_STRING_STRING_STRING_STRING_LONG(ptr, objectID.id, interactionProfile, displayName, toplevelPath, openxrPath, openxrExtensionNames, actionType.value)
    TransferContext.callMethod(MethodBindings.registerIoPathPtr)
  }

  public companion object {
    @JvmField
    public val registerProfileRenameName:
        MethodStringName2<OpenXRInteractionProfileMetadata, Unit, String, String> =
        MethodStringName2<OpenXRInteractionProfileMetadata, Unit, String, String>("register_profile_rename")

    @JvmField
    public val registerPathRenameName:
        MethodStringName2<OpenXRInteractionProfileMetadata, Unit, String, String> =
        MethodStringName2<OpenXRInteractionProfileMetadata, Unit, String, String>("register_path_rename")

    @JvmField
    public val registerTopLevelPathName:
        MethodStringName3<OpenXRInteractionProfileMetadata, Unit, String, String, String> =
        MethodStringName3<OpenXRInteractionProfileMetadata, Unit, String, String, String>("register_top_level_path")

    @JvmField
    public val registerInteractionProfileName:
        MethodStringName3<OpenXRInteractionProfileMetadata, Unit, String, String, String> =
        MethodStringName3<OpenXRInteractionProfileMetadata, Unit, String, String, String>("register_interaction_profile")

    @JvmField
    public val registerIoPathName:
        MethodStringName6<OpenXRInteractionProfileMetadata, Unit, String, String, String, String, String, OpenXRAction.ActionType>
        =
        MethodStringName6<OpenXRInteractionProfileMetadata, Unit, String, String, String, String, String, OpenXRAction.ActionType>("register_io_path")
  }

  public object MethodBindings {
    internal val registerProfileRenamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfileMetadata", "register_profile_rename", 3186203200)

    internal val registerPathRenamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfileMetadata", "register_path_rename", 3186203200)

    internal val registerTopLevelPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfileMetadata", "register_top_level_path", 254767734)

    internal val registerInteractionProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfileMetadata", "register_interaction_profile", 254767734)

    internal val registerIoPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInteractionProfileMetadata", "register_io_path", 3443511926)
  }
}
