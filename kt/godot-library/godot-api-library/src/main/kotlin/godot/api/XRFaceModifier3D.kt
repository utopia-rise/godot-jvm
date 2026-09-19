// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_STRING_NAME
import godot.callPtrMethod_NODE_PATH
import godot.callPtrMethod_STRING_NAME
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.StringName
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node applies weights from an [XRFaceTracker] to a mesh with supporting face blend shapes.
 *
 * The
 * [url=https://docs.vrcft.io/docs/tutorial-avatars/tutorial-avatars-extras/unified-blendshapes]Unified
 * Expressions[/url] blend shapes are supported, as well as ARKit and SRanipal blend shapes.
 *
 * The node attempts to identify blend shapes based on name matching. Blend shapes should match the
 * names listed in the
 * [url=https://docs.vrcft.io/docs/tutorial-avatars/tutorial-avatars-extras/compatibility/overview]Unified
 * Expressions Compatibility[/url] chart.
 */
@GodotBaseType
public open class XRFaceModifier3D : Node3D() {
  /**
   * The [XRFaceTracker] path.
   */
  public final inline var faceTracker: StringName
    @JvmName("faceTrackerProperty")
    get() = getFaceTracker()
    @JvmName("faceTrackerProperty")
    set(`value`) {
      setFaceTracker(value)
    }

  /**
   * The [NodePath] of the face [MeshInstance3D].
   */
  public final inline var target: NodePath
    @JvmName("targetProperty")
    get() = getTarget()
    @JvmName("targetProperty")
    set(`value`) {
      setTarget(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(942, scriptPtr)
  }

  public final fun setFaceTracker(trackerName: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.setFaceTrackerPtr, trackerName)
  }

  public final fun getFaceTracker(): StringName =
      TransferContext.callPtrMethod0_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getFaceTrackerPtr)

  public final fun setTarget(target: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setTargetPtr, target)
  }

  public final fun getTarget(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getTargetPtr)

  public final fun setFaceTracker(trackerName: String) =
      setFaceTracker(trackerName.asCachedStringName())

  public final fun setTarget(target: String) = setTarget(target.asCachedNodePath())

  public companion object {
    @JvmField
    public val setFaceTrackerName: MethodStringName1<XRFaceModifier3D, Unit, StringName> =
        MethodStringName1<XRFaceModifier3D, Unit, StringName>("set_face_tracker")

    @JvmField
    public val getFaceTrackerName: MethodStringName0<XRFaceModifier3D, StringName> =
        MethodStringName0<XRFaceModifier3D, StringName>("get_face_tracker")

    @JvmField
    public val setTargetName: MethodStringName1<XRFaceModifier3D, Unit, NodePath> =
        MethodStringName1<XRFaceModifier3D, Unit, NodePath>("set_target")

    @JvmField
    public val getTargetName: MethodStringName0<XRFaceModifier3D, NodePath> =
        MethodStringName0<XRFaceModifier3D, NodePath>("get_target")
  }

  public object MethodBindings {
    internal val setFaceTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceModifier3D", "set_face_tracker", 3304788590)

    internal val getFaceTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceModifier3D", "get_face_tracker", 2002593661)

    internal val setTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceModifier3D", "set_target", 1348162250)

    internal val getTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceModifier3D", "get_target", 4075236667)
  }
}
