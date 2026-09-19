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
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod0_ret_QUATERNION
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_LONG
import godot.callPtrMethod_QUATERNION
import godot.callPtrMethod_VECTOR3
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Quaternion
import godot.core.Vector3
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A collision can be a child of [SpringBoneSimulator3D]. If it is not a child of
 * [SpringBoneSimulator3D], it has no effect.
 *
 * The colliding and sliding are done in the [SpringBoneSimulator3D]'s modification process in order
 * of its collision list which is set by [SpringBoneSimulator3D.setCollisionPath]. If
 * [SpringBoneSimulator3D.areAllChildCollisionsEnabled] is `true`, the order matches [SceneTree].
 *
 * If [bone] is set, it synchronizes with the bone pose of the ancestor [Skeleton3D], which is done
 * in before the [SpringBoneSimulator3D]'s modification process as the pre-process.
 *
 * **Warning:** A scaled [SpringBoneCollision3D] will likely not behave as expected. Make sure that
 * the parent [Skeleton3D] and its bones are not scaled.
 */
@GodotBaseType
public open class SpringBoneCollision3D : Node3D() {
  /**
   * The name of the attached bone.
   */
  public final inline var boneName: String
    @JvmName("boneNameProperty")
    get() = getBoneName()
    @JvmName("boneNameProperty")
    set(`value`) {
      setBoneName(value)
    }

  /**
   * The index of the attached bone.
   */
  public final inline var bone: Int
    @JvmName("boneProperty")
    get() = getBone()
    @JvmName("boneProperty")
    set(`value`) {
      setBone(value)
    }

  /**
   * The offset of the position from [Skeleton3D]'s [bone] pose position.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var positionOffset: Vector3
    @JvmName("positionOffsetProperty")
    get() = getPositionOffset()
    @JvmName("positionOffsetProperty")
    set(`value`) {
      setPositionOffset(value)
    }

  /**
   * The offset of the rotation from [Skeleton3D]'s [bone] pose rotation.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotationOffset: Quaternion
    @JvmName("rotationOffsetProperty")
    get() = getRotationOffset()
    @JvmName("rotationOffsetProperty")
    set(`value`) {
      setRotationOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(694, scriptPtr)
  }

  /**
   * This is a helper function for [positionOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = springbonecollision3d.positionOffset
   * //Your changes
   * springbonecollision3d.positionOffset = myCoreType
   * ``````
   *
   * The offset of the position from [Skeleton3D]'s [bone] pose position.
   */
  @CoreTypeHelper
  public final fun positionOffsetMutate(block: Vector3.() -> Unit): Vector3 = positionOffset.apply {
     block(this)
     positionOffset = this
  }

  /**
   * This is a helper function for [rotationOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = springbonecollision3d.rotationOffset
   * //Your changes
   * springbonecollision3d.rotationOffset = myCoreType
   * ``````
   *
   * The offset of the rotation from [Skeleton3D]'s [bone] pose rotation.
   */
  @CoreTypeHelper
  public final fun rotationOffsetMutate(block: Quaternion.() -> Unit): Quaternion =
      rotationOffset.apply {
     block(this)
     rotationOffset = this
  }

  /**
   * Get parent [Skeleton3D] node of the parent [SpringBoneSimulator3D] if found.
   */
  public final fun getSkeleton(): Skeleton3D? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getSkeletonPtr) as Skeleton3D?)

  public final fun setBoneName(boneName: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setBoneNamePtr, boneName)
  }

  public final fun getBoneName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getBoneNamePtr)

  public final fun setBone(bone: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBonePtr, bone.toLong())
  }

  public final fun getBone(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBonePtr).toInt()

  public final fun setPositionOffset(offset: Vector3): Unit {
    TransferContext.callPtrMethod_VECTOR3(ptr, objectID.id, MethodBindings.setPositionOffsetPtr, offset)
  }

  public final fun getPositionOffset(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getPositionOffsetPtr)

  public final fun setRotationOffset(offset: Quaternion): Unit {
    TransferContext.callPtrMethod_QUATERNION(ptr, objectID.id, MethodBindings.setRotationOffsetPtr, offset)
  }

  public final fun getRotationOffset(): Quaternion =
      TransferContext.callPtrMethod0_ret_QUATERNION(ptr, objectID.id, MethodBindings.getRotationOffsetPtr)

  public companion object {
    @JvmField
    public val getSkeletonName: MethodStringName0<SpringBoneCollision3D, Skeleton3D?> =
        MethodStringName0<SpringBoneCollision3D, Skeleton3D?>("get_skeleton")

    @JvmField
    public val setBoneNameName: MethodStringName1<SpringBoneCollision3D, Unit, String> =
        MethodStringName1<SpringBoneCollision3D, Unit, String>("set_bone_name")

    @JvmField
    public val getBoneNameName: MethodStringName0<SpringBoneCollision3D, String> =
        MethodStringName0<SpringBoneCollision3D, String>("get_bone_name")

    @JvmField
    public val setBoneName: MethodStringName1<SpringBoneCollision3D, Unit, Int> =
        MethodStringName1<SpringBoneCollision3D, Unit, Int>("set_bone")

    @JvmField
    public val getBoneName: MethodStringName0<SpringBoneCollision3D, Int> =
        MethodStringName0<SpringBoneCollision3D, Int>("get_bone")

    @JvmField
    public val setPositionOffsetName: MethodStringName1<SpringBoneCollision3D, Unit, Vector3> =
        MethodStringName1<SpringBoneCollision3D, Unit, Vector3>("set_position_offset")

    @JvmField
    public val getPositionOffsetName: MethodStringName0<SpringBoneCollision3D, Vector3> =
        MethodStringName0<SpringBoneCollision3D, Vector3>("get_position_offset")

    @JvmField
    public val setRotationOffsetName: MethodStringName1<SpringBoneCollision3D, Unit, Quaternion> =
        MethodStringName1<SpringBoneCollision3D, Unit, Quaternion>("set_rotation_offset")

    @JvmField
    public val getRotationOffsetName: MethodStringName0<SpringBoneCollision3D, Quaternion> =
        MethodStringName0<SpringBoneCollision3D, Quaternion>("get_rotation_offset")
  }

  public object MethodBindings {
    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "get_skeleton", 1488626673)

    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "set_bone_name", 83702148)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "get_bone_name", 201670096)

    internal val setBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "set_bone", 1286410249)

    internal val getBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "get_bone", 3905245786)

    internal val setPositionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "set_position_offset", 3460891852)

    internal val getPositionOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "get_position_offset", 3360562783)

    internal val setRotationOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "set_rotation_offset", 1727505552)

    internal val getRotationOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollision3D", "get_rotation_offset", 1222331677)
  }
}
