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
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is a special node within the AR/VR system that maps the physical location of the center of
 * our tracking space to the virtual location within our game world.
 *
 * Multiple origin points can be added to the scene tree, but only one can used at a time. All the
 * [XRCamera3D], [XRController3D], and [XRAnchor3D] nodes should be direct children of this node for
 * spatial tracking to work correctly.
 *
 * It is the position of this node that you update when your character needs to move through your
 * game world while we're not moving in the real world. Movement in the real world is always in
 * relation to this origin point.
 *
 * For example, if your character is driving a car, the [XROrigin3D] node should be a child node of
 * this car. Or, if you're implementing a teleport system to move your character, you should change the
 * position of this node.
 */
@GodotBaseType
public open class XROrigin3D : Node3D() {
  /**
   * The scale of the game world compared to the real world. This is the same as
   * [XRServer.worldScale]. By default, most AR/VR platforms assume that 1 game unit corresponds to 1
   * real world meter.
   */
  public final inline var worldScale: Float
    @JvmName("worldScaleProperty")
    get() = getWorldScale()
    @JvmName("worldScaleProperty")
    set(`value`) {
      setWorldScale(value)
    }

  /**
   * If `true`, this origin node is currently being used by the [XRServer]. Only one origin point
   * can be used at a time.
   */
  public final inline var current: Boolean
    @JvmName("currentProperty")
    get() = isCurrent()
    @JvmName("currentProperty")
    set(`value`) {
      setCurrent(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(949, scriptPtr)
  }

  public final fun setWorldScale(worldScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, worldScale.toDouble())
    TransferContext.callMethod(MethodBindings.setWorldScalePtr)
  }

  public final fun getWorldScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorldScalePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setCurrent(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setCurrentPtr)
  }

  public final fun isCurrent(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCurrentPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setWorldScaleName: MethodStringName1<XROrigin3D, Unit, Float> =
        MethodStringName1<XROrigin3D, Unit, Float>("set_world_scale")

    @JvmField
    public val getWorldScaleName: MethodStringName0<XROrigin3D, Float> =
        MethodStringName0<XROrigin3D, Float>("get_world_scale")

    @JvmField
    public val setCurrentName: MethodStringName1<XROrigin3D, Unit, Boolean> =
        MethodStringName1<XROrigin3D, Unit, Boolean>("set_current")

    @JvmField
    public val isCurrentName: MethodStringName0<XROrigin3D, Boolean> =
        MethodStringName0<XROrigin3D, Boolean>("is_current")
  }

  public object MethodBindings {
    internal val setWorldScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XROrigin3D", "set_world_scale", 373806689)

    internal val getWorldScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XROrigin3D", "get_world_scale", 1740695150)

    internal val setCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XROrigin3D", "set_current", 2586408642)

    internal val isCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XROrigin3D", "is_current", 36873697)
  }
}
