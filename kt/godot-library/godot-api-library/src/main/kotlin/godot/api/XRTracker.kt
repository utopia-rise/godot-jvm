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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is the base of all XR trackers.
 */
@GodotBaseType
public open class XRTracker internal constructor() : RefCounted() {
  /**
   * The type of tracker.
   */
  public final inline var type: XRServer.TrackerType
    @JvmName("typeProperty")
    get() = getTrackerType()
    @JvmName("typeProperty")
    set(`value`) {
      setTrackerType(value)
    }

  /**
   * The unique name of this tracker. The trackers that are available differ between various XR
   * runtimes and can often be configured by the user. Godot maintains a number of reserved names that
   * it expects the [XRInterface] to implement if applicable:
   *
   * - `"head"` identifies the [XRPositionalTracker] of the player's head
   *
   * - `"left_hand"` identifies the [XRControllerTracker] in the player's left hand
   *
   * - `"right_hand"` identifies the [XRControllerTracker] in the player's right hand
   *
   * - `"/user/hand_tracker/left"` identifies the [XRHandTracker] for the player's left hand
   *
   * - `"/user/hand_tracker/right"` identifies the [XRHandTracker] for the player's right hand
   *
   * - `"/user/body_tracker"` identifies the [XRBodyTracker] for the player's body
   *
   * - `"/user/face_tracker"` identifies the [XRFaceTracker] for the player's face
   */
  public final inline var name: StringName
    @JvmName("nameProperty")
    get() = getTrackerName()
    @JvmName("nameProperty")
    set(`value`) {
      setTrackerName(value)
    }

  /**
   * The description of this tracker.
   */
  public final inline var description: String
    @JvmName("descriptionProperty")
    get() = getTrackerDesc()
    @JvmName("descriptionProperty")
    set(`value`) {
      setTrackerDesc(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(953, scriptPtr)
  }

  public final fun getTrackerType(): XRServer.TrackerType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackerTypePtr)
    return XRServer.TrackerType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTrackerType(type: XRServer.TrackerType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, type.value)
    TransferContext.callMethod(MethodBindings.setTrackerTypePtr)
  }

  public final fun getTrackerName(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackerNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setTrackerName(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setTrackerNamePtr)
  }

  public final fun getTrackerDesc(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackerDescPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setTrackerDesc(description: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, description)
    TransferContext.callMethod(MethodBindings.setTrackerDescPtr)
  }

  public final fun setTrackerName(name: String) = setTrackerName(name.asCachedStringName())

  public companion object {
    @JvmField
    public val getTrackerTypeName: MethodStringName0<XRTracker, XRServer.TrackerType> =
        MethodStringName0<XRTracker, XRServer.TrackerType>("get_tracker_type")

    @JvmField
    public val setTrackerTypeName: MethodStringName1<XRTracker, Unit, XRServer.TrackerType> =
        MethodStringName1<XRTracker, Unit, XRServer.TrackerType>("set_tracker_type")

    @JvmField
    public val getTrackerNameName: MethodStringName0<XRTracker, StringName> =
        MethodStringName0<XRTracker, StringName>("get_tracker_name")

    @JvmField
    public val setTrackerNameName: MethodStringName1<XRTracker, Unit, StringName> =
        MethodStringName1<XRTracker, Unit, StringName>("set_tracker_name")

    @JvmField
    public val getTrackerDescName: MethodStringName0<XRTracker, String> =
        MethodStringName0<XRTracker, String>("get_tracker_desc")

    @JvmField
    public val setTrackerDescName: MethodStringName1<XRTracker, Unit, String> =
        MethodStringName1<XRTracker, Unit, String>("set_tracker_desc")
  }

  public object MethodBindings {
    internal val getTrackerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "get_tracker_type", 2784508102)

    internal val setTrackerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "set_tracker_type", 3055763575)

    internal val getTrackerNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "get_tracker_name", 2002593661)

    internal val setTrackerNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "set_tracker_name", 3304788590)

    internal val getTrackerDescPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "get_tracker_desc", 201670096)

    internal val setTrackerDescPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRTracker", "set_tracker_desc", 83702148)
  }
}
