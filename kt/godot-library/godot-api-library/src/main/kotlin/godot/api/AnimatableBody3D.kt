// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An animatable 3D physics body. It can't be moved by external forces or contacts, but can be moved
 * manually by other means such as code, [AnimationMixer]s (with [AnimationMixer.callbackModeProcess]
 * set to [AnimationMixer.ANIMATION_CALLBACK_MODE_PROCESS_PHYSICS]), and [RemoteTransform3D].
 *
 * When [AnimatableBody3D] is moved, its linear and angular velocity are estimated and used to
 * affect other physics bodies in its path. This makes it useful for moving platforms, doors, and other
 * moving objects.
 */
@GodotBaseType
public open class AnimatableBody3D : StaticBody3D() {
  /**
   * If `true`, the body's movement will be synchronized to the physics frame. This is useful when
   * animating movement via [AnimationPlayer], for example on moving platforms. Do **not** use together
   * with [PhysicsBody3D.moveAndCollide].
   */
  public final inline var syncToPhysics: Boolean
    @JvmName("syncToPhysicsProperty")
    get() = isSyncToPhysicsEnabled()
    @JvmName("syncToPhysicsProperty")
    set(`value`) {
      setSyncToPhysics(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(8, scriptPtr)
  }

  public final fun setSyncToPhysics(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setSyncToPhysicsPtr, enable)
  }

  public final fun isSyncToPhysicsEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isSyncToPhysicsEnabledPtr)

  public companion object {
    @JvmField
    public val setSyncToPhysicsName: MethodStringName1<AnimatableBody3D, Unit, Boolean> =
        MethodStringName1<AnimatableBody3D, Unit, Boolean>("set_sync_to_physics")

    @JvmField
    public val isSyncToPhysicsEnabledName: MethodStringName0<AnimatableBody3D, Boolean> =
        MethodStringName0<AnimatableBody3D, Boolean>("is_sync_to_physics_enabled")
  }

  public object MethodBindings {
    internal val setSyncToPhysicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatableBody3D", "set_sync_to_physics", 2586408642)

    internal val isSyncToPhysicsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatableBody3D", "is_sync_to_physics_enabled", 36873697)
  }
}
